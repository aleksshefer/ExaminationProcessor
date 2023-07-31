package ru.shefer.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.shefer.dao.interfaces.AnswersLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Данный класс реализует интерфейс AnswerLoader, загружает и возвращает список правильных ответов и ответов студентов
 *
 * @author aleksandr shefer
 * @version 1
 * @since 1
 */
@Repository
public class AnswersLoaderFromFileSystem implements AnswersLoader {
    /**
     * Путь к файлу для загрузки правильных ответов
     */

    private final String rightAnswersPath;
    /**
     * Путь к файлу для загрузки ответов студента
     */

    private final String studentAnswersPath;

    public AnswersLoaderFromFileSystem(@Value("${path.rightAnswers}") String rightAnswersPath,
                                       @Value("${path.studentAnswers}") String studentAnswersPath) {
        this.rightAnswersPath = rightAnswersPath;
        this.studentAnswersPath = studentAnswersPath;
    }

    /**
     * Добавляет и возвращает список правильных ответов студентов
     *
     * @return список правильных ответов
     * @throws IOException в случае невозможности чтения файла по пути, указанному в файле application.properties
     *                     по ключу path.rightAnswers
     */
    @Override
    public List<String> downloadAndGetRightAnswers() throws IOException {
        return downloadAnswers(rightAnswersPath);
    }

    /**
     * Добавляет и возвращает список ответов студентов
     *
     * @return список ответов студентов
     * @throws IOException в случае невозможности чтения файла по пути, указанному в файле application.properties
     *                     по ключу path.studentAnswers
     */
    @Override
    public List<String> downloadAndGetStudentAnswers() throws IOException {
        return downloadAnswers(studentAnswersPath);
    }

    /**
     * Загружает из файла в список строк
     *
     * @param path путь к файлу
     * @return список строк из файла
     * @throws IOException в случае невозможности чтения файла по пути, указанному в параметре path
     */
    private List<String> downloadAnswers(String path) throws IOException {
        List<String> answers = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                answers.add(line);
            }
        }
        return answers;
    }
}
