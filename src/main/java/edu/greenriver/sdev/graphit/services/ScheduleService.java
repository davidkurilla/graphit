package edu.greenriver.sdev.graphit.services;

import org.springframework.stereotype.Service;

import edu.greenriver.sdev.graphit.models.Course;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    public List<List<Course>> buildScheduleFromList(List<Course> inputList, int chunkSize) {

        List<List<Course>> result = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i += chunkSize) {
            int end = Math.min(inputList.size(), i + chunkSize);
            List<Course> chunk = new ArrayList<>(inputList.subList(i, end));
            result.add(chunk);
        }

        return result;
    }


}
