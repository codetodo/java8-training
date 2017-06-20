package com.codetodo.java8.training.stream.exercise;

import java.util.List;
import java.util.stream.Collectors;

public class FlattenMultidimensionalCollectionStreamImpl implements FlattenMultidimensionalCollection {

	@Override
	public List<String> execute(List<List<String>> input) {
		return input.stream().flatMap((l) -> l.stream()).collect(Collectors.toList());
	}

}
