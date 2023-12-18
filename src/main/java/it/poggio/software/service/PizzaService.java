package it.poggio.software.service;

import it.poggio.software.dao.PizzaRepository;
import it.poggio.software.domain.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PizzaService {

    @Autowired
    PizzaRepository pizzaRepository;

    public Pizza getPizzaFromId(String idPizza) {
        return pizzaRepository.getPizzaFromId(idPizza);
    }

    public Pizza getPizzaFromName(String pizzaName) {
        return pizzaRepository.getPizzaFromName(pizzaName);
    }
}
