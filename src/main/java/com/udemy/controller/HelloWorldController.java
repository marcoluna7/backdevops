package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Person;

@Controller
@RequestMapping("/say")
public class HelloWorldController {
	
	public static final String HELLO_VIEW = "helloworld";
	
	@GetMapping("/helloworld")
	public String helloWorld(Model model)
	{	model.addAttribute("people", getList());
		return HELLO_VIEW;
	}
	
	@GetMapping("/hello")
	public ModelAndView helloMV()
	{
		ModelAndView mav = new ModelAndView(HELLO_VIEW);
		mav.addObject("people", getList());
		return mav;
	}
	
	@GetMapping("/helloparam")
	public ModelAndView getParam(@RequestParam(name = "p", required=false, defaultValue="NA") String param)
	{
		ModelAndView mav = new ModelAndView(HELLO_VIEW);		
		mav.addObject("people", getList(param));
		return mav;
	}
	
	@GetMapping("/helloparam2/{p}")
	public ModelAndView getParam2(@PathVariable("p") String param)
	{
		ModelAndView mav = new ModelAndView(HELLO_VIEW);		
		mav.addObject("people", getList(param));
		return mav;
	}
	
	
	private List<Person> getList(  )
	{
		return getList("NA");
	}
	
	
	private List<Person> getList( String param )
	{
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("Marco", 1).setParam(param));
		people.add(new Person("Hugo", 2).setParam(param));
		people.add(new Person("Paco", 3).setParam(param));
		people.add(new Person("Luis", 4).setParam(param));
		return people;
	}

}
