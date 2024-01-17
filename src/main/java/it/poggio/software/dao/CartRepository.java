package it.poggio.software.dao;

import it.poggio.software.domain.Cart;
import it.poggio.software.domain.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import static it.poggio.software.dao.utils.Query.INSERT_CART;
import static it.poggio.software.dao.utils.Query.INSERT_CUSTOMER;
import static it.poggio.software.domain.exception.Errors.ERROR_DB;

@Repository
@Slf4j
public class CartRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insertCart(Cart cart) throws CustomException {
        MapSqlParameterSource params= new MapSqlParameterSource()
                .addValue("id", cart.getId())
                .addValue("prezzo_totale", cart.getTotalPrice())
                .addValue("costo_consegna", cart.getDeliveryPrice());

        try {
            namedParameterJdbcTemplate.update(INSERT_CART, params);
        } catch (DataAccessException e){
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }

    }
}
