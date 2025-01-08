package com.jforce.expense_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jforce.expense_tracker.entity.Expense;
import com.jforce.expense_tracker.entity.User;
import com.jforce.expense_tracker.service.ExpenseService;
import com.jforce.expense_tracker.service.UserService;


@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public String addExpensePage(Model model) {
        model.addAttribute("expense", new Expense());
        return "addExpense";
    }

    @PostMapping("/add")
    public String addExpense(@ModelAttribute Expense expense, User user) {
        expense.setUser(user);
        expenseService.saveExpense(expense);
        return "redirect:/expenses/list";
    }

    @GetMapping("/list")
    public String listExpenses(Model model, User user) {
        List<Expense> expenses = expenseService.findExpensesByUser(user);
        model.addAttribute("expenses", expenses);
        return "listexpenses";
    }

    @GetMapping("/update/{id}")
    public String updateExpensePage(@PathVariable int id, Model model) {
        Expense expense = expenseService.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
        model.addAttribute("expense", expense);
        return "updateexpense";
    }

    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable int id, @ModelAttribute Expense expense) {
        expense.setId(id);
        expenseService.saveExpense(expense);
        return "redirect:/expenses/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses/list";
    }
}
