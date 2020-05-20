package com.askme.askme.service.Impl;

import com.askme.askme.exceptions.CategoryNotFoundException;
import com.askme.askme.exceptions.QuestionNotFoundException;
import com.askme.askme.exceptions.UserNotFoundException;
import com.askme.askme.models.Category;
import com.askme.askme.models.Question;
import com.askme.askme.models.User;
import com.askme.askme.repository.jpa.JpaCategoryRepository;
import com.askme.askme.repository.jpa.JpaQuestionRepository;
import com.askme.askme.repository.jpa.JpaUserRepository;
import com.askme.askme.repository.jpa.JpaUserRoleRepository;
import com.askme.askme.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private JpaQuestionRepository questionRepository;

    @Autowired
    private JpaCategoryRepository categoryRepository;

    @Autowired
    private JpaUserRepository userRepository;

    @Override
    public Question save(Question q) {
        Optional<Category> oc = categoryRepository.findById(q.getCategory().getId());
        if(!oc.isPresent()){
            throw new CategoryNotFoundException();
        }
        q.setCategory(oc.get());

        Optional<User> ou = userRepository.findById(q.getUser().getId());
        if(!ou.isPresent()){
            throw new UserNotFoundException();
        }
        q.setUser(ou.get());


        return questionRepository.save(q);
    }

    public List<Question> findAll(){
        return  questionRepository.findAll();
    }

    public Question findById(Long id){
        Optional<Question> c = questionRepository.findById(id);
        if(!c.isPresent()){
            throw new QuestionNotFoundException();
        }
        return c.get();
    }
}
