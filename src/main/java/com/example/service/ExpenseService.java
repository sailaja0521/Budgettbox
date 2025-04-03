package com.example.service;

import com.example.entity.*;

import java.util.List;

public interface ExpenseService {
    void addExpense(Expense expense); // Method to add an expense
    Expense updateExpense(Expense expense);
   void deleteExpense(Expense expense);
   Expense findById(long expenseId);
    List<Expense>findAll(); // Method to get expenses by user ID
    List<Expense> getExpensesByUser(User user); 
    void deleteExpense(long id);
}