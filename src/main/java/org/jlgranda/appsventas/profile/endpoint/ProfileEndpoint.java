package org.jlgranda.appsventas.profile.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.jlgranda.appsventas.security.auth.JwtAuthenticationToken;
import org.jlgranda.appsventas.security.model.Ping;
import org.jlgranda.appsventas.security.model.UserContext;

/**
 * End-point for retrieving logged-in user details.
 * 
 * @author vladimir.stankovic
 *
 * Aug 4, 2016
 */
@RestController
public class ProfileEndpoint {
    @RequestMapping(value="/api/me", method=RequestMethod.GET)
    public @ResponseBody UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }
    @RequestMapping(value="/ping", method=RequestMethod.GET)
    public @ResponseBody Ping ping() {
        return new Ping("0.0.1", "SMC Servicio de autenticación basado en JWT");
    }
}
