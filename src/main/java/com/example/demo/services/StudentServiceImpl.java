package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentServiceImpl  implements StudentService
{
	@Autowired
	private StudentRepository studRepo;

	@Override
	public Student createStudDetails(Student stud) 
	{
		return studRepo.save(stud);
	}

	@Override
	public List<Student> getAllStudDetails() 
	{
		return studRepo.findAll();
	}

	@Override
	public Optional<Student> getStudDetailsById(int id) {
		return studRepo.findById(id);
	}

	@Override
	public Student updateStudDetailsById(int id, Student student) {
		Student studData = studRepo.findById(id).orElse(null);
		
		if(studData != null)
		{			
			studData.setName(student.getName());
			studData.setEmail(student.getEmail());
			studData.setCity(student.getCity());
			studData.setPassword(student.getPassword());
			
			return studRepo.save(studData);
		}
		else
		{
			return null;
		}
	}

	@Override
	public void deleteStudDetailsById(int id) {
		studRepo.deleteById(id);;
	}


	
	
	
}