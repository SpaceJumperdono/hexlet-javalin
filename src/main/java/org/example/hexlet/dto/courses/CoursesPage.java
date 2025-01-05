package org.example.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.Course;

import java.util.List;

@Getter
@AllArgsConstructor
public class CoursesPage {
    private List<Course> courses;
    private String header;
}
