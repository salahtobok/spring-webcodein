package com.webcodein.admin.config.webservice;

import com.webcodein.admin.exception.handler.AccessDeniedExceptionMapper;
import com.webcodein.admin.exception.handler.ConstraintViolationExceptionMapper;
import com.webcodein.admin.exception.handler.GenericExceptionMapper;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletProperties;


public class AdminJerseyConfiguration extends ResourceConfig {

    public AdminJerseyConfiguration() {
        packages("com.webcodein.admin.endpoint");
        //register(GenericExceptionMapper.class);
//        register(ConstraintViolationExceptionMapper.class);
//        register(AccessDeniedExceptionMapper.class);
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
//        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,true);
    }
}


