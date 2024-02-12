package com.pw.airbnb.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ValidationErrorResponse {
    private String fieldName;
    private String errorMessage;

}