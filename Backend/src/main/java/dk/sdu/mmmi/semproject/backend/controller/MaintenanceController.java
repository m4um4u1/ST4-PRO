package dk.sdu.mmmi.semproject.backend.controller;

import dk.sdu.mmmi.semproject.backend.model.Maintenance;
import dk.sdu.mmmi.semproject.backend.service.MaintenanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {
    private final MaintenanceService ms;

    public MaintenanceController(MaintenanceService ms) {
        this.ms = ms;
    }

    @GetMapping("/get")
    public ResponseEntity<Maintenance> getMaintenanceStatus() {
        Maintenance m = new Maintenance(ms.getMaintenance());
        return new ResponseEntity<>(m, HttpStatus.OK);
    }
}
