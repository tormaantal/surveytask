package com.test.survey.repositories;

import com.test.survey.models.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberDaoImpl implements MemberDao {
    private final List<Member> memberList;

    public MemberDaoImpl() {
        InterfaceImport<Member> importMember = new MemberImportImpl();
        this.memberList = importMember.importData();
    }

    @Override
    public Optional<Member> fetchById(int id) {
        return memberList.stream().filter(member -> member.getId() == id).findFirst();
    }

    public List<Member> fetchAll() {
        return memberList;
    }

}
