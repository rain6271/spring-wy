package org.springframework.function.Interface;

@FunctionalInterface
public interface MyPredicate<T> {

    void test(T t);
}
