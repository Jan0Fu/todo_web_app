package com.todoapp.todoproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.todoproject.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByName(String name);
    List<Course> findAllByUsername(String username);
}
