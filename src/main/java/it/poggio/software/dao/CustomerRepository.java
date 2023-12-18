package it.poggio.software.dao;

import it.poggio.software.domain.Customer;
import it.poggio.software.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static it.poggio.software.dao.utils.Query.INSERT_CUSTOMER;
import static it.poggio.software.domain.exception.Errors.ERROR_DB;

@Repository
@Slf4j
public class CustomerRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void insertCustomer(Customer customer) throws CustomException {

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", customer.getName())
                .addValue("intercom", customer.getIntercom())
                .addValue("phone", customer.getPhone())
                .addValue("address", customer.getAddress())
                .addValue("postalCode", customer.getPostalCode())
                .addValue("email", customer.getEmail());

        try {
            namedParameterJdbcTemplate.update(INSERT_CUSTOMER, params);
        } catch (DataAccessException e){
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }

    }
}
