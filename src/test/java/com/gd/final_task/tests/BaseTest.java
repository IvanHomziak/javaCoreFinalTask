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





    @DataProvider(name = "getAvailableCourses")
    public static Object[][] getAvailableCoursesDataProvider() {
        return new Object[][]{
                {JAVA_DEVELOPER},
                {AQE}
        };
    }
}
