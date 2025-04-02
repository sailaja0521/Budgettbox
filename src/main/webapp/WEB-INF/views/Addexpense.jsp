<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Expense</title>
    <style>
        button {
            margin-top: 10px;
            padding: 10px;
            font-size: 16px;
            cursor: pointer;
        }
       
    </style>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles4.css">
</head>
<body>
    <h2>Add New Expense</h2>
    <form action="Addexpense" method="POST">
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" required><br>

        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required><br>

        <label for="date">Date:</label>
        <input type="date" id="date" name="expenseDate" required><br>

        <button type="submit">Add Expense</button>
    </form>

    <br>
    
    <!-- ✅ Button to navigate to expenses.jsp -->
    <form action="expenses" method="GET">
        <button type="submit">List of Expenses</button>
    </form>
</body>
</html>
