package com.askme.askme.service;

import com.askme.askme.models.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();
    Question save(Question q);
    Question findById(Long id);
}
