package com.odelia.grails.plugins.atmosphere

import org.atmosphere.cpr.AtmosphereServlet
import javax.servlet.ServletConfig
import javax.servlet.ServletException


class StratosphereServlet extends AtmosphereServlet  {
	
	public final static def ATMOSPHERE_PLUGIN_ATMOSPHERE_SERVLET = 'com.odelia.grails.plugins.atmosphere.atmosphere.servlet'
	public final static def ATMOSPHERE_PLUGIN_HANDLERS_CONFIG = 'com.odelia.grails.plugins.atmosphere.handlers.config'
	public final static def ATMOSPHERE_PLUGIN_SERVICE_HANDLERS = 'com.odelia.grails.plugins.atmosphere.service.handlers'



	@Override
    public void init(final ServletConfig sc) throws ServletException {

        sc.servletContext.setAttribute(ATMOSPHERE_PLUGIN_ATMOSPHERE_SERVLET, this)
        sc.servletContext.setAttribute(ATMOSPHERE_PLUGIN_HANDLERS_CONFIG, framework.atmosphereConfig.handlers())

        // Add services handlers
        def handlers = sc.servletContext.getAttribute(ATMOSPHERE_PLUGIN_SERVICE_HANDLERS)
        handlers.each {
            it.handler.setServletContext(sc.servletContext)
            framework.addAtmosphereHandler("${it.mapping}", it.handler)
        }

        super.init sc
    }
	
}
