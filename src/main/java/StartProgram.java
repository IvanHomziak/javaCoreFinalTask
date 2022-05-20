public class StartProgram {

    static void startProgram() {
        ProgramInput input = new ProgramInput();
        CoursesData c = new CoursesData();
        input.inputStudentName();
        String courseNAme = c.chooseCourse(input.inputCourseName());
        c.displayCourseName(courseNAme);
        c.displayCourseData();
        c.displayCourseDuration();
        int days = c.courseDurationInDays(c.courseDurationHours());
        String startDate = input.inputStartDate();
        System.out.println(c.addDaysSkippingWeekends(c.parseStringToDate(startDate), days));
    }

    public static void main(String[] args) {
        startProgram();
    }
}
