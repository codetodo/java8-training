package com.codetodo.java8.training.stream.exercise;

import java.util.List;
import java.util.stream.Collectors;

public class GetItemsWithLessThanNcharactersStreamImpl implements GetItemsWithLessThanNcharacters {

	private static final int DEFAULT_MAX = 4;

	private int max = DEFAULT_MAX;

	public GetItemsWithLessThanNcharactersStreamImpl() {
	}

	public GetItemsWithLessThanNcharactersStreamImpl(int max) {
		this.max = max;
	}

	@Override
	public List<String> filter(List<String> input) {
		return input.stream().filter((String item) -> {
			return item.length() < max;
		}).collect(Collectors.toList());
	}

}
