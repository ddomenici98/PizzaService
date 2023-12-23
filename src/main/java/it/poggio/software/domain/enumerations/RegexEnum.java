package it.poggio.software.domain.enumerations;

import java.util.regex.Pattern;

public enum RegexEnum {

    PHONE("^\\d{10}$", "Numero di telefono non valido"),
    EMAIL("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", "Indirizzo email non valido");

    private final String regex;
    private final String errorMessage;

    RegexEnum(String regex, String errorMessage) {
        this.regex = regex;
        this.errorMessage = errorMessage;
    }

    public boolean validate(String value) {
        return Pattern.matches(regex, value);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
