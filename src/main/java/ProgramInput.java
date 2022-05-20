import java.util.Scanner;

public class ProgramInput {

    Scanner sc = new Scanner(System.in);

    void inputStudentName(){
        System.out.println("Enter the name of the student: ");
        sc.nextLine();
    }

    String inputCourseName(){
        CoursesData coursesData = new CoursesData();
        System.out.println("Available courses: AQE or Java Developer.");
        System.out.println("Enter course name: ");
        return coursesData.chooseCourse(sc.nextLine());
    }

    String inputStartDate() {
        System.out.println("Enter the start date: YYYY-MM-DD.");
        return sc.nextLine();
    }
}
