package it.poggio.software.domain.request;

import it.poggio.software.domain.Order;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class OrderRequest {
    Order order;
}
