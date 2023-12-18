package it.poggio.software.restful;

import it.poggio.software.domain.Pizza;
import it.poggio.software.domain.exception.CustomException;
import it.poggio.software.service.PizzaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping(value = "/{idPizza}")
    public ResponseEntity<Pizza> getPizzaFromId(@PathVariable Integer idPizza) throws CustomException {

        Pizza pizza = pizzaService.getPizzaFromId(idPizza);

        return new ResponseEntity<>(pizza, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Pizza> getPizzaFromName(@RequestParam String pizzaName) throws CustomException {

        Pizza pizza = pizzaService.getPizzaFromName(pizzaName);

        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Pizza>> getPizze() throws CustomException {

        List<Pizza> pizze = pizzaService.getPizze();

        return new ResponseEntity<>(pizze, HttpStatus.OK);
    }
}
