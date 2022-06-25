package com.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * ClusterDemo
 *
 * @author liuyong
 * @version 1.0
 * @description com.redis
 * @date 2022/6/23 21:59
 */
public class ClusterDemo {
    public static void main(String[] args) {
        Set<HostAndPort> set = new HashSet<>();
        set.add(new HostAndPort("192.168.213.133",7001));
        set.add(new HostAndPort("192.168.213.133",7002));
        set.add(new HostAndPort("192.168.213.133",7003));
        set.add(new HostAndPort("192.168.93.10",7004));
        set.add(new HostAndPort("192.168.93.10",7005));
        set.add(new HostAndPort("192.168.93.10",7006));
        JedisCluster jedisCluster = new JedisCluster(set);
        jedisCluster.set("name","bjmsb");
        String value = jedisCluster.get("name");
        System.out.println(value);
    }
}
