package biztechi.aic.error;

import biztechi.aic.error.ErrorResponse;
import biztechi.aic.error.exception.ResourceNotFoundException;
import biztechi.aic.error.exception.ResourceUnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        log.error("Resource not found = {}", ex.getMessage());
        return ResponseEntity.status(404).body(
                ErrorResponse.builder()
                        .code(HttpStatus.NOT_FOUND)
                        .message(ex.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(ResourceUnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleResourceUnauthorizedException(ResourceUnauthorizedException ex) {
        log.error("Resource unauthorized = {}", ex.getMessage());
        return ResponseEntity.status(401).body(
                ErrorResponse.builder()
                        .code(HttpStatus.UNAUTHORIZED)
                        .message(ex.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnknownException(Exception ex) {
        log.error("Internal Server Error = {}", ex.getMessage());
        return ResponseEntity.status(500).body(
                ErrorResponse.builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR)
                        .message("Internal Server Error")
                        .build()
        );
    }
}
