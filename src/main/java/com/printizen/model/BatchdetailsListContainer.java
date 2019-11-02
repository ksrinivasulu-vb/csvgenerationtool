package com.printizen.model;

import java.util.List;

import com.printizen.entity.Batchdetail;

public class BatchdetailsListContainer {
    private List<Batchdetail> batchdetails;

    public List<Batchdetail> getBatchdetails() {
        return batchdetails;
    }

    public void setBatchdetails(List<Batchdetail> Batchdetails) {
        this.batchdetails = Batchdetails;
    }
}