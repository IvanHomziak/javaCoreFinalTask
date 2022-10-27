package org.javacorefinaltask.calculations.students;

import org.javacorefinaltask.functionality.Functionality;
import org.javacorefinaltask.studentcourses.Student;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.javacorefinaltask.enums.Curriculum.AQE;
import static org.javacorefinaltask.enums.Curriculum.JAVA_DEVELOPER;

public class StudentTest {

    @Test(dataProvider = "getStudents", expectedExceptions = IllegalArgumentException.class)
    public void testProgramDurationHasIllegalArgumentException(List<Student> studentsList, LocalDate entryPoint) {
        new Functionality().calculateBusinessDays(studentsList, entryPoint);
    }

    @DataProvider(name = "getStudents")
    public Object[][] Students() {
        return new Object[][]{
                {Arrays.asList(
                        new Student("Ivanov Ivan", JAVA_DEVELOPER, null),
                        new Student("Sidorov Ivan", AQE, LocalDate.of(2022, 3, 1))),
                        LocalDate.of(2022, 3, 1)},
                {Arrays.asList(
                        new Student("Ivanov Ivan", JAVA_DEVELOPER, LocalDate.of(2022, 3, 1)),
                        new Student("Sidorov Ivan", AQE, LocalDate.of(2022, 3, 1))),
                        null}
        };
    }
}
