package com.survey.services;

import com.survey.models.Survey;
import com.survey.models.SurveyDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SurveyServices {
    Optional<Survey> fetchById(int surveyId);

    List<Survey> fetchAll();

    List<SurveyDto> fetchSurveysWithStats();

    List<Survey> fetchSurveysCompletedByMemberId(int memberId);

    Map<String,Integer> surveyPointsByMemberId(int memberId);
}
