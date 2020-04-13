package com.zzy.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisUser implements Serializable {
    private Integer userId;
    private String userName;
    private String sex;
    private Integer age;
    private String phone;
}
