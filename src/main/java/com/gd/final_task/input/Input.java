package com.gd.final_task.input;

import java.util.Scanner;

public class Input {


    private final Scanner sc = new Scanner(System.in);

    public void inputStudentName(){
        System.out.println("Enter student name: ");
        inputString();
    }

    public String inputCourseName(){
        System.out.println("Please input course name:");
        return inputString();
    }

    public String inputStartDate() {
        System.out.println("Enter the start date: YYYY-MM-DD.");
        return inputString();
    }

    private String inputString() {
        return sc.nextLine();
    }
}
