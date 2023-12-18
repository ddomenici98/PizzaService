package it.poggio.software.restful;

import it.poggio.software.domain.Pizza;
import it.poggio.software.service.PizzaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping(value = "/{idPizza}")
    public Pizza getPizzaFromId(@PathVariable Integer idPizza) {

        return pizzaService.getPizzaFromId(idPizza);

    }

    @GetMapping
    public Pizza getPizzaFromName(@RequestParam String pizzaName) {

        return pizzaService.getPizzaFromName(pizzaName);

    }
}
