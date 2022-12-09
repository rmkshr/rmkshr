package org.srv.interview;

import org.assertj.core.util.Arrays;

import java.io.IOException;
import java.util.List;

public class PracticePrograms {

    /**
     * Method to manipulate file data.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {

//    twoSum(new int[]{1, 2, 3, 4, 5, 6}, 6);

        String[] listarray = {"vihaan","srv"};
        isPalUtil(555, 555);
    }


    public static void isLetterRepeated() {
        String inputString = "quickbrownfox";
        char[] input = inputString.toCharArray();
        String a = String.valueOf(input[0]);
        boolean result = false;
        for(int i = 0 ; i < input.length ; i ++) {
            for (int j = i+1; j < input.length; j++) {
                if (String.valueOf(input[i]).equals(String.valueOf(input[j]))) {
                    result = true;
                }
            }
        }
        System.out.println(result);
    }

    public static void twoSum (int[] inputArray, int target) {
        for (int a = 0; a < inputArray.length; a++) {
            for (int b = 0; b < inputArray.length; b++) {
                if (inputArray[a] + inputArray[b] == target) {
                    System.out.println(inputArray[a] + "," + inputArray[b]);
                }
            }
        }
    }

    public static void isIntegerPalindrome (Integer input) {
       StringBuilder intValue =  new StringBuilder();
       intValue.append(input.toString());
       if(intValue.equals(intValue.reverse())){
           System.out.println(true);
       }

       int primitive = input;
       //TODO
    }

    //TODO
    public static int isPalUtil
            (int num, int dupNum) throws Exception {

        if (num == 0) {
            return dupNum;
        } else {
            dupNum = isPalUtil(num / 10, dupNum);
        }
        if (num % 10 == dupNum % 10) {
            return dupNum / 10;
        } else {
            throw new Exception();
        }

    }
}
