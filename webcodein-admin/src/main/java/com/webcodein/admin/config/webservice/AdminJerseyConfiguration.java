package com.webcodein.admin.config.webservice;

import com.webcodein.admin.exception.handler.AccessDeniedExceptionMapper;
import com.webcodein.admin.exception.handler.ConstraintViolationExceptionMapper;
import com.webcodein.admin.exception.handler.GenericExceptionMapper;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class AdminJerseyConfiguration extends ResourceConfig {

    public AdminJerseyConfiguration() {
        packages("com.webcodein.admin.endpoint");
        register(GenericExceptionMapper.class);
        register(ConstraintViolationExceptionMapper.class);
        register(AccessDeniedExceptionMapper.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,true);
    }
}