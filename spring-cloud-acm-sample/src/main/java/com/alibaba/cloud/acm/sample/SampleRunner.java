package com.alibaba.cloud.acm.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    @Value("${user.id}")
    String userId;

    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int userAge;

    public void run(ApplicationArguments args) {
        System.out.println(userId);
        System.out.println(userName);
        System.out.println(userAge);
    }
}