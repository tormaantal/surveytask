package com.survey.services;

import com.survey.models.Participation;
import com.survey.models.Survey;
import com.survey.models.SurveyDto;
import com.survey.repositories.ParticipationDao;
import com.survey.repositories.StatusDao;
import com.survey.repositories.SurveyDao;
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
    public List<SurveyDto> fetchSurveysWithStats() {
        List<SurveyDto> resultList = new ArrayList<>();
        surveyDao.fetchAll().forEach(survey -> {
            int times = 0;
            List<Participation> filteredList = participationDao.fetchAll().stream()
                    .filter(participation -> participation.getSurveyId() == survey.getId())
                    .filter(participation -> participation.getStatus() == statusDao.convertStatus("Completed"))
                    .toList();
            if (!filteredList.isEmpty()) {
                for (Participation p :filteredList) {
                    times += p.getLength();
                }
                resultList.add(SurveyDto.convert(survey,(double)times/filteredList.size()));
            }
        });
        return resultList;
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
