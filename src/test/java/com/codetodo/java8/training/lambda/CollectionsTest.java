package com.codetodo.java8.training.lambda;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CollectionsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSort() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		// Each lambda corresponds to a given type, specified by an interface. Functional interface
		// must contain exactly one abstract method declaration.  Since default methods are not abstract
		// you're free to add default methods to your functional interface.
		
		Collections.sort(names, (a, b) -> b.compareTo(a));

		assertTrue("xenia".equals(names.get(0)));
	}
	
}
