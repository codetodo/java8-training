package com.codetodo.java8.training.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(Hints.class)
public @interface Hint {
	String value();
}
