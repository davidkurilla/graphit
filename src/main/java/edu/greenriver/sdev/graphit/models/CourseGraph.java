package edu.greenriver.sdev.graphit.models;

import java.util.*;

// CLASS: CourseGraph
public class CourseGraph {

    // FIELDS
    Map<Course, List<Course>> graph;

    // CONSTRUCTOR
    public CourseGraph() {
        graph = new HashMap<>();
    }

    // METHOD: addCourse
    public void addCourse(Course course, List<Course> prerequisites) {
        graph.put(course, new ArrayList<>(prerequisites));
    }

    //METHOD: hasCycle
    public boolean hasCycle() {

        Map<Course, Boolean> visited = new HashMap<>();
        Map<Course, Boolean> recursionStack = new HashMap<>();

        for (Course course : graph.keySet()) {
            if (isCyclic(course, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }

    // PRIVATE-METHOD: isCyclic
    private boolean isCyclic(Course course, Map<Course, Boolean> visited, Map<Course, Boolean> recursionStack) {
        if (!visited.containsKey(course)) {
            visited.put(course, true);
            recursionStack.put(course, true);

            List<Course> neighbors = graph.get(course);
            if (neighbors != null) {
                for (Course neighbor : neighbors) {
                    if (!visited.containsKey(neighbor) && isCyclic(neighbor, visited, recursionStack)) {
                        return true;
                    } else if (recursionStack.containsKey(neighbor)) {
                        return true;
                    }
                }
            }
        }

        recursionStack.remove(course);
        return false;
    }

    // METHOD: sort
    public List<Course> sort() {
        List<Course> result = new ArrayList<>();
        Set<Course> visited = new HashSet<>();

        for (Course course : graph.keySet()) {
            if (!visited.contains(course)) {
                sortUtil(course, visited, result);
            }
        }

        Collections.reverse(result);
        return result;
    }

    // PRIVATE-METHOD: sortUtil
    private void sortUtil(Course course, Set<Course> visited, List<Course> result) {
        visited.add(course);

        List<Course> neighbors = graph.get(course);
        if (neighbors != null) {
            for (Course neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    sortUtil(neighbor, visited, result);
                }
            }
        }

        result.add(course);
    }

}
