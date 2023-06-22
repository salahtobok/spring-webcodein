package com.webcodein.common.config.webservice;

import com.webcodein.admin.exception.handler.AccessDeniedExceptionMapper;
import com.webcodein.admin.exception.handler.ConstraintViolationExceptionMapper;
import com.webcodein.admin.exception.handler.GenericExceptionMapper;
import com.webcodein.common.config.webservice.ServerFilters.CommonPreMatchRequestFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletProperties;


public class CommonJerseyConfiguration extends ResourceConfig {

    public CommonJerseyConfiguration() {
        packages("com.webcodein.common.endpoint");
        register(CommonPreMatchRequestFilter.class);
        register(GenericExceptionMapper.class);
        register(ConstraintViolationExceptionMapper.class);
        register(AccessDeniedExceptionMapper.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,true);
    }
}