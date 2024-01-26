package org.srv.functionalinterface;

import static org.srv.functionalinterface.Main.Gender.FEMALE;
import static org.srv.functionalinterface.Main.Gender.MALE;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Ramkishore
 */
public class Main {

  public static void main(String[] args) {
    List<Person> people = List.of(
        new Person("Ram", MALE),
        new Person("Sugan", FEMALE),
        new Person("Vihaan", MALE)
    );

    //IMPERATIVE APPROACH
    System.out.println("========Imperative Approach");
    List<Person> females = new ArrayList<>();
    for (Person person : people) {
      if (FEMALE.equals(person.gender)) {
        females.add(person);
      }
    }
    for (Person female : females) {
      System.out.println(female.toString());
    }

    //DECLARATIVE APPROACH
    System.out.println("========Declarative approach");

    //PREDICATE => EXECUTES A BOOLEAN EXPRESSION AND RETURNS RESULT.
    Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

    people.stream().filter(personPredicate)
        .forEach(System.out::println);

    List<Person> femalesNew = people.stream().filter(personPredicate)
        .collect(Collectors.toList());
    femalesNew.forEach(System.out::println);
  }

  enum Gender {
    MALE, FEMALE
  }

  static class Person {

    private final String name;
    private final Gender gender;

    public Person(String name, Gender gender) {
      this.name = name;
      this.gender = gender;
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", gender='" + gender + '\'' +
          '}';
    }
  }
}
