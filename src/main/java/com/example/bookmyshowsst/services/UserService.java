package com.example.bookmyshowsst.services;

import com.example.bookmyshowsst.dtos.ResponseStatus;
import com.example.bookmyshowsst.models.User;

public interface UserService {
    User signup(String name, String email, String password);

    ResponseStatus login(String email, String password);
}
