package com.rmkshr.javanewfeatures.java12;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SwitchExpressionsPreview {

    public static void main(String[] args) {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String typeOfDay = "";

        //New switch statements are not only more compact and readable. They also remove the need for break statements.
        // The code execution will not fall through after the first match.
        //Another notable difference is that we can assign a switch statement directly to the variable.
        // It was not possible previously.
        
        typeOfDay = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
            case SATURDAY, SUNDAY -> "Day Off";
        };
        System.out.println(typeOfDay);
        
        //Alternative way to implement the same. 

        switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
                System.out.println("Working day");
            }
            case SATURDAY, SUNDAY -> {
                System.out.println("Day Off");
            }
        };
 
    }
}
