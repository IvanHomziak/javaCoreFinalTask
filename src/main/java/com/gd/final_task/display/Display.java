package com.gd.final_task.display;

import com.gd.final_task.calculations.Calculations;
import com.gd.final_task.choose_actions.ChooseCourse;
import com.gd.final_task.data.Data;

import static com.gd.final_task.enum_data.EnumData.AQE;
import static com.gd.final_task.enum_data.EnumData.JAVA_DEVELOPER;


public class Display extends Data {

    Calculations calculations = new Calculations();
    Data data = new Data();

    public void displayChosenCourseName(String courseName) {
        System.out.println("CURRICULUM: " + courseName);
    }

    public void displayCourseData(String courseName) {
        if (courseName.equals(AQE.toString())) {
            System.out.println(calculations.getJavaDevCourseData());
        }
        if (courseName.equals(JAVA_DEVELOPER.toString())) {
            System.out.println(calculations.getAqeCourseData());
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
