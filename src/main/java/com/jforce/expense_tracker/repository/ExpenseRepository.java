package com.jforce.expense_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jforce.expense_tracker.entity.Expense;
import com.jforce.expense_tracker.entity.User;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    List<Expense> findByUser(User user);

}
