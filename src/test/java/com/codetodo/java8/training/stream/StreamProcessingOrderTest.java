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
	}

}
