package com.example.bookmyshowsst.services;

import com.example.bookmyshowsst.dtos.ResponseStatus;
import com.example.bookmyshowsst.models.User;
import com.example.bookmyshowsst.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signup(String name, String email, String password) {

        //First Check if User with the given email is already present in the DB or not.
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            //Redirect to login.
            return optionalUser.get();
        }

        //User is not present in the DB, create the user with the given details and save it in the DB.
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        //Password should be stored in the DB aafter encryption.
        //For now we are storing password as it is in the DB, we can use BCryptPasswordEncoder
        // to encode the password.
        user.setPassword(password);

        return userRepository.save(user);
    }

    @Override
    public ResponseStatus login(String email, String inputPassword) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            //Redirect to Signup
        }

        User user = optionalUser.get();

        if (user.getPassword().equals(inputPassword)) {
            //Login Successful.
            return ResponseStatus.SUCCESS;
        }

        return ResponseStatus.FAILURE;
    }
}
