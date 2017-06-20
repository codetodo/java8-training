package com.codetodo.java8.training.stream.exercise;

import java.util.List;

import com.codetodo.java8.training.model.Person;

public class GetOldestPersonStreamImpl implements GetOldestPerson {

	@Override
	public Person from(List<Person> persons) {
		return persons.stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2).get();
	}

}
