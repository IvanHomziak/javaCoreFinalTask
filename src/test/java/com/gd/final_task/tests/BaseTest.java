package com.gd.final_task.tests;

import com.gd.final_task.calculations.Calculations;
import com.gd.final_task.enum_data.Curriculum;
import com.gd.final_task.enum_data.Course;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static com.gd.final_task.enum_data.Curriculum.AQE;
import static com.gd.final_task.enum_data.Curriculum.JAVA_DEVELOPER;
import static org.assertj.core.api.Assertions.assertThat;


public class BaseTest {

    private final Calculations calculations = new Calculations();

    //перевір що години відповідають кількості годин на курсі. Два аргументи перевірити назву курсу та його довжину в годинах
    @Test(dataProvider = "getAvailableCourses")
    public void testCourseDurationIsEqualZero(Curriculum coursesData) {
        assertThat(calculations.courseDurationHours(coursesData.getCourseName()))
                .describedAs("Course duration is equal to ZERO:" + coursesData)
                .isNotEqualTo(0);
    }

    @Test(dataProvider = "getAvailableCourses")
    public void testCourseDurationIsNotNull(Curriculum coursesData) {
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
    public void testProgramDuration(Curriculum coursesData) {
        assertThat(calculations.courseDurationHours(coursesData.getCourseName()))
                .describedAs("Course duration is incorrect")
                .isEqualTo(coursesData.getSubjects().stream().mapToInt(Course::getSubjectDuration)
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
