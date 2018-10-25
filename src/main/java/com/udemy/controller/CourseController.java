package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.entity.Course;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	private static final String COURSE_VIEW = "courses";
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAll(){
		ModelAndView result = new ModelAndView(CourseController.COURSE_VIEW);
		CourseController.LOG.info("Call:  listAll() " );
		result.addObject("courses", courseService.listAllCourse());
		result.addObject("course", new Course());
		return result;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("courser") Course course)	{
		courseService.addCourse(course);
		CourseController.LOG.info("Call: addCourse(): " + course.toString());
		return "redirect:/course/listcourses";			
	}

}
