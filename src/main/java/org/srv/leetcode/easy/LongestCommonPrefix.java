package org.srv.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        List<String> inputString = new ArrayList<>(Arrays.asList("rivian","ragnarok","ratatoskar", "red"));
        System.out.println(inputString);
        int lengthOfShortestString = inputString
                .stream()
                .map(String::length)
                .min(Integer::compare)
                .get();
        System.out.println("\nLength of Shortest String is = "
                + lengthOfShortestString);
        List<String[]> charArrays = inputString.stream().map(name -> name.split("")).toList();
        StringBuilder commonPrefix = new StringBuilder();
        for(int i = 0 ; i < lengthOfShortestString; i++){
            List<String> charList = new ArrayList<>();
            for(String[] letters : charArrays){
                charList.add(letters[i]);
            }
            if (charList.stream().allMatch(letter -> letter.equals(charList.get(0)))){
                commonPrefix.append(charList.get(0));
            }
        }
        System.out.println("\nLongest common prefix is : "
                + commonPrefix.toString());
    }
}
