package com.survey.repositories;

import com.survey.models.Status;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatusImportImpl implements InterfaceImport<Status> {
    public List<Status> importData() {
        Scanner sc;
        String line;
        List<Status> statusList = new ArrayList<>();
        try {
            sc = new Scanner(new File("src/data/Statuses.csv"));
            sc.nextLine();
            while (sc.hasNext()) {
                if (!(line = sc.nextLine()).isEmpty()){
                    String[] row = line.split(",");
                    statusList.add(new Status(Integer.parseInt(row[0]), row[1]));
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return statusList;
    }
}
