package com.test.survey.repositories;

import com.test.survey.models.Participation;

import java.util.List;
import java.util.Optional;
public interface ParticipationDao {
    Optional<Participation> fetchById(int id);

    List<Participation> fetchAll();

}
