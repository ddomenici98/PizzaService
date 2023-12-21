package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Add;
import it.poggio.software.domain.Cart;
import it.poggio.software.domain.Pizza;
import it.poggio.software.domain.Selection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectionMapper implements RowMapper<Selection> {

    private final AddMapper addMapper;

    public SelectionMapper(AddMapper addMapper) {
        this.addMapper = addMapper;
    }

    @Override
    public Selection mapRow(ResultSet rs, int rowNum) throws SQLException {
        Selection selection = new Selection();
        selection.setId(rs.getInt("id"));
        Pizza pizza = new Pizza();
        pizza.setId(rs.getInt("id_pizza"));
        selection.setPizza(pizza);
        Cart cart = new Cart();
        cart.setId(rs.getInt("id_carrello"));
        selection.setCart(cart);
        selection.setQuantity(rs.getInt("quantita"));
        Add add = this.addMapper.mapRow(rs, rowNum);
        add.setSelection(selection);
        selection.getAdds().add(add);
        return selection;
    }
}
