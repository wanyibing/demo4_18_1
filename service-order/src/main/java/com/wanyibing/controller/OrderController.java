package com.wanyibing.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wanyibing.dao.OrderReopsitory;
import com.wanyibing.entity.Order;
import com.wanyibing.entity.User;
import com.wanyibing.feign.UserFeignClient;
import com.wanyibing.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.ORB;
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

    @Autowired
    private OrderReopsitory orderReopsitory;


    /**
     * 根据Id查询订单
     * @param id
     * @return
     */

    @RequestMapping("getOrderById")
    public Order getOrderById(@RequestParam("id") Integer id){
        Order order = orderService.getOrderById(id);
        //service-user 是被调用的服务名称  写名称的时候不写地址和ip
//        User user = restTemplate.getForObject("http://service-user/user/getUserById?id="+order.getUserId(),User.class);
        User userParam = new User();
        userParam.setId(1);
        User user = userFeignClient.getUserByUser(userParam);

        log.info("user:{}",user);
        order.setUsername(user.getName());

        return  order;
    }

    public Order getUserFallbackMethod(Integer id){
        Order order = orderService.getOrderById(id);
        order.setUsername("固定值 ");
        return order;
    }


    @HystrixCommand(fallbackMethod = "getUserFallbackMethod")
    @RequestMapping("getOrderById2")
    public Order getOrderById2(@RequestParam("id") Integer id){
       /* Order order = orderService.getOrderById(id);
        User user = userFeignClient.getUserById(id);

        order.setUsername(user.getName());*/
       Order order = orderReopsitory.getOne(id);
       User user = userFeignClient.getuser(order.getUserId());
       order.setUserId(user.getId());
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
