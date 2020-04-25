package com.wanyibing;

import com.wanyibing.config.HostAddrKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class GatewayAppliction {

    public static void main(String[] args) {

        SpringApplication.run(GatewayAppliction.class,args);


    }
}
