package it.poggio.software.dao.mapper;

import it.poggio.software.domain.Pizza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PizzaMapper implements RowMapper<Pizza> {
    @Override
    public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Pizza.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("nome")) // usare alias
                .price(rs.getDouble("prezzo"))
                .description(rs.getString("descrizione"))
                .categoryName(rs.getString("nomeCategoria"))
                .build();
    }
}
