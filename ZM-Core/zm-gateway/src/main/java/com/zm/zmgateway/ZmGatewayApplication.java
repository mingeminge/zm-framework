package com.zm.zmgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZmGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmGatewayApplication.class, args);
    }

}
