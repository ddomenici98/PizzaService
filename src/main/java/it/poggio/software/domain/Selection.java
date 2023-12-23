package it.poggio.software.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Selection {
    Integer id;
    Pizza pizza;
    Cart cart;
    Integer quantity;
    List<Add> adds = new ArrayList<>();

}
