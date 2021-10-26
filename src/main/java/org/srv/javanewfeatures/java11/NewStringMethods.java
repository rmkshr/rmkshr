package org.srv.javanewfeatures.java11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewStringMethods {

    public static void main(String[] args) {

        //Java 11 adds a few new methods to the String class:
        // isBlank, lines, strip, stripLeading, stripTrailing, and repeat.

        String multilineString = "King kong \n \n aint got \n shit on me.";
        List<String> lines = multilineString.lines().collect(Collectors.toList());
        List<String> collect = lines.stream().filter(line -> !line.isBlank()).map(String::strip).collect(Collectors.toList());
        System.out.println(collect);

        String repeatString = collect.get(0).repeat(2);
        System.out.println(repeatString);

        List<String> sampeList = Arrays.asList("ram");
        sampeList.add("sugan");
        System.out.println(sampeList);
        System.out.println("This is the end of line for the program");
    }
}
