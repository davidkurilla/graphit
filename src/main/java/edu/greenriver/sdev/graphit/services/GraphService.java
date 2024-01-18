package edu.greenriver.sdev.graphit.services;

import edu.greenriver.sdev.graphit.models.Course;
import edu.greenriver.sdev.graphit.models.CourseDigraph;
import org.springframework.stereotype.Service;

import java.util.List;

// CLASS: GraphService
@Service
public class GraphService {

    // FIELDS
    private CourseDigraph graph;

    // CONSTRUCTOR
    public GraphService() {
        graph = new CourseDigraph();
    }

    // METHOD: addCourse
    public void addCourse(Course course) {
        graph.addVertex(course);
    }

    // METHOD: addPrereq
    public boolean addPrereq(Course source, Course destination) {
        graph.addEdge(source, destination);
        if (graph.hasCycle()) {
            graph.removeEdge(source, destination);
            return false;
        }
        return true;
    }

    // METHOD: removeCourse
    public void removeCourse(Course course) {
        graph.removeVertex(course);
    }

    // METHOD: removePrereq
    public void removePrereq(Course source, Course destination) {
        graph.removeEdge(source, destination);
    }

    // METHOD: sortCourses
    public List<Course> sortCourses() {
        return graph.sortCourses();
    }

}
