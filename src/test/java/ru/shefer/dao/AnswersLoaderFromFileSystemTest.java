package ru.shefer.dao;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnswersLoaderFromFileSystemTest {
    @Test
    void downloadAndGetRightAnswers() throws IOException {
        AnswersLoaderFromFileSystem loader =
                new AnswersLoaderFromFileSystem("src\\test\\resources\\rightAnswers.txt",
                        "src\\test\\resources\\studentAnswers.txt");

        List<String> rightAnswers = loader.downloadAndGetRightAnswers();

        assertEquals(2, rightAnswers.size());
        assertEquals("name: Ivanov", rightAnswers.get(0));
        assertEquals("1-A", rightAnswers.get(1));
    }

    @Test
    void downloadAndGetStudentAnswers() throws IOException {
        AnswersLoaderFromFileSystem loader =
                new AnswersLoaderFromFileSystem("src\\test\\resources\\rightAnswers.txt",
                        "src\\test\\resources\\studentAnswers.txt");
        List<String> studentAnswers = loader.downloadAndGetStudentAnswers();

        assertEquals(3, studentAnswers.size());
        assertEquals("name: Ivanov", studentAnswers.get(0));
        assertEquals("1-D", studentAnswers.get(1));
        assertEquals("2-C", studentAnswers.get(2));

    }
}