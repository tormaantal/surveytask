package com.survey.repositories;

import com.survey.models.Participation;

import java.util.List;
public interface ParticipationDao {

    List<Participation> fetchAll();

}
