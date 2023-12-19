package it.poggio.software.domain.response;

import it.poggio.software.domain.Ingredient;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class IngredientResponse extends GenericResponse{
    Ingredient ingredient;


    public IngredientResponse(String message) {
    }
}
