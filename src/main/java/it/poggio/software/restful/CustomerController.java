package it.poggio.software.restful;

import it.poggio.software.domain.Customer;
import it.poggio.software.domain.exception.CustomException;
import it.poggio.software.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Customer> insertCustomer(@RequestBody(required=true) Customer customer) throws CustomException {

        customerService.insertCustomer(customer);

        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
