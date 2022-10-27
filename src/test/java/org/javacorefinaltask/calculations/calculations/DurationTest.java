package org.javacorefinaltask.calculations.calculations;

import org.javacorefinaltask.functionality.Functionality;
import org.javacorefinaltask.enums.Course;
import org.javacorefinaltask.enums.Curriculum;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.javacorefinaltask.enums.Curriculum.AQE;
import static org.javacorefinaltask.enums.Curriculum.JAVA_DEVELOPER;
import static org.assertj.core.api.Assertions.assertThat;

public class DurationTest {

    private final Functionality calculations = new Functionality();


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

    @DataProvider(name = "getAvailableCourses")
    public static Object[][] getAvailableCoursesDataProvider() {
        return new Object[][]{
                {JAVA_DEVELOPER, 56},
                {AQE, 42}
        };
    }
}
