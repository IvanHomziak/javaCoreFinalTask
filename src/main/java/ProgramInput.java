import org.junit.Test;

import java.util.Locale;
import java.util.Scanner;

public class ProgramInput {

    private Scanner sc = new Scanner(System.in);
    private String course;



    void inputStudentName(){
        System.out.println("Enter the name of the student: ");
        inputString();
    }

    public String inputCourseName(){
        System.out.println("Please input course name:");
        return inputString();
    }

    String inputStartDate() {
        System.out.println("Enter the start date: YYYY-MM-DD.");
        return inputString();
    }

    String inputString() {
        return sc.nextLine();
    }


    public static void main(String[] args) {
        MainFunctionality mF = new MainFunctionality();
        ProgramInput is = new ProgramInput();
        is.inputCourseName();
    }
}
