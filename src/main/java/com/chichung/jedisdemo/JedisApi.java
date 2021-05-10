package com.chichung.jedisdemo;

import redis.clients.jedis.Jedis;

/**
 * jedis原生客户端使用。
 */
public class JedisApi {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.get("name");
        jedis.close();
    }
}
