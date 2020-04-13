package com.zzy.redis.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.zzy.redis.entity.RedisUser;
import com.zzy.redis.service.RedisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisUserServiceImpl implements RedisUserService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 全查询
     * @return
     * @throws JsonProcessingException
     */
    public List<RedisUser> selectList() {
        List<String> list=stringRedisTemplate.opsForList().range("user",0,stringRedisTemplate.opsForList().size("user"));
        List<RedisUser> users=new ArrayList<>();
        for (String s:list){
            ObjectMapper mapper=new ObjectMapper();
            try {
                users.add(mapper.readValue(s, RedisUser.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    /**
     * 添加
     * @param user
     * @return
     */
    public Long add(RedisUser user){
        return stringRedisTemplate.opsForList().rightPush("user", JSON.toJSONString(user));
    }

    /**
     * 修改
     * @param user
     * @param number
     * @return
     */
    public Integer update(RedisUser user, Integer number){
        stringRedisTemplate.opsForList().set("user",number, JSON.toJSONString(user));
        return 1;
    }

    /**
     * 删除
     * @param user
     * @return
     */
    public Long del(RedisUser user){
        return stringRedisTemplate.opsForList().remove("user",1, JSON.toJSONString(user));
    }
}
