package it.poggio.software.domain;

import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Order {
    private Integer id;
    private Customer customer;
    private Date date;
    private Time requestedTime;
    private Time confirmedTime;
    private Boolean accepted;
    private Cart cart;
}
