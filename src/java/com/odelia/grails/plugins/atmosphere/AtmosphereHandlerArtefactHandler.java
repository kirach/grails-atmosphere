package com.odelia.grails.plugins.atmosphere;

import org.codehaus.groovy.grails.commons.ArtefactHandlerAdapter;


/**
 *
 * @author BGoetzmann
 */
public class AtmosphereHandlerArtefactHandler extends ArtefactHandlerAdapter {

    public static final String TYPE = "AtmosphereHandler";

    public AtmosphereHandlerArtefactHandler() {
        super(TYPE, GrailsAtmosphereHandlerClass.class, DefaultGrailsAtmosphereHandlerClass.class, null);
    }

    @Override
    public boolean isArtefactClass(Class clazz) {
        if (clazz == null) return false;

        return clazz.getName().endsWith(DefaultGrailsAtmosphereHandlerClass.ATMOSPHEREHANDLER);
    }

}
