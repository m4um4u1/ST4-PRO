package com.example.springmongoimplementation;


import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ReportService {


    private final ReportRepository rP;


    public ReportService(ReportRepository rP) {
        this.rP = rP;
    }


    public void add(Report report) {
        rP.save(report);
    }


    public List<Report> getAll() {
        return rP.findAll();
    }


    public Report getOne(Float batchId) {
        return rP.findById(batchId)
                .orElseThrow(() -> new ResourceNotFoundException());
    }


}
