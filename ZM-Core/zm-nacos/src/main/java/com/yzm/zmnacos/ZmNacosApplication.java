package com.yzm.zmnacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZmNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmNacosApplication.class, args);
    }

}
