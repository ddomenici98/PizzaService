package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Add;
import it.poggio.software.domain.Ingredient;
import it.poggio.software.domain.Selection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMapper implements RowMapper<Add> {
    @Override
    public Add mapRow(ResultSet rs, int rowNum) throws SQLException {
        Add add = new Add();
        add.setId(rs.getInt("id"));
        Selection selection = new Selection();
        selection.setId(rs.getInt("id_selezione"));
        add.setSelection(selection);
        Ingredient ingredient = new Ingredient();
        ingredient.setId(rs.getInt("id_ingrediente"));
        add.setIngredient(ingredient);
        return add;
    }
}
