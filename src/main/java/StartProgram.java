public class StartProgram {

    static void startProgram() {
        ProgramInput input = new ProgramInput();
        MainFunctionality c = new MainFunctionality();
        F f = new F();
        input.inputStudentName();
        c.displayAvailableCourses();
        String courseName = c.chosenCourse(input.inputCourseName());
        c.displayChosenCourseName(courseName);
        c.displayCourseData();
        c.displayCourseDuration();
        int days = (int) c.courseDurationInDays(c.courseDurationHours());
        String startDate = input.inputStartDate();
        System.out.println(c.addDaysSkippingWeekends(c.parseStringToDate(startDate), days));
    }

    public static void main(String[] args) {
        startProgram();
    }
}
