package com.webcodein.common.endpoint;


import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Slf4j
@Path("/token")
public class TokenRestController {

    @GET
    @Produces(APPLICATION_JSON)
    @RolesAllowed("front_common_function")
    public Map<String,Object> getToken(@AuthenticationPrincipal Jwt jwt){
        return Collections.singletonMap("principal",jwt);
    }
}