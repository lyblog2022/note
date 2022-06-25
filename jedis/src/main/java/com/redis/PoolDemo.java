package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * PoolDemo
 *
 * @author liuyong
 * @version 1.0
 * @description com.redis
 * @date 2022/6/23 21:54
 */
public class PoolDemo {
    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMinIdle(3);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"192.168.213.133",7001);
        Jedis jedis = jedisPool.getResource();
        jedis.set("jedisdemo","pool1");
        String value = jedis.get("jedisdemo");
        System.out.println(value);
    }
}
