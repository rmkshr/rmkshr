package org.srv.javanewfeatures.java8.staticanddefault;

public interface Vehicle {

    // The static producer() method is available only through and inside of an interface.
    // It can't be overridden by an implementing class.
    static String producer() {
        return "V&R Vehicles";
    }

    //Default methods are declared using the new default keyword.
    //These are accessible through the instance of the implementing class and can be overridden.
    default String getOverview() {
        return "ATV made by " + producer();
    }
}
