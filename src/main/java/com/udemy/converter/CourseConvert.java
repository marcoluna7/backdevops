package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

@Component("courseConvert")
public class CourseConvert {

	public CourseModel entityToModel(Course course) {
		CourseModel result = new CourseModel();
		result.setId(course.getId());
		result.setDescription(course.getDescription());
		result.setHours(course.getHours());
		result.setName(course.getName());
		result.setPrice(course.getPrice());
		return result;
	}
	
	public Course modelToEntity(CourseModel model)
	{
		Course result = new Course();
		result.setId(model.getId());
		result.setDescription(model.getDescription());
		result.setHours(model.getHours());
		result.setPrice(model.getPrice());
		result.setName(model.getName());
		return result;		
	}
	
	
	
			
}
