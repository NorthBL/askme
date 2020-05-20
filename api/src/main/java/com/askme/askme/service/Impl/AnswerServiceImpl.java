package com.askme.askme.service.Impl;

import com.askme.askme.exceptions.AnswerNotFoundException;
import com.askme.askme.models.Answer;
import com.askme.askme.models.Projections.AnswerProjection;
import com.askme.askme.models.Projections.UserProjection;
import com.askme.askme.models.Question;
import com.askme.askme.models.User;
import com.askme.askme.repository.jpa.JpaAnswerRepository;
import com.askme.askme.service.AnswerService;
import com.askme.askme.service.QuestionService;
import com.askme.askme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private JpaAnswerRepository answerRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @Override
    public Answer save(Answer a) {
        Question q = questionService.findById(a.getQuestion().getId());
        User u = userService.findById(/*a.getUser().getId()*/ 1l);
        a.setQuestion(q);
        a.setUser(u);

        return answerRepository.save(a);
    }

    public List<Answer> findAll(){
        return answerRepository.findAll();
    }

    @Override
    public Answer findById(Long id) {
        Optional<Answer> oa = answerRepository.findById(id);
        if(!oa.isPresent()){
            throw new AnswerNotFoundException();
        }

        return oa.get();
    }

    @Override
    public List<AnswerProjection> findAllBy() {
        return answerRepository.findAllBy();
    }
}
