package com.udemy.controller;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.component.LogComponent;
import com.udemy.service.FirstService;

import model.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
	//private static final Log LOGGER =  LogFactory.getLog(PersonController.class);
	public static final String PERSON_VIEW = "person";
	public static final String PERSON_LIST = "listPeople";
	@Autowired
	@Qualifier("firstService")
	private FirstService firstService;
	
	
	
	@Autowired
	@Qualifier("logComponent")
	private LogComponent logComponent;
	
	@GetMapping("")
	public RedirectView redirect()
	{
		
		return new RedirectView("/person/created");
	}
	
	@GetMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("people", firstService.getListPeople());
		return PERSON_LIST;
	}

	@GetMapping("/created")
	public String created(Model model)
	{
		this.logComponent.saveLog("Este es un mensaje desde un componente");
		
		model.addAttribute("person", new Person());
		return PERSON_VIEW;
	}
	
	@PostMapping("/created")
	public ModelAndView created(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			
		}
		else
		{
			person.setId(2);
		}
		ModelAndView mav = new ModelAndView(PERSON_VIEW);		
		mav.addObject("person", person);
		return mav;
	}	
	
}
