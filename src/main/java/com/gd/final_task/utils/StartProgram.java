package com.gd.final_task.utils;

import com.gd.final_task.functionality.Functionality;
import com.gd.final_task.functionality.ChooseCourse;
import com.gd.final_task.io.Input;
import com.gd.final_task.functionality.Parse;
import com.gd.final_task.io.Output;

public class StartProgram {

    public static void startProgram() {
        Input input = new Input();
        Output display = new Output();
        Functionality calculations = new Functionality();
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
