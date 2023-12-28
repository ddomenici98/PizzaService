package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Ingredient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientMapper implements RowMapper<Ingredient>{

    @Override
    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Ingredient.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("nome")) //usare alias
                .price(rs.getDouble("prezzo"))
                .available(rs.getBoolean("disponibile"))
                .build();
    }

}
