package com.codetodo.java8.training.stream.exercise;


import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class FlattenMultidimensionalCollectionTest {

	private FlattenMultidimensionalCollection flattenMultidimensionalCollection = new FlattenMultidimensionalCollectionStreamImpl();
	
	@Test
	public void shouldFlattenMultidimensionalCollection() {
		List<List<String>> input = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        
        List<String> output = flattenMultidimensionalCollection.execute(input);
        
        assertEquals(output, expected);
	}
	
}
