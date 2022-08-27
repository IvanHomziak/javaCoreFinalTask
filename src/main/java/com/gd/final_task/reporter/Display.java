package com.gd.final_task.reporter;

import com.gd.final_task.calculations.Calculations;
import com.gd.final_task.data.Data;

import static com.gd.final_task.enum_data.Curriculum.AQE;
import static com.gd.final_task.enum_data.Curriculum.JAVA_DEVELOPER;


public class Display extends Data {

    private final Calculations calculations = new Calculations();

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
