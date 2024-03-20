package com.test.survey.controllers;

import com.test.survey.models.Member;
import com.test.survey.services.MemberServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/member")
public class MemberController {

    private final MemberServices memberServices;

    public MemberController(MemberServices memberServices) {
        this.memberServices = memberServices;
    }

    @GetMapping("/")
    public List<Member> fetchAll(){
        return memberServices.fetchAll();
    }
    @GetMapping("/{memberId}")
    public Optional<Member> fetchById(@PathVariable int memberId){
        return memberServices.fetchById(memberId);
    }

    @GetMapping("/respondents/{surveyId}")
    public List<Member> fetchRespondentsBySurvey(@PathVariable int surveyId){
        return memberServices.fetchRespondentsBySurvey(surveyId);
    }

    @GetMapping("/inviteables/{surveyId}")
    public List<Member> fetchMembersToInvite(@PathVariable int surveyId){
        return memberServices.fetchMembersToInvite(surveyId);
    }
}
