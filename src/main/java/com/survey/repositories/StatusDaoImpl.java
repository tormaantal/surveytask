package com.survey.repositories;

import com.survey.models.Status;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StatusDaoImpl implements StatusDao{

    private final List<Status> statusList;

    public StatusDaoImpl() {
        InterfaceImport<Status> importStatus = new StatusImportImpl();
        this.statusList = importStatus.importData();
    }

    public int convertStatus(String statusName){
        for (Status status:statusList) {
            if (status.getName().equals(statusName)) return status.getId();
        }
        return 0;
    }
}
