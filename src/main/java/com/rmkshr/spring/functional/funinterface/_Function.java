package com.rmkshr.spring.functional.funinterface;

import java.util.function.BiFunction;
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
        int squareIncrementNumber = squareIncrement.apply(5);
        System.out.println("Fucntional Approach Increment Chain========= " + squareIncrementNumber);

        //BI-FUNCTIONAL APPROACH [TWO INPUT, ONE OUTPUT]
        int sumOfNumbers = addTwoNumbers.apply(5,5);
        System.out.println("Bi-Function === Add Two Numbers : " + sumOfNumbers);

        String combinedStrings = combineStrings.apply("Vihaan ","S.R");
        System.out.println("Combined String : " + combinedStrings);
    }

    //Usual Approach
    static int increment (int input) {
        return input+1;
    }

    public static String joinTwoStrings(String source, String target) {
        return source.concat(target);
    }

    //Functional Approach [ONE INPUT, ONE OUTPUT]
    static Function<Integer, Integer> incrementOnOneFunction = number -> number+1;
    static Function<Integer,Integer> squareNumberFunction = number -> number*number;

    //Chaining multiple functions
    static Function<Integer,Integer> squareIncrement = squareNumberFunction.andThen(incrementOnOneFunction);

    //BI-FUNCTIONAL APPROACH [TWO INPUT, ONE OUTPUT]
    static BiFunction<Integer, Integer, Integer> addTwoNumbers = (numOne, numTwo) -> incrementOnOneFunction.apply(numOne) + incrementOnOneFunction.apply(numTwo);
    static BiFunction<String, String, String>  combineStrings = (source, target) -> joinTwoStrings(source,target);
}
