package edu.greenriver.sdev.graphit.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.greenriver.sdev.graphit.models.Course;
import edu.greenriver.sdev.graphit.services.GraphService;

import java.util.List;

// CLASS: CourseAPI
@RestController
public class CourseAPI {

    // FIELDS
    private final GraphService courses = new GraphService();

    // METHOD: createCourse
    @PostMapping("/courses/create/{title}")
    public void addCourse(@PathVariable String title) {
        courses.addCourse(new Course(title));
    }

    // METHOD: deleteCourse
    @DeleteMapping("/courses/delete/{title}")
    public void deleteCourse(@PathVariable String title) {
        // TODO: Write Delete Courses
    }

    // METHOD: readAllCourses
    @GetMapping("/courses/read/all")
    public List<Course> readAllCourses() {
        return courses.sortCourses();
    }

    // METHOD: readCourseByTitle
    @GetMapping("/courses/read/by-title/{title}")
    public Course readCourseByTitle(@PathVariable String title) {
        // TODO: Write readCourseByTitle
        return null;
    }

    // METHOD: updateCourse
    @PutMapping("/courses/update/{oldTitle}/{newTitle}")
    public void updateCourse(@PathVariable String oldTitle, @PathVariable String newTitle) {
        // TODO: Write updateCourse
    }
}
