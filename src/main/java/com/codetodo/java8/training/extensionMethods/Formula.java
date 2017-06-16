package com.codetodo.java8.training.extensionMethods;

@FunctionalInterface
public interface Formula {
	
	double calculate(int a);
	
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
