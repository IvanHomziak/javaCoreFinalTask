package com.gd.final_task.calculations;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.gd.final_task.enum_data.EnumData.AQE;
import static com.gd.final_task.enum_data.EnumData.JAVA_DEVELOPER;


public class Calculations{

    private static final Map<String, Integer> javaDevCourse = new HashMap<>();
    private static final Map<String, Integer> aqeCourse = new HashMap<>();

    public Map<String, Integer> getJavaDevCourseData() {
        javaDevCourse.put("Java", 16);
        javaDevCourse.put("JDBC", 24);
        javaDevCourse.put("Spring", 16);
        return javaDevCourse;
    }
    public Map<String, Integer> getAqeCourseData() {
        aqeCourse.put("Test design", 10);
        aqeCourse.put("Page Object", 16);
        aqeCourse.put("Selenium", 16);
        return aqeCourse;
    }

    public static int programDuration(Map<String, Integer> program) {
        return program.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int courseDurationHours(String courseName) {
        int courseDuration = 0;
        if (courseName.equals(JAVA_DEVELOPER.toString())){
            courseDuration = programDuration(getJavaDevCourseData());
            return courseDuration;
        }
        if (courseName.equals(AQE.toString())) {
            courseDuration = programDuration(getAqeCourseData());
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
