package it.poggio.software.domain.response;

import it.poggio.software.domain.Ingredient;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class IngredientListResponse extends GenericResponse{
    private List<Ingredient> ingredientList;


    public IngredientListResponse(String message) {
    }
}
