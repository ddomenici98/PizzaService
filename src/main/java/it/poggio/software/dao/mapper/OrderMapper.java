package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Cart;
import it.poggio.software.domain.Customer;
import it.poggio.software.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setDate(rs.getDate("data_ordine"));
        order.setRequestedTime(rs.getTime("orario_richiesto"));
        order.setConfirmedTime(rs.getTime("orario_confermato"));
        order.setAccepted(rs.getBoolean("accettato"));
        Customer customer = new Customer();
        customer.setId(rs.getInt("id_cliente"));
        order.setCustomer(customer);
        Cart cart = new Cart();
        cart.setId(rs.getInt("id_carrello"));
        order.setCart(cart);
        return order;
    }
}
