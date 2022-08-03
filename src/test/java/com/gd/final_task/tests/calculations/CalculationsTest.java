package com.gd.final_task.tests.calculations;

import com.gd.final_task.dataproviders.DataProviderSuppliers;
import com.gd.final_task.enum_data.AvailableCourses;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CalculationsTest {

    @Test(description = "Merge bag between Web and Mob app",
            dataProvider = "AvailableCourses",
            dataProviderClass = DataProviderSuppliers.class)
    public void courseDurationHoursTest(String string) {
        AvailableCourses availableCourses = new AvailableCourses();
        assertEquals(string, availableCourses.getAvailableCourses());

    }


}
