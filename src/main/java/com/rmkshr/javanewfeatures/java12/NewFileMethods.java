package com.rmkshr.javanewfeatures.java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewFileMethods {

    public static void main(String[] args) {

        //The method is used to compare two files and find the position of the first mismatched byte in their contents.
        //The return value will be in the inclusive range of 0L up to the byte size of the smaller file or -1L if the files are identical.

        try {
            Path pathOne = Files.createTempFile(Path.of("/Users/ramkishoremadheshwaran/Local/javatempfiles"),"tempFileOne", ".txt");
            Path pathTwo = Files.createTempFile(Path.of("/Users/ramkishoremadheshwaran/Local/javatempfiles"),"tempFileTwo", ".txt");
            Files.writeString(pathOne, "Ram learning Java12 concepts");
            Files.writeString(pathTwo, "Ram learning Java12 concepts");
            long mismatchPointer = Files.mismatch(pathOne, pathTwo);
            System.out.println(mismatchPointer);

            Path pathThree = Files.createTempFile(Path.of("/Users/ramkishoremadheshwaran/Local/javatempfiles"),"tempFileThree", ".txt");
            Path pathFour = Files.createTempFile(Path.of("/Users/ramkishoremadheshwaran/Local/javatempfiles"),"tempFileFour", ".txt");
            Files.writeString(pathThree, "Ram learning Java12 concepts");
            Files.writeString(pathFour, "Ram learning Java12");
            long mismatchPointerTwo = Files.mismatch(pathThree, pathFour);
            System.out.println(mismatchPointerTwo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
