//import org.testng.annotations.Test;
//
//import java.time.LocalDate;
//
//import static org.testng.Assert.*;
//
//public class MainFunctionalityTest {
//
//    private MainFunctionality mainFunctionality = new MainFunctionality();
//    private String courseNameValue = "Course_Name";
//    private String todayDate = "2022-06-03";
//    private LocalDate date = LocalDate.of(2022,06,03);
//
//
//    @Test
//    public void testChosenCourse() {
//        String value1 = mainFunctionality.chosenCourse(courseNameValue);
//        assertEquals(value1, "COURSE_NAME", "String not convert to Upper case");
//    }
//
//    @Test
//    public void testDisplayChosenCourseName() {
//        mainFunctionality.displayChosenCourseName(courseNameValue);
//    }
//
//    @Test
//    public void testCourseDurationHours() {
//        mainFunctionality.chosenCourse("aqe");
//        assertEquals(mainFunctionality.courseDurationHours(), 42);
//    }
//
//    @Test
//    public void testCourseDurationInDays() {
//        mainFunctionality.chosenCourse("aqe");
//        mainFunctionality.courseDurationHours();
//        mainFunctionality.courseDurationInDays(mainFunctionality.courseDurationHours());
//        assertEquals(mainFunctionality.courseDurationInDays(mainFunctionality.courseDurationHours()),
//                5.25, "Course days not equal");
//    }
//
//    @Test
//    public void testAddDaysSkippingWeekends() {
//        LocalDate dateWithSkippedWeekends = LocalDate.of(2022,06,17);
//        assertEquals(mainFunctionality.addDaysSkippingWeekends(date, 10), dateWithSkippedWeekends);
//    }
//
//    @Test
//    public void testParseStringToDate() {
//        LocalDate date1 = mainFunctionality.parseStringToDate(todayDate);
//        assertEquals(date1 , date);
//    }
//
//    @Test
//    public void testCompareCourseData() {
//    }
//
//    @Test
//    public void testDisplayAvailableCourses() {
//        mainFunctionality.displayAvailableCourses();
//    }
//
//    @Test
//    public void testDisplayCourseDuration() {
//    }
//}