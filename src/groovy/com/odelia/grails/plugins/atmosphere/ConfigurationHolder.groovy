package com.odelia.grails.plugins.atmosphere

import grails.util.GrailsUtil

/**
 *
 * @author BGoetzmann
 */
class ConfigurationHolder {

    static ConfigObject getConfig() {
        GroovyClassLoader classLoader = new GroovyClassLoader(ConfigurationHolder.classLoader)

        def slurper = new ConfigSlurper(GrailsUtil.environment)
        ConfigObject config
        try {
            config = slurper.parse(classLoader.loadClass('AtmosphereConfig'))
        }
        catch (e) {
        }

        return config
    }
}

