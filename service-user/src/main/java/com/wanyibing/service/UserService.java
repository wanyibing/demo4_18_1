package com.wanyibing.service;


import com.wanyibing.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * 根据Id 查询user
     * @param id
     * @return
     */
    public User getUserById(Integer id){
        User user = new User();
        user.setId(id);
        user.setName("userName："+id);
        return user;
    }

    /**
     * 根据Id，查询用户名称
     * @param id
     * @return
     */
    public String getUsernameById(Integer id){
        User user = getUserById(id);
        return user.getName();
    }
}
