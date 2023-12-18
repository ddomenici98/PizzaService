package it.poggio.software.domain.exception.response;

import it.poggio.software.domain.Ingredient;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class IngredientResponse extends GenericResponse{
    Ingredient ingredient;
}
