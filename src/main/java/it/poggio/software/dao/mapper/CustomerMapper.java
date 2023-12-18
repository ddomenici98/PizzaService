package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Customer;
import it.poggio.software.domain.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    private final OrderMapper orderMapper;

    public CustomerMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("nome"));
        customer.setIntercom(rs.getString("citofono"));
        customer.setPhone(rs.getString("telefono"));
        customer.setAddress(rs.getString("address"));
        customer.setPostalCode(rs.getString("cap"));
        customer.setPreviousOrdersNumber(rs.getInt("ordini_effettuati"));
        customer.setEmail(rs.getString("email"));
        Order order = this.orderMapper.mapRow(rs, rowNum);
        order.setCustomer(customer);
        customer.getOrders().add(order);
        return customer;
    }
}
