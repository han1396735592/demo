package com.alibaba.cloud.acm.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
@RefreshScope
class SampleController {

    @Value("${user.name}")
    String userName;

    @Value("${user.id}")
    String userId;

    @RequestMapping("/acm")
    public String simple() {
        return "Hello Spring Cloud ACM!" + "Hello " + userName + "," + userId + "," + this;
    }
}