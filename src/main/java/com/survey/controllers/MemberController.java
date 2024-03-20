package com.survey.controllers;

import com.survey.models.Member;
import com.survey.services.MemberServices;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/canBeInvited/{surveyId}")
    public List<Member> fetchMembersToInvite(@PathVariable int surveyId){
        return memberServices.fetchMembersToInvite(surveyId);
    }
}
