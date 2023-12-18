package it.poggio.software.restful;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("pizza")
public class PizzaController {

    @GetMapping(value = "/{id}")
    public void getPizza(@PathVariable String idPizza) {

    }
}
