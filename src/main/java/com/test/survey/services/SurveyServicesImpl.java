package com.test.survey.services;

import com.test.survey.models.Survey;
import com.test.survey.repositories.ParticipationDao;
import com.test.survey.repositories.StatusDao;
import com.test.survey.repositories.SurveyDao;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SurveyServicesImpl implements SurveyServices {

    private final SurveyDao surveyDao;
    private final ParticipationDao participationDao;
    private final StatusDao statusDao;

    public SurveyServicesImpl(SurveyDao surveyDao, ParticipationDao participationDao, StatusDao statusDao) {
        this.surveyDao = surveyDao;
        this.participationDao = participationDao;
        this.statusDao = statusDao;
    }

    @Override
    public Optional<Survey> fetchById(int surveyId) {
        return surveyDao.fetchById(surveyId);
    }

    @Override
    public List<Survey> fetchAll() {
        return surveyDao.fetchAll();
    }

    @Override
    public List<Survey> fetchSurveysWithStats() {
        return null;
    }

    @Override
    public List<Survey> fetchSurveysCompletedByMemberId(int memberId) {
        List<Survey> resultList = new ArrayList<>();
        participationDao.fetchAll().stream()
                .filter(p -> p.getMemberId() == memberId)
                .filter(p -> p.getStatus() == statusDao.convertStatus("Completed"))
                .forEach(p -> surveyDao.fetchById(p.getSurveyId()).ifPresent(resultList::add));
        return resultList;

    }

    @Override
    public Map<String, Integer> surveyPointsByMemberId(int memberId) {
        Map<String, Integer> resultMap = new HashMap<>();
        participationDao.fetchAll().stream()
                .filter(p -> p.getMemberId() == memberId)
                .forEach(p -> {
                    if (p.getStatus() == statusDao.convertStatus("Completed")) {
                        resultMap.put(surveyDao.fetchById(p.getSurveyId()).get().getName(),
                                surveyDao.fetchById(p.getSurveyId()).get().getCompletionPoints());
                    }
                    if (p.getStatus() == statusDao.convertStatus("Filtered")) {
                        resultMap.put(surveyDao.fetchById(p.getSurveyId()).get().getName(),
                                surveyDao.fetchById(p.getSurveyId()).get().getFilteredPoints());
                    }
                });
        return resultMap;
    }
}
