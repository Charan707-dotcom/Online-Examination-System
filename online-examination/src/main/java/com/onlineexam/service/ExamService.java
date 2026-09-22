package com.onlineexam.service;

import org.springframework.stereotype.Service;

import com.onlineexam.model.ExamResult;
import com.onlineexam.repository.ExamResultRepository;

@Service
public class ExamService {

    private final ExamResultRepository examResultRepository;

    public ExamService(ExamResultRepository examResultRepository) {
        this.examResultRepository = examResultRepository;
    }

    public ExamResult calculateResult(String studentName,
                                      int totalQuestions,
                                      int correctAnswers) {

        int score = correctAnswers;

        ExamResult result = new ExamResult(
                studentName,
                totalQuestions,
                correctAnswers,
                score
        );

        return examResultRepository.save(result);
    }
}