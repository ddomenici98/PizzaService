package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Customer;
import it.poggio.software.domain.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Customer.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("nome"))
                .intercom(rs.getString("citofono"))
                .phone(rs.getString("telefono"))
                .address(rs.getString("indirizzo"))
                .postalCode(rs.getString("cap"))
                .previousOrdersNumber(rs.getInt("ordini_effettuati"))
                .email(rs.getString("email"))
                .build();
    }
}
