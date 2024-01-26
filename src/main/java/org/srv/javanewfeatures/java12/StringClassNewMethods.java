package org.srv.javanewfeatures.java12;

public class StringClassNewMethods {

  public static void main(String[] args) {

    //If the parameter is greater than zero, new spaces will be inserted at the beginning of each line.
    //On the other hand, if the parameter is less than zero, it removes spaces from the begging of each line.
    //If a given line does not contain sufficient white space, then all leading white space characters are removed.
    String text = "Hi guys this is Ramkishore";
    text = text.indent(5);
    System.out.println(text);
    text = text.indent(-10);
    System.out.println(text);

    //The second new method is transform.
    //It accepts a single argument function as a parameter that will be applied to the string.
    String someString = "qwerty";
    someString = someString.transform(value -> new StringBuilder(value).reverse().toString());
    System.out.println(someString);
  }
}
