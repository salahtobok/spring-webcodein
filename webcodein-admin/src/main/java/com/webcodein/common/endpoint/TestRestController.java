package com.webcodein.common.endpoint;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Slf4j
@Path("/sayHello")
public class TestRestController {


    @GET
    @Produces(APPLICATION_JSON)
    public String writeHello() {
        return "HHHHHHHHHHHHHHHHH";
    }
}
