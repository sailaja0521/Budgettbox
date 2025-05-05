package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Expense;
import com.example.entity.User;
import com.example.service.ExpenseService;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/expenses") // Base URL for all expense-related APIs
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addExpense(@RequestBody Expense expense, HttpSession session) throws ParseException {
        // Check if user is logged in
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }
        // Retrieve user from DB
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        // Convert String to Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse(expense.getExpenseDate());

        // Create Expense Object and set properties
        Expense newExpense = new Expense();
        newExpense.setUser(user);
        newExpense.setAmount(expense.getAmount());
        newExpense.setDescription(expense.getDescription());
        newExpense.setExpenseDate(parsedDate);

        // Save to Database
        expenseService.addExpense(newExpense);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExpense);
    }


    // ✅ Get All Expenses of Logged-in User (GET)
    @GetMapping
    public ResponseEntity<?> listExpenses(HttpSession session) {
        // Ensure user is logged in
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        // Retrieve user
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        // Fetch all expenses of the logged-in user
        List<Expense> expenses = expenseService.getExpensesByUser(user);
        return ResponseEntity.ok(expenses);
    }

    // ✅ Get Expense by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getExpenseById(@PathVariable Long id, HttpSession session) {
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        Expense expense = expenseService.findById(id);
        if (expense == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense not found");
        }

        return ResponseEntity.ok(expense);
    }

    // ✅ Delete Expense by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id, HttpSession session) {
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        Expense expense = expenseService.findById(id);
        if (expense == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense not found");
        }

        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}
