package aaa.moc.TinyBox.controller;

import aaa.moc.TinyBox.exception.EjercicioNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviser extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ExceptionResponse> handleRestException(Exception ex, WebRequest request) {
        return buildExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler({EjercicioNotFoundException.class })
    public ResponseEntity<ExceptionResponse> handleEjercicioNotFoundException(Exception ex, WebRequest request) {
        return buildExceptionResponse(HttpStatus.BAD_REQUEST, ex);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(buildExceptionResponse(HttpStatus.BAD_REQUEST, ex).getBody(),
                status);
    }

    private ResponseEntity<ExceptionResponse> buildExceptionResponse(HttpStatus status,
                                                                     Exception ex) {
        ExceptionResponse result;

        if (ex instanceof MethodArgumentNotValidException) {
            result = this.processSpringValidationErrorResponse(status, ex);
        } else {
            result = new ExceptionResponse(status, ex);
        }
        return new ResponseEntity<>(result, status);
    }

    private ExceptionResponse processSpringValidationErrorResponse(HttpStatus status,
                                                                   Exception ex) {
        ExceptionResponse result = new ExceptionResponse(status, ex);

        StringBuilder message = new StringBuilder();
        ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors()
                .forEach(err -> message
                        .append(err.getDefaultMessage())
                        .append("\n"));

        result.setMessage(message.toString());

        return result;
    }

    @Getter
    @Setter
    protected class ExceptionResponse {
        private int errorCode;
        private String errorDescription;
        private String message;

        public ExceptionResponse(HttpStatus status, Exception exception) {
            this.errorCode = status.value();
            this.errorDescription = status.getReasonPhrase();
            this.message = exception.getMessage();
        }

    }
}
