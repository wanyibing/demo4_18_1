package com.wanyibing.controller;

import com.wanyibing.entity.Order;
import com.wanyibing.entity.User;
import com.wanyibing.feign.UserFeignClient;
import com.wanyibing.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 根据Id查询订单
     * @param id
     * @return
     */
    @RequestMapping("getOrderById")
    public Order getOrderById(@RequestParam("id") Integer id){
        Order order = orderService.getOrderById(id);
        //service-user是被调用服务名称，spring.application.name的名称
        User user = restTemplate.getForObject("http://service-user/user/getUserById?id="+order.getUserId(), User.class);
//        User user = userFeignClient.getUserById(id);
       /* User userParam = new User();
        userParam.setId(1);
        User user = userFeignClient.getUserByUser(userParam);
        log.info("user:{}",user);*/
        order.setUsername(user.getName());
        return order;
    }

    @RequestMapping("getOrderById2")
    public Order getOrderById2(@RequestParam("id") Integer id){
        Order order = orderService.getOrderById(id);
        //service-user是被调用服务名称，spring.application.name的名称
        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id="+order.getUserId(), User.class);
       User user = userFeignClient.getUserById(id);
      /*  User userParam = new User();
        userParam.setId(1);
        User user = userFeignClient.getUserByUser(userParam);
        log.info("user:{}",user);*/
        order.setUsername(user.getName());
        return order;
    }


    @RequestMapping("getOrderById3")
    public Order getOrderById3(@RequestParam("id") Integer id){
        Order order = orderService.getOrderById(id);
        //service-user是被调用服务名称，spring.application.name的名称
        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id="+order.getUserId(), User.class);
      //  User user = userFeignClient.getUserById(id);
         User userParam = new User();
        userParam.setId(1);
        User user = userFeignClient.getUserByUser(userParam);
        log.info("user:{}",user);
        order.setUsername(user.getName());
        return order;
    }


}
