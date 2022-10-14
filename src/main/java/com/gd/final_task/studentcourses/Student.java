package com.gd.final_task.studentcourses;

import com.gd.final_task.enums.Curriculum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {

    private final String studentFullName;
    private final Curriculum courseName;
    private final LocalDate startDate;
}
