package org.srv.combinatorpattern;

import java.time.LocalDate;

import static org.srv.combinatorpattern.CustomerRegistrationValidator.*;

/**
 * @author Ramkishore
 */
public class CombinatorMain {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "Ramkishore",
                "ramkishore619@gmail.com",
                "+919976135831",
                LocalDate.of(1993, 02, 02)
        );

        // THIS IS THE USUAL APPROACH ============================================
        System.out.println("USUAL APPROACH : ====== : "
                + new CustomerValidatorService().isValid(customer));

        //USING COMBINATOR PATTERN ============================================
        ValidationResult validationResult = isEmailValid().
                combine(isPhoneValid()).
                combine(isAdult()).apply(customer);

        System.out.println("COMBINATOR APPROACH : " + validationResult);

        if(validationResult != ValidationResult.SUCCESS){
            throw new IllegalStateException(validationResult.name());
        }
    }
}
