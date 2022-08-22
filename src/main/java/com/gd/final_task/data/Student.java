package com.gd.final_task.data;

import com.gd.final_task.enum_data.Curriculum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {

    private final String studentFullName;
    private final Curriculum courseName;
    private final LocalDate startDate;
}
