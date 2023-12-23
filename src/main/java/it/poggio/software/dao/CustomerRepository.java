package it.poggio.software.dao;

import it.poggio.software.dao.mapper.CustomerMapper;
import it.poggio.software.dao.mapper.PizzaMapper;
import it.poggio.software.domain.Customer;
import it.poggio.software.domain.Pizza;
import it.poggio.software.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static it.poggio.software.dao.utils.Query.*;
import static it.poggio.software.domain.exception.Errors.ERROR_DB;
import static it.poggio.software.domain.exception.Errors.ERROR_EMPTY_RESULTSET;

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

    public Customer checkIfCustomerExists(String phone, String email) throws CustomException {

        Map<String,Object> params = new HashMap<>();

        String query = CHECK_CUSTOMER_EXISTS;

        if(phone != null) {
            params.put("phone", phone);
            query = query.concat(AND_CUSTOMER_TELEPHONE);
        }
        if(email != null) {
            params.put("email", email);
            query = query.concat(AND_CUSTOMER_EMAIL);
        }

        try {
            return namedParameterJdbcTemplate.queryForObject(query, params, new CustomerMapper());
        }catch (DataAccessException e){
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateCustomer(Customer customer, String customerId) throws CustomException {

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", customerId);

        String query = UPDATE_CUSTOMER;

        if(customer.getName() != null) {
            params.addValue("name", customer.getName());
            query = query.concat(UPDATE_CUSTOMER_NAME);
        }
        if(customer.getIntercom() != null) {
            params.addValue("intercom", customer.getIntercom());
            query = query.concat(UPDATE_CUSTOMER_INTERCOM);
        }
        if(customer.getPhone() != null) {
            params.addValue("phone", customer.getPhone());
            query = query.concat(UPDATE_CUSTOMER_PHONE);
        }
        if(customer.getAddress() != null) {
            params.addValue("address", customer.getAddress());
            query = query.concat(UPDATE_CUSTOMER_ADDRESS);
        }
        if(customer.getPostalCode() != null) {
            params.addValue("postalCode", customer.getPostalCode());
            query = query.concat(UPDATE_CUSTOMER_POSTALCODE);
        }
        if(!customer.getOrders().isEmpty()) {
            params.addValue("orders", customer.getOrders());
            query = query.concat(UPDATE_CUSTOMER_ORDERS);
        }
        if(customer.getEmail() != null) {
            params.addValue("email", customer.getEmail());
            query = query.concat(UPDATE_CUSTOMER_EMAIL);
        }

        query = query.concat(WHERE_UPDATE_CUSTOMER);

        try {
            namedParameterJdbcTemplate.update(query, params);
        } catch (DataAccessException e){
            log.error(e.getMessage(), e);
            throw new CustomException(ERROR_DB.getErrorDescription(), ERROR_DB.getHttpStatus());
        }
    }
}
