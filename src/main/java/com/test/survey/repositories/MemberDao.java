package com.test.survey.repositories;

import com.test.survey.models.Member;

import java.util.List;
import java.util.Optional;

public interface MemberDao {
    Optional<Member> fetchById(int id);

    List<Member> fetchAll();

}
