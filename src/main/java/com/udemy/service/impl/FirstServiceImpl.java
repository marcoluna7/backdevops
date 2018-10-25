package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;


import org.springframework.stereotype.Service;

import com.udemy.service.FirstService;

import model.Person;

@Service("firstService")
public class FirstServiceImpl implements FirstService{
	
	private static final Log LOG = LogFactory.getLog(FirstServiceImpl.class);

	@Override
	public List<Person> getListPeople() {

		String param = "";
		List<Person> people = new ArrayList<>();
		people.add(new Person("Marco", 1).setParam(param));
		people.add(new Person("Hugo", 2).setParam(param));
		people.add(new Person("Paco", 3).setParam(param));
		people.add(new Person("Luis", 4).setParam(param));
		LOG.info("Implementacion desde el services.");
		return people;
		
	}

}
