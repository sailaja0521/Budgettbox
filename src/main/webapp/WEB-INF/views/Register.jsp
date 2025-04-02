<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
   <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
    </head>
<body>

    <h2>Register</h2>
    <form action="/processRegistration" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <button type="submit">Register</button>
    </form>
    <p>Already have an account? <a href="login">Login here</a></p>
</body>
</html>