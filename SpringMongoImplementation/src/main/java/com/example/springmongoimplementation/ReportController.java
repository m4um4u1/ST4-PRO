package com.example.springmongoimplementation;

import dk.sdu.mmmi.semproject.backend.model.LiveData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
    @RequestMapping("/api/report")
    public class ReportController {


      private final ReportService rS;

@Autowired
        public ReportController(ReportService rS) {
            this.rS = rS;
        }


        @PostMapping("/create")
    public ResponseEntity<?> addReport(@RequestBody LiveData ld) {
    Report rep = new Report(ld.getBatchID(), ld.getProductType(), new Date(), ld.getAmount(), ld.getDefective(), ld.getAccepted(), ld.getHumidity(), ld.getTemperature());
    rS.add(rep);
    return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @GetMapping("/find/{batchId}")
    public ResponseEntity<Report> getReport(@PathVariable("batchId") Float bId) {
    Report bReport = rS.getOne(bId);
    return new ResponseEntity<>(bReport,HttpStatus.OK);

        }



        @GetMapping("/all")
    public ResponseEntity<List<Report>> getAllReports() {

    List<Report> listsOfReports = rS.getAll();
return new ResponseEntity<>(listsOfReports, HttpStatus.OK);

}


    }
