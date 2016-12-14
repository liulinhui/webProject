package com.learn.web.test.redisTest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.servlet.http.HttpServlet;

/**
 * Created by linkage on 2016-12-14.
 */
@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {
    private static Logger logger = Logger.getLogger(RedisDataSourceImpl.class);
    @Autowired
    private ShardedJedisPool shardedJedisPool;

    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            logger.error("getRedisClent error", e);
        }
        return null;
    }

    /**
     * returnResource方法已经被废弃了   用close代替
     * @param shardedJedis
     * @param broken
     */
    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
        shardedJedis.close();
    }
}
