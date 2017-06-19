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
	}

	/**
	 * Reduces a stream of elements to exactly one element of the stream.
	 * 
	 * The reduce method accepts a BinaryOperator accumulator function. That's
	 * actually a BiFunction where both operands share the same type.
	 */
	@Test
	public void tesReduceWithCombiner() {
		persons.stream().reduce((Person p1, Person p2) -> {
			return p1.getAge() > p2.getAge() ? p1 : p2;
		}).ifPresent(System.out::println); // Pamela
	}

	/**
	 * The second reduce method accepts both an identity value and a
	 * BinaryOperator accumulator. This method can be utilized to construct a
	 * new Person with the aggregated names and ages from all other persons in
	 * the stream.
	 */
	@Test
	public void tesReduceWihtIdentityAndAcumulator() {
		Person result = persons.stream().reduce(new Person("", 0), (p1, p2) -> {
			p1.setAge(p1.getAge() + p2.getAge());
			p1.setName(p1.getName() + p2.getName());

			return p1;
		});

		System.out.format("name=%s; age=%s", result.getName(), result.getAge());
	}

	@Test
	public void tesReduceWithIdentityAcumulatorAndCombiner() {
		@SuppressWarnings("unused")
		Integer ageSum = persons.stream().reduce(0, (sum, p) -> {
			System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			return sum += p.getAge();
		}, (sum1, sum2) -> {
			System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			return sum1 + sum2;
		});		
	}

}
