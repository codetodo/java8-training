package com.codetodo.java8.training.lambda;

public class FullNameToSimpleNameConverter implements Converter<String, String> {

	@Override
	public String convert(String fullName) {
		return fullName;
	}

}
