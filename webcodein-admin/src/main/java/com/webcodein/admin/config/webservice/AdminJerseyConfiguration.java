package com.webcodein.admin.config.webservice;

import com.webcodein.admin.exception.handler.AccessDeniedExceptionMapper;
import com.webcodein.admin.exception.handler.ConstraintViolationExceptionMapper;
import com.webcodein.admin.exception.handler.GenericExceptionMapper;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ApplicationPath("/api/v1/admin")
public class AdminJerseyConfiguration extends ResourceConfig {

    @PostConstruct
    public void init() {
        packages("com.webcodein.admin.endpoint");
        register(GenericExceptionMapper.class);
        register(ConstraintViolationExceptionMapper.class);
        register(AccessDeniedExceptionMapper.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,true);
    }
}