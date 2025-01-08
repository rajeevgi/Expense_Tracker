package com.jforce.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jforce.expense_tracker.entity.User;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
