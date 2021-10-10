package com.rmkshr.javanewfeatures.java16;

import java.util.Arrays;
import java.util.List;

public class StreamsToList {

    public static void main(String[] args) {

        //Java 16 introduces toList method in streams to reduce the boilerplate codes like Collectors.toList or Collectors.toSet

        List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List filteredList = numList.stream().filter(n -> n == 2).toList();
        System.out.println(filteredList);
    }
}
