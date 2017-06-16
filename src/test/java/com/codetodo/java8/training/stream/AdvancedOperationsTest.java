package com.codetodo.java8.training.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class AdvancedOperationsTest {

	List<Person> persons;

	@Before
	public void setup() {
		persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
				new Person("David", 12));
	}

	@Test
	public void testCollectToList() {
		System.out.println("# Test Collect (toList)");

		List<Person> filtered = persons.stream().filter(p -> p.getName().startsWith("P")).collect(Collectors.toList());

		System.out.println(filtered);
	}

	@Test
	public void testCollectToMap() {
		System.out.println("# Test Collect (groupingBy)");

		Map<Integer, List<Person>> personsByAge = persons.stream().collect(Collectors.groupingBy(p -> p.getAge()));

		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
	}

	@Test
	public void testCollectToDouble() {
		System.out.println("# Test Collect (averagingInt)");

		Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.getAge()));

		System.out.println(averageAge); // 19.0
	}

	@Test
	public void testCollectToIntSummaryStatistics() {
		System.out.println("# Test Collect (summarizingInt)");

		IntSummaryStatistics ageSummary = persons.stream().collect(Collectors.summarizingInt(p -> p.getAge()));

		System.out.println(ageSummary);
	}

	@Test
	public void testMyOwnCollector() {
		System.out.println("# Test Collect (own collector)");
		
		Collector<Person, StringJoiner, String> personNameCollector = Collector.of(() -> new StringJoiner(" | "), // supplier initially constructs such a StringJoiner with the appropriate delimiter.
				(j, p) -> j.add(p.getName().toUpperCase()), // accumulator is used to add each persons upper-cased name to the StringJoiner.
				(j1, j2) -> j1.merge(j2), // combiner knows how to merge two StringJoiners into one.
				StringJoiner::toString); // finisher constructs the desired String from the StringJoiner.

		String names = persons.stream().collect(personNameCollector);

		System.out.println(names); // MAX | PETER | PAMELA | DAVID
	}

}
