package ru.shefer.service;

import org.springframework.stereotype.Component;
import ru.shefer.dao.Answers;

/**
 * Данный класс хранит в себе результаты экзаменов после загрузки и преобразования
 *
 * @author aleksandr shefer
 * @version 1
 * @since 1
 */
@Component
public class ExaminationResults {
    /**
     * Правильные ответы
     */
    private Answers rightAnswers;
    /**
     * Ответы студентов
     */
    private Answers studentAnswers;

    public Answers getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(Answers rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public Answers getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(Answers studentAnswers) {
        this.studentAnswers = studentAnswers;
    }
}
