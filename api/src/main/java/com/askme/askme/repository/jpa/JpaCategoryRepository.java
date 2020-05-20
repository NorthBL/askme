package com.askme.askme.repository.jpa;

import com.askme.askme.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

public interface JpaCategoryRepository extends JpaRepository<Category,Long> {

    Category save(Category c);
    List<Category> findAll();
    Optional<Category> findById(Long id);
}
