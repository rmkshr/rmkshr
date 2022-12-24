package org.srv.leetcode.easy;

public class Palindrome {
    public static void main(String[] args) {
        Integer input = 919;
        if (new StringBuilder(String.valueOf(input)).reverse().toString().equals(input.toString())){
            System.out.println("It is a palindrome");
        } else {
            System.out.println("It is NOT a palindrome");
        }
    }
}
