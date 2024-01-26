package org.srv.javanewfeatures.java15;

public class RecordsWithOverride {

  public static void main(String[] args) {

  }

  //While records eliminate a lot of boilerplate code, they do allow us to override some of the default behaviors.
  //For example, we could define a canonical constructor that does some validation:
  //Records are always final by default.
  public static record ShoppingData(Integer price, String name, String description) {

    public ShoppingData {
      if (price < 0) {
        throw new IllegalArgumentException("price cannot be a negative value");
      }
    }
  }
}
