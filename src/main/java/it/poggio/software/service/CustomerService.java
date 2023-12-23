package it.poggio.software.service;

import it.poggio.software.dao.CustomerRepository;
import it.poggio.software.domain.Customer;
import it.poggio.software.domain.exception.CustomException;
import it.poggio.software.utils.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ValidationUtils validationUtils;

    public Customer insertCustomer(Customer customer) throws CustomException {

        //customer validations
        validationUtils.validateCustomer(customer);

        //check that the customer doesn't already exist
        Customer customerDB = checkCustomerAlreadyExists(customer);

        if(customerDB == null) {
            customerRepository.insertCustomer(customer);
        }else {
            //merge orders DB + Input
            customer.getOrders().addAll(customerDB.getOrders());

            customerRepository.updateCustomer(customer, String.valueOf(customerDB.getId()));
        }

        return customer;
    }

    private Customer checkCustomerAlreadyExists(Customer customer) throws CustomException {
        return customerRepository.checkIfCustomerExists(customer.getPhone(), customer.getEmail());
    }


}
