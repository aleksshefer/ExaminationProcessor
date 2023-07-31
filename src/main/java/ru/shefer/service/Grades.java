package ru.shefer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Данный класс предоставляет количество баллов за определенную группу ответов
 *
 * @author aleksandr shefer
 * @version 1
 * @since 1
 */
@Component
public class Grades {
    /**
     * Список оценок, конфигурируется в файле application.properties по ключу weight.answers
     */

    private final List<String> stringGrades;

    public Grades(@Value("#{'${weight.answers}'.split(',')}") List<String> stringGrades) {
        this.stringGrades = stringGrades;
    }

    /**
     * Количество баллов за первую группу ответов
     *
     * @return количество баллов
     */
    public Integer getFirstGrade() {
        return Integer.parseInt(stringGrades.get(0));
    }

    /**
     * Количество баллов за вторую группу ответов
     *
     * @return количество баллов
     */
    public Integer getSecondGrade() {
        return Integer.parseInt(stringGrades.get(1));
    }

    /**
     * Количество баллов за третью группу ответов
     *
     * @return количество баллов
     */
    public Integer getThirdGrade() {
        return Integer.parseInt(stringGrades.get(2));
    }
}
