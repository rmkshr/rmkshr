package org.srv.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static org.srv.streams._Streams.Gender.*;

/**
 * @author Ramkishore
 */
public class _Streams {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ram", MALE),
                new Person("Sugan", FEMALE),
                new Person("Vihaan", MALE),
                new Person("Dhayaan", MALE),
                new Person("Riya", FEMALE),
                new Person("Kaasini", FEMALE),
                new Person("Chanel", RATHER_NOT_SAY),
                new Person("Jessie Dubai", RATHER_NOT_SAY)
        );

        List<Person> girls = List.of(
                new Person("Sugan", FEMALE),
                new Person("Riya", FEMALE),
                new Person("Kaasini", FEMALE)
        );

        //THE BELOW CODE IS TO DEMONSTRATE THE USAGE OF FUNCTIONAL PROGRAMING IN STREAMS API
        Predicate<Person> male = person -> person.gender.equals(MALE);
        Consumer<Person> personConsumer = person -> System.out.println(person.toString());
        people.stream().filter(male).collect(Collectors.toList()).forEach(personConsumer);

        Consumer<Gender> genderConsumer = gender -> System.out.println(gender);
        people.stream().map(person -> person.gender).collect(Collectors.toSet()).forEach(genderConsumer);

        ToIntFunction<Person> personToIntFunction = person -> person.name.length();
        IntConsumer println = System.out::println;    //ALSO REFERRED AS PERSON -> SYSTEM.OUT.PRINTLN(PERSON)
        people.stream().mapToInt(personToIntFunction).forEach(println);

        // THERE ARE NONEMATCH() METHODS AS WELL
        boolean onlyFemale = girls.stream().allMatch(person -> FEMALE.equals(person.gender));
        boolean anyFemale = people.stream().anyMatch(person -> FEMALE.equals(person.gender));
        System.out.println("ONLY FEMALES : " + onlyFemale);
        System.out.println("ONLY FEMALES PEOPLE : " + anyFemale);


    }

    enum Gender {
        MALE, FEMALE, RATHER_NOT_SAY
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
