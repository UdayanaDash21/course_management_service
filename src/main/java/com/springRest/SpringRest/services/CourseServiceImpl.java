package com.springRest.SpringRest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springRest.SpringRest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService{

	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(1,"Java Course","This is a Java Course"));
		list.add(new Course(2,"MERN Course","This is a React Course"));
		list.add(new Course(3,"MEAN Course","This is a Angular Course"));

	}
	
	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		
		Course c = null;
		for(Course course1:list) {
			if(course1.getId()==courseId) {
				c = course1;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course,long courseId) {
		
	list = list.stream().map(c->{
			if(c.getId()== courseId) {
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
			}
			return c;
		}).collect(Collectors.toList());
	return course;
	}

	@Override
	public Course deleteCourse(long courseId) {
		return null;
	}
	
	
	
	
}
