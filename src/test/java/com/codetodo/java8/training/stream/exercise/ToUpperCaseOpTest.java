package com.codetodo.java8.training.stream.exercise;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ToUpperCaseOpTest {

	private ToUpperCaseOp toUpperCase = new ToUpperCaseOpStreamImpl();
	
	@Test
	public void shouldTransformCollectionElementsToUpperCase() {
		List<String> input = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");
        
        List<String> output = toUpperCase.transform(input);
        
        assertEquals(expected, output);
	}
	
}
