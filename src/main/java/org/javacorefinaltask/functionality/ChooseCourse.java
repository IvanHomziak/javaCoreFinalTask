package org.javacorefinaltask.functionality;

public class ChooseCourse {

    private String courseName;

    public ChooseCourse() {
    }

    public ChooseCourse(String courseName) {
        this.courseName = courseName;
    }

    public String chosenCourse(String courseName) {

        return this.courseName = courseName.toUpperCase();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
