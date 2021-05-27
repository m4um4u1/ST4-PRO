package dk.sdu.mmmi.semproject.backend.controller;

import dk.sdu.mmmi.semproject.backend.service.CommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/command")
public class CommandController {
    private final CommandService cs;

    public CommandController(CommandService cs) {
        this.cs = cs;
    }

    @PostMapping("/{i}")
    public ResponseEntity<Integer> commandOPC(@PathVariable("i") Integer i) {
        cs.setCntrlCmd(i);
        cs.setCCR(true);
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
}
