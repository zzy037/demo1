package com.zzy.redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author 邹靓仔
 * @date 2020/4/11 -15:26 -zzy_redis
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUserServiceTest {

    @Autowired
    private RedisUserService redisUserService;

    @Test
    public void selectList() {
        redisUserService.selectList();
    }
}