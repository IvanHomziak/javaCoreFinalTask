package com.gd.final_task.dataproviders;

import org.testng.annotations.DataProvider;

import java.time.LocalDate;

import static com.gd.final_task.enum_data.EnumData.*;

public class DataProviderSuppliers {

    @DataProvider(name = "AvailableCourses")
    public static Object[][] getAvailableCoursesDataProvider() {
        return new Object[][]{
                {JAVA_DEVELOPER},
                {AQE}
        };
    }
}
