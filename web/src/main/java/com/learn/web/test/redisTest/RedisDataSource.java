package com.learn.web.test.redisTest;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by linkage on 2016-12-14.
 */
public interface  RedisDataSource {
    public abstract ShardedJedis getRedisClient();  //取得redis的客户端，可以执行命令了。
    public void returnResource(ShardedJedis shardedJedis,boolean broken);  //出现异常后，将资源返还给pool （其实不需要第二个方法）
}
