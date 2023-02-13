package com.todoapp.todoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.todoproject.repositories.CourseRepository;
import com.todoapp.todoproject.model.Course;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        System.out.println(course.toString());
        return courseRepository.save(course);
    }

    public List<Course> saveCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    public List<Course> getCoursesForUser(String username) {
        return courseRepository.findAllByUsername(username);
    }

    public Course updateCourse(Course course) {
        System.out.println("updates");
        Course existing_course = courseRepository.findById(course.getId()).orElse(null);
        existing_course.setName(course.getName());
        existing_course.setDescription(course.getDescription());
        existing_course.setStatus(course.getStatus());
        return courseRepository.save(existing_course);
    }

    public String deleteCourse(int id) {
        courseRepository.deleteById(id);
        return id + " id -> course removed/completed";
    }
}
