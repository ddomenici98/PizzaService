package it.poggio.software.domain.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;

@ToString
public enum Errors {
    //database errors
    ERROR_DB(INTERNAL_SERVER_ERROR, "An error occurred while communicating with the database."),
    ERROR_EMPTY_RESULTSET(NOT_FOUND,"Result not found" );


    private final HttpStatus httpStatus;
    private final String errorDescription;

    Errors(HttpStatus httpStatus, String errorDescription) {
        this.httpStatus = httpStatus;
        this.errorDescription = errorDescription;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
