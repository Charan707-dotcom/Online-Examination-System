package com.onlineexam.controller;

import com.onlineexam.model.ExamResult;
import com.onlineexam.service.ExamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
public class ExamResultController {

    private final ExamService examService;

    public ExamResultController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public ExamResult calculateResult(
            @RequestParam String studentName,
            @RequestParam int totalQuestions,
            @RequestParam int correctAnswers) {

        return examService.calculateResult(
                studentName,
                totalQuestions,
                correctAnswers
        );
    }
}