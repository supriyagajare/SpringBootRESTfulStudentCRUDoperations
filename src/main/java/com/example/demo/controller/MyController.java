package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@RestController
public class MyController {
	
	@Autowired
	private StudentService studServ;

	@PostMapping("/student")
	public Student addStudentDetails(@RequestBody Student student)
	{
		return this.studServ.createStudDetails(student);
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudDetails()
	{
		return this.studServ.getAllStudDetails();
	}
	
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getstudDetailsById(@PathVariable int id)
	{
		Student stud = studServ.getStudDetailsById(id).orElse(null);
		
		if(stud != null)
		{
			return ResponseEntity.ok().body(stud);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("student/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student student)
	{
		 Student std = studServ.updateStudDetailsById(id, student);
		 
		 if(std != null)
		 {
			 return ResponseEntity.ok(std);
		 }
		 else
		 {
			 return ResponseEntity.notFound().build();
		 }
	}
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<Student> deleteById(@PathVariable int id)
	{
		studServ.deleteStudDetailsById(id);
		return ResponseEntity.noContent().build();
	}
}