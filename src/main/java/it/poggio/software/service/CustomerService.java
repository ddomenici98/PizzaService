package it.poggio.software.service;

import it.poggio.software.dao.CustomerRepository;
import it.poggio.software.domain.Customer;
import it.poggio.software.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer insertCustomer(Customer customer) throws CustomException {

        customerRepository.insertCustomer(customer);

        return customer;
    }


}
