package com.webcodein.common.config.webservice;

import com.webcodein.admin.config.webservice.AdminJerseyConfiguration;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig {

    @Bean
    public ServletRegistrationBean commonJerseyConfiguration() {
        ServletRegistrationBean commonJerseyConfiguration
                = new ServletRegistrationBean(new ServletContainer(new CommonJerseyConfiguration()));
        commonJerseyConfiguration.addUrlMappings("/api/v1/common/*");
        commonJerseyConfiguration.setName("CommonJerseyConfiguration");
        commonJerseyConfiguration.setLoadOnStartup(0);
        return commonJerseyConfiguration;
    }


    @Bean
    public ServletRegistrationBean adminJerseyConfiguration() {
        ServletRegistrationBean adminJerseyConfiguration
                = new ServletRegistrationBean(new ServletContainer(new AdminJerseyConfiguration()));
        adminJerseyConfiguration.addUrlMappings("/api/v1/admin/*");
        adminJerseyConfiguration.setName("AdminJerseyConfiguration");
        adminJerseyConfiguration.setLoadOnStartup(0);
        return adminJerseyConfiguration;
    }


}



