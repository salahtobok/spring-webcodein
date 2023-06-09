package com.webcodein.common.endpoint;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
