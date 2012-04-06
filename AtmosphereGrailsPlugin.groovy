import com.odelia.grails.plugins.atmosphere.ConfigurationHolder
import com.odelia.grails.plugins.atmosphere.AtmosphereHandlerArtefactHandler

import org.atmosphere.cpr.AtmosphereHandler
import com.odelia.grails.plugins.atmosphere.GrailsHandler
import com.odelia.grails.plugins.atmosphere.StratosphereServlet

import org.codehaus.groovy.grails.commons.GrailsClassUtils
import org.apache.log4j.Logger


class AtmosphereGrailsPlugin {
	private static final Logger log = Logger.getLogger('com.odelia.grails.plugins.atmosphere.AtmosphereGrailsPlugin')
	
    // the plugin version
    def version = "0.4.2.2"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.5 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]
    
    def observe = ['controllers']

    def artefacts = [new AtmosphereHandlerArtefactHandler()]

    // TODO Fill in these fields
    def author = "Bertrand Goetzmann, Stéphane Maldini"
    def authorEmail = "bgoetzmann@odelia-technologies.com, stephane.maldini@gmail.com"
    def title = "Grails Atmosphere Plugin"
    def description = '''\\
Provides integration with the Atmosphere framework, a portable AjaxPush/Comet framework.
'''
    def ctrlHanlers = []

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/atmosphere"

	private def getAtmospherePropertyValue(service) {
		def atmosphereValue = GrailsClassUtils.getStaticPropertyValue(service.clazz, 'atmosphere')
		(atmosphereValue instanceof Map && atmosphereValue.mapping) ? atmosphereValue : null
	}
	
    def doWithSpring = {
        application.serviceClasses?.each { service ->
        	if (getAtmospherePropertyValue(service)) {
        		"${service.propertyName}GrailsHandler"(com.odelia.grails.plugins.atmosphere.GrailsHandler) {
        			targetService = ref("${service.propertyName}")
        		}
        	}
        }
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    	application.serviceClasses.each { service ->			
			def atmosphereValue = getAtmospherePropertyValue(service)
			if (atmosphereValue) {				
				ctrlHanlers << [mapping: atmosphereValue.mapping,
				                handler: applicationContext.getBean("${service.propertyName}GrailsHandler")]			                
			}
    	}
    }

    def doWithWebDescriptor = { xml ->    
        // Use the configuration file AtmosphereConfig in project's conf folder

        def config = ConfigurationHolder.config		      
        if (config) {
            def servlets = xml.'servlet'
            servlets[servlets.size()-1] + {
                'servlet' {
                    'description'('StratosphereServlet')
                    'servlet-name'('StratosphereServlet')
                    'servlet-class'('com.odelia.grails.plugins.atmosphere.StratosphereServlet')
                    config?.atmospherePlugin?.servlet?.initParams.each { initParam ->
                    	'init-param' {
                    		'param-name'(initParam.key)
                    		'param-value'(initParam.value)
                    	}
                    }                    
                    'load-on-startup'('0')
                }
            }

            def mappings = xml.'servlet-mapping'
            mappings[mappings.size()-1] + {
                'servlet-mapping' {
                    'servlet-name'('StratosphereServlet')
                    def urlPattern = config?.atmospherePlugin?.servlet?.urlPattern ?: '/atmosphere/*'
                    'url-pattern'(urlPattern)
                }
            }
        }
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional) 

	   	ctx.servletContext.setAttribute(StratosphereServlet.ATMOSPHERE_PLUGIN_SERVICE_HANDLERS, ctrlHanlers)		    
        
    	application.controllerClasses.each { addMethod(it) }	
    	application.serviceClasses.each { service ->
			if (getAtmospherePropertyValue(service))
				addMethod(service)
		}
    }

    def onChange = { event ->
		if (application.isControllerClass(event.source)) {
			addMethod(event.source)
		}
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
    
	private addMethod(source) {
		log.debug "Adding dynamic method to ${source}"
		source.metaClass.getBroadcaster = {->
			def _broadcaster = [:]
			servletContext[StratosphereServlet.ATMOSPHERE_PLUGIN_HANDLERS_CONFIG].each {
				_broadcaster."${it.key}" = it.value.broadcaster
			}
			_broadcaster
		}
	}
   
}
