package com.codetodo.java8.training.stream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class StreamTest {

	/**
	 * Filter accepts a predicate to filter all elements of the stream. This operation
	 * is intermediate which enables us to call another stream operation (forEach) on the result.
	 */
	@Test
	public void Filter() {
		List<String> elems = getStringCollections();

		elems.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
	}

	/**
	 * Sorted is an intermediate operation which returns a sorted view of the stream. 
	 * The elements are sorted in natural order unless you pass a custom Comparator.
	 */
	@Test
	public void Sorted() {
		List<String> elems = getStringCollections();

		elems.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println); // Such a chain of stream operations is known as operation pipeline
	}

	/**
	 * The intermediate operation map converts each element into another object via
	 * the given function.
	 */
	@Test
	public void Map() {
		List<String> elems = getStringCollections();

		elems.stream().map(String::toUpperCase).sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);
	}

	/**
	 * Various matching operations can be used to check whether a certain predicate matches
	 * the stream. All of those operations are terminal and return a boolean result.
	 */
	@Test
	public void Match() {
		List<String> elems = getStringCollections();

		boolean anyStartsWithA = elems.stream().anyMatch((s) -> s.startsWith("a")); 
		boolean allStartsWithA = elems.stream().allMatch((s) -> s.startsWith("a"));
		boolean noneStartsWithZ = elems.stream().noneMatch((s) -> s.startsWith("z"));

		assertTrue(anyStartsWithA);
		assertFalse(allStartsWithA);
		assertTrue(noneStartsWithZ);
	}

	/**
	 * Count is a terminal operation returning the number of elements in the stream as a long.
	 */
	@Test
	public void Count() {
		List<String> elems = getStringCollections();

		long startsWithB = elems.stream().filter((s) -> s.startsWith("b")).count();

		assertTrue(startsWithB > 0);
	}

	/**
	 * This terminal operation performs a reduction on the elements of the stream with the
	 * given function. The result is an Optional holding the reduced value.
	 */
	@Test
	public void Reduce() {
		List<String> elems = getStringCollections();
		
		Optional<String> reduced = elems.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);

		reduced.ifPresent(System.out::println);
	}

	private List<String> getStringCollections() {
		List<String> result = new ArrayList<>();
		result.add("ddd2");
		result.add("aaa2");
		result.add("bbb1");
		result.add("aaa1");
		result.add("bbb3");
		result.add("cccc");
		result.add("bbb2");
		result.add("ddd1");

		return result;
	}

}
