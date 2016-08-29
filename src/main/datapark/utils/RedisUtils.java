package datapark.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

/**
 * Created by dpliyuan on 2016/2/29.
 */
public class RedisUtils {

//    private static Jedis jedis;//非切片额客户端连接
    private static JedisPool jedisPool;//非切片连接池
    private static Map configProperties = PropertiesUtil.getPropertyMap();

    public RedisUtils() {
        initRedisPool();
    }

    public RedisUtils(String host, int port) {
        initRedisPool(host, port);
    }

    private void initRedisPool() {
        if (jedisPool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxTotal(1000);
            config.setMaxIdle(20);
            config.setMinIdle(10);
//            config.setMaxWaitMillis(30000);
            jedisPool = new JedisPool(config, "10.45.143.87", 6379);
//            jedisPool = new JedisPool(config, "192.168.31.6", 6379);
        }

    }

    private void initRedisPool(String host, int port) {
        if (jedisPool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            jedisPool = new JedisPool(config, host, port);
        }

    }

    public Jedis getJedisFromPool() {
        return jedisPool.getResource();
    }

    public void returnJedisToPool(Jedis jedis) {
        if (jedis !=null){
            jedis.close();
        }
    }

}
