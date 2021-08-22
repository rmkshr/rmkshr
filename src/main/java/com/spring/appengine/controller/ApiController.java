package com.spring.appengine.controller;

import com.spring.appengine.dataconfig.DataAccessController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/apiv3/appengine")
@RequiredArgsConstructor
public class ApiController {

    @RequestMapping(value = "/check")
    public String printMethod () {
        return "DOCKER CONTAINER RUN CHECK";
    }

    @RequestMapping(value = "/info/movies")
    public String getMovieInfo () throws IOException {
        DataAccessController dataAccessController = new DataAccessController();
        String movieData = dataAccessController.fetchAllData();
        return movieData;
    }
}
