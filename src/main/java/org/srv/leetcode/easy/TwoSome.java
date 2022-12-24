package org.srv.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSome {
    public static void main(String[] args) {
        List<Integer> parentList = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 1, 7, 8, 9, 10));
        int target = 5;

        System.out.println("START=====================OLF FOR LOOP======");
        for (int r = 0; r < parentList.size(); r++) {
            for (int m = r + 1; m < parentList.size(); m++) {
                if (target == parentList.get(r) + parentList.get(m)) {
                    System.out.println(Arrays.asList(r, m));
                    break;
                }
            }
        }
        System.out.println("END=====================OLF FOR LOOP======");

        System.out.println("START===========ENHANCED FOR LOOP");
        for (int firstIteratorInt : parentList) {
            for (int secondIteratorInt : parentList) {
                if (target == firstIteratorInt + secondIteratorInt) {
                    System.out.println(Arrays.asList(parentList.indexOf(firstIteratorInt), parentList.indexOf(secondIteratorInt)));
                    break;
                }
            }
        }
        System.out.println("END===========ENHANCED FOR LOOP");
    }
}
