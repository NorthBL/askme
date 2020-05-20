package com.askme.askme.repository.jpa;

import com.askme.askme.models.Category;
import com.askme.askme.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface JpaQuestionRepository extends JpaRepository<Question,Long>{

    Question save(Question q);

    List<Question> findAll();

    @Override
    Optional<Question> findById(Long id);

    List<Question> findAllByCategoryId(Long categoryId);

    List<Question> findAllByUserId(Long userId);

    @Override
    long count();

    List<Question> findAllByCategoryIdAndUserId(Long categoryId,Long userId);
}
