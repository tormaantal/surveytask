package com.test.survey.repositories;

import com.test.survey.models.Survey;

import java.util.List;
import java.util.Optional;

public interface SurveyDao{
    Optional<Survey> fetchById(int id);

    List<Survey> fetchAll();

}
