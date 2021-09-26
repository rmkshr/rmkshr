package com.rmkshr.callbacks;

import java.util.function.BiFunction;

public class Lambdas {

    public static void main(String[] args) {

        //THE PARAMTERS OF TYPE PRIMITIVE ARE NOT ALLOWED IN FUNCTIONAL PROGRAMMING
        BiFunction<Integer, Integer, Boolean> whichIsGreater = (numOne, numTwo) -> {
            return numOne > numTwo ? true : false;
        };

        System.out.println(whichIsGreater.apply(4,5));
    }
}
