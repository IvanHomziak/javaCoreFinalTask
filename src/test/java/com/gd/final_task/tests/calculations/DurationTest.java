package com.gd.final_task.tests.calculations;

import com.gd.final_task.calculations.Calculations;
import com.gd.final_task.enum_data.Course;
import com.gd.final_task.enum_data.Curriculum;
import com.gd.final_task.parsers.Parse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static com.gd.final_task.enum_data.Curriculum.AQE;
import static com.gd.final_task.enum_data.Curriculum.JAVA_DEVELOPER;
import static org.assertj.core.api.Assertions.assertThat;

public class DurationTest {

    private final Calculations calculations = new Calculations();


    @Test(expectedExceptions = DateTimeException.class)
    public void testCourseDurationHaveTimeExceptionJavaDev() {
        assertThat(calculations.addDaysSkippingWeekends(LocalDate.of(2022, 8, 32),
                (int) calculations.courseDurationInDays(calculations.courseDurationHours(AQE.toString()))))
                .describedAs("Day number is incorrect")
                .isEqualTo(LocalDate.of(2022, 8, 12));
        assertThat(calculations.addDaysSkippingWeekends(LocalDate.of(2022, 13, 12),
                (int) calculations.courseDurationInDays(calculations.courseDurationHours(AQE.toString()))))
                .describedAs("Month number is incorrect")
                .isEqualTo(LocalDate.of(2022, 8, 8));
    }

    @Test(expectedExceptions = DateTimeException.class)
    public void testCourseDurationHaveTimeExceptionAQE() {
        assertThat(calculations.addDaysSkippingWeekends(LocalDate.of(2022, 8, 32),
                (int) calculations.courseDurationInDays(calculations.courseDurationHours(JAVA_DEVELOPER.toString()))))
                .describedAs("Day number is incorrect")
                .isEqualTo(LocalDate.of(2022, 8, 12));
        assertThat(calculations.addDaysSkippingWeekends(LocalDate.of(2022, 13, 12),
                (int) calculations.courseDurationInDays(calculations.courseDurationHours(JAVA_DEVELOPER.toString()))))
                .describedAs("Month number is incorrect")
                .isEqualTo(LocalDate.of(2022, 8, 8));
    }

    @Test(dataProvider = "getAvailableCourses")
    public void testProgramDuration(Curriculum coursesData) {
        assertThat(calculations.courseDurationHours(coursesData.getCourseName()))
                .describedAs("Course duration is incorrect")
                .isEqualTo(coursesData.getSubjects().stream().mapToInt(Course::getSubjectDuration)
                        .sum());
    }

    @Test(dataProvider = "getAvailableCourses")
    public void testCourseDurationIsEqualToHours(Curriculum coursesData, int courseDuration) {
        assertThat(calculations.courseDurationHours(coursesData.getCourseName()))
                .describedAs("Course duration is equal to ZERO:" + coursesData)
                .isEqualTo(courseDuration);
    }

    @Test(dataProvider = "getAvailableCoursesWithStartDate")
    public void testCourseStartLastDay(Curriculum coursesData, String startDay, LocalDate lastDay) {
        Parse parser = new Parse();
        assertThat(calculations.addDaysSkippingWeekends(parser.parseStringToDate(startDay),
                (int) calculations.courseDurationInDays(calculations.courseDurationHours(coursesData.getCourseName()))))
                .describedAs(coursesData + " course last day is incorrect")
                .isEqualTo(lastDay); //last date
    }

    @DataProvider(name = "getAvailableCourses")
    public static Object[][] getAvailableCoursesDataProvider() {
        return new Object[][]{
                {JAVA_DEVELOPER, 56},
                {AQE, 42}
        };
    }

    @DataProvider(name = "getAvailableCoursesWithStartDate")
    public static Object[][] getAvailableCoursesWithStartDate() {
        return new Object[][]{
                {JAVA_DEVELOPER, "2022-10-12", LocalDate.of(2022, 10, 21)},
                {AQE, "2022-10-12", LocalDate.of(2022, 10, 19)}
        };
    }
}
