package com.odelia.grails.plugins.atmosphere;

import org.codehaus.groovy.grails.commons.AbstractInjectableGrailsClass;


/**
 *
 * @author BGoetzmann
 */
public class DefaultGrailsAtmosphereHandlerClass extends AbstractInjectableGrailsClass implements GrailsAtmosphereHandlerClass, GrailsAtmosphereHandlerClassProperty {

    public static final String ATMOSPHEREHANDLER = "AtmosphereHandler";

    public DefaultGrailsAtmosphereHandlerClass(Class clazz) {
        super(clazz, ATMOSPHEREHANDLER);
    }

}
