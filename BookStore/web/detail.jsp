<%-- 
    Document   : detail
    Created on : Nov 8, 2023, 9:21:24 AM
    Author     : 1112v
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                                <a class="nav-link" href="about.html"> About</a>
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
    </div>
    <!--           detail       -->
    <
    <c:set var="b" value="${requestScope.b}"></c:set>
        <div class = "card-wrapper" style=" display: flex;
             justify-content: space-between;">
            <div class = "card" >
                <!-- card left -->
                <!-- card left -->
                <div class = "product-imgs" style=" flex: 1;">
                    <div class = "img-display">
                        <div class = "img-showcase">
                            <img src = "${b.image}" alt = "book image">             
                    </div>
                </div>

            </div>
            <!-- card right -->
            <div class = "product-content" style="flex: 2;
                 padding-left: 20px;">
                <h2 class = "product-title">${b.title}</h2>                           
                <p class = "last-price">Author: <span>${b.author}</span></p>
                <c:set var="discountedPrice" value="${b.price * (1 - b.discount / 100.0)}" />
                <c:set var="roundedDiscountedPrice" value="${Math.round(discountedPrice * 100.0) / 100.0}" />
                <p><del>$${b.price}</del> <strong class="discounted-price">$${roundedDiscountedPrice}</strong></p>



                <div class = "product-detail" style="margin-top: -20px;">
                    <h2>about this book: </h2>
                    <p>${b.description} </p>


                </div>

                <div class = "purchase-info">
                    <input type = "number" min = "0" value = "1">
                    <button type = "button" class = "btn" style="background-color: red;
                            color: white;">
                        Add to Cart <i class = "fas fa-shopping-cart"></i>
                    </button>
                    
                </div>


            </div>
        </div>
    </div>



</body>
</html>
