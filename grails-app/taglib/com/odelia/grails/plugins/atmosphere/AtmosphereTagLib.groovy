package com.odelia.grails.plugins.atmosphere


class AtmosphereTagLib {
	
    static namespace = 'atmosphere'
        
    def resources = { attrs ->
    	out << g.javascript(plugin: namespace, src: 'jquery-1.4.2.js')
    	out << g.javascript(plugin: namespace, src: 'jquery.atmosphere.js')
    }
    
}
