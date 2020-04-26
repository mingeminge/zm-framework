package com.zm.zmadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ZmAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmAdminApplication.class, args);
    }

}
