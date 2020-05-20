package com.askme.askme.repository.jpa;

import com.askme.askme.models.Answer;
import com.askme.askme.models.Projections.AnswerProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAnswerRepository extends JpaRepository<Answer,Long> {

    List<AnswerProjection> findAllBy();
}
