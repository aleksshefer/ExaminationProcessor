package ru.shefer.dao;

import org.springframework.stereotype.Component;
import ru.shefer.dao.interfaces.AnswersParser;

import java.text.ParseException;
import java.util.List;

/**
 * Данный класс реализует интерфейс AnswerParser, преобразует список строк ответов в объект типа Answers
 *
 * @author aleksandr shefer
 * @version 1
 * @since 1
 */
@Component
public class StringToAnswersParser implements AnswersParser {
    /**
     * Преобразует список строк в
     *
     * @param answersList список строк для преобразования
     * @return новый объект типа Answers содержащий в своей структуре ответы на вопросы экзамена
     * @throws ParseException в случае неверного формата входной строки. Валидный формат: "name: LastName" или "1-A"
     */
    @Override
    public Answers parseToAnswer(List<String> answersList) throws ParseException {
        Answers answers = new Answers();
        String lastName = "";
        int questionNumber = 0;
        String questionAnswer;

        for (String answer : answersList) {

            if (answer.startsWith("name:")) {
                lastName = answer.split(" ")[1];
            } else {
                String[] solution = answer.split("-");

                try {
                    questionNumber = Integer.parseInt(solution[0]);
                } catch (NumberFormatException e) {
                    throw new ParseException("Неверный номер ответа студента " + lastName, questionNumber + 1);
                }
                questionAnswer = solution[1];
                answers.addAnswer(new Answer(lastName, questionNumber, questionAnswer));
            }
        }
        return answers;
    }
}
