import java.time.DayOfWeek;
import java.time.LocalDate;

public class MainFunctionality extends Constants {

    private String courseName;
    private ProgramInput programInput = new ProgramInput();

    protected String chosenCourse(String courseName) {
        return this.courseName = courseName.toUpperCase();
    }

    protected void displayChosenCourseName(String courseName) {
        System.out.println("CURRICULUM: " + courseName);
    }

    protected void displayCourseData() {
        if (courseName.equals(AQE)) {
            for (int i = 0; i < aqeSubjects.length; i++) {
                System.out.println(aqeSubjects[i] + '\t' + aqeSubjectsHours[i]);
            }
        }
        if (courseName.equals(JAVA_DEVELOPER)) {
            for (int i = 0; i < javaDeveloperSubjects.length; i++) {
                System.out.println(javaDeveloperSubjects[i] + '\t' + javaDeveloperHours[i]);
            }
        }
    }

    protected void displayAvailableCourses() {
        System.out.println("Available courses:");
        for (String course : availableCourses) System.out.println("* " + course);
    }

    protected void displayCourseDuration() {
        System.out.println("COURSE DURATION:" + courseDurationHours() + " (hrs), " +
                courseDurationInDays(courseDurationHours()) + " (days).");
    }

    protected int courseDurationHours() {
        int courseDuration = 0;
        if (courseName.equals(JAVA_DEVELOPER)){
            courseDuration = sum(javaDeveloperHours);
            return courseDuration;
        }
        if (courseName.equals(Constants.AQE)) {
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

    protected float courseDurationInDays(int courseDurationHours){
        return (float) courseDurationHours / 8;
    }

    protected LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
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

    protected LocalDate parseStringToDate(String string) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(string);
        } catch (Exception e) {
            e.fillInStackTrace();
            System.out.println("Inputted date format is invalid.\nPlease input valid date format:");
            localDate = parseStringToDateRecursion();
        }
        return localDate;
    }

    private LocalDate parseStringToDateRecursion() {
        String startDate = programInput.inputStartDate();
        return addDaysSkippingWeekends(parseStringToDate(startDate),
                (int) courseDurationInDays(courseDurationHours()));
    }
}

