package it.poggio.software.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    private Integer id;
    private Customer customer;
    private Date date;
    private Time requestedTime;
    private Time confirmedTime;
    private Boolean accepted;
    private Integer cartId;
}
