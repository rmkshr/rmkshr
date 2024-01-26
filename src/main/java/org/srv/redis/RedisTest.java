package org.srv.redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RedisTest {

  @Test
  public void testRedisCache() {
    String redisConnect = RedisUtils.redisConnect();
    Assertions.assertEquals(redisConnect, "S.R.Vihaan");
  }
}
