package com.codetodo.java8.training.stream.exercise;

import java.util.List;
import java.util.stream.Collectors;

import com.codetodo.java8.training.model.Person;

public class PersonServiceImpl implements PersonService {

	@Override
	public List<String> getKidNames(List<Person> persons) {
		return persons.stream().filter((p) -> p.getAge() < 18).map((p) -> p.getName()).collect(Collectors.toList());
	}

}
