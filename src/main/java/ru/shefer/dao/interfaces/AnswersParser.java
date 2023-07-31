package ru.shefer.dao.interfaces;

import ru.shefer.dao.Answers;

import java.text.ParseException;
import java.util.List;

/**
 * Данный интерфейс предоставляет возможность парсинга списка строк в объект типа Answers
 *
 * @author aleksandr shefer
 * @version 1
 * @since 1
 */
public interface AnswersParser {
    /**
     * Преобразует список строк в объект типа Answers
     *
     * @param answersList список строк для преобразования
     * @return объект типа Answers, содержащий ответы на экзамен
     * @throws ParseException в случае неверного формата списка строк, переданного в параметры
     */
    Answers parseToAnswer(List<String> answersList) throws ParseException;
}
