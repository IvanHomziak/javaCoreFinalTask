//public class StartProgram {
//
//    static void startProgram() {
//        ProgramInput input = new ProgramInput();
//        MainFunctionality mF = new MainFunctionality();
//
//        input.inputStudentName();
//        mF.displayAvailableCourses();
//        String courseName = mF.chosenCourse(input.inputCourseName());
//        mF.displayChosenCourseName(courseName);
//        mF.displayCourseData();
//        mF.displayCourseDuration();
//        int days = (int) mF.courseDurationInDays(mF.courseDurationHours());
//        String startDate = input.inputStartDate();
//        System.out.println(mF.addDaysSkippingWeekends(mF.parseStringToDate(startDate), days));
//    }
//
//    public static void main(String[] args) {
//        startProgram();
//    }
//}
