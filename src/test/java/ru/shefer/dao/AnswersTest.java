package ru.shefer.dao;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnswersTest {

    @Test
    void getAnswersByLastName() {
        Answers answers = new Answers();
        Answer answer1 = new Answer("lastName1", 1, "A");
        Answer answer2 = new Answer("lastName1", 2, "C");
        Answer answer3 = new Answer("lastName2", 1, "C");
        Answer answer4 = new Answer("lastName2", 2, "C");

        answers.addAnswer(answer1);
        answers.addAnswer(answer2);
        answers.addAnswer(answer3);
        answers.addAnswer(answer4);
        Map<Integer, Answer> lastName1Answers = answers.getAnswersByLastName("lastName1");
        assertEquals(2, lastName1Answers.size());
        assertEquals(answer1, lastName1Answers.get(1));
        assertEquals(answer2, lastName1Answers.get(2));


    }

    @Test
    void addAnswerAndGetAllAnswers() {
        Answers answers = new Answers();
        List<Answer> allAnswers = answers.getAllAnswers();
        assertTrue(allAnswers.isEmpty());

        Answer answer1 = new Answer("lastName1", 1, "A");
        Answer answer2 = new Answer("lastName1", 2, "C");

        answers.addAnswer(answer1);
        answers.addAnswer(answer2);

        allAnswers = answers.getAllAnswers();

        assertEquals(2, allAnswers.size());
    }
}