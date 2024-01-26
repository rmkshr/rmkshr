package org.srv.javanewfeatures.java14;

public class Records {

  public static void main(String[] args) {

    UserRecord userOne = new UserRecord(789, "rmkshr", "rmkshr", "rmkshr", "Komalikadu");
    System.out.println(userOne.toString());

  }

  //we are making use of a new keyword, record, here.
  //This simple declaration will automatically add a constructor, getters, equals, hashCode and toString methods for us.

  public static record UserRecord(long id, String userName, String Password, String name,
                                  String address) {

  }

}
