package com.canon4g.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.canon4g.provider.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
