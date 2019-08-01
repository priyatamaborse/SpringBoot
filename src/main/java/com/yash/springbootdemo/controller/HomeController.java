package com.yash.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yash.springbootdemo.exception.BusinessException;
import com.yash.springbootdemo.exception.ValidationException;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/hello")
	public ModelAndView sayHello()// throws ValidationException
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		if(true)
			throw new BusinessException("Invalid login--------");
		return modelAndView;
		
	}

}
