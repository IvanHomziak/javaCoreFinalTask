package org.javacorefinaltask.functionality;

import org.javacorefinaltask.io.Input;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Parse {

    private final ChooseCourse chooseCourse = new ChooseCourse();
    private final Functionality calculations = new Functionality();
    private final Input input = new Input();

    private final String courseName = chooseCourse.chosenCourse(input.inputCourseName());

    public LocalDate parseStringToDate(String string) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(string);
        } catch (DateTimeParseException e) {
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

