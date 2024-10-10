package com.example.bookmyshowsst.controllers;

import com.example.bookmyshowsst.dtos.*;
import com.example.bookmyshowsst.dtos.ResponseStatus;
import com.example.bookmyshowsst.models.User;
import com.example.bookmyshowsst.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8080/users/signup
    @PostMapping("/signup")
    public SignupResponseDto signUp(@RequestBody SignUpRequestDto requestDto) {

        User user = userService.signup(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        SignupResponseDto responseDto = new SignupResponseDto();
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setEmail(user.getEmail());
        responseDto.setId(user.getId());

        return responseDto;
    }

    @GetMapping("/login")
    public LogInResponseDto login(@RequestBody LogInRequestDto requestDto) {
        ResponseStatus responseStatus =
                userService.login(
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );


        LogInResponseDto responseDto = new LogInResponseDto();
        responseDto.setResponseStatus(responseStatus);
        return responseDto;
    }
}
