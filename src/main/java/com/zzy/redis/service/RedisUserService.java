package com.zzy.redis.service;




import com.zzy.redis.entity.RedisUser;

import java.util.List;

public interface RedisUserService {
    List<RedisUser> selectList();

    Long add(RedisUser user);
    Integer update(RedisUser user, Integer number);
    Long del(RedisUser user);
}
