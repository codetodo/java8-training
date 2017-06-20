package com.codetodo.java8.training.stream.exercise;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.codetodo.java8.training.model.Person;

public class PersonServiceTest {

	private PersonService personService = new PersonServiceImpl();

	@Test
	public void test() {
		List<Person> persons = Arrays.asList(new Person("Sara", 4), new Person("Viktor", 23), new Person("Eva", 44),
				new Person("Anna", 8), new Person("Andrea", 1));

		List<String> kids = personService.getKidNames(persons);
		
		assertTrue(kids.containsAll(Arrays.asList("Anna", "Sara", "Andrea")));
	}

}
