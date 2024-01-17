package it.poggio.software.dao;

import it.poggio.software.dao.mapper.CustomerMapper;
import it.poggio.software.dao.mapper.OrderMapper;
import it.poggio.software.domain.Order;
import it.poggio.software.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static it.poggio.software.dao.utils.Query.INSERT_ORDER;
import static it.poggio.software.domain.exception.Errors.ERROR_DB;

@Slf4j
@Repository
public class OrderRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insertOrder(Order order) throws CustomException {


        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id_cliente", order.getCustomer().getId())
                .addValue("data_ordine", order.getDate())
                .addValue("orario_richiesto", order.getRequestedTime())
                .addValue("id_carrello", order.getCustomer().getId());

        try {
            namedParameterJdbcTemplate.update(INSERT_ORDER, params);
        }catch(DataAccessException e){
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }
    }




}
