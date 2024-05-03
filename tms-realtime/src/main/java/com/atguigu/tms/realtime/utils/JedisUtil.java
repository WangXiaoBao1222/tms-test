package com.atguigu.tms.realtime.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Felix
 * @date 2023/5/30
 * 获取操作Redis客户端的工具类
 */
public class JedisUtil {
    private static JedisPool jedisPool;
    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(1000); // 最大连接数；
        poolConfig.setMaxIdle(5); // 最大空闲连接数；
        poolConfig.setMinIdle(5); // 最小空闲连接数；
        poolConfig.setBlockWhenExhausted(true); // 表示当pool中的jedis实例都被分配完时，是否要进行阻塞；
        poolConfig.setMaxWaitMillis(2000L); // 当blockWhenExhausted为true时，最大的阻塞时长。
        poolConfig.setTestOnBorrow(true); // 在资源池借出Jedis实例时，测试连接可用性，默认关闭，如果打开，则保证借出的都是可用的；
        jedisPool = new JedisPool(poolConfig,"hadoop102",6379,10000);
    }
    public static Jedis getJedis(){
        System.out.println("~~~创建Jedis客户端~~~");
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

    public static void main(String[] args) {
        Jedis jedis = getJedis();
        String pong = jedis.ping();
        System.out.println(pong);
    }
}