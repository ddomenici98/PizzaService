package it.poggio.software.utils;

import it.poggio.software.domain.Customer;
import it.poggio.software.domain.enumerations.RegexEnum;
import it.poggio.software.domain.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtils {

    public void validateCustomer(Customer customer) throws CustomException {

        //validate phone
        if(!RegexEnum.PHONE.validate(customer.getPhone())) {
            throw new CustomException(RegexEnum.PHONE.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }

        //validate email
        if(!RegexEnum.EMAIL.validate(customer.getEmail())) {
            throw new CustomException(RegexEnum.EMAIL.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }



    }
}
