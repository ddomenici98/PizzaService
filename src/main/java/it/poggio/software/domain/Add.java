package it.poggio.software.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Add {
    Integer id;
    Selection selection;
    Ingredient ingredient;
}
