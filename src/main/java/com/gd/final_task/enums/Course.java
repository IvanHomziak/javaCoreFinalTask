package com.gd.final_task.enums;

public enum Course {

    JAVA("Java", 16),
    JDBC("JDBC", 24),
    SPRING("Spring", 16),
    TEST_DESIGN("Test design", 10),
    PAGE_OBJECT("Page Object", 16),
    SELENIUM("Selenium", 16);

    private final String name;
    private final int courseSubjectDuration;

    Course(String name, int courseSubjectDuration) {
        this.name = name;
        this.courseSubjectDuration = courseSubjectDuration;
    }

    public int getSubjectDuration() {
        return this.courseSubjectDuration;
    }
}
