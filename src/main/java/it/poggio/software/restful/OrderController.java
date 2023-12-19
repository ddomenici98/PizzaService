package it.poggio.software.restful;

import it.poggio.software.domain.Order;
import it.poggio.software.domain.exception.CustomException;
import it.poggio.software.domain.request.OrderRequest;
import it.poggio.software.domain.response.GenericResponse;
import it.poggio.software.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/insert")
    public ResponseEntity<GenericResponse> insertOrders(@RequestBody OrderRequest orderRequest) throws CustomException {

        orderService.insertOrder(orderRequest.getOrder());


        return new ResponseEntity<>( HttpStatus.OK);
    }
}
