package org.srv.javanewfeatures.java8.methodreference;

import java.util.List;
import java.util.stream.Stream;


public class MRMain {


  public static void main(String[] args) {
    List<_User> people = List.of(
        new _User("Ram", 28),
        new _User("Sugan", 24),
        new _User("Vihaan", 0),
        new _User("Dhayaan", 0),
        new _User("Riya", 6),
        new _User("Kaasini", 7)
    );

    //Reference to a Static Method

    boolean isReal = people.stream().anyMatch(user -> UserImpl.isRealUser(user));

    //Take a closer look at lambda expression in the anyMatch() method above,
    //It just makes a call to a static method isRealUser(_User user) of the UserImpl class.
    //So it can be substituted with a reference to a static method:

    boolean isRealMR = people.stream().anyMatch(UserImpl::isRealUser);

    //Both statement below give the same output

    System.out.println(isReal);
    System.out.println(isRealMR);

    //Reference to an Instance Method
    //The reference to an instance method holds the following syntax: containingInstance::methodName.
    //Following code calls method isLegalName(String string) of type User
    // which validates an input parameter:

    UserImpl user = new UserImpl();
    boolean isRealMRI = people.stream().anyMatch(user::isLegalName);
    System.out.println(isRealMRI);

    //Reference to an Instance Method of an Object of a Particular Type
    //This reference method takes the following syntax: ContainingType::methodName.

    List<String> nameList = List.of("Ram", "Suganya", "Vihaan");
    long count = nameList.stream().filter(String::isEmpty).count();

    System.out.println(count);

    //Reference to a Constructor
    //A reference to a constructor takes the following syntax: ClassName::new.
    // As constructor in Java is a special method,
    // method reference could be applied to it too with the help of new as a method name.
    Stream<_User> streamMRC = people.stream().map(_User::new);
    Stream<_User> streamMRCL = people.stream().map(user1 -> new _User(user1));

  }

  static boolean isEmpty(String name) {
    return name.length() > 0 ? true : false;
  }
}
