package com.askme.askme.web.rest;

import com.askme.askme.models.Answer;
import com.askme.askme.models.Projections.AnswerProjection;
import com.askme.askme.service.AnswerService;
import com.askme.askme.service.Impl.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AnswerRestResource {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/answers")
    public List<Answer> getAllAnswers(){
        return  answerService.findAll();
    }

    @GetMapping("/answer/{id}")
    public Answer getAnswerById(@PathVariable("id") Long id){
        return answerService.findById(id);
    }

    @PostMapping("/answer")
    public Answer addAnswer(@RequestBody Answer answer){
        return answerService.save(answer);
    }

    @GetMapping("/test")
    public List<AnswerProjection> findAllBy(){
        return answerService.findAllBy();
    }
}
