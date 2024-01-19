package edu.greenriver.sdev.graphit.controllers;

import edu.greenriver.sdev.graphit.services.CourseService;
import edu.greenriver.sdev.graphit.services.ScheduleService;
import org.hibernate.graph.Graph;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final GraphService graphService;
    private final CourseService courseService;
    private final ScheduleService scheduleService;

    // CONSTRUCTOR
    @Autowired
    public CourseAPI(CourseService courseService, GraphService graphService, ScheduleService scheduleService) {
        this.courseService = courseService;
        this.graphService = graphService;
        this.scheduleService = scheduleService;
    }

    // METHOD: createCourse
    @PostMapping("/courses/create/{title}")
    public void addCourse(@PathVariable String title) {
        graphService.addCourse(new Course(title));
    }

    // METHOD: deleteCourse
    @DeleteMapping("/courses/delete/{title}")
    public void deleteCourse(@PathVariable String title) {
        // TODO: Write Delete Courses
    }

    // METHOD: readAllCourses
    @GetMapping("/courses/read/all")
    public List<Course> readAllCourses() {
        return courseService.getAll();
    }

    // METHOD: readCourseByTitle
    @GetMapping("/courses/read/by-title/{title}")
    public Course readCourseByTitle(@PathVariable String title) {
        // TODO: Write readCourseByTitle
        return null;
    }

    // METHOD: getSchedule
    @GetMapping("/schedule/create/{classesPerQuarter}")
    public List<List<Course>> getSchedule(@PathVariable int classesPerQuarter) {
        List<Course> courseList = courseService.getAll();
        return scheduleService.buildScheduleFromList(courseList, classesPerQuarter);
    }

    // METHOD: updateCourse
    @PutMapping("/courses/update/{oldTitle}/{newTitle}")
    public void updateCourse(@PathVariable String oldTitle, @PathVariable String newTitle) {
        // TODO: Write updateCourse
    }
}
