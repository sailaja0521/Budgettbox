package com.example.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Expense;
import com.example.entity.User;
import com.example.service.ExpenseService;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private UserService userService;

    // Display Add Expense Page
    @GetMapping("/Addexpense")
    public String showExpenseForm() {
        return "Addexpense"; // Maps to AddExpense.jsp
    }

    // Process the Expense Form and Store in Database
    @PostMapping("/Addexpense")
    public ModelAndView addExpense(@RequestParam int amount, 
                                   @RequestParam String description, 
                                   @RequestParam String  expenseDate, 
                                   HttpSession session) throws ParseException {
        // Retrieve logged-in user from session
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return new ModelAndView("redirect:/login"); // Redirect to login if no user is logged in
        }

        // Fetch user from the database
        User user = userService.findByUsername(username);
        if (user == null) {
            return new ModelAndView("redirect:/login"); // Redirect if user is not found
        }

     // ✅ Convert String to Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse(expenseDate);


        // Create Expense Object
        Expense expense = new Expense();
        expense.setUser(user); // Store User ID
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setExpenseDate(parsedDate);

        // Save to Database
        expenseService.addExpense(expense);
        return new ModelAndView("redirect:/Addexpense");
    }
    @GetMapping("/expenses")
    public String listExpenses(Model model, HttpSession session) {
        // ✅ Ensure user is logged in
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return "redirect:/login";
        }

        // ✅ Retrieve user
        User user = userService.findByUsername(username);
        if (user == null) {
            return "redirect:/login";
        }

        // ✅ Fetch all expenses of the logged-in user
        List<Expense> expenses = expenseService.getExpensesByUser(user);
        model.addAttribute("expenses", expenses);

        return "expenses";  // Redirect to `expenses.jsp`
    }
}

