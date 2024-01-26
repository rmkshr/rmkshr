package org.srv.javanewfeatures.java10;

import java.util.HashSet;
import java.util.Set;

public class CopyOf {

  public static void main(String[] args) {
    //java.util.List, java.util.Map and java.util.
    //Set each got a new static method copyOf(Collection).
    //It returns the unmodifiable copy of the given Collection:

    Set<Integer> integerSet = new HashSet<>();
    integerSet.add(14);
    integerSet.add(12);
    integerSet.add(01);
    integerSet.add(02);
    Set<Integer> copyCat = Set.copyOf(integerSet);
    // The below statement will throw UnsupportedOperationException runtime exception.
    copyCat.add(22);
    System.out.println(copyCat);


  }
}
