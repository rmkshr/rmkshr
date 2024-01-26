package org.srv.javanewfeatures.java14;

public class TextBlockMultiLine {

  public static void main(String[] args) {

    String multiLine = "A quick brown fox jumped over the lazy dog; The lazy dog howls loudly;";

    String multiline = """
        A quick brown fox jumps over a lazy dog; \
        the lazy dog howls loudly.""";

    System.out.println(multiLine);
  }
}
