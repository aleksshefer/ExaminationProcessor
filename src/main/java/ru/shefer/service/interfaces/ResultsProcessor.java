package ru.shefer.service.interfaces;

/**
 * Данный интерфейс предоставляет возможность обработки результатов экзамена
 *
 * @author aleksandr shefer
 * @version 1
 * @since 1
 */
public interface ResultsProcessor {
    /**
     * Инициирует загрузку и обработку результатов экзамена
     */
    void downloadAndParseAnswers();

    /**
     * Расчет суммарного балла за экзамен
     *
     * @param lastName Фамилия студента
     * @return суммарный балл за экзамен
     */
    Integer getSummaryGrade(String lastName);
}
