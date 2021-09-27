package com.rmkshr.java.java8.methodreference;

public class _User {

    String name;
    Integer age;

    public _User(_User user) {
        this.name = user.name;
        this.age = user.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "_User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public _User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
