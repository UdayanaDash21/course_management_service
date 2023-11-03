package com.springRest.SpringRest.services;

import java.util.List;

import com.springRest.SpringRest.entities.Course;

public interface CourseService {

	
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course,long courseId);
	public Course deleteCourse(long courseId);
}
