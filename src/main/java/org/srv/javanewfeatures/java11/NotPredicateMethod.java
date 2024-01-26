package org.srv.javanewfeatures.java11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotPredicateMethod {

  public static void main(String[] args) {

    //While not(isBlank) reads more naturally than isBlank.negate(),
    // the big advantage is that we can also use not with method references, like not(String:isBlank).
    List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
    List withoutBlanks = sampleList.stream()
        .filter(Predicate.not(String::isBlank))
        .collect(Collectors.toList());

    System.out.println(withoutBlanks);
  }
}
