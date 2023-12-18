package it.poggio.software.domain;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {

    private Integer id;
    private String name;
    private Double price;

}
