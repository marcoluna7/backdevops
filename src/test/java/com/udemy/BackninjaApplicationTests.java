package com.udemy;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;


import com.udemy.model.CourseModel;


public class BackninjaApplicationTests {

	@Test
	public void contextLoads() {
		assertEquals(true, true);
	}
	
	@Test
	public void testCourseModel()
	{
		int id = 3;
		String name = "demo";
		String description = "description";
		BigDecimal price = BigDecimal.valueOf(23);
		int hours = 26;
		CourseModel model = new CourseModel(id, name ,description, price, hours);
		assertEquals(id, model.getId());
		assertEquals(name, model.getName());
		assertEquals(description, model.getDescription());
		assertEquals(price, model.getPrice());
		assertEquals(hours, model.getHours());
	}

}
