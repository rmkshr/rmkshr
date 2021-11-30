package org.srv.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonObjectMapper {
//Jackson is CASE SENSITIVE : case sensitivity between the json and the POJO class MATTERS!

    /**
     * Function used to marshal data between json and POJO class.
     * @return
     * @throws IOException
     */
    public EmployeeJackson readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeJackson employeeJackson = objectMapper.readValue(new File("/Users/ramkishoremadheshwaran/Documents/IntelliJ Workspace/rmkshr/src/main/java/org/srv/jackson/employee.json"), EmployeeJackson.class);
        System.out.println(employeeJackson.toString());
        return employeeJackson;
    }
}
