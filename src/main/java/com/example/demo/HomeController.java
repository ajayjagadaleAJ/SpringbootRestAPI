package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	StudentService ss;
	
	@Autowired
	StudentRepo sr;
	
	//Mappping to Save all data
	@PostMapping("/students")
	public String Recordsave(@RequestBody Student s1)
	{
		ss.register(s1);
		return "Record saved";
		
	}
	
	
	//Mappping to display all data
	@GetMapping("/display")
	public List<Student> two()
	{
		return sr.findAll();
	}

	
	//Mapping to get data of student by id
	@GetMapping("/students/{id}")
	public Optional<Student> studbyid(@PathVariable int id)
	{
		return sr.findById(id);
			
	}
	

	//Mapping to update data by id
	@PutMapping("/students/update/{id}")
	public Student updatestudent(@PathVariable int id)
	{
		  
		Student student = sr.findById(id).get();
		student.setName("shreenu");
		student.setEmail("shreenu@gmail.com");
	    student.setGender("female");
	   	student.setAddress("Pune");
	   	sr.save(student);
		return student;
	}
		
	
	//Mappping to Delete data by id
	@GetMapping("/delete/{id}")
	public String three(@PathVariable int id)
	{
		sr.deleteById(id);
		return "Record deleted";
		
	}
	
	
	
}
