package com.test.survey.repositories;

import com.test.survey.models.Survey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class SurveyDaoImpl implements SurveyDao {

    private final List<Survey> surveyList;

    public SurveyDaoImpl() {
        InterfaceImport<Survey> surveyImport = new SurveyImportImpl();
        this.surveyList = surveyImport.importData();
    }

    @Override
    public Optional<Survey> fetchById(int id) {
        return surveyList.stream().filter(survey -> survey.getId()==id).findFirst();
    }

    public List<Survey> fetchAll() {
        return surveyList;
    }

}
