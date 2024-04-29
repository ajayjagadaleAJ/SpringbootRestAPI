package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentDao implements StudentService {

	@Autowired
	StudentRepo sr;
	
	
	@Override
	public void register(Student s1) {
		sr.save(s1);
		
	}


	@Override
	public List<Student> getallInfo() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
