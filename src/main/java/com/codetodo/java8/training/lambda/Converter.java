package com.codetodo.java8.training.lambda;

@FunctionalInterface
public interface Converter<S, T> {
    T convert(S source);
}
