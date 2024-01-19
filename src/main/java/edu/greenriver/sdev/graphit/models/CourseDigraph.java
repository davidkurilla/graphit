package edu.greenriver.sdev.graphit.models;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;

// CLASS: CourseDigraph
public class CourseDigraph {

    // FIELDS
    private final Map<Course, List<Course>> adjList;

    // CONSTRUCTOR
    public CourseDigraph() {
        adjList = new HashMap<>();
    }

    // METHOD: addVertex
    public void addVertex(Course vertex) {
        adjList.put(vertex, new LinkedList<>());
    }

    // METHOD: addEdge
    public void addEdge(Course source, Course destination) {
        if (!adjList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjList.containsKey(destination)) {
            addVertex(destination);
        }
        adjList.get(source).add(destination);
    }

    // METHOD: removeVertex
    public void removeVertex(Course vertex) {
        adjList.remove(vertex);
    }

    // METHOD: removeEdge
    public void removeEdge(Course source, Course destination) {
        if (!adjList.containsKey(source)) {
            return;
        }
        if (!adjList.containsKey(destination)) {
            return;
        }
        adjList.get(source).remove(destination);
    }

    // PRIVATE-METHOD: hasCycle
    public boolean hasCycle() {

        Set<Course> visited = new HashSet<>();
        Set<Course> recursionStack = new HashSet<>();

        for (Course vertex : adjList.keySet()) {
            if (!visited.contains(vertex) && hasCycleUtil(vertex, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }

    // PRIVATE-METHOD: hasCycleUtil
    private boolean hasCycleUtil(Course vertex, Set<Course> visited, Set<Course> recursionStack) {

        visited.add(vertex);
        recursionStack.add(vertex);

        for (Course neighbor : adjList.getOrDefault(vertex, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                if (hasCycleUtil(neighbor, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack.contains(neighbor)) {
                return true;
            }
        }

        recursionStack.remove(vertex);

        return false;
    }

    // MEHTOD: sortCourses
    public List<Course> sortCourses() {
        Stack<Course> stack = new Stack<>();
        Set<Course> visited = new HashSet<>();

        for (Course vertex : adjList.keySet()) {
            if (!visited.contains(vertex)) {
                sortUtil(vertex, visited, stack);
            }
        }

        List<Course> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    // METHOD: sortUtil
    private void sortUtil(Course vertex, Set<Course> visited, Stack<Course> stack) {
        visited.add(vertex);

        for (Course neighbor : adjList.getOrDefault(vertex, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                sortUtil(neighbor, visited, stack);
            }
        }

        stack.push(vertex);
    }
}
