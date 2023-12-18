package it.poggio.software.service;

import it.poggio.software.dao.PizzaRepository;
import it.poggio.software.domain.Pizza;
import it.poggio.software.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaService {

    @Autowired
    PizzaRepository pizzaRepository;

    public Pizza getPizzaFromId(Integer idPizza) throws CustomException {
        return pizzaRepository.getPizzaFromId(idPizza);
    }

    public Pizza getPizzaFromName(String pizzaName) throws CustomException {
        return pizzaRepository.getPizzaFromName(pizzaName);
    }

    public List<Pizza> getPizze() throws CustomException {
        return pizzaRepository.getPizze();
    }
}
