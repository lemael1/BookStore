<%-- 
    Document   : signup
    Created on : Nov 8, 2023, 11:38:59 AM
    Author     : 1112v
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register An Account</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/signup.css" />
        <style>
            input[type="date"] {
                color: black;
            }
            body {
                width: 100%;
            }
        </style>
    </head>
    <body>


        <form action="signup" method="post" >
            <h1> Sign up </h1>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required pattern="[a-zA-Z0-9_.]+" title="Chỉ bao gồm chữ cái, số, dấu gạch dưới và dấu chấm"><br><br>
            <c:set var="thongbao"  value="${requestScope.thongbao}"></c:set>
                <h2>${thongbao}</h2>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>

            <label for="fullname">Fullname:</label>
            <input type="text" id="fullname" name="fullname" required><br><br>
            <label for="dob">Date of Birth:</label>
            <input type="date" name="dob">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required pattern=".+@.+" title="Email phải bao gồm ký tự @">
            <label for="phone">Phone:</label>
            <input type="text" name="phone">
            <label for="gender">Gender:</label>
            <select id="gender" name="gender">
                <option value="1">Male</option>
                <option value="0">Female</option>

            </select><br><br>

            <label for="address">Address:</label>
            <textarea id="address" name="address"></textarea><br><br>

            <input type="submit" value="Register" required>
            <a href="login" class="cancel-button">Login</a>
        </form>
        <!-- Scripts -->
        <script src="js/signup.js"></script>
    </body>
</html>
