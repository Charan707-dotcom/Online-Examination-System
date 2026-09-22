package com.onlineexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineexam.model.ExamResult;

public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {
}