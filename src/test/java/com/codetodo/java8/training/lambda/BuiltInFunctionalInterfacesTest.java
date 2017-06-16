package com.codetodo.java8.training.lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Before;
import org.junit.Test;

import com.codetodo.java8.training.methodAndConstructorReferences.Person;



public class BuiltInFunctionalInterfacesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void predicate() {
		// Predicates are boolean-valued functions of one argument.
		Predicate<String> predicate = (s) -> s.length() > 0;

		predicate.test("foo");              // true
		predicate.negate().test("foo");     // false
		
		Predicate<Boolean> nonNull = Objects::nonNull;
		nonNull.test(Boolean.FALSE);
		
		Predicate<Boolean> isNull = Objects::isNull;
		isNull.test(null);
		
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<Boolean> isBoolean = Boolean::booleanValue;
		
		if (isEmpty.test("foo")) {
			System.out.println("Empty!!" + isEmpty);
		}
		
		if (isBoolean.test(Boolean.TRUE)) {
			System.out.println("It's boolean!!" + isBoolean);
		}
		
		Predicate<String> isNotEmpty = isEmpty.negate();		
		isNotEmpty.test("foo");
	}
	
	/**
	 * Functions accept one argument and produce a result. Default methods can be used
	 * to chain multiple functions together (compose, andThen).
	 */
	@Test
	public void function() { 
		// Using anonymous interface
		Function<String, Integer> getSize = new Function<String, Integer>() {
			
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		}; 
		
		// Using lambda expression
		Function<String, Integer> getSize2 = (s) -> s.length();
		
		// Using method reference
		Function<String, Integer> getSize3 = String::length;
		
		
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		backToString.apply("123");     // "123"
		
		getSize.apply("");
		getSize2.apply("");
		getSize3.apply("");
	}
	
	/**
	 * Suppliers produce a result of a given generic type. Unlike Functions, Suppliers don't
	 * accept arguments.
	 */
	@Test
	public void supplier() {
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();   // new Person
	}

	/**
	 * Comparators are well known from older versions of Java. Java 8 adds various default
	 * methods to the interface.
	 */
	@Test
	public void comparator() {
		Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		comparator.compare(p1, p2);             // > 0
		comparator.reversed().compare(p1, p2);  // < 0
	}
	
	/**
	 * <code>Optional<code> are not functional interfaces, instead it's a nifty utility
	 * to prevent <code>NullPointerException</code>.
	 * 
	 * Optional is a simple container for a value which may be null or non-null. Think of
	 * a method which may return a non-null result but sometimes return nothing. Instead
	 * of returning null you return an Optional in Java 8.
	 */
	@Test
	public void optional() {
		Optional<String> optional = Optional.of("bam");

		optional.isPresent();           // true
		optional.get();                 // "bam"
		optional.orElse("fallback");    // "bam"

		optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
	}
	
}
