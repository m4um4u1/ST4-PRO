package dk.sdu.mmmi.semproject.backend.controller;

import dk.sdu.mmmi.semproject.backend.model.State;
import dk.sdu.mmmi.semproject.backend.service.StateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/state")
public class StateController {

    private final StateService ss;

    public StateController(StateService ss) {
        this.ss = ss;
    }

    @GetMapping("/get")
    public ResponseEntity<State> getStateStatus(){
        State state = new State(ss.getState());
        return new ResponseEntity<>(state, HttpStatus.OK);
    }
}
