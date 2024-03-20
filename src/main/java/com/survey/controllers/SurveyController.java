package com.survey.controllers;

import com.survey.models.Survey;
import com.survey.services.SurveyServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/survey")
public class SurveyController {

    private final SurveyServices surveyServices;

    public SurveyController(SurveyServices surveyServices) {
        this.surveyServices = surveyServices;
    }

    @GetMapping("/")
    public List<Survey> fetchAll(){
        return surveyServices.fetchAll();
    }

    @GetMapping("/completedSurveys/{memberId}")
    public List<Survey> fetchSurveysCompletedByMemberId(@PathVariable int memberId){
        return surveyServices.fetchSurveysCompletedByMemberId(memberId);
    }

    @GetMapping("/points/{memberId}")
    public Map<String, Integer> surveyPointsByMemberId(@PathVariable int memberId){
        return surveyServices.surveyPointsByMemberId(memberId);
    }

}
