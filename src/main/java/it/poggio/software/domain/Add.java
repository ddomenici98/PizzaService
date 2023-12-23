package it.poggio.software.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Add {
    Integer id;
    Selection selection;
    Ingredient ingredient;
}
