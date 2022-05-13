package com.example.card.controller.error;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class HTTPStatusException extends RuntimeException {

    //상태값
    protected HttpStatus httpStatus = HttpStatus.OK;

    //에러코드
    protected String errorCode = "";

    //에러메세지
    protected String errorMessage = "";

}
