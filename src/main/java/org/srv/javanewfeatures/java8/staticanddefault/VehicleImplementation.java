package org.srv.javanewfeatures.java8.staticanddefault;

import static org.srv.javanewfeatures.java8.staticanddefault.Vehicle.*;

public class VehicleImplementation implements Vehicle {

    // The static producer() method is available only through and inside of an interface.
    // It can't be overridden by an implementing class.

    //Default methods are declared using the new default keyword.
    //These are accessible through the instance of the implementing class and can be overridden.

    public static void main(String[] args) {
        String producer = producer();
        Vehicle vehicle = new VehicleImplementation();
        System.out.println(producer);
        System.out.println(vehicle.getOverview());
        
    }
}
