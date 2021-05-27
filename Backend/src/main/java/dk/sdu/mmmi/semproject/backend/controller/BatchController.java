package dk.sdu.mmmi.semproject.backend.controller;


import dk.sdu.mmmi.semproject.backend.model.Batch;
import dk.sdu.mmmi.semproject.backend.service.BatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batch")
public class BatchController {
    private final BatchService bs;

    public BatchController(BatchService bs) {
        this.bs = bs;
    }

    @PostMapping("/post")
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch) {

        Batch b = batch;
        bs.setMachSpeed(b.getMachSpeed());
        bs.setProductType(b.getProductType());
        bs.setBatchID(b.getId());
        bs.setProductAmount(b.getAmount());
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }
}
