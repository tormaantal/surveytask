package com.survey.services;

import com.survey.models.Member;

import java.util.List;
import java.util.Optional;

public interface MemberServices {
    Optional<Member> fetchById(int id);
    List<Member> fetchAll();
    List<Member> fetchRespondentsBySurvey(int surveyId);
    List<Member> fetchMembersToInvite(int surveyId);

}
