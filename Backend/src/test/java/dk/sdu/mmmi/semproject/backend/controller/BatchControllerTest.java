package dk.sdu.mmmi.semproject.backend.controller;

import dk.sdu.mmmi.semproject.backend.model.Batch;
import dk.sdu.mmmi.semproject.backend.service.BatchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class BatchControllerTest {
    @Mock
    BatchService bs;
    @InjectMocks
    BatchController batchController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateBatch() throws Exception {
        ResponseEntity<Batch> result = batchController.createBatch(new Batch(Long.valueOf(1), Float.valueOf(1.1f), Float.valueOf(1.1f), Float.valueOf(1.1f)));
        Assert.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }
}

