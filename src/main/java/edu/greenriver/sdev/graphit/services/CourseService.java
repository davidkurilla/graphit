package edu.greenriver.sdev.graphit.services;

import edu.greenriver.sdev.graphit.models.Course;
import edu.greenriver.sdev.graphit.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public void add(Course course) {
        repository.save(course);
    }

    public void update(int id, String title) {

    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
