package com.webcodein.common.config.webservice;

import com.webcodein.admin.exception.handler.AccessDeniedExceptionMapper;
import com.webcodein.admin.exception.handler.ConstraintViolationExceptionMapper;
import com.webcodein.admin.exception.handler.GenericExceptionMapper;
import com.webcodein.common.config.webservice.ServerFilters.CommonPreMatchRequestFilter;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Qualifier;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ApplicationPath("/api/v1/common")
public class CommonJerseyConfiguration extends ResourceConfig {

    @PostConstruct
    public void init() {
        register(CommonPreMatchRequestFilter.class);
        packages("com.webcodein.common.endpoint");
        register(GenericExceptionMapper.class);
        register(ConstraintViolationExceptionMapper.class);
        register(AccessDeniedExceptionMapper.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,true);
    }
}