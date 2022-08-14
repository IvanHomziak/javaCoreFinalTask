package com.gd.final_task.calculations;

import com.gd.final_task.enum_data.CoursesData;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        Calculations calculations = new Calculations();
        System.out.println(calculations.courseDurationHours("Java Developer"));

    }
    public int courseDurationHours(String courseName) {
        int courseDurationHours = 0;
        if (courseName.equals(CoursesData.JAVA_DEVELOPER.getCourseName())){
            courseDurationHours = programDuration(getJavaDevCourseData());
            return courseDurationHours;
        }
        else if (courseName.equals(CoursesData.AQE.getCourseName())) {
            courseDurationHours = programDuration(getAqeCourseData());
            return courseDurationHours;
        }
        return courseDurationHours;
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
