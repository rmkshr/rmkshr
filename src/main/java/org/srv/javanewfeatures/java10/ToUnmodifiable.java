package org.srv.javanewfeatures.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToUnmodifiable {

  public static void main(String[] args) {

    //java.util.stream.Collectors get additional methods to collect a Stream into unmodifiable List,
    //Map or Set:

    List<String> nameList = new ArrayList<>();

    nameList.add("Ram");
    nameList.add("Sugan");
    nameList.add("Vihaan");

    List<String> unmodifiable = nameList.stream().filter(name -> name.contains("a"))
        .collect(Collectors.toUnmodifiableList());
    System.out.println(unmodifiable);

    //Any attempt to modify such a collection would result in
    //java.lang.UnsupportedOperationExceptionruntime exception.

    unmodifiable.add("Riya");
  }
}
