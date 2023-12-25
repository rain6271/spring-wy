package org.springframework.function;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Consumer<String> tConsumer = System.out::print;
        tConsumer.accept("test a main");
    }
}