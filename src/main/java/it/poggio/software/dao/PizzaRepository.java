package it.poggio.software.dao;

import it.poggio.software.dao.mapper.PizzaMapper;
import it.poggio.software.domain.Pizza;
import it.poggio.software.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static it.poggio.software.dao.utils.Query.*;
import static it.poggio.software.domain.exception.Errors.ERROR_DB;
import static it.poggio.software.domain.exception.Errors.ERROR_EMPTY_RESULTSET;

@Repository
@Slf4j
public class PizzaRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Pizza getPizzaFromId(Integer idPizza) throws CustomException {

        Map<String,Object> params = new HashMap<>();
        params.put("id",idPizza);

        try {
            return namedParameterJdbcTemplate.queryForObject(GET_PIZZA_FROM_ID, params, new PizzaMapper());
        }catch (EmptyResultDataAccessException er){
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }catch (DataAccessException e){
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_EMPTY_RESULTSET.getErrorDescription(), ERROR_EMPTY_RESULTSET.getHttpStatus());
        }
    }

    public Pizza getPizzaFromName(String pizzaName) throws CustomException {

        Map<String,Object> params = new HashMap<>();
        params.put("name",pizzaName);

        try {
            return namedParameterJdbcTemplate.queryForObject(GET_PIZZA_FROM_NAME, params, new PizzaMapper());
        }catch (EmptyResultDataAccessException er){
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }catch (DataAccessException e){
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_EMPTY_RESULTSET.getErrorDescription(), ERROR_EMPTY_RESULTSET.getHttpStatus());
        }
    }

    public List<Pizza> getPizze() throws CustomException {

        try {
            return namedParameterJdbcTemplate.query(GET_PIZZE, new HashMap<>(), new PizzaMapper());
        }catch (EmptyResultDataAccessException er){
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }catch (DataAccessException e){
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_EMPTY_RESULTSET.getErrorDescription(), ERROR_EMPTY_RESULTSET.getHttpStatus());
        }
    }
}
