package com.rmkshr.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        //IMPERATIVE APPROACH
        System.out.println("===============WITHOUT PREDICATE");
        System.out.println(validateMobileNumber("919976135831"));
        System.out.println(validateMobileNumber("9976135831"));
        System.out.println(validateMobileNumber("09976135831"));

        //DECLARATIVE APPROACH
        System.out.println("===============WITH PREDICATE");
        System.out.println(validateMobilePredicate.test("919976135831"));
        System.out.println(validateMobilePredicate.test("9976135831"));
        System.out.println(validateMobilePredicate.test("09976135831"));
    }

    //IMPERATIVE APPROACH
    static boolean validateMobileNumber(String mobileNumber) {
        return mobileNumber.startsWith("91") && mobileNumber.length()==12;
    }

    //DECLARATIVE APPROACH
    static Predicate<String> validateMobilePredicate = mobileNumber -> mobileNumber.startsWith("91") && mobileNumber.length()==12;
}
