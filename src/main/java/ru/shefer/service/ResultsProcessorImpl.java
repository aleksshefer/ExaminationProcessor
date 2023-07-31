package ru.shefer.service;

import org.springframework.stereotype.Service;
import ru.shefer.dao.Answer;
import ru.shefer.dao.Answers;
import ru.shefer.dao.interfaces.AnswersLoader;
import ru.shefer.dao.interfaces.AnswersParser;
import ru.shefer.service.interfaces.ResultsProcessor;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

/**
 * Данный класс реализует интерфейс ResultsProcessorInterface, обрабатывает результаты экзаменов
 */
@Service
public class ResultsProcessorImpl implements ResultsProcessor {
    /**
     * Результаты экзаменов
     */
    private final ExaminationResults examinationResults;
    /**
     * Загрузчик результатов
     */
    private final AnswersLoader answersLoader;
    /**
     * Обработчик результатов
     */
    private final AnswersParser answersParser;
    /**
     * Оценки ответов
     */
    private final Grades grades;

    public ResultsProcessorImpl(ExaminationResults examinationResults, AnswersLoader answersLoader, AnswersParser answersParser, Grades grades) {
        this.examinationResults = examinationResults;
        this.answersLoader = answersLoader;
        this.answersParser = answersParser;
        this.grades = grades;
    }

    /**
     * Инициирует загрузку и обработку результатов экзамена
     */
    @Override
    public void downloadAndParseAnswers() {
        try {
            Answers rightAnswers = answersParser.parseToAnswer(answersLoader.downloadAndGetRightAnswers());
            examinationResults.setRightAnswers(rightAnswers);

            Answers studentAnswers = answersParser.parseToAnswer(answersLoader.downloadAndGetStudentAnswers());
            examinationResults.setStudentAnswers(studentAnswers);

        } catch (IOException e) {
            System.out.println("Невозможно загрузить ответы " + "\n" + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Результаты экзамена в неверном формате" + "\n" + e.getMessage() + ", в строке: " + e.getErrorOffset());
        }
    }

    /**
     * Расчет суммарного балла за экзамен
     *
     * @param lastName Фамилия студента
     * @return суммарный балл за экзамен
     */
    @Override
    public Integer getSummaryGrade(String lastName) {
        Map<Integer, Answer> rightAnswersByLastName = examinationResults.getRightAnswers().getAnswersByLastName(lastName);
        Map<Integer, Answer> studentAnswersByLastName = examinationResults.getStudentAnswers().getAnswersByLastName(lastName);
        int result = 0;

        for (int i = 1; i <= 10; i++) {
            String studentAnswer = studentAnswersByLastName.get(i).getQuestionAnswer();
            String rightAnswer = rightAnswersByLastName.get(i).getQuestionAnswer();
            if (studentAnswer.equals(rightAnswer)) {
                if (i <= 4) {
                    result += grades.getFirstGrade();
                } else if (i <= 8) {
                    result += grades.getSecondGrade();
                } else {
                    result += grades.getThirdGrade();
                }
            }
        }
        return result;
    }
}
