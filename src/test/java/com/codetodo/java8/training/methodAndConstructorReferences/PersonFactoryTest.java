package com.codetodo.java8.training.methodAndConstructorReferences;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreatePerson() {
		PersonFactory<Person> factory = Person::new;
		
		String firstName = "foo";
		String lastName = "bar";
		
		Person person = factory.create(firstName , lastName);
		
		assertEquals(person.getFirstName(), firstName);
	}

}
