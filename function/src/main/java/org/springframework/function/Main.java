package org.springframework.function;

import org.junit.jupiter.api.Test;
import org.springframework.function.Interface.MyPredicate;
import org.springframework.function.Interface.MyPredicate2;
import org.springframework.function.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Main {

    public void test(String s, MyPredicate<String> myPredicate) {
        myPredicate.test(s);
    }

    public Boolean test(String s1, String s2, MyPredicate2<String, String> myPredicate) {
        return myPredicate.predicate(s1, s2);
    }



    public static void main(String[] args) {
        System.out.println("Hello world!");
        // 接口的抽象方法的形参表 返回类型需要和调用的类方法形参表 返回类型保持一致
        Consumer<String> tConsumer = System.out::print;
        tConsumer.accept("test a main");

        new Main().test("test", (t) -> {
            System.out.println(t);
            System.out.println(t);
        });

        new Main().test("t", s -> {

        });

        Comparator<Integer> comparator = Integer::compareTo;
        MyPredicate2<String, String> myPredicate2 =String::equals;
        BiPredicate<String, String> function = String::equals;


        // 第一个参数是实例的调用者，第二个参数是方法传入参数时
        new Main().test("s1", "s2", String::equals);

        // 构造器的引用
        Supplier<Person> p = Person::new;

        Function<Integer, Person> f = Person::new;

        Arrays.asList("1", "2").forEach(
                System.out::println
        );



    }

    @Test
    private void test() {
        List<Person> list = Arrays.asList(
                new Person(20000, "wangyu", 31),
                new Person(200001, "wangyu1", 32));
        list.stream().map(Person::getAge);

        list.stream().map(x-> x.getAge1("1"));


        Function<Person, Integer> getAge = Person::getAge;


    }



}