package it.poggio.software.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Selection {
    Integer id;
    Pizza pizza;
    Cart cart;
    Integer quantity;
    Set<Add> adds = new HashSet<Add>();

}
