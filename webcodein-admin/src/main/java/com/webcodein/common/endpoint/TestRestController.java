package com.webcodein.common.endpoint;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayHelloApi")
public class TestRestController {

    @GetMapping
    public String writeHello(){
        return "Hello world";
    }
}
