package org.srv.appengine.controller;

import org.srv.appengine.dataconfig.DataAccessController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Ramkishore
 */
@RestController
@RequestMapping("/apiv3/appengine")
@RequiredArgsConstructor
public class ApiController {

    private final  DataAccessController dataAccessController;

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
