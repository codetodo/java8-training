package com.codetodo.java8.training.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class CreatingStreamTest {

	@Test
	public void gettingFromCollection() {
		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println); // a1
	}

	@Test
	public void gettingFromStreamStaticFactoryMethodOf() {
		Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println); // a1
	}

	@Test
	public void testIntStream() {
		IntStream.range(1, 5).forEach(System.out::println);
	}

	@Test
	public void testStreamConversion() {
		Stream.of("a1", "a2", "a3").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max()
				.ifPresent(System.out::println); // 3

		IntStream.range(1, 4).mapToObj(i -> "a" + i).forEach((s) -> System.out.println("Test::testStreamConversion " + s));

		List<String> names = Arrays.asList("abc", "xyz", "yyy", "xxxx");

		names.stream().sorted().filter((s) -> s.startsWith("x")).filter((s) -> s.length() > 3)
				.forEach(System.out::println);
	}

}
