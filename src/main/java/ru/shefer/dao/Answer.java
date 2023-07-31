package ru.shefer.dao;

import java.util.Objects;

/**
 * Данный класс описывает ответ на задание на экзамене
 *
 * @author aleksandr shefer
 * @version 1
 * @since 1
 */
public class Answer {
    /**
     * Фамилия студента сдающего экзамен
     */
    private final String studentLastName;
    /**
     * Номер задания
     */
    private final Integer questionNumber;
    /**
     * Ответ на задание
     */
    private final String questionAnswer;


    /**
     * Создает новый объект, описывающий результат ответа на задание на экзамене
     *
     * @param studentLastName Фамилия студента сдающего экзамен
     * @param questionNumber  Номер задания
     * @param questionAnswer  Ответ на задание
     */
    public Answer(String studentLastName, Integer questionNumber, String questionAnswer) {
        this.studentLastName = studentLastName;
        this.questionNumber = questionNumber;
        this.questionAnswer = questionAnswer;
    }


    public String getStudentLastName() {
        return studentLastName;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(studentLastName, answer.studentLastName) && Objects.equals(questionNumber, answer.questionNumber) && Objects.equals(questionAnswer, answer.questionAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentLastName, questionNumber, questionAnswer);
    }

    @Override
    public String toString() {
        return studentLastName + ": " + questionNumber + "-" + questionAnswer;
    }

}
