package org.springframework.function.entity;

public class Person {
    private Integer salary;
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Person(Integer salary, String name, Integer age) {
        this.salary = salary;
        this.name = name;
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getAge1(String s) {
        return Integer.valueOf(s);
    }
}
