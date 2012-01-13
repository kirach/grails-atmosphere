package com.odelia.grails.plugins.atmosphere


class AtmosphereTagLib {
	
    static namespace = 'atmosphere'
        
    def resources = { attrs ->
    	out << g.javascript(plugin: namespace, src: 'jquery/jquery.atmosphere.js')
    }
    
}
