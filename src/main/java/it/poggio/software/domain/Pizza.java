package it.poggio.software.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pizza {

    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String categoryName;
}
