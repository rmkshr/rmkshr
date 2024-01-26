package org.srv.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisUtils {

  /**
   * Function to store and get data from redis cache.
   *
   * @return value
   */
  public static String redisConnect() {
    RedisClient redisClient = RedisClient.create(RedisURI.create("localhost", 6379));
    StatefulRedisConnection<String, String> statefulRedisConnection = redisClient.connect();
    RedisCommands<String, String> redisCommands = statefulRedisConnection.sync();
    redisCommands.set("key", "Hello World");
    redisCommands.set("key", "S.R.Vihaan");
    return redisCommands.get("key");
  }
}
