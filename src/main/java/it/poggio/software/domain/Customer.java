package it.poggio.software.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer{

    private Integer id;
    private String name;
    private String intercom;
    private String phone;
    private String address;
    private String postalCode;
    private Integer previousOrdersNumber;
    private String email;
    private Set<Order> orders = new HashSet<Order>();


}
