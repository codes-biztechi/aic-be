package biztechi.aic.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Resource disallowed")
public class ResourceUnauthorizedException extends RuntimeException {
    public ResourceUnauthorizedException(String message) {
        super(message);
    }
}
