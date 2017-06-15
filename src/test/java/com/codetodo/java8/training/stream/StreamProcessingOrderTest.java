package com.codetodo.java8.training.stream;

import java.util.stream.Stream;

import org.junit.Test;

public class StreamProcessingOrderTest {

	@Test
	public void test() {
		// When executing this code snippet, nothing is printed to the console.
		// That is because intermediate operations will only be executed when a
		// terminal operation is present.
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return true;
		}).forEach(s -> System.out.println("forEach: " + s));

		// The operation anyMatch returns true as soon as the predicate applies
		// to the given input element. This is true for the second element
		// passed "A2". Due to the vertical execution of the stream chain, map
		// has only to be executed twice in this case. So instead of mapping all
		// elements of the stream, map will be called as few as possible.
		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("A");
		});
	}

}
