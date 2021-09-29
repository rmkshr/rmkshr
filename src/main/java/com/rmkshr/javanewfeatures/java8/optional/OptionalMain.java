package com.rmkshr.javanewfeatures.java8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalMain {


    public static void main(String[] args) {

        //An instance of the Optional class can be created with the help of its static methods
        Optional<String> optionalEmpty = Optional.empty();
        System.out.println(optionalEmpty.isPresent());

        //Returns an Optional which contains a non-null value.
        String value = "VIHAAN";
        Optional<String> optionalValue = Optional.of(value);
        System.out.println(optionalValue.get());

        //Will return an Optional with a specific value or an empty Optional if the parameter is null.
        Optional<String> optionalOfNullable = Optional.ofNullable(value);
        System.out.println(optionalOfNullable.get());


        //Usual way
        List<String> userOpt = getUserNames() != null ? getUserNames() : new ArrayList<>();

        //Using optional
        List<String> userNameList = Optional.of(getUserNames()).orElseGet(() -> new ArrayList<>());

        //Assume you have an object of type User which has a field of type Address
        // with a field street of type String.
        //And for some reason you need to return a value of the street field if some
        //exist or a default value if street is null:


        //Usual way
        UserOptional user = getUser();
        if (user != null) {
            AddressOptional address = user.getAddress();
            if (address != null) {
                String street = address.getStreetName();
                if (street != null) {
                    System.out.println(street);
                }
            }
        }
        System.out.println("Not Specified");

        //With Optional
        Optional<UserOptional> userOptional = Optional.ofNullable(getUser());
        String result = userOptional.map(UserOptional::getAddress)
                .map(AddressOptional::getStreetName).orElse("Not specified");

        //Imagine that our getters return Optional<T>.
        // So, we should use the flatMap() method instead of the map():

        String optionalString = userOptional.flatMap(UserOptional::getAddressOptional)
                .flatMap(AddressOptional::getStreetNameOptional).orElse("Not Specified");

        //Another use case of Optional is changing NPE with another exception.
        //So, as we did previously,
        //let's try to do this in pre-Java 8's style:

        String valueOfString = null;
        String resultOfString = "";
        try {
            resultOfString = value.toUpperCase();
        } catch (NullPointerException exception) {
            throw new IllegalStateException("Illegal Parameter");
        }

        // Using Optional to throw Custom exceptions.
        String resultOptional = Optional.ofNullable(valueOfString).orElseThrow(() -> new IllegalStateException("")).toUpperCase();

    }


    static List<UserOptional> getUserList() {
        AddressOptional address = new AddressOptional(711,"Komalikadu","TamilNadu","India",637102);
        List<UserOptional> userOptional = List.of(
                new UserOptional("Ramkishore", 9976135831D, address));
        return userOptional;
    }

    static UserOptional getUser() {
        AddressOptional address = new AddressOptional(711,"Komalikadu","TamilNadu","India",637102);
        return new UserOptional("Ramkishore", 9976135831D, address);
    }

    static List<String> getUserNames() {
        return List.of("Ram", "Suganya","Vihaan");
    }
}
