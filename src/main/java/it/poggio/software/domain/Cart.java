package it.poggio.software.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Cart {
    Integer id;
    Double totalPrice;
    Double deliveryPrice;
    List<Selection> selections = new ArrayList<>();
}
