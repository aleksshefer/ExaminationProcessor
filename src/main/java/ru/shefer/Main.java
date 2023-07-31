package ru.shefer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.shefer.service.interfaces.ResultsProcessor;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ResultsProcessor resultsProcessor = context.getBean(ResultsProcessor.class);
        resultsProcessor.downloadAndParseAnswers();

        System.out.println(resultsProcessor.getSummaryGrade("Ivanov"));

        System.out.println(resultsProcessor.getSummaryGrade("Petrov"));
    }
}