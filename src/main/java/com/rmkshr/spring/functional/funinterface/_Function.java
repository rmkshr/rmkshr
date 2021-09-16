package com.rmkshr.spring.functional.funinterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        //Usual Approach
        int increment = increment(4);
        System.out.println("Usual Approach ======= " + increment);

        //Functional Approach
         int incrementByFunction = incrementOnOneFunction.apply(9);
        System.out.println("Fucntional Approach Increment========= " + incrementByFunction);

        //Chaining multiple functions
        Function<Integer,Integer> squareIncrement = squareNumberFunction.andThen(incrementOnOneFunction);
        int squareIncrementNumber = squareIncrement.apply(5);
        System.out.println("Fucntional Approach Increment Chain========= " + squareIncrementNumber);

    }

    //Usual Approach
    static int increment (int input) {
        return input+1;
    }

    //Functional Approach [ONE INPUT, ONE OUTPUT]
    static Function<Integer, Integer> incrementOnOneFunction = number -> number+1;
    static Function<Integer,Integer> squareNumberFunction = number -> number*number;

    //Bi-Functional Approach [TWO INPUT, ONE OUTPUT]
}
