package com.survey.repositories;

import com.survey.models.Participation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ParticipationDaoImpl implements ParticipationDao{
    private final List<Participation> participationList;

    public ParticipationDaoImpl() {
        InterfaceImport<Participation> importParticipation = new ParticipationImportImpl();
        this.participationList = importParticipation.importData();
    }

    @Override
    public Optional<Participation> fetchById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Participation> fetchAll() {
        return participationList;
    }
}
