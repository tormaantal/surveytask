package com.survey.repositories;

import com.survey.models.Member;

import java.util.List;
import java.util.Optional;

public interface MemberDao {
    Optional<Member> fetchById(int id);

    List<Member> fetchAll();

}
