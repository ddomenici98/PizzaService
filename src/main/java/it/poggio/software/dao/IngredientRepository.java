package it.poggio.software.dao;
import it.poggio.software.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class IngredientRepository{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Ingredient> getIngredients() {

        String query = "aaaaa";

    return null;
    }


}
