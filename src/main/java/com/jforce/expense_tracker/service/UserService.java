package com.jforce.expense_tracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jforce.expense_tracker.entity.User;
import com.jforce.expense_tracker.repository.UserDetailsRepository;

@Service
public class UserService {
    
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public User registerUser(User user) {
         User user2 = new User();

         user2.setUsername(user.getUsername());
         user2.setEmail(user.getEmail());
         user2.setPassword(user.getPassword());
         user2.setFullname(user.getFullname() );

        return userDetailsRepository.save(user2);
    }

    public Optional<User> findByEmail(String email) {
        return userDetailsRepository.findByEmail(email);
    }

    public User login(String email, String password) {
        User user = userDetailsRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found!"));

        if(user != null){
            return user;
        }

        return null;
    }
}
