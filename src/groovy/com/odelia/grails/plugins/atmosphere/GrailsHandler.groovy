package com.odelia.grails.plugins.atmosphere

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.atmosphere.cpr.AtmosphereHandler
import org.atmosphere.cpr.AtmosphereResource
import org.atmosphere.cpr.AtmosphereResourceEvent


class GrailsHandler implements AtmosphereHandler<HttpServletRequest, HttpServletResponse> {
	
    def targetService
    def servletContext    
    
    def setServletContext(ctx) {
    	servletContext = ctx
    	targetService.metaClass.getServletContext = { servletContext }
    }
	
	void onRequest(AtmosphereResource event) throws IOException {
    	targetService.onRequest(event)
	}
	
	void onStateChange(AtmosphereResourceEvent event) throws IOException {
		targetService.onStateChange(event)
	}

    void destroy() {}
	
}
