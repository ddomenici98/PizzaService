package it.poggio.software.dao.mapper;
import it.poggio.software.domain.Selection;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class SelectionMapper implements RowMapper<Selection> {

    private final AddMapper addMapper = new AddMapper();
    private final PizzaMapper pizzaMapper= new PizzaMapper();

    @Override
    public Selection mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Selection.builder()
                .id(rs.getInt("id"))
                .pizza(pizzaMapper.mapRow(rs, rowNum))
                .quantity(rs.getInt("quantita"))
                .adds(Collections.singletonList(addMapper.mapRow(rs, rowNum)))
                .build();
    }
}
