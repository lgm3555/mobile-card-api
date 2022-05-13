package com.example.card.domain.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResultMessage {

    private String errorCode;
    private String errorMessage;

}
