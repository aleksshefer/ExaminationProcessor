package ru.shefer.dao;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringToAnswersParserTest {

    @Test
    void parseToAnswer() throws ParseException {
        StringToAnswersParser parser = new StringToAnswersParser();
        List<String> answersList = new ArrayList<>(
                List.of("name: Ivanov",
                        "1-A",
                        "2-B",
                        "3-C",
                        "4-D",
                        "5-A"));
        Answers answers = new Answers();
        answers.addAnswer(new Answer("Ivanov", 1, "A"));
        answers.addAnswer(new Answer("Ivanov", 2, "B"));
        answers.addAnswer(new Answer("Ivanov", 3, "C"));
        answers.addAnswer(new Answer("Ivanov", 4, "D"));
        answers.addAnswer(new Answer("Ivanov", 5, "A"));

        assertEquals(answers, parser.parseToAnswer(answersList));

    }
}