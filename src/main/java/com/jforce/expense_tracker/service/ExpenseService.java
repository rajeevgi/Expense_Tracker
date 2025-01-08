package com.jforce.expense_tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jforce.expense_tracker.entity.Expense;
import com.jforce.expense_tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
    
    @Autowired
    private ExpenseRepository expenseRepository;

    // Post Mapping to save expenses.
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Get Mapping to get list of expenses.
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Mapping to get expense by Id.
    public Optional<Expense> findById(int id) {
        return expenseRepository.findById(id);
    }

    // Delete expenses from list.
    public void deleteExpense(int id) {
        expenseRepository.deleteById(id);
    }
}
