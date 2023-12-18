package it.poggio.software.dao;

import it.poggio.software.dao.mapper.PizzaMapper;
import it.poggio.software.domain.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class PizzaRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Pizza getPizzaFromId(Integer idPizza) {

        Map<String,Object> params = new HashMap<>();
        params.put("id",idPizza);


        String query = "SELECT nome FROM pizze WHERE id = :id";

        return namedParameterJdbcTemplate.queryForObject(query, params, new PizzaMapper());

    }

    public Pizza getPizzaFromName(String pizzaName) {

        Map<String,Object> params = new HashMap<>();
        params.put("name",pizzaName);

        String query = "aaaaa";

        return namedParameterJdbcTemplate.queryForObject(query, params, new PizzaMapper());
    }
}
