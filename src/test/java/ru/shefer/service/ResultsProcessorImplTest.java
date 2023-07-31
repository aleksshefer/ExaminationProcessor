package ru.shefer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.shefer.dao.Answer;
import ru.shefer.dao.Answers;
import ru.shefer.dao.interfaces.AnswersLoader;
import ru.shefer.dao.interfaces.AnswersParser;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ResultsProcessorImplTest {
    @Mock
    private ExaminationResults examinationResults;
    @Mock
    private AnswersLoader answersLoader;
    @Mock
    private AnswersParser answersParser;
    @Mock
    private Grades grades;
    @InjectMocks
    private ResultsProcessorImpl resultsProcessor;

    @Test
    void downloadAndParseAnswers() throws IOException, ParseException {
        List<String> list1 = new ArrayList<>();
        Answers answers1 = new Answers();

        when(answersLoader.downloadAndGetRightAnswers()).thenReturn(list1);
        when(answersLoader.downloadAndGetStudentAnswers()).thenReturn(list1);
        when(answersParser.parseToAnswer(list1)).thenReturn(answers1);

        resultsProcessor.downloadAndParseAnswers();

        verify(answersLoader, times(1)).downloadAndGetRightAnswers();
        verify(answersLoader, times(1)).downloadAndGetStudentAnswers();
        verify(answersParser, times(2)).parseToAnswer(list1);
        verify(examinationResults, times(1)).setRightAnswers(answers1);
        verify(examinationResults, times(1)).setStudentAnswers(answers1);

    }

    @Test
    void getSummaryGrade() {
        Answers rightAnswers = new Answers();
        rightAnswers.addAnswer(new Answer("Ivanov", 1, "A"));
        rightAnswers.addAnswer(new Answer("Ivanov", 2, "A"));
        rightAnswers.addAnswer(new Answer("Ivanov", 3, "A"));
        rightAnswers.addAnswer(new Answer("Ivanov", 4, "A"));
        rightAnswers.addAnswer(new Answer("Ivanov", 5, "A"));
        rightAnswers.addAnswer(new Answer("Ivanov", 6, "A"));
        rightAnswers.addAnswer(new Answer("Ivanov", 7, "A"));
        rightAnswers.addAnswer(new Answer("Ivanov", 8, "A"));
        rightAnswers.addAnswer(new Answer("Ivanov", 9, "A"));
        rightAnswers.addAnswer(new Answer("Ivanov", 10, "A"));

        Answers studentAnswers = new Answers();
        studentAnswers.addAnswer(new Answer("Ivanov", 1, "A"));
        studentAnswers.addAnswer(new Answer("Ivanov", 2, "B"));
        studentAnswers.addAnswer(new Answer("Ivanov", 3, "B"));
        studentAnswers.addAnswer(new Answer("Ivanov", 4, "B"));
        studentAnswers.addAnswer(new Answer("Ivanov", 5, "A"));
        studentAnswers.addAnswer(new Answer("Ivanov", 6, "B"));
        studentAnswers.addAnswer(new Answer("Ivanov", 7, "B"));
        studentAnswers.addAnswer(new Answer("Ivanov", 8, "B"));
        studentAnswers.addAnswer(new Answer("Ivanov", 9, "A"));
        studentAnswers.addAnswer(new Answer("Ivanov", 10, "B"));


        when(grades.getFirstGrade()).thenReturn(2);
        when(grades.getSecondGrade()).thenReturn(4);
        when(grades.getThirdGrade()).thenReturn(6);

        when(examinationResults.getRightAnswers()).thenReturn(rightAnswers);
        when(examinationResults.getStudentAnswers()).thenReturn(studentAnswers);

        Integer ivanovGrade = resultsProcessor.getSummaryGrade("Ivanov");

        assertEquals(12, ivanovGrade);

    }
}