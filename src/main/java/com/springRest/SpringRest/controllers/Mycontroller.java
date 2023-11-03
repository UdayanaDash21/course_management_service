package com.springRest.SpringRest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.SpringRest.entities.Course;
import com.springRest.SpringRest.services.CourseService;

@RestController
public class Mycontroller {
	@Autowired
	private CourseService courseService;

	
@GetMapping("/home")
  public String home() {
	  return "This is Home page";
  }

//get the courses
@GetMapping("/courses")
public List<Course> getCourses(){
	return  this.courseService.getCourses();
}
//Get Course by Id
@GetMapping("/courses/{courseId}")
public Course getCourse(@PathVariable String courseId) {
	return this.courseService.getCourse(Long.parseLong(courseId));
}
//Adding Courses
@PostMapping(path="/courses",consumes = "application/json")
public Course addCourse(@RequestBody Course course) {
	return this.courseService.addCourse(course);
}
//Updating the Course
@PutMapping("/courses/{courseId}")
public Course updateCourse(@RequestBody Course course,@PathVariable String courseId) {
 this.courseService.updateCourse(course,Long.parseLong(courseId));
 return course;
}
//Delete the Course
@DeleteMapping("courses/{courseId}")
public Course deleteCourse(@PathVariable("courseId") String courseId) {
	return this.courseService.deleteCourse(Long.parseLong(courseId));
}

}
