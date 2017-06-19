package com.codetodo.java8.training.stream.exercise;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class GetItemsWithLessThanNcharactersTest {

	private GetItemsWithLessThanNcharacters getItems = new GetItemsWithLessThanNcharactersStreamImpl();
	
	@Test
	public void shouldReturnOnlyItemsWithLessThan4Characters() {
		List<String> input = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        
        List<String> output = getItems.filter(input);
        
        assertEquals(expected, output);
	}
	
}
