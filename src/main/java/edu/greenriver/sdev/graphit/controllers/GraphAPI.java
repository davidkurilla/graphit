package edu.greenriver.sdev.graphit.controllers;

import edu.greenriver.sdev.graphit.models.Course;
import edu.greenriver.sdev.graphit.models.CourseGraph;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class GraphAPI {

    // FIELDS
    Course math97 = new Course("MATH97");
    Course eng101 = new Course("ENG101");
    Course eng126 = new Course("ENG126");
    Course math141 = new Course("MATH141");
    Course math146 = new Course("MATH146");
    Course cmst210 = new Course("CMST210");
    Course labsci = new Course("LAB_SCIENCE");
    Course sdev101 = new Course("SDEV101");
    Course sdev201 = new Course("SDEV201");
    Course sdev106 = new Course("SDEV106");
    Course sdev117 = new Course("SDEV117");
    Course cs108 = new Course("CS108");
    Course sdev121 = new Course("SDEV121");
    Course sdev218 = new Course("SDEV218");
    Course sdev219 = new Course("SDEV219");
    Course sdev220 = new Course("SDEV220");
    Course sdev280 = new Course("SDEV280");

    CourseGraph courseGraph = new CourseGraph();

    private void loadCourses() {
        courseGraph.addCourse(math97, new ArrayList<>(List.of(math141, math146, cs108, sdev218)));
        courseGraph.addCourse(eng101, new ArrayList<>(List.of(eng126)));
        courseGraph.addCourse(eng126, new ArrayList<>());
        courseGraph.addCourse(math141, new ArrayList<>());
        courseGraph.addCourse(math146, new ArrayList<>());
        courseGraph.addCourse(cmst210, new ArrayList<>());
        courseGraph.addCourse(labsci, new ArrayList<>());
        courseGraph.addCourse(sdev101, new ArrayList<>());
        courseGraph.addCourse(sdev201, new ArrayList<>());
        courseGraph.addCourse(sdev106, new ArrayList<>(List.of(sdev117)));
        courseGraph.addCourse(sdev117, new ArrayList<>());
        courseGraph.addCourse(cs108, new ArrayList<>(List.of(sdev121)));
        courseGraph.addCourse(sdev121, new ArrayList<>());
        courseGraph.addCourse(sdev218, new ArrayList<>(List.of(sdev219)));
        courseGraph.addCourse(sdev219, new ArrayList<>(List.of(sdev220)));
        courseGraph.addCourse(sdev220, new ArrayList<>());
        courseGraph.addCourse(sdev280, new ArrayList<>());
    }

    // METHOD: addCourse
    @PostMapping("courses/add/{title}")
    public void addCourse(@PathVariable String title) {
        courseGraph.addCourse(new Course(title), new ArrayList<>());
    }

    // METHOD: getCourses
    @GetMapping("courses/sorted")
    public List<Course> getCourses() {
        loadCourses();
        return courseGraph.sort();
    }

}
