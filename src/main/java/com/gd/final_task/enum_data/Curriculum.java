package com.gd.final_task.enum_data;

import java.util.Arrays;
import java.util.List;

import static com.gd.final_task.enum_data.Course.*;

public enum Curriculum {

    JAVA_DEVELOPER("Java Developer", Arrays.asList(JAVA, JDBC, SPRING)),
    AQE("AQE", Arrays.asList(TEST_DESIGN, PAGE_OBJECT, SELENIUM));

    private final String courseName;
    private final List<Course> subjects;

    Curriculum(String courseName, List<Course> subjects) {
        this.courseName = courseName;
        this.subjects = subjects;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public List<Course> getSubjects() {
        return this.subjects;
    }
}

