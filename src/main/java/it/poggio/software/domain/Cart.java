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
public class Cart {
    Integer id;
    Double totalPrice;
    Double deliveryPrice;
    Set<Selection> selections = new HashSet<>();
}
