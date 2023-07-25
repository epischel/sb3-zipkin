package de.epischel.zipkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class MyController {

    private static final Logger log = LoggerFactory.getLogger(MyController.class);
    private final MyUserService myUserService;
//
//    MyController(MyUserService myUserService) {
//        this.myUserService = myUserService;
//    }
    private RestTemplate rest;
    
    public MyController(MyUserService myUserService, RestTemplateBuilder builder) {
    	rest = builder.build();
    	this.myUserService = myUserService;
    }

    @GetMapping("/user/{userId}")
    String userName(@PathVariable("userId") String userId) {
        log.info("Got a request");
        myUserService.userName(userId);
        String response = rest.getForObject("https://httpbin.org/headers", String.class);
        log.info(response);
        return "erik"; //myUserService.userName(userId);
    }
}
