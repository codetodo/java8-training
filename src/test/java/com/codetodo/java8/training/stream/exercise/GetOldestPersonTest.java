package com.codetodo.java8.training.stream.exercise;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.codetodo.java8.training.model.Person;

public class GetOldestPersonTest {

	private GetOldestPerson getOldestPerson = new GetOldestPersonStreamImpl();
	
	@Test
	public void shouldGetOldestPerson() {
		List<Person> persons = Arrays.asList(new Person("Sara", 4), new Person("Viktor", 23), new Person("Eva", 44));
		
		Person oldest = getOldestPerson.from(persons);
		
		assertEquals("Eva", oldest.getName());
	}
	
}
