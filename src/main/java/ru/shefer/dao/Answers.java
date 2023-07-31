package ru.shefer.dao;


import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Данный класс описывает структуру, хранящую ответы на задание на экзамене всех студентов
 *
 * @author aleksandr shefer
 * @version 1
 * @since 1
 */
@Component
public class Answers {
    /**
     * Ответы студентов
     */
    private final Map<String, Map<Integer, Answer>> answers;

    public Answers() {
        this.answers = new HashMap<>();
    }

    /**
     * Возвращает карту номер задания-ответ по фамилии студента
     *
     * @param lastName фамилия студента
     * @return карта номер задания - ответ
     */
    public Map<Integer, Answer> getAnswersByLastName(String lastName) {
        return answers.get(lastName);
    }

    /**
     * Возвращает список всех ответов
     *
     * @return список всех ответов
     */
    public List<Answer> getAllAnswers() {
        return answers.values().stream().map(Map::values).flatMap(Collection::stream).toList();
    }

    /**
     * Добавляет ответ в структуру хранения ответов
     *
     * @param answer ответ, добавляемый в структуру
     */
    public void addAnswer(Answer answer) {
        if (answers.containsKey(answer.getStudentLastName())) {
            answers.get(answer.getStudentLastName()).put(answer.getQuestionNumber(), answer);
        } else {
            Map<Integer, Answer> questionToAnswerMap = new HashMap<>();
            questionToAnswerMap.put(answer.getQuestionNumber(), answer);
            answers.put(answer.getStudentLastName(), questionToAnswerMap);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answers answers1 = (Answers) o;
        return Objects.equals(answers, answers1.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answers);
    }
}
