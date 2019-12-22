package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	//@RequestMapping("/courses/{id}/courses")
	//@RequestMapping(value="/courses",method=RequestMethod.GET)   <---Default Request mapping
	public List<Course> getAllCourses(@PathVariable("id") String id) {		
		return courseService.getAllCourses(id);	

	}
	
	@RequestMapping("/topics/{topicId}/courses/{ID}")
	public Optional<Course> getCourse(@PathVariable("ID") String id) {
		return courseService.getCourse(id);
		
	}
	
	@RequestMapping(value="/topics/{tId}/courses",method=RequestMethod.POST)
	public void addCourse(@RequestBody Course course,@PathVariable("tId") String topiceId) {
		course.setTopic(new Topic(topiceId,"",""));
		courseService.postCourse(course);
		
	}
	
	// update data
	@RequestMapping(value="/topics/{topicId}/courses/{cid}",method=RequestMethod.PUT)
	public void updateCourse(@RequestBody  Course course ,@PathVariable("topicId") String tid,@PathVariable("cid") String cid ) {
		course.setTopic(new Topic(tid,"",""));
		courseService.updateCourse(course);
		
	}
	
	
	//  Remove element
	@RequestMapping(value="/courses/{ID}",method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("ID") String id ) {
		courseService.deleteCourse(id);		
	}
	
	//  Remove element
	@RequestMapping(value="/topics/{topicId}/courses/{cid}",method=RequestMethod.DELETE)
	public void deleteAllCourse() {
		courseService.deleteAllCourse();		
	}
	

}
