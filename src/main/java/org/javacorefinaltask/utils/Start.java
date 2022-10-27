package org.javacorefinaltask.utils;

import org.javacorefinaltask.functionality.ChooseCourse;
import org.javacorefinaltask.functionality.Functionality;
import org.javacorefinaltask.functionality.Parse;
import org.javacorefinaltask.io.Input;
import org.javacorefinaltask.io.Output;

public class Start {

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
