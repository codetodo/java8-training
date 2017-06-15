package com.codetodo.java8.training.methodAndConstructorReferences;

public interface PersonFactory<P extends Person> {
	P create(String firstName, String lastName);
}