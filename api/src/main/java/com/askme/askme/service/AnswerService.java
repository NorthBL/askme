package com.askme.askme.service;

import com.askme.askme.models.Answer;
import com.askme.askme.models.Projections.AnswerProjection;

import java.util.List;

public interface AnswerService {

    Answer save(Answer a);
    List<Answer> findAll();
    Answer findById(Long id);
    List<AnswerProjection> findAllBy();
}
