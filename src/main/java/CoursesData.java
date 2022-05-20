import java.time.DayOfWeek;
import java.time.LocalDate;

public class CoursesData extends Constants {

    private String courseName;

    String chooseCourse(String courseName) {
        return this.courseName = courseName.toUpperCase();
    }

    protected void displayCourseName(String courseName) {
        System.out.println("CURRICULUM: " + courseName);
    }

    protected void displayCourseData() {
        if (courseName.equals(JAVA_DEVELOPER)) {
            System.out.println("Java: " + JAVA + " hours");
            System.out.println("JDBC: " + JDBC + " hours");
            System.out.println("Spring: " + SPRING + " hours");
        }
        if (courseName.equals(AQE)) {
            System.out.println("Test Design: " + TEST_DESIGN + " hours");
            System.out.println("Page Object: " + PAGE_OBJECT + " hours");
            System.out.println("Selenium: " + SELENIUM + " hours");
        }
    }

    protected void displayCourseDuration() {
        System.out.println("COURSE DURATION:" + courseDurationHours() + "(hrs)");
    }

    protected int courseDurationHours() {
        int courseDuration = 0;
        if (courseName.equals(JAVA_DEVELOPER)){
            int javaCourseDuration = JAVA + JDBC + SPRING;
            courseDuration = javaCourseDuration;
            return courseDuration;
        }
        if (courseName.equals(AQE)) {
            int aqaCourseDuration = TEST_DESIGN + PAGE_OBJECT + SELENIUM;
            courseDuration = aqaCourseDuration;
            return courseDuration;
        }
        return courseDuration;
    }

    protected int courseDurationInDays(int courseDurationHours){
        return courseDurationHours / 8;
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

    LocalDate parseStringToDate(String string) {
        return LocalDate.parse(string);
    }
}

