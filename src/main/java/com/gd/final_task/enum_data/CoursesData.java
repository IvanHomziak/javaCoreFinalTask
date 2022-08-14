package com.gd.final_task.enum_data;

import java.util.Arrays;
import java.util.List;

import static com.gd.final_task.enum_data.Subjects.*;

public enum CoursesData {

    JAVA_DEVELOPER("Java Developer", Arrays.asList(JAVA, JDBC, SPRING)),
    AQE("AQE", Arrays.asList(TEST_DESIGN, PAGE_OBJECT, SELENIUM));

    private final String courseName;
    private List<Subjects> subjects;

    CoursesData(String courseName) {
        this.courseName = courseName;
    }

    CoursesData(String courseName, List<Subjects> subjects) {
        this.courseName = courseName;
        this.subjects = subjects;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public List<Subjects> getSubjects() {
        return this.subjects;
    }
}

