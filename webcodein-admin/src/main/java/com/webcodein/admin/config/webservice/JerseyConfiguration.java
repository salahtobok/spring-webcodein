package com.webcodein.admin.config.webservice;

import com.webcodein.admin.controller.GenericExceptionMapper;
import com.webcodein.admin.endpoint.ClientRestController;
import com.webcodein.admin.endpoint.UserRestController;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api/v1/admin")
public class JerseyConfiguration extends ResourceConfig {

    @PostConstruct
    public void init() {
        packages("com.webcodein.admin.endpoint");
        register(GenericExceptionMapper.class);
    }
}