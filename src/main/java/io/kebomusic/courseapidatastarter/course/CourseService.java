package io.kebomusic.courseapidatastarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses()
	{	
		return courseRepository.findAll();
	}
	
	public Course getCourse(String id)
	{
			return  courseRepository.findById(id).get();
	}
	
	public void addCourse(Course course) {
		
		courseRepository.save(course);
	}

	public void updateCourse(Course course)
	{
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
	
}
