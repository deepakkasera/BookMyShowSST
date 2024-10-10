package com.example.bookmyshowsst.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {
    private Long id;
    private String email;
    private ResponseStatus responseStatus;
}
