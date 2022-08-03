package com.gd.final_task.enum_data;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.Objects;

import static com.gd.final_task.enum_data.EnumData.AQE;
import static com.gd.final_task.enum_data.EnumData.JAVA_DEVELOPER;
import static org.junit.Assert.assertTrue;

public class AvailableCourses {

    private String a = "Hi";
    private static String object;
    private static String string;


    public ArrayList<String> getAvailableCourses() {
        ArrayList<String> availableCourses = new ArrayList();
        availableCourses.add(JAVA_DEVELOPER.toString());
        availableCourses.add(AQE.toString());
        return availableCourses;
    }






    public static void main(String[] args) {
    }
}
