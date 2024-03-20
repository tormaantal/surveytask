package com.survey.repositories;

import com.survey.models.Survey;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyImportImpl implements InterfaceImport<Survey> {
    public List<Survey> importData() {
        Scanner sc;
        String line;
        List<Survey> surveyList = new ArrayList<>();
        try {
            sc = new Scanner(new File("src/main/resources/static/Surveys.csv"));
            sc.nextLine();
            while (sc.hasNext()) {
                if (!(line = sc.nextLine()).isEmpty()){
                    String[] row = line.split(",");
                    surveyList.add(new Survey(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]),
                            Integer.parseInt(row[3]), Integer.parseInt(row[4])));
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return surveyList;
    }
}
