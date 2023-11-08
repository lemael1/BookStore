<%-- 
    Document   : add.jsp
    Created on : Nov 8, 2023, 2:04:33 AM
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
        <h1>Add a New Book</h1>
        <form action="add" method="post">           
            Title:<br>
            <input type="text"  name="title"><br>
            Author:<br>
            <input type="text" name="author"><br>
            Category:<br>
            <select name="cateid">
                <c:forEach items="${requestScope.list_cate1}" var="lc1">
                    <option value="${lc1.id}">${lc1.name}</option>
                </c:forEach>
            </select>
            <br>
            Quantity:<br>
            <input type="text"  name="quantity"><br>
            Price:<br>
            <input type="text"  name="price"><br>
            Is Sale:<br>
            <input type="radio" value="1" name="is_sale"><br>Sales
            <input type="radio" value="0" name="is_sale"><br>Not Sales
            Discount:<br>
            <input type="text" name="discount"><br>
            Image:<br>
            <input type="text" name="image"><br>
            Description:<br>
            <textarea id="description" name="description"></textarea><br>
            <input type="submit" value="Add">
        </form>
    </body>
</html>
