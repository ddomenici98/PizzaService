package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Customer;
import it.poggio.software.domain.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("nome"));
        customer.setIntercom(rs.getString("citofono"));
        customer.setPhone(rs.getString("telefono"));
        customer.setAddress(rs.getString("indirizzo"));
        customer.setPostalCode(rs.getString("cap"));
        customer.setPreviousOrdersNumber(rs.getInt("ordini_effettuati"));
        customer.setEmail(rs.getString("email"));

        return customer;
    }
}
