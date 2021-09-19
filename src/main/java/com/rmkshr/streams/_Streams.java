package com.rmkshr.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static com.rmkshr.streams._Streams.Gender.*;


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

        //The below code is to demonstrate the usage of FUNCTIONAL PROGRAMING in streams API
        Predicate<Person> male = person -> person.gender.equals(MALE);
        Consumer<Person> personConsumer = person -> System.out.println(person.toString());
        people.stream().filter(male).collect(Collectors.toList()).forEach(personConsumer);
        
        Consumer<Gender> genderConsumer = gender -> System.out.println(gender);
        people.stream().map(person -> person.gender).collect(Collectors.toSet()).forEach(genderConsumer);

        ToIntFunction<Person> personToIntFunction = person -> person.name.length();
        IntConsumer println = System.out::println;    //Also referred as person -> System.out.println(person)
        people.stream().mapToInt(personToIntFunction).forEach(println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name,  Gender gender) {
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

    enum Gender {
        MALE, FEMALE, RATHER_NOT_SAY
    }
}
