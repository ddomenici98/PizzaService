package it.poggio.software.service;

import it.poggio.software.dao.OrderRepository;
import it.poggio.software.domain.Order;
import it.poggio.software.domain.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void insertOrder(Order order) throws CustomException {

        orderRepository.insertOrder(order);
    }

    public Order getOrderById(Integer id){
        return orderRepository.getOrder(id);
    }
}
