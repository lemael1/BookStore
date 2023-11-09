<%-- 
    Document   : update
    Created on : Nov 8, 2023, 1:00:51 AM
    Author     : 1112v
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Update Book</h1>
        <form action="update" method="post">
            ID:<br>
            <input type="text" value="${id}" name="id" readonly><br>
            Title:<br>
            <input type="text"  name="title" required><br>
            Author:<br>
            <input type="text" name="author" required><br>
            Category:<br>
            <select name="cateid" required>
                <c:forEach items="${requestScope.list_cate}" var="lc">
                    <option value="${lc.id}">${lc.name}</option>
                </c:forEach>
            </select>
            <br>
            Quantity:<br>
            <input type="text" name="quantity" pattern="\d+" title="Please enter a positive integer" required><br>
            Price:<br>
            <input type="text"  name="price" pattern="\d+(\.\d{2})?" title="Please enter a valid price" required><br>
            Is Sale:<br>
            <input type="radio" value="1" name="is_sale" checked><br>Sales
            <input type="radio" value="0" name="is_sale"><br>Not Sales
            Discount:<br>
            <input type="text" name="discount" pattern="\d+(\.\d{2})?" title="Please enter a valid discount"><br>
            Image:<br>
            <input type="text" name="image" required><br>
            Description:<br>
            <textarea id="description" name="description" required></textarea><br>
            <input type="submit" value="Update">
        </form>

    </body>
</html>
