package edu.greenriver.sdev.graphit.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Schedule {

    private Course[] fall;
    private Course[] winter;
    private Course[] spring;

    public Schedule() {
        fall = new Course[3];
        winter = new Course[3];
        spring = new Course[3];
    }
}
