package com.survey.repositories;

import com.survey.models.Member;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class MemberImportImpl implements InterfaceImport<Member> {

    public List<Member> importData() {
        Scanner sc;
        String line;
        List<Member> membersList = new ArrayList<>();
        try {
            sc = new Scanner(new File("src/main/resources/static/Members.csv"));
            sc.nextLine();
            while (sc.hasNext()) {
                if (!(line = sc.nextLine()).isEmpty()){
                    String[] row = line.split(",");
                    membersList.add(new Member(Integer.parseInt(row[0]), row[1], row[2], Integer.parseInt(row[3])));
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return membersList;
    }
}
