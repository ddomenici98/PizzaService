package it.poggio.software.dao;

import it.poggio.software.dao.mapper.OrderMapper;
import it.poggio.software.domain.Order;
import it.poggio.software.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static it.poggio.software.domain.exception.Errors.ERROR_DB;

@Slf4j
@Repository
public class OrderRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Order> getAllOrders() throws CustomException {

    String sql = "SELECT * FROM ordine WHERE cliente_id = :customerId";

        try {
            return namedParameterJdbcTemplate.query(sql, new OrderMapper());
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }
    }


}
