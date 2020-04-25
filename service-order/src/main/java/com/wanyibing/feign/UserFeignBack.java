package com.wanyibing.feign;

import com.wanyibing.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
//@Configuration
public class UserFeignBack implements UserFeignClient{


    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public User getUserByUser(User user) {
        User u = new User();
        u.setName("固定值");

        return u;
    }

    @Override
    public String getUsernameById(Integer id) {
        return null;
    }

    @Override
    public User getuser(Integer id) {
        return null;
    }
}
