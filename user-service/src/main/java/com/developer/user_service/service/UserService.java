package com.developer.user_service.service;

import com.developer.user_service.model.User;
import com.developer.user_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> registerUser(User user) {
        Optional<User> findUser=userRepo.findByEmail(user.getEmail());
        if(findUser.isPresent()){
            return new ResponseEntity<>("User is already registered",HttpStatus.FOUND);
        }
        else {
            userRepo.save(user);
            return new ResponseEntity<>("Registered successfully ", HttpStatus.OK);
        }
    }

    public ResponseEntity<String> login(String email, String password) {
        User user=userRepo.findByEmail(email).get();
        if(Objects.equals(password, user.getPassword())){
            return new ResponseEntity<>("Login Success",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Invalid credentials",HttpStatus.NOT_FOUND);
        }
    }
}
