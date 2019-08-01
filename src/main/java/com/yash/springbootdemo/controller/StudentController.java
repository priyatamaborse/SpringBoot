package com.yash.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yash.springbootdemo.dtos.StudentDto;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private List<StudentDto> listOfStudentDtos = new ArrayList<StudentDto>();
	
	@GetMapping("/details")
	public StudentDto getStudentDetails()
	{
		StudentDto studentDto = new StudentDto();
		studentDto.setRollNo(1);
		studentDto.setName("priyatama");
		studentDto.setAddress("pune");
		return studentDto;
	}
	
	@GetMapping("/details/{rollNo}")
	public StudentDto getStudentDetailsById(@PathVariable("rollNo") Integer rollNo)
	{
		StudentDto studentDto = new StudentDto();
		System.out.println(rollNo);
		studentDto.setRollNo(1);
		studentDto.setName("priyatama");
		studentDto.setAddress("pune");
		return studentDto;
	}
	
	@GetMapping("/detail")
	public StudentDto getStudentDetailsByIdWithRequestParam(@RequestParam("rollno") Integer rollNo)
	{
		StudentDto studentDto = new StudentDto();
		System.out.println(rollNo);
		studentDto.setRollNo(1);
		studentDto.setName("priyatama");
		studentDto.setAddress("pune");
		return studentDto;
	}
	
	@PostMapping("/create")
	public ModelAndView createStudent(@RequestBody @Valid StudentDto studentDto, BindingResult result,Model model)
	{
		ModelAndView modelAndView = new ModelAndView();
		
		if(result.hasErrors())
		{
			
			if(result.getFieldError() != null)
			{
				modelAndView.setViewName("error");
				model.addAttribute("message", result.getFieldError().getDefaultMessage());
			}
			
		}else {
			
			listOfStudentDtos.add(studentDto);
			modelAndView.setViewName("success");
			model.addAttribute("student", studentDto);
			
		}
		
		return modelAndView;
		
	}
	
	@PostMapping("/update")
	public ModelAndView updateStudent(@RequestBody @Valid StudentDto studentDto,BindingResult result,Model model)
	{
		
		ModelAndView modelAndView = new ModelAndView();
			
		if(result.hasErrors())
		{
			modelAndView.setViewName("error");
			model.addAttribute("error",result.getFieldError().getDefaultMessage());
			
		}
		else
		{
			if (studentDto.getRollNo() == 1)
			{
				listOfStudentDtos.add(studentDto);
				model.addAttribute("update", "Student With rollNo :"+studentDto.getRollNo()+"Updated succesfully");
				modelAndView.setViewName("success");
			}
			
		}

		return modelAndView;
		
	}
	
	@PostMapping("/delete")
	public ModelAndView deleteStudent(@RequestBody @Valid StudentDto studentDto,BindingResult result,Model model)
	{
		
		ModelAndView modelAndView = new ModelAndView();
			
		if(result.hasErrors())
		{
			modelAndView.setViewName("error");
			model.addAttribute("error",result.getFieldError().getDefaultMessage());
			
		}
		else {
			listOfStudentDtos.remove(studentDto);
			model.addAttribute("delete", "Student With rollNo :" + studentDto.getRollNo() + "deleted succesfully");
			modelAndView.setViewName("success");

		}
		return modelAndView;
		
	}
	
	
}
