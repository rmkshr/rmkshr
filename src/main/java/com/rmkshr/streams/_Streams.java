package com.rmkshr.streams;

import java.util.List;

import static com.rmkshr.streams._Streams.Gender.FEMALE;
import static com.rmkshr.streams._Streams.Gender.MALE;


public class _Streams {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ram", MALE),
                new Person("Sugan", FEMALE),
                new Person("Vihaan", MALE),
                new Person("Dhayaan", MALE),
                new Person("Riya", FEMALE),
                new Person("Kaasini", FEMALE)
        );

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
        MALE, FEMALE
    }
}
