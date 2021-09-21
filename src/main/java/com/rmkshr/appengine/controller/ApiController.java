package com.rmkshr.appengine.controller;

import com.rmkshr.appengine.dataconfig.DataAccessController;
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

    @GetMapping("/check")
    public String printMethod() {
        return "DOCKER CONTAINER RUN CHECK";
    }

    @GetMapping("/info/movies")
    public String getMovieInfo() throws IOException {
        DataAccessController dataAccessController = new DataAccessController();
        String movieData = dataAccessController.fetchAllData();
        return movieData;
    }


}
