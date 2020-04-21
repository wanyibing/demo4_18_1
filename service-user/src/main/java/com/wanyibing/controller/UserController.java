package com.wanyibing.controller;

import com.wanyibing.entity.User;
import com.wanyibing.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据Id查询用户
     * @param id
     * @return
     */
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping("getUserById")
    public User getUserById(@RequestParam("id") Integer id){
        log.info("UserId:{}",id+"/////////////////////");
        return userService.getUserById(id);
    }

    @RequestMapping("getUserByUser")
    public User getUserByUser(@RequestBody User user){
        log.info("UserId:{}",user.getId()+"/////////////////////");
        return userService.getUserById(user.getId());
    }

    /**
     * 根据id查询用户名称
     * @param id
     * @return
     */
    @RequestMapping("getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id){

        return userService.getUsernameById(id);
    }
}
