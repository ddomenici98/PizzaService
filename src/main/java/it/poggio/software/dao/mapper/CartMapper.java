package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Cart;
import it.poggio.software.domain.Selection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper {

    private final SelectionMapper selectionMapper;

    public CartMapper(SelectionMapper selectionMapper) {
        this.selectionMapper = selectionMapper;
    }

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart cart = new Cart();
        cart.setId(rs.getInt("id"));
        cart.setTotalPrice(rs.getDouble("prezzo_totale"));
        cart.setDeliveryPrice(rs.getDouble("costo_consegna"));
        Selection selection = this.selectionMapper.mapRow(rs, rowNum);
        selection.setCart(cart);
        cart.getSelections().add(selection);
        return cart;
    }
}
