package com.gd.final_task.parsers;

import com.gd.final_task.calculations.Calculations;
import com.gd.final_task.choose_actions.ChooseCourse;
import com.gd.final_task.input.Input;

import java.time.LocalDate;

public class Parse {

    ChooseCourse chooseCourse = new ChooseCourse();
    Calculations calculations = new Calculations();
    Input input = new Input();

    String courseName = chooseCourse.chosenCourse(input.inputCourseName());

    public LocalDate parseStringToDate(String string) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(string);
        } catch (Exception e) {
            e.fillInStackTrace();
            System.out.println("Inputted date format is invalid.\nPlease input valid date format:");
            localDate = parseStringToDateRecursion();
        }
        return localDate;
    }

    private LocalDate parseStringToDateRecursion() {
        String startDate = input.inputStartDate();
        return calculations.addDaysSkippingWeekends(parseStringToDate(startDate),
                (int) calculations.courseDurationInDays(calculations.courseDurationHours(courseName)));
    }

}
