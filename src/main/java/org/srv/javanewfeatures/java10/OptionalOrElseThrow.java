package org.srv.javanewfeatures.java10;

import java.util.List;

public class OptionalOrElseThrow {

  public static void main(String[] args) {

    List<Integer> integerHolder = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //java.util.Optional, java.util.OptionalDouble, java.util.OptionalInt and
    //java.util.OptionalLong each got a new method
    //orElseThrow(), which doesn't take any argument and throws
    // NoSuchElementException if no value is present:

    Integer integer_not_found = integerHolder.stream().filter(i -> i == 11).findFirst()
        .orElseThrow(() -> new IllegalStateException("Integer Not found"));

    System.out.println(integer_not_found);
  }
}
