package com.test.survey.services;

import com.test.survey.models.Survey;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface SurveyServices {
    Optional<Survey> fetchById(int surveyId);

    List<Survey> fetchAll();

    List<Survey> fetchSurveysWithStats();

    List<Survey> fetchSurveysCompletedByMemberId(int memberId);

    Map<String,Integer> surveyPointsByMemberId(int memberId);
}
