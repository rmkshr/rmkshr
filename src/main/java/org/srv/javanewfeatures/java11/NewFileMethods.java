package org.srv.javanewfeatures.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewFileMethods {

    public static void main(String[] args) {

        //We can use the new readString and writeString static methods from the Files class:

        try {
            Path path = Files.writeString(Files.createTempFile(Path.of("/Users/ramkishoremadheshwaran/Local/javatempfiles"), "file_demo", ".txt"),
                    "First program with desktop setup");
            String fileContent = Files.readString(path);
            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
