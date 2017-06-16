package com.codetodo.java8.training.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ParallelStreamTest {

	@Test
	public void sequentialSort() {
		List<String> ids  = generateUUIDs();
		
		long t0 = System.nanoTime();

		ids.stream().sorted().count();
		
		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		
		System.out.println(String.format("Sequential sort took: %d ms", millis));
	}
	
	@Test
	public void parallelSort() {
		List<String> ids  = generateUUIDs();
		
		long t0 = System.nanoTime();

		ids.parallelStream().sorted().count();
		
		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		
		System.out.println(String.format("Parallel sort took: %d ms", millis));
	}

	private List<String> generateUUIDs() {
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		return values;
	}
	
}
