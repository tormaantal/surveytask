package com.survey.repositories;

import com.survey.models.Participation;

import java.util.List;
import java.util.Optional;
public interface ParticipationDao {
    Optional<Participation> fetchById(int id);

    List<Participation> fetchAll();

}
