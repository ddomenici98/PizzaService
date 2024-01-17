package it.poggio.software.service;

import it.poggio.software.dao.CartRepository;
import it.poggio.software.dao.CustomerRepository;
import it.poggio.software.dao.OrderRepository;
import it.poggio.software.domain.Order;
import it.poggio.software.domain.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository;

    @Autowired
    CustomerRepository customerRepository; // da rimuovere, per scopo di test

    @Transactional
    public void insertOrder(Order order) throws CustomException {

        customerRepository.insertCustomer(order.getCustomer());
        cartRepository.insertCart(order.getCart());
        orderRepository.insertOrder(order);
    }


}
