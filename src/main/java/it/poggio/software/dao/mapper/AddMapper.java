package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Add;
import it.poggio.software.domain.Ingredient;
import it.poggio.software.domain.Selection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMapper implements RowMapper<Add> {

    private final IngredientMapper ingredientMapper = new IngredientMapper();
    @Override
    public Add mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Add.builder()
                .id(rs.getInt("id"))
                .ingredient(ingredientMapper.mapRow(rs, rowNum))
                .build();
    }
}
