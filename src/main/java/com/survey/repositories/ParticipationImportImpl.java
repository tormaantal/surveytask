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
            sc = new Scanner(new File("src/data/Participation.csv"));
            sc.nextLine();
            while (sc.hasNext()) {
                if (!(line = sc.nextLine()).isEmpty()){
                    String[] row = line.split(",");
                    Participation p = new Participation(Integer.parseInt(row[0]),Integer.parseInt(row[1]),
                            Integer.parseInt(row[2]));
                    if (row.length == 4) p.setLength(Integer.parseInt(row[3]));
                    participationList.add(p);
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return participationList;
    }
}
