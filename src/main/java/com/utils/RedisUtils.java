package com.utils;

import com.alibaba.fastjson.JSON;
import com.common.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class RedisUtils<T> {
    @Autowired
    private RedisService redisService;

    public void updateRedisListValue(String key,List<T> list){
        String result= JSON.toJSON(list).toString();
        redisService.set(key,result);
    }
}
