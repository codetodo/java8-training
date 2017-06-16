package com.codetodo.java8.training.stream.operation.reduce;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.codetodo.java8.training.stream.operation.collect.Person;

public class ReduceOperationTest {

	private List<Person> persons;

	@Before
	public void setup() {
		persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
				new Person("David", 12));

	@Test
	public void test() {
		persons.stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2).ifPresent(System.out::println); // Pamela
	}

}
