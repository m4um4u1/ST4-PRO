package dk.sdu.mmmi.semproject.backend.controller;

import dk.sdu.mmmi.semproject.backend.component.LiveHandler;
import dk.sdu.mmmi.semproject.backend.model.LiveData;
import dk.sdu.mmmi.semproject.backend.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/liveData")
public class LiveController {
    private final LiveService ls;

    @Autowired
    public LiveController(LiveService ls) {
        this.ls = ls;
    }

    @GetMapping("/get")
    public ResponseEntity<LiveData> getLiveData() {
        LiveData ld = new LiveData(ls.getBatchID(), ls.getProduced(), ls.getAccepted(), ls.getDefective(), ls.getMachSpeed(), ls.getProductType(), ls.getAmount(), ls.getTemperature(), ls.getHumidity(), ls.getVibration());
        return new ResponseEntity<>(ld, HttpStatus.OK);
    }
}
