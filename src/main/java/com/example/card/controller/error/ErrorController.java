package com.example.card.controller.error;

import com.example.card.domain.error.ResultMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(HTTPStatusException.class)
    public ResponseEntity<ResultMessage> HttpStatusExceptionHandler (HTTPStatusException e) {
        ResultMessage rm = new ResultMessage(e.errorCode, e.errorMessage);

        return new ResponseEntity<ResultMessage>(rm, e.httpStatus);
    }
}
