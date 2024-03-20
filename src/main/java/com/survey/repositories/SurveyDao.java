package com.survey.repositories;

import com.survey.models.Survey;

import java.util.List;
import java.util.Optional;

public interface SurveyDao{
    Optional<Survey> fetchById(int id);

    List<Survey> fetchAll();

}
