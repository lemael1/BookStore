<%-- 
    Document   : mua
    Created on : Nov 10, 2023, 2:09:52 PM
    Author     : 1112v
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <link rel="icon" href="images/favicon.png" type="image/gif" />
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />

        <title>HStore</title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <!-- font awesome style -->
        <link href="css/font-awesome.min.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />
        <script src="js/jquery-3.4.1.min.js"></script>
        <!-- bootstrap js -->
        <script src="js/bootstrap.js"></script>
        <!-- custom js -->      
        <!-- Google Map -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
        </script>
        <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 15px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .buy-button {
            background-color: red;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
    </head>

    <body>

        <div class="hero_area">
            <!-- header section strats -->
            <header class="header_section">
                <div class="container-fluid">
                    <nav class="navbar navbar-expand-lg custom_nav-container ">
                        <a class="navbar-brand" href="home">
                            <span>
                                HStore
                            </span>
                        </a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class=""> </span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav">
                                <li class="nav-item active">
                                    <a class="nav-link pl-lg-0" href="home">Home <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="order"> Cart</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="seft">Seft</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="blog.html"> Blog </a>
                                </li>
                                <li class="nav-item">
                                    <c:choose>
                                        <c:when test="${not empty sessionScope.user}">
                                            <a class="nav-link" href="logout">Logout</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="nav-link" href="login">Login</a>
                                        </c:otherwise>
                                    </c:choose>     
                                </li>
                            </ul>
                            <div id="greeting">
                                <c:choose>
                                    <c:when test="${not empty sessionScope.user}">
                                        Hello <c:out value="${sessionScope.user.username}" />
                                    </c:when>
                                    <c:otherwise>
                                        <!-- You can put something else here if the user is not logged in -->
                                    </c:otherwise>
                                </c:choose>
                            </div>

                        </div>
                    </nav>
                </div>
            </header>
            <!-- end header section -->
              <h2>Your Cart</h2>
    <table>
        <tr>
            <th>Book Title</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <c:forEach var="item" items="${sessionScope.cart}">
            <tr>
                <td>${item.itemname}</td>
                <td>${item.quantity}</td>
                <td>${item.price}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2">Total</td>
            <td>
                <c:set var="total" value="0"/>
                <c:forEach var="item" items="${sessionScope.cart}">
                    <c:set var="total" value="${total + (item.price * item.quantity)}"/>
                </c:forEach>
                ${total}
            </td>
        </tr>
    </table>
    <form action="mua" method="post">
        <button class="buy-button" type="submit">Buy All</button>
    </form>






    </body>

</html>
