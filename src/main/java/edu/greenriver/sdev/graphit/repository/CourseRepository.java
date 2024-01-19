package edu.greenriver.sdev.graphit.repository;

import edu.greenriver.sdev.graphit.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
