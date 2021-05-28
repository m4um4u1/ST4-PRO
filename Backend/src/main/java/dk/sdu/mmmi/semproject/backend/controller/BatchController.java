package dk.sdu.mmmi.semproject.backend.controller;

import dk.sdu.mmmi.semproject.backend.model.Batch;
import dk.sdu.mmmi.semproject.backend.service.BatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/batch")
public class BatchController {
    private final BatchService bs;

    public BatchController(BatchService bs) {
        this.bs = bs;
    }

    @PostMapping("/post")
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch) {
        System.out.println(batch);
        bs.setMachSpeed(batch.getMachSpeed());
        bs.setProductType(batch.getProductType());
        bs.setBatchID(batch.getId());
        bs.setProductAmount(batch.getAmount());
        return new ResponseEntity<>(batch, HttpStatus.CREATED);
    }
}
