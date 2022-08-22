package com.gd.final_task.enum_data;

import java.util.ArrayList;

import static com.gd.final_task.enum_data.Curriculum.AQE;
import static com.gd.final_task.enum_data.Curriculum.JAVA_DEVELOPER;

public class AvailableCourses {

    public ArrayList<String> getAvailableCourses() {
        ArrayList<String> availableCourses = new ArrayList();
        availableCourses.add(JAVA_DEVELOPER.getCourseName());
        availableCourses.add(AQE.getCourseName());
        return availableCourses;
    }
}
