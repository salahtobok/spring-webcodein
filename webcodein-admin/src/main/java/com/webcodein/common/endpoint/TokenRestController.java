package com.webcodein.common.endpoint;


import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;
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

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(APPLICATION_JSON)
    @RolesAllowed("front_common_function")
    public Map<String,Object> getToken(){

        return Collections.singletonMap("principal",securityContext.getUserPrincipal());
    }
}