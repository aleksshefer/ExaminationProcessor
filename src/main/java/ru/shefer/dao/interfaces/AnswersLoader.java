package ru.shefer.dao.interfaces;

import java.io.IOException;
import java.util.List;

/**
 * Данный интерфейс предоставляет загрузчик результатов экзаменов в виде списка
 *
 * @author aleksandr shefer
 * @version 1
 * @since 1
 */
public interface AnswersLoader {
    /**
     * Загружает и возвращает список правильных ответов
     *
     * @return список строк, содержащих правильные ответы
     * @throws IOException в случае неверного пути или невозможности чтения файла по пути
     *                     указанному в файле application.properties по ключу path.rightAnswers
     */
    List<String> downloadAndGetRightAnswers() throws IOException;

    /**
     * Загружает и возвращает список ответов студента
     *
     * @return список строк, содержащих ответы студента
     * @throws IOException в случае неверного пути или невозможности чтения файла по пути
     *                     указанному в файле application.properties по ключу path.studentAnswers
     */
    List<String> downloadAndGetStudentAnswers() throws IOException;
}
