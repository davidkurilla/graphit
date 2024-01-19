package edu.greenriver.sdev.graphit;

import edu.greenriver.sdev.graphit.models.Course;
import edu.greenriver.sdev.graphit.repository.CourseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GraphitApplication {

    // MAIN METHOD CONTAINS PRE-LOADED DATA
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GraphitApplication.class, args);
        CourseRepository repository = context.getBean(CourseRepository.class);
        List<Course> courseList = new ArrayList<>(List.of(
                new Course("MATH97"),
                new Course("ENG101"),
                new Course("ENG126"),
                new Course("MATH141"),
                new Course("MATH146"),
                new Course("CMST210"),
                new Course("Lab Science"),
                new Course("SDEV101"),
                new Course("SDEV201"),
                new Course("SDEV106"),
                new Course("SDEV117"),
                new Course("CS108"),
                new Course("SDEV121"),
                new Course("SDEV218"),
                new Course("SDEV219"),
                new Course("SDEV220"),
                new Course("SDEV280")
        ));

        repository.saveAll(courseList);
    }

}
