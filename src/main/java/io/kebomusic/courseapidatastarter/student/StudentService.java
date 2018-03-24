package io.kebomusic.courseapidatastarter.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public void addStudent(Student student) {
		
		studentRepository.save(student);
	}
	
	public List<Student> retrieveAllStudents() {
		
		return studentRepository.findAll();
	}	
	
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}
	
	public Student getStudent(String id)
	{	
		return studentRepository.findById(id).get();
	}
}
