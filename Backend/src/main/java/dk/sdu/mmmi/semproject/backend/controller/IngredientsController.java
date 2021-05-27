package dk.sdu.mmmi.semproject.backend.controller;

import dk.sdu.mmmi.semproject.backend.model.Ingredients;
import dk.sdu.mmmi.semproject.backend.service.IngredientsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientsController {
    private final IngredientsService is;

    public IngredientsController(IngredientsService is) {
        this.is = is;
    }

    @GetMapping("/get")
    public ResponseEntity<Ingredients> getIngredientsStatus(){
        Ingredients i = new Ingredients(is.getBarley(), is.getHops(), is.getMalt(), is.getWheat(), is.getYeast());
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
}
