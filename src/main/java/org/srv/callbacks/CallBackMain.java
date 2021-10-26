package org.srv.callbacks;

import java.util.function.Consumer;

public class CallBackMain {

    public static void main(String[] args) {

        Consumer<String> stringConsumer = value -> System.out.println("No last name provided" + value);
        hello("Ram", "kishore", stringConsumer);
        hello2("Ram", null,
                () -> System.out.println("No last name provided"));

    }

    //IMPLEMENTING CALLBACK USING CONSUMER
    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    //IMPLEMENTING CALLBACK USING RUNNABLE
    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
