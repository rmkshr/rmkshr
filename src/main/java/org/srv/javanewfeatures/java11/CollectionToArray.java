package org.srv.javanewfeatures.java11;

import java.util.Arrays;
import java.util.List;

public class CollectionToArray {

    //The java.util.Collection interface contains a new default toArray method which takes an IntFunction argument.
    //This makes it easier to create an array of the right type from a collection:

    public static void main(String[] args) {
        List sampleList = Arrays.asList("Java", "Kotlin");
        Object[] objects = sampleList.toArray(String[]::new);
        System.out.println(
                objects
        );
    }
}
