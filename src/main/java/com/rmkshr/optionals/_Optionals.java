package com.rmkshr.optionals;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Ramkishore
 */
public class _Optionals {

    public static void main(String[] args) {

        //FUNCTIONAL PROGRAM BLOCKS.
        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
        Supplier<Object> objectSupplier = () -> "supplier default value";

        //OFNULLABLE : RETURNS AN OPTIONAL DESCRIBING THE GIVEN VALUE, IF NON-NULL,
        // OTHERWISE RETURNS AN EMPTY OPTIONAL
        //ORELSEGET : IF A VALUE IS PRESENT, RETURNS THE VALUE,
        // OTHERWISE RETURNS THE RESULT PRODUCED BY THE SUPPLYING FUNCTION.
        Object value = Optional.ofNullable(null).orElseGet(objectSupplier);

        //ORELSETHROW : IF A VALUE IS PRESENT, RETURNS THE VALUE,
        // OTHERWISE THROWS AN EXCEPTION PRODUCED BY THE EXCEPTION SUPPLYING FUNCTION.
        Object valueOne = Optional.ofNullable("HI").
                orElseThrow(exception);

        System.out.println("=========" + value);
        System.out.println("=======" + valueOne);

        //IFPRESENT : IF A VALUE IS PRESENT, PE RFORMS THE GIVEN ACTION WITH THE VALUE,
        // OTHERWISE DOES NOTHING.
        Optional.ofNullable("ramkishore@gmail.com").ifPresent(email -> {
            System.out.println("Sending email to : " + email);
        });

        //IF A VALUE IS PRESENT, PERFORMS THE GIVEN ACTION WITH THE VALUE,
        // OTHERWISE PERFORMS THE GIVEN EMPTY-BASED ACTION.
        Optional.ofNullable(null).ifPresentOrElse(email ->
                        System.out.println("Sending email to : " + email),
                () -> {
                    System.out.println("Invalid Email id");
                });


    }
}
