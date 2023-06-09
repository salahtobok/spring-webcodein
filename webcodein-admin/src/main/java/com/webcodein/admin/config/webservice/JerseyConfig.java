package com.webcodein.admin.config.webservice;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig {

    @Bean
    public ServletRegistrationBean adminJerseyConfiguration() {
        ServletRegistrationBean adminJerseyConfiguration
                = new ServletRegistrationBean(new ServletContainer(new AdminJerseyConfiguration()));
        adminJerseyConfiguration.addUrlMappings("/api/v1/admin/*");
        adminJerseyConfiguration.setName("PublicJersey");
        adminJerseyConfiguration.setLoadOnStartup(0);
        return adminJerseyConfiguration;
    }
}