//package com.webcodein.admin.config.webservice;
//
//import com.webcodein.admin.config.webservice.ServerFilters.AdminPostMatchRequestFilter;
//import com.webcodein.admin.config.webservice.ServerFilters.AdminPostMatchResponseFilter;
//import com.webcodein.admin.config.webservice.ServerFilters.AdminPreMatchRequestFilter;
//import com.webcodein.admin.config.webservice.ServerFilters.AdminPreMatchResponseFilter;
//import com.webcodein.admin.config.webservice.ServerInterceptors.AdminReaderInterceptor;
//import com.webcodein.admin.config.webservice.ServerInterceptors.AdminWriterInterceptor;
//import com.webcodein.admin.endpoint.ClientRestController;
//import jakarta.annotation.PostConstruct;
//import org.glassfish.jersey.server.ResourceConfig;
//import org.springframework.context.annotation.Configuration;
//
//import javax.ws.rs.ApplicationPath;
//
///**
// * This is applicable only when request enter and exit from server side
// * ( Lifecycle of the treatment Java EE // Jakarta EE client is not mentioned )
// * Client Request Initiated → Client Request Filters → Client Writer Interceptors →
// * Client MessageBodyWriter → Server → Client Response Filters →
// * Client Reader Interceptors → Client MessageBodyReader → Client Receives the Response
// */
//@Configuration
//@ApplicationPath("/api/v1/admin")
//public class AdminJerseyServerConfiguration extends ResourceConfig {
//    public AdminJerseyServerConfiguration() {
//
//        // 01 - PempPreMatchRequestFilter
//        register(new AdminPreMatchRequestFilter());
//        // 02 - PempPostMatchRequestFilter
//        register(new AdminPostMatchRequestFilter());
//        // 03 - PempReaderInterceptor
//        register(new AdminReaderInterceptor());
//        // 04 - PempPreMatchResponseFilter
//        register(new AdminPreMatchResponseFilter());
//        // 05 - PempPostMatchResponseFilter
//        register(new AdminPostMatchResponseFilter());
//        // 06 - PempWriterInterceptor
//        register(new AdminWriterInterceptor());
//
//
//        packages("com.webcodein.admin.endpoint");
//    }
//
//    @PostConstruct
//    public void init() {
//        register(ClientRestController.class);
//        //register(GenericExceptionMapper.class);
//    }
//
//}
