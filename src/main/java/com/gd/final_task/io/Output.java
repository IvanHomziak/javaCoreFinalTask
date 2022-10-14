package com.gd.final_task.io;

import com.gd.final_task.functionality.Functionality;
import com.gd.final_task.studentcourses.AvailableCourses;

import static com.gd.final_task.enums.Curriculum.AQE;
import static com.gd.final_task.enums.Curriculum.JAVA_DEVELOPER;


public class Output extends AvailableCourses {

    private final Functionality calculations = new Functionality();

    public void displayChosenCourseName(String courseName) {
        System.out.println("CURRICULUM: " + courseName);
    }

    public void displayCourseData(String courseName) {
        if (courseName.equals(AQE.getCourseName())) {
            System.out.println(calculations.getAqeCourseData());
        }
        if (courseName.equals(JAVA_DEVELOPER.getCourseName())) {
            System.out.println(calculations.getJavaDevCourseData());
        }
    }

    public void displayAvailableCourses() {
        System.out.println("Available courses:");
        for (String course : availableCourses) System.out.println("* " + course);
    }

    public void displayCourseDuration(String courseName) {
        System.out.println("COURSE DURATION:" + calculations.courseDurationHours(courseName) + " (hrs), " +
                calculations.courseDurationInDays(calculations.courseDurationHours(courseName)) + " (days).");
    }

}
