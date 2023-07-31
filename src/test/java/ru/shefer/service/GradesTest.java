package ru.shefer.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GradesTest {
    private final Grades grades = new Grades(List.of("2", "4", "6"));

    @Test
    void getFirstGrade() {
        assertEquals(2, grades.getFirstGrade());
    }

    @Test
    void getSecondGrade() {
        assertEquals(4, grades.getSecondGrade());
    }

    @Test
    void getThirdGrade() {
        assertEquals(6, grades.getThirdGrade());
    }
}