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


        <form action="signup" method="post">
            <h1>Đăng ký</h1>
            <label for="username">Tên người dùng:</label>
            <input type="text" id="username" name="username" required pattern="[a-zA-Z0-9_.]+" title="Chỉ bao gồm chữ cái, số, dấu gạch dưới và dấu chấm"><br><br>
            <c:set var="thongbao"  value="${requestScope.thongbao}"></c:set>
            <h2>${thongbao}</h2>
            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required><br><br>

            <label for="fullname">Họ và tên:</label>
            <input type="text" id="fullname" name="fullname" required><br><br>
            <label for="dob">Ngày sinh:</label>
            <input type="date" name="dob">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required pattern=".+@.+" title="Email phải bao gồm ký tự @">
            <label for="phone">Số điện thoại:</label>
            <input type="text" name="phone" required pattern="\d{10}" title="Số điện thoại phải bao gồm 10 chữ số">
            <label for="gender">Giới tính:</label>
            <select id="gender" name="gender">
                <option value="1">Nam</option>
                <option value="0">Nữ</option>
            </select><br><br>

            <label for="address">Địa chỉ:</label>
            <textarea id="address" name="address"></textarea><br><br>

            <input type="submit" value="Đăng ký" required>
            <a href="login" class="cancel-button">Đăng nhập</a>
        </form>

        <!-- Scripts -->
        <script src="js/signup.js"></script>
    </body>
</html>
