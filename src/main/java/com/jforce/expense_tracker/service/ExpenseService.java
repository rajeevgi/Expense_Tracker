package com.jforce.expense_tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jforce.expense_tracker.entity.Expense;
import com.jforce.expense_tracker.entity.User;
import com.jforce.expense_tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
    
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> findExpensesByUser(User user) {
        return expenseRepository.findByUser(user);
    }

    public Optional<Expense> findById(int id) {
        return expenseRepository.findById(id);
    }

    public void deleteExpense(int id) {
        expenseRepository.deleteById(id);
    }
}
