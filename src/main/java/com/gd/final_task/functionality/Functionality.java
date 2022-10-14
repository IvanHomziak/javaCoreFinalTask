package com.gd.final_task.functionality;

import com.gd.final_task.studentcourses.Student;
import com.gd.final_task.enums.Curriculum;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Functionality {

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
        int courseDurationHours = 0;
        if (courseName.equals(Curriculum.JAVA_DEVELOPER.getCourseName())){
            courseDurationHours = programDuration(getJavaDevCourseData());
            return courseDurationHours;
        }
        else if (courseName.equals(Curriculum.AQE.getCourseName())) {
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

    public Map<Student, Integer> calculateBusinessDays(final List<Student> studentsList, LocalDate waypointDate) {
        Map<Student, Integer> calculatedStudentsDays = new HashMap<>();

        for (Student student : studentsList) {
            if (student.getStartDate() == null || waypointDate == null) {
                throw new IllegalArgumentException("Invalid method argument(s) to " +
                        "countBusinessDaysBetween (" + student.getStartDate()
                        + "," + waypointDate + ")");
            }

            Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
                    || date.getDayOfWeek() == DayOfWeek.SUNDAY;

            long daysBetween = ChronoUnit.DAYS.between(student.getStartDate(), waypointDate);

            calculatedStudentsDays.put(student, (int) Stream.iterate(student.getStartDate(), date -> date.plusDays(1))
                    .limit(daysBetween)
                    .filter(isWeekend.negate()).count());
        }
        return calculatedStudentsDays;
    }
}
