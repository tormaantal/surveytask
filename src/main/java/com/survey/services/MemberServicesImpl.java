package com.survey.services;

import com.survey.repositories.MemberDao;
import com.survey.repositories.ParticipationDao;
import com.survey.repositories.StatusDao;
import com.survey.models.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServicesImpl implements MemberServices {
    private final MemberDao memberDao;
    private final ParticipationDao participationDao;
    private final StatusDao statusDao;

    public MemberServicesImpl(MemberDao memberDao, ParticipationDao participationDao, StatusDao statusDao) {
        this.memberDao = memberDao;
        this.participationDao = participationDao;
        this.statusDao = statusDao;
    }

    @Override
    public Optional<Member> fetchById(int id) {
        return memberDao.fetchById(id);
    }

    @Override
    public List<Member> fetchAll() {
        return memberDao.fetchAll();
    }

    @Override
    public List<Member> fetchRespondentsBySurvey(int surveyId) {
        List<Member> resultList = new ArrayList<>();
        participationDao.fetchAll().stream()
                .filter(p -> p.getSurveyId() == surveyId && p.getStatus() == statusDao.convertStatus("Completed"))
                .forEach(p -> memberDao.fetchById(p.getMemberId()).ifPresent(resultList::add));
        return resultList;
    }

    @Override
    public List<Member> fetchMembersToInvite(int surveyId) {
        List<Member> resultList = new ArrayList<>();
        participationDao.fetchAll().stream()
                .filter(p -> p.getSurveyId() == surveyId && p.getStatus() == statusDao.convertStatus("Not asked"))
                .forEach(p-> memberDao.fetchById(p.getMemberId()).ifPresent(member -> {
                    if (member.getIsActive() == 1) {
                        resultList.add(member);
                    }
                }));
        return resultList;
    }
}
