package com.udemy.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{

	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourse() {
		LOG.info("call: getAllCourse(");
		List<Course> result = courseJpaRepository.findAll();
		return result;
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("call: addCourse()");
		Course result = this.courseJpaRepository.save(course);
		return result;
	}

	@Override
	public int removeCourse(int id) {
		int result = this.removeCourse(id);
		return result;
	}

	@Override
	public Course updateCourse(Course course) {
		Course result = this.courseJpaRepository.save(course);
		return result;
	}
	
	

}
