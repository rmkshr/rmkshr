package org.srv.jackson;

import org.junit.jupiter.api.Test;

public class JacksonObjectMapperTest {

  @Test
  public void testReadJsonWithObjectMapper() throws Exception {
    JacksonObjectMapper jacksonObjectMapper = new JacksonObjectMapper();
    jacksonObjectMapper.readJsonWithObjectMapper();
  }
}
