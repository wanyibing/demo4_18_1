package com.wanyibing.feign;
import com.wanyibing.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * z指定服务名称:service-user
 * feign服务端是调用用户服务接口的
 * orderf服务调用了用户服务,如果其他服务服务
 * 那么它也压迫创建feignclient相关接口 其他
 */
@Component
@FeignClient(name = "service-user")
public interface UserFeignClient {

    @RequestMapping("/user/getUserById")
    public User getUserById(@RequestParam("id") Integer id);

    @RequestMapping("/user/getUserByUser")
    public User getUserByUser(@RequestBody User user);

    /**
     * 根据Id，查询用户名称
     * @param id
     * @return
     */
    @RequestMapping("/user/getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id);
}
