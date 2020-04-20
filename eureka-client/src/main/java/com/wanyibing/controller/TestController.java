package com.wanyibing.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wanyibing.config.ConsulConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@JsonIgnoreProperties("$$beanFactory")
@RefreshScope
@RestController
public class TestController {
   /* @Value("${config.info}")
    private String configInfo;*/

    @Autowired
    private ConsulConfigInfo consulConfigInfo;

    @RequestMapping("getconfig")
    public Object getConsulConfigInfo(){
    return consulConfigInfo;
    }


}
