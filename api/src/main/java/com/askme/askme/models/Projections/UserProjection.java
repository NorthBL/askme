package com.askme.askme.models.Projections;

import com.askme.askme.models.Answer;
import com.askme.askme.models.Question;
import com.askme.askme.models.UserRole;
import com.askme.askme.models.Vote;

import java.util.List;

public interface UserProjection {
    String getFirstName();
    String getLastName();
    String getProfileImgUrl();
    String getProfileDescription();
    UserRole getUserRole();
    Long getId();
    List<Question> getQuestions();
    List<Answer> getAnswers();
    List<Vote> getVotes();
    String getUsername();
}
