<%-- 
    Document   : seft
    Created on : Nov 7, 2023, 12:59:31 AM
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
        <script>
            function sortPrice() {
                var select = document.getElementById("sortPrice");
                var option = select.value;
                window.location.href = "seft?sortprice=" + option;
            }
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



            <!-- Book Show -->
            <section class="catagory_section layout_padding">
                <div class="catagory_container">
                    <div class="container ">
                        <div class="heading_container heading_center">
                            <h2>
                                Book Collection
                            </h2>
                        </div>
                        <select id="sortPrice" onchange="sortPrice()">
                            <option value="all" ${sortprice == null || sortprice.equals("all") ? "selected" : ""}>Sắp xếp theo giá</option>
                            <option value="asc" ${sortprice != null && sortprice.equals("asc") ? "selected" : ""}>Giá tăng dần</option>
                            <option value="desc" ${sortprice != null && sortprice.equals("desc") ? "selected" : ""}>Giá giảm dần</option>
                        </select>


                        <br><!-- comment -->
                        <br>
                        <br>
                        <div class="book-container">
                            <!-- Book  -->
                            <c:forEach items="${requestScope.book_list}" var="bl">
                                <div class="book">
                                    <img src="${bl.image}" alt="Book image">
                                    <h3><a href="detail?id=${bl.id}">${bl.title}</a></h3>
                                    <p>${bl.author}</p>
                                    <c:choose>
                                        <c:when test="${bl.is_sale}">
                                            <c:set var="discountedPrice" value="${bl.price * (1 - bl.discount / 100.0)}" />
                                            <c:set var="roundedDiscountedPrice" value="${Math.round(discountedPrice * 100.0) / 100.0}" />
                                            <p><del>$${bl.price}</del> <strong class="discounted-price">$${roundedDiscountedPrice}</strong></p>
                                        </c:when>
                                        <c:otherwise>
                                            <p>$${bl.price}</p>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </c:forEach>


                        </div>
                    </div>
                </div>
            </section>

            <!-- end catagory section -->

            <!-- info section -->

            <section class="info_section layout_padding2">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-lg-3 info-col">
                            <div class="info_detail">
                                <h4>
                                    About Us
                                </h4>
                                <p>
                                    Vitae aut explicabo fugit facere alias distinctio, exem commodi mollitia minusem dignissimos atque asperiores incidunt vel voluptate iste
                                </p>
                                <div class="info_social">
                                    <a href="">
                                        <i class="fa fa-facebook" aria-hidden="true"></i>
                                    </a>
                                    <a href="">
                                        <i class="fa fa-twitter" aria-hidden="true"></i>
                                    </a>
                                    <a href="">
                                        <i class="fa fa-linkedin" aria-hidden="true"></i>
                                    </a>
                                    <a href="">
                                        <i class="fa fa-instagram" aria-hidden="true"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3 info-col">
                            <div class="info_contact">
                                <h4>
                                    Address
                                </h4>
                                <div class="contact_link_box">
                                    <a href="">
                                        <i class="fa fa-map-marker" aria-hidden="true"></i>
                                        <span>
                                            Location
                                        </span>
                                    </a>
                                    <a href="">
                                        <i class="fa fa-phone" aria-hidden="true"></i>
                                        <span>
                                            Call +01 1234567890
                                        </span>
                                    </a>
                                    <a href="">
                                        <i class="fa fa-envelope" aria-hidden="true"></i>
                                        <span>
                                            demo@gmail.com
                                        </span>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3 info-col">
                            <div class="info_contact">
                                <h4>
                                    Newsletter
                                </h4>
                                <form action="#">
                                    <input type="text" placeholder="Enter email" />
                                    <button type="submit">
                                        Subscribe
                                    </button>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3 info-col">
                            <div class="map_container">
                                <div class="map">
                                    <div id="googleMap"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- end info section -->

            <!-- footer section -->
            <footer class="footer_section">
                <div class="container">
                    <p>
                        &copy; <span id="displayYear"></span> All Rights Reserved By
                        <a href="https://html.design/">Free Html Templates</a>
                    </p>
                </div>
            </footer>
            <!-- footer section -->



    </body>

</html>
