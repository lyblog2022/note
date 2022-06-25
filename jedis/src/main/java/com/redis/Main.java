package com.redis;

import redis.clients.jedis.Jedis;

/**
 * Main
 *
 * @author liuyong
 * @version 1.0
 * @description com.redis
 * @date 2022/6/23 21:44
 */
public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.213.133",7001);
        jedis.set("text","hello jedis");
        String result = jedis.get("text");
        System.out.println(result);
    }
}
