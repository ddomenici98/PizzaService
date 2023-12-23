package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Cart;
import it.poggio.software.domain.Selection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class CartMapper implements RowMapper {

    private final SelectionMapper selectionMapper = new SelectionMapper();

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Cart.builder()
                .id(rs.getInt("id"))
                .totalPrice(rs.getDouble("prezzo_totale"))
                .deliveryPrice(rs.getDouble("costo_consegna"))
                .selections(Collections.singletonList(selectionMapper.mapRow(rs, rowNum)))
                .build();
    }
}
