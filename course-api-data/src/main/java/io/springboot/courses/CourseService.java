package io.springboot.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Courses> getAllCourses(String id) {
		List<Courses> courses = new ArrayList<>();
		courseRepository.findByTopicId(id).forEach(courses::add);
		return courses;
	}
	
	public Courses getCourse(String id) {
		return courseRepository.findById(id).get();
	}

	public void addCourse(Courses course) {
		courseRepository.save(course);
	}

	public void updateCourse(Courses course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
	
}
