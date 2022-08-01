package com.gd.final_task.display;

import com.gd.final_task.calculations.Calculations;
import com.gd.final_task.choose_actions.ChooseCourse;
import com.gd.final_task.data.Data;


public class Display extends Data {

    Calculations calculations = new Calculations();
    ChooseCourse chooseCourse = new ChooseCourse();

    public void displayChosenCourseName(String courseName) {
        System.out.println("CURRICULUM: " + courseName);
    }

    public void displayCourseData(String courseName) {
        if (courseName.equals(AQE)) {
            for (int i = 0; i < aqeSubjects.length; i++) {
                System.out.println(aqeSubjects[i] + '\t' + aqeSubjectsHours[i]);
            }
        }
        if (courseName.equals(JAVA_DEVELOPER)) {
            for (int i = 0; i < javaDeveloperSubjects.length; i++) {
                System.out.println(javaDeveloperSubjects[i] + '\t' + javaDeveloperHours[i]);
            }
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
