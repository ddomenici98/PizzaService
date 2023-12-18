package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Order;
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
        order.setCartId(rs.getInt("id_carrello"));
        return order;
    }
}
