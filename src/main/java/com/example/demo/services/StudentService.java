package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Student;

public interface StudentService 
{
	public Student createStudDetails(Student stud);
	public List<Student> getAllStudDetails();
	public Optional<Student> getStudDetailsById(int id);
	public Student updateStudDetailsById(int id, Student student);
	public void deleteStudDetailsById(int id);
}
