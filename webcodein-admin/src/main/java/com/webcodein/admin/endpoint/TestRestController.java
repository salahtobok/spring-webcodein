package com.webcodein.admin.endpoint;


import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/sayHelloApi")
public class TestRestController {

    @GetMapping
    public String writeHello(){
        return "Hello world";
    }
}
