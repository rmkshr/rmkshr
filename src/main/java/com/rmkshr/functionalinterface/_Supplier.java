package com.rmkshr.functionalinterface;

import java.util.Random;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        //WITHOUT SUPPLIER
        System.out.println("Random Number " + generateRandomNumber());

        //WITH SUPPLIER
        System.out.println("Random Number with Supplier : " + randomSupplier.get());
    }

    //IMPERATIVE APPROACH
    static Integer generateRandomNumber() {
        return new Random().nextInt(500);
    }

    //DECLARATIVE APPROACH
    static Supplier<Integer> randomSupplier = () -> new Random().nextInt(500);
}
