package com.jforce.expense_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jforce.expense_tracker.entity.User;
import com.jforce.expense_tracker.repository.UserDetailsRepository;

@Service
public class UserService {
    
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public String registerUser(User user) {
       userDetailsRepository.save(user);

       return " User Registerd successfully";
    }
    
    public User findByEmail(String email) {
        return userDetailsRepository.findByEmail(email);
    }

}
