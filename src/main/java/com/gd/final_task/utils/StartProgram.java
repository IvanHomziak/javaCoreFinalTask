package com.gd.final_task.utils;

import com.gd.final_task.calculations.Calculations;
import com.gd.final_task.chooseactions.ChooseCourse;
import com.gd.final_task.io.Input;
import com.gd.final_task.parsers.Parse;
import com.gd.final_task.reporter.Display;

public class StartProgram {

    public static void startProgram() {
        Input input = new Input();
        Display display = new Display();
        Calculations calculations = new Calculations();
        ChooseCourse chooseCourse = new ChooseCourse();
        Parse parse = new Parse();

        input.inputStudentName();
        display.displayAvailableCourses();
        String courseName = chooseCourse.chosenCourse(input.inputCourseName());
        display.displayChosenCourseName(courseName);
        display.displayCourseData(courseName);
        display.displayCourseDuration(courseName);
        int days = (int) calculations.courseDurationInDays(calculations.courseDurationHours(courseName));
        String startDate = input.inputStartDate();
        System.out.println(calculations.addDaysSkippingWeekends(parse.parseStringToDate(startDate), days));
    }
}
