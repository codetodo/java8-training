package com.codetodo.java8.training.lambda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConverterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStringToIntegerConversionWithLambda() {
		Converter<String, Integer> stringToIntegerConverter = (s) -> Integer.valueOf(s);
		
		Integer target = stringToIntegerConverter.convert("2");
		
		assertEquals(target, new Integer(2));
	}
	
	@Test
	public void testStringToIntegerConversionWithMethodReferences() {
		Converter<String, Integer> stringToIntegerConverter = Integer::valueOf;
		
		Integer target = stringToIntegerConverter.convert("2");
		
		assertEquals(target, new Integer(2));
	}
	
	@SuppressWarnings("unused")
	@Test
	public void differentInterfaceImplementation() {
		// Initializing converter1 with a Converter implementation.
		Converter<String, String> converter1 = new FullNameToSimpleNameConverter();
		
		// Initializing converter2 with anonymous class (Quite verbose)
		Converter<String, String> converter2 = new Converter<String, String>() {

			@Override
			public String convert(String source) {
				return source;
			}
			
		};
		
		// Initializing converter3 with lambda expression. 
		Converter<String, String> converter3 = (s) -> s;
		
		String source = "foo";
		
		String target = converter3.convert(source );
		
		assertEquals(source, target);
	}
	

}
