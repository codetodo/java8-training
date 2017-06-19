package com.codetodo.java8.training.stream.exercise;

import java.util.List;
import java.util.stream.Collectors;

public class ToUpperCaseOpStreamImpl implements ToUpperCaseOp {

	@Override
	public List<String> transform(List<String> input) {
		return input.stream().map(String::toUpperCase).collect(Collectors.toList());
	}

}
