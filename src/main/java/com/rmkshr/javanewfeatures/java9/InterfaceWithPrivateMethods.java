package com.rmkshr.javanewfeatures.java9;

public interface InterfaceWithPrivateMethods {

    //Interfaces in the upcoming JVM version can have private methods,
    //which can be used to split lengthy default methods:

    private static String staticPrivate() {
        return "static private";
    }

    private String instancePrivate() {
        return "instance private";
    }

    default void check() {
        String result = staticPrivate();
        InterfaceWithPrivateMethods pvt = new InterfaceWithPrivateMethods() {
            // anonymous class hidden from other logics
        };
        result = pvt.instancePrivate();
    }
}
