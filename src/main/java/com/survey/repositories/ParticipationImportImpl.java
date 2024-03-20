package com.survey.repositories;

import com.survey.models.Participation;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ParticipationImportImpl implements InterfaceImport<Participation> {
    public List<Participation> importData() {
        Scanner sc;
        String line;
        List<Participation> participationList = new ArrayList<>();
        try {
            sc = new Scanner(new File("src/main/resources/static/Participation.csv"));
            sc.nextLine();
            while (sc.hasNext()) {
                if (!(line = sc.nextLine()).isEmpty()){
                    String[] row = line.split(",");
                    if(row.length == 3 ){
                        participationList.add(
                                new Participation(Integer.parseInt(row[0]),Integer.parseInt(row[1]), Integer.parseInt(row[2])));
                    }else {
                        participationList.add(
                                new Participation(Integer.parseInt(row[0]),Integer.parseInt(row[1]), Integer.parseInt(row[2]),
                                        Integer.parseInt(row[3])));
                    }
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return participationList;
    }
}
