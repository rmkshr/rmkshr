package org.srv.appengine.controller;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.srv.appengine.dataconfig.DataAccessController;

/**
 * @author Ramkishore
 */
@RestController
@RequestMapping("/apiv3/appengine")
@RequiredArgsConstructor
public class ApiController {

  private final DataAccessController dataAccessController;

  @GetMapping("/check")
  public String printMethod() {
    return "DOCKER CONTAINER RUN CHECK";
  }

  @GetMapping("/info/movies")
  public String getMovieInfo() throws IOException {
    String movieData = dataAccessController.fetchAllData();
    return movieData;
  }


}
