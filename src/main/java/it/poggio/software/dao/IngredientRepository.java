package it.poggio.software.dao;
import it.poggio.software.dao.mapper.IngredientMapper;
import it.poggio.software.domain.Ingredient;
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

@Slf4j
@Repository
public class IngredientRepository{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //Ingredients list
    public List<Ingredient> getIngredients() throws CustomException {

        try {
            return namedParameterJdbcTemplate.query(INGREDIENT_LIST, new IngredientMapper());
        }catch (EmptyResultDataAccessException er){
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }catch (DataAccessException e){
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_EMPTY_RESULTSET.getErrorDescription(), ERROR_EMPTY_RESULTSET.getHttpStatus());
        }

    }

    public Ingredient getIngredientById(Integer id) throws CustomException {

        Map<String,Object> params = new HashMap<>();
        params.put("id",id);

        try {
            return namedParameterJdbcTemplate.queryForObject(INGREDIENT_BYID,params, new IngredientMapper());
        }catch (EmptyResultDataAccessException er){
            throw new CustomException(ERROR_EMPTY_RESULTSET.getErrorDescription(), ERROR_EMPTY_RESULTSET.getHttpStatus());
        }catch (DataAccessException e){
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }

    }
}
