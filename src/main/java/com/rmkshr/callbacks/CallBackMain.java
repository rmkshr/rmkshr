package com.rmkshr.callbacks;

import java.util.function.Consumer;

public class CallBackMain {

    public static void main(String[] args) {

    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }
}
