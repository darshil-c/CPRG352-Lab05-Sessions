<%-- 
    Document   : login
    Created on : 19-Jun-2021, 5:05:51 PM
    Author     : Chaudhari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${username}">
            <br>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password" value="${password}">
            <br>
            <input type="submit" value="Log In">
        </form>
            <p>${message}</p>
    </body>
</html>
