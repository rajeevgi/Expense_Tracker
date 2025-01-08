package com.jforce.expense_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jforce.expense_tracker.entity.Expense;
import com.jforce.expense_tracker.service.ExpenseService;
import com.jforce.expense_tracker.service.UserService;


@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @GetMapping("/add-expense")
    public String addExpensePage(Model model) {
        model.addAttribute("Expense", new Expense());
        return "addExpense";
    }

    @PostMapping("/add-expense")
    public String addExpense(@ModelAttribute Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/listexpense";
    }

    @GetMapping("/list-expense")
    public String listExpensePage(Model model) {    
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "listexpense";
    }

    @GetMapping("/update-expense/{id}")
    public String updateExpensePage(@PathVariable int id, Model model) {
        Expense expense = expenseService.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
        model.addAttribute("expense", expense);
        return "updateexpense";
    }

    @PostMapping("/update-expense")
    public String updateExpense(@ModelAttribute Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/listexpense";
    }

    @GetMapping("/delete-expense/{id}")
    public String deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
        return "redirect:/list-expense";
    }
}
