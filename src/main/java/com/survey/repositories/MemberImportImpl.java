package com.survey.repositories;

import com.survey.models.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
