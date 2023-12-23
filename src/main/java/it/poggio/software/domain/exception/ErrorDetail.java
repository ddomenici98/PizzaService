package it.poggio.software.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorDetail {

    private String message;
    private HttpStatus status;
    private String timestamp;

    public ErrorDetail(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        this.timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(Instant.now().atZone(ZoneId.of("Europe/Rome")));
    }
}
