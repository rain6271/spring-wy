package org.springframework.function.Interface;

@FunctionalInterface
public interface MyPredicate2<T, U> {

    boolean predicate(T t, U u);

}
