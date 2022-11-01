package org.javacorefinaltask.utils;

import org.javacorefinaltask.functionality.ChooseCourse;
import org.javacorefinaltask.functionality.Functionality;
import org.javacorefinaltask.functionality.Parse;
import org.javacorefinaltask.io.Input;
import org.javacorefinaltask.io.Output;

public class Start {

    public static void startProgram() {

        ChooseCourse chooseCourse = new ChooseCourse();

        new Input().inputStudentName();
        new Output().displayAvailableCourses();

        chooseCourse.setCourseName(new Input().inputCourseName());
        chooseCourse.chosenCourse(chooseCourse.getCourseName());

        new Output().displayFullData(chooseCourse.getCourseName());

        System.out.println(new Functionality().addDaysSkippingWeekends(
                new Parse().parseStringToDate(new Input().inputStartDate()),
                new Functionality().courseDaysDuration(chooseCourse.getCourseName()))
        );
    }
}
