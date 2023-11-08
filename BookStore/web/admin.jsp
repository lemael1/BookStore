<%-- 
    Document   : admin
    Created on : Nov 8, 2023, 12:20:35 AM
    Author     : 1112v
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function confirmDelete() {
                return confirm("Bạn có chắc chắn muốn xóa không?");
            }
        </script>
    </head>
    <body>
        <h1> Hello Admin</h1>
        <br><!-- comment -->
        <br><!-- comment -->
        <br><!-- comment -->
        <a href="add">Add Book</a><!-- comment -->

        <form>
            <table border="1px">
                <tr>
                    <td>id</td>
                    <td>Image</td>
                    <td>Title</td>
                    <td>Author</td>
                    <td>Quantity</td>
                    <td>Price</td>
                    <td>Update</td>
                    <td>Delete</td>
                </tr>
                <c:forEach var="bl" items="${requestScope.list_book}">
                    <tr>
                        <td>${bl.id}</td>
                        <td><img src="${bl.image}" alt="Book image" width="50" height="50"></td>
                        <td>${bl.title}</td>
                        <td>${bl.author}</td>
                        <td>${bl.quantity}</td>
                        <td>${bl.price}</td>
                        <td><a href="update?id=${bl.id}">Update</a></td>
                        <td><a href="delete?id=${bl.id}" onclick="return confirmDelete()">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>


        </form>
    </body>
</html>
