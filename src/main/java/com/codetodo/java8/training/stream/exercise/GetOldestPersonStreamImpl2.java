package com.codetodo.java8.training.stream.exercise;

import java.util.Comparator;
import java.util.List;

import com.codetodo.java8.training.model.Person;

public class GetOldestPersonStreamImpl2 implements GetOldestPerson {

	@Override
	public Person from(List<Person> persons) {
		return persons.stream().max(Comparator.comparing(Person::getAge)).get();
	}

}
