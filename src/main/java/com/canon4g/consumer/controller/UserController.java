package com.canon4g.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.canon4g.provider.model.User;
import com.canon4g.provider.service.UserService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * create by Canon4G 2019-01-04
 **/
@RestController
@RequestMapping(value = "user/")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping(value = "sayHello")
    public String sayHello(@RequestParam(name = "name") String name) {
        return userService.sayHello(name);
    }

    @RequestMapping(value = "initRedisData")
    public String initRedisData(){
        userService.redisInitData();
        return "success";
    }

    @RequestMapping(value = "/getUserRedisByLoginName/{loginName}")
    public Map<String, Object> getUserRedisByLoginName(@PathVariable String loginName) {
        Map<String, Object> result = new HashMap<>();
        User user = userService.getUserInfo(loginName);
        Assert.notNull(user);
        result.put("name", user.getUserName());
        return result;
    }
}
