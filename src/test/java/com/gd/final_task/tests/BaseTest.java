package com.gd.final_task.tests;

import com.gd.final_task.calculations.Calculations;
import com.gd.final_task.enum_data.CoursesData;
import com.gd.final_task.enum_data.Subjects;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.gd.final_task.enum_data.CoursesData.AQE;
import static com.gd.final_task.enum_data.CoursesData.JAVA_DEVELOPER;
import static org.assertj.core.api.Assertions.assertThat;


public class BaseTest {

    private final Calculations calculations = new Calculations();

    @Test(dataProvider = "getAvailableCourses")
    public void testCourseDurationIsEqualZero(CoursesData coursesData) {
        assertThat(calculations.courseDurationHours(coursesData.getCourseName()))
                .describedAs("Course duration is equal to ZERO:" + coursesData)
                .isNotEqualTo(0);
    }

    @Test(dataProvider = "getAvailableCourses")
    public void testCourseDurationIsNotNull(CoursesData coursesData) {
        assertThat(calculations.courseDurationHours(coursesData.getCourseName()))
                .describedAs("Course is equal to NULL" + coursesData)
                .isNotNull();
    }

    @Test
    public void testCourseLastDay() {
        assertThat(calculations.addDaysSkippingWeekends(LocalDate.of(2022, 8, 12),
                (int) calculations.courseDurationInDays(calculations.courseDurationHours(AQE.getCourseName()))))
                .describedAs("Course last day is incorrect")
                .isEqualTo(LocalDate.of(2022, 8, 19));
        assertThat(calculations.addDaysSkippingWeekends(LocalDate.of(2022, 8, 12),
                (int) calculations.courseDurationInDays(calculations.courseDurationHours(JAVA_DEVELOPER.getCourseName()))))
                .describedAs("Course last day is incorrect")
                .isEqualTo(LocalDate.of(2022, 8, 23));
    }

    @Test(expectedExceptions = DateTimeException.class)
    public void testCourseDurationHaveTimeException() {
        assertThat(calculations.addDaysSkippingWeekends(LocalDate.of(2022, 8, 32),
                (int) calculations.courseDurationInDays(calculations.courseDurationHours(AQE.toString()))))
                .describedAs("Day number is incorrect")
                .isEqualTo(LocalDate.of(2022, 8, 12));
        assertThat(calculations.addDaysSkippingWeekends(LocalDate.of(2022, 13, 12),
                (int) calculations.courseDurationInDays(calculations.courseDurationHours(AQE.toString()))))
                .describedAs("Month number is incorrect")
                .isEqualTo(LocalDate.of(2022, 8, 8));
    }

    @Test(dataProvider = "getAvailableCourses")
    public void testProgramDuration(CoursesData coursesData) {
        assertThat(calculations.courseDurationHours(coursesData.getCourseName()))
                .describedAs("Course duration is incorrect")
                .isEqualTo(coursesData.getSubjects().stream().mapToInt(Subjects::getSubjectDuration)
                        .sum());
    }

    @DataProvider(name = "getAvailableCourses")
    public static Object[][] getAvailableCoursesDataProvider() {
        return new Object[][]{
                {JAVA_DEVELOPER},
                {AQE}
        };
    }
}
