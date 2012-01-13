@artifact.package@

import org.atmosphere.cpr.AtmosphereHandler
import org.atmosphere.cpr.AtmosphereResource
import org.atmosphere.cpr.AtmosphereResourceEvent
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class @artifact.name@ implements AtmosphereHandler<HttpServletRequest, HttpServletResponse> {

    void onRequest(AtmosphereResource<HttpServletRequest, HttpServletResponse> event) throws IOException {

    }

    void onStateChange(AtmosphereResourceEvent<HttpServletRequest, HttpServletResponse> event) throws IOException {
        
    }

}
