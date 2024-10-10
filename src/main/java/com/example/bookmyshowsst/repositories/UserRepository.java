package com.example.bookmyshowsst.repositories;

import com.example.bookmyshowsst.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //select * from users where email = email;
    Optional<User> findByEmail(String email);

    @Override
    User save(User user);
}