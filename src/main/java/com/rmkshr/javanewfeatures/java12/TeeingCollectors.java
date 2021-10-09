package com.rmkshr.javanewfeatures.java12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TeeingCollectors {

    public static void main(String[] args) {

        //It is a composite of two downstream collectors. Every element is processed by both downstream collectors.
        //Then their results are passed to the merge function and transformed into the final result.

        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List collect = numberList.stream().collect(
                Collectors.teeing(
                        Collectors.summingInt(num -> (Integer) num),
                        Collectors.counting(), (sum, count) -> List.of(sum, count))
        );
        System.out.println(collect);
    }
}
