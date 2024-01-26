package org.srv.javanewfeatures.java11;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import lombok.NonNull;

public class LocalVariableSyntaxForLambda {

  public static void main(String[] args) {

    //Support for using the local variable syntax (var keyword) in lambda parameters was added in Java 11.
    //We can make use of this feature to apply modifiers to our local variables, like defining a type annotation:

    List<String> nameList = Arrays.asList("Ram", "Sugan", "Vihaan");
    String resultString = nameList.stream().map((@NonNull var x) -> x.toUpperCase(Locale.ROOT))
        .collect(Collectors.joining(","));
    System.out.println(resultString);
  }
}
