<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.example.entity.Expense" %>
<% List<Expense> expenses = (List<Expense>) request.getAttribute("expenses"); %>
<!DOCTYPE html>
<html>
<head>
    <title>Expenses List</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles3.css">
</head>
<body>
    <h2>Expense List</h2>
    <table border="1">
        <tr>
            <th>Amount</th>
            <th>Description</th>
            <th>Date</th>
        </tr>
        <% if (expenses != null) {
            for (Expense expense : expenses) { %>
            <tr>
                <td><%= expense.getAmount() %></td>
                <td><%= expense.getDescription() %></td>
                <td><%= expense.getExpenseDate() %></td>
            </tr>
        <% } } else { %>
            <tr><td colspan="3">No expenses found.</td></tr>
        <% } %>
    </table>
    <br>
    <a href="Addexpense"><button>Add Expense</button></a>
</body>
</html>
