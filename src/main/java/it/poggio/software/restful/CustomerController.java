package it.poggio.software.restful;

import it.poggio.software.domain.Customer;
import it.poggio.software.domain.exception.CustomException;
import it.poggio.software.domain.exception.ErrorHandler;
import it.poggio.software.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private ErrorHandler errorHandler = new ErrorHandler();

    @PostMapping()
    @Description(value = "L'API si occupa di inserire gli sbirri mpami all'interno del DB")
    public ResponseEntity<Object> insertCustomer(@RequestBody(required = true) Customer customer) throws CustomException {

        ResponseEntity<Object> response;
        Customer customerResponse;
        try {
            customerResponse = customerService.insertCustomer(customer);
            response = new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
        }catch(CustomException e) {
            response = errorHandler.handleCustomExceptions(e);
        }

        return response;
    }
}
