package com.gd.final_task.functionality;

import com.gd.final_task.io.Input;

import java.time.LocalDate;

public class Parse {

    private final ChooseCourse chooseCourse = new ChooseCourse();
    private final Functionality calculations = new Functionality();
    private final Input input = new Input();

    private final String courseName = chooseCourse.chosenCourse(input.inputCourseName());

    public LocalDate parseStringToDate(String string) {
        LocalDate localDate;
        localDate = LocalDate.parse(string);
//        try {
//            localDate = LocalDate.parse(string);
//        } catch (Exception e) {
//            e.fillInStackTrace();
//            System.out.println("Inputted date format is invalid.\nPlease input valid date format:");
//            localDate = parseStringToDateRecursion();
//        }
        return localDate;
    }

//    private LocalDate parseStringToDateRecursion() {
//        String startDate = input.inputStartDate();
//        return calculations.addDaysSkippingWeekends(parseStringToDate(startDate),
//                (int) calculations.courseDurationInDays(calculations.courseDurationHours(courseName)));
//    }
}

