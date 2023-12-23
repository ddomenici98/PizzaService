package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Cart;
import it.poggio.software.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    public final CustomerMapper customerMapper = new CustomerMapper();
    public final CartMapper cartMapper = new CartMapper();

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Order.builder()
                .id(rs.getInt("id"))
                .customer(customerMapper.mapRow(rs, rowNum))
                .date(rs.getDate("data_ordine"))
                .requestedTime(rs.getTime("orario_richiesto"))
                .confirmedTime(rs.getTime("orario_confermato"))
                .accepted(rs.getBoolean("accettato"))
                .cart(cartMapper.mapRow(rs, rowNum))
                .build();
    }
}
