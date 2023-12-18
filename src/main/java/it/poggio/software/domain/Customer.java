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
public class Customer{

    private Integer id;
    private String name;
    private String intercom;
    private Integer phone;
    private String address;
    private Integer postalCode;
    private Integer previousOrdersNumber;
    private String email;
    private Set<Order> orders = new HashSet<Order>();


}
