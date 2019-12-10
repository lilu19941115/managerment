package com.rest;

import com.common.api.ApiRest;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserRest extends ApiRest {
    private static final Logger LOG= LoggerFactory.getLogger(UserRest.class);
    @Autowired
    private UserService userService;
}
