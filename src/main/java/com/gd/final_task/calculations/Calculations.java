package com.gd.final_task.calculations;

import com.gd.final_task.data.Data;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static com.gd.final_task.data.Data.AQE;
import static com.gd.final_task.data.Data.JAVA_DEVELOPER;

public class Calculations {

    protected int []aqeSubjectsHours = {TEST_DESIGN, PAGE_OBJECT, SELENIUM};
    protected int []javaDeveloperHours = {JAVA, JDBC, SPRING};

    private static final int
            JAVA = 16,
            JDBC = 24,
            SPRING = 16,
            TEST_DESIGN = 10,
            PAGE_OBJECT = 16,
            SELENIUM = 16;

    @Test
    public int courseDurationHours(String courseName) {
        int courseDuration = 0;
        if (courseName.equals(JAVA_DEVELOPER)){
            courseDuration = sum(javaDeveloperHours);
            return courseDuration;
        }
        if (courseName.equals(AQE)) {
            courseDuration = sum(aqeSubjectsHours);
            return courseDuration;
        }
        return courseDuration;
    }

    private int sum(int []subjectsHours) {
        int sum = 0;
        int i;
        for (i = 0; i < subjectsHours.length; i++)
            sum += subjectsHours[i];
        return sum;
    }

    public float courseDurationInDays(int courseDurationHours){
        return (float) courseDurationHours / 8;
    }

    public LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

}
