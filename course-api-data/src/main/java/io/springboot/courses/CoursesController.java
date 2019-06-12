package io.springboot.courses;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.topics.Topics;

@RestController
public class CoursesController {
	
	@Autowired
	private CourseService topicservice;

	@RequestMapping("/topics/{id}/courses")
	public List<Courses> getAllCourses(@PathVariable String id) {
		return topicservice.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Courses getCourse(@PathVariable String id) {
		return topicservice.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{id}/courses")
	public void addCourse(@RequestBody Courses course, @PathVariable String id) {
		course.setTopic(new Topics(id, "", ""));
		topicservice.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Courses course, @PathVariable String id, @PathVariable String topicId) {
		course.setTopic(new Topics(topicId, "", ""));
		topicservice.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		topicservice.deleteCourse(id);
	}
}
