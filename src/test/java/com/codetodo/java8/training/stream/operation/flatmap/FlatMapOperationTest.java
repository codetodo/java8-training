package com.codetodo.java8.training.stream.operation.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class FlatMapOperationTest {

	private List<Foo> foos;

	@Before
	public void setup() {
		initFoos();
	}

	@Test
	public void test() {
		foos.stream().flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));
	}

	private void initFoos() {
		foos = new ArrayList<>();

		IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));

		foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
	}

}
