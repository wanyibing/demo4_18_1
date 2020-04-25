package com.wanyibing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConifgServiceAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(ConifgServiceAppliaction.class,args);
    }
}
