package com.gd.final_task.start_program;

import com.gd.final_task.calculations.Calculations;
import com.gd.final_task.choose_actions.ChooseCourse;
import com.gd.final_task.display.Display;
import com.gd.final_task.input.Input;
import com.gd.final_task.parsers.Parse;

public class Start extends Input {

    static void startProgram() {
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

    public static void main(String[] args) {
        startProgram();
    }
}
