package dk.sdu.mmmi.semproject.backend.controller;

import dk.sdu.mmmi.semproject.backend.model.Maintenance;
import dk.sdu.mmmi.semproject.backend.service.MaintenanceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class MaintenanceControllerTest {
    @Mock
    MaintenanceService ms;
    @InjectMocks
    MaintenanceController maintenanceController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMaintenanceStatus() throws Exception {
        when(ms.getMaintenance()).thenReturn(0);

        ResponseEntity<Maintenance> result = maintenanceController.getMaintenanceStatus();
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
