package com.codetodo.java8.training.extensionMethods;

import static org.junit.Assert.assertEquals;



import org.junit.Before;
import org.junit.Test;

public class FormulaImplTest {

	private Formula defaultFormula;
	
	@Before
	public void setUp() throws Exception {
		defaultFormula = new FormulaImpl();
	}

	@Test
	public void testSqrt() {
		int a = 25;
		double result = defaultFormula.sqrt(a);
		
		assertEquals(result, Math.sqrt(a), 0.0);
	}

	@Test
	public void testOtherImpl() {
		defaultFormula = (a) -> Math.sqrt(a);
		
		int a = 25;
		double result = defaultFormula.sqrt(a);
		
		assertEquals(result, Math.sqrt(a), 0.0);
	}
	
}
