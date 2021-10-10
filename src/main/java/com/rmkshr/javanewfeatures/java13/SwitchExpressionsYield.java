package com.rmkshr.javanewfeatures.java13;

public class SwitchExpressionsYield {

    //Using yield, we can now effectively return values from a switch expression:
    public static void main(String[] args) {
        Integer me = 4;
        String operation = "squareMe";
        Integer result = switch (operation) {
            case "doubleMe" -> {
                yield me * 2;
            }
            case "squareMe" -> {
                yield me * me;
            }
            default -> me;
        };
        System.out.println(result);
    }
}
