package com.todoapp.todoproject.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import com.todoapp.todoproject.model.Course;
import com.todoapp.todoproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course) {
        logger.info("Course object {}", course.toString());
        return courseService.saveCourse(course);
    }

    @PostMapping("/addCourses")
    public List<Course> addCourses(@RequestBody List<Course> courses) {
        return courseService.saveCourses(courses);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getCourses();
    }
    @GetMapping("/course/{id}")
    public Course findCourseById(@PathVariable int id) {
        return courseService.getCourse(id);
    }
    @GetMapping("/courseByName/{name}")
    public Course findCourseByName(@PathVariable String name) {
        return courseService.getCourseByName(name);
    }
    @GetMapping("/listCourseByUsername/{username}")
    public List<Course> findCoursesByUsername(@PathVariable String username) {
        return courseService.getCoursesForUser(username);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        System.out.println("UPDATED");
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }
}
