

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
                <!-- end header section -->
                <!-- slider section -->
                <section class="slider_section ">
                    <div id="customCarousel1" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="container ">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="detail-box">
                                                <h5>
                                                    HStore
                                                </h5>
                                                <h1>
                                                    For All Your <br>
                                                    Reading Needs
                                                </h1>
                                                <p>
                                                    “Reading is a conversation. All books talk. But a good book listens as well.”
                                                </p>

                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="img-box">
                                                <img src="images/slider-img.png" alt="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="container ">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="detail-box">
                                                <h5>
                                                    Hao Bookstore
                                                </h5>
                                                <h1>
                                                    For All Your <br>
                                                    Reading Needs
                                                </h1>
                                                <p>
                                                    “Books are a uniquely portable magic.”
                                                </p>

                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="img-box">
                                                <img src="images/slider-img.png" alt="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="container ">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="detail-box">
                                                <h5>
                                                    Hao Bookstore
                                                </h5>
                                                <h1>
                                                    For All Your <br>
                                                    Reading Needs
                                                </h1>
                                                <p>
                                                    “A reader lives a thousand lives before he dies. The man who never reads lives only one.”
                                                </p>

                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="img-box">
                                                <img src="images/slider-img.png" alt="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel_btn_box">
                            <a class="carousel-control-prev" href="#customCarousel1" role="button" data-slide="prev">
                                <i class="fa fa-angle-left" aria-hidden="true"></i>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#customCarousel1" role="button" data-slide="next">
                                <i class="fa fa-angle-right" aria-hidden="true"></i>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                </section>
                <!-- end slider section -->
            </div>


            <!-- Book show in first page -->

            <section class="catagory_section layout_padding">
                <div class="catagory_container">
                    <div class="container ">
                        <div class="heading_container heading_center">
                            <h2>
                                Featured Book
                            </h2>
                        </div>
                        <div class="book-container">
                            <!-- Book  -->
                            <c:forEach items="${requestScope.list_feature}" var="lf">
                                <div class="book">
                                    <img src="${lf.image}" alt="Book image">
                                    <h3><a href="detail?id=${lf.id}">${lf.title}</a></h3>
                                    <p>${lf.author}</p>
                                    <c:set var="discountedPrice" value="${lf.price * (1 - lf.discount / 100.0)}" />
                                    <c:set var="roundedDiscountedPrice" value="${Math.round(discountedPrice * 100.0) / 100.0}" />
                                    <p><del>$${lf.price}</del> <strong class="discounted-price">$${roundedDiscountedPrice}</strong></p>

                                </div>
                            </c:forEach>                          
                        </div>
                    </div>
                </div>
            </section>
            <!--         end featurebook-->

            <!-- end catagory section -->

            <!-- about section -->

            <section class="about_section layout_padding">
                <div class="container ">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="img-box">
                                <img src="images/about-img.png" alt="">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="detail-box">
                                <div class="heading_container">
                                    <h2>
                                        About Our Bookstore
                                    </h2>
                                </div>
                                <p>
                                    Our bookstore is a treasure trove for book enthusiasts, offering a wide array of books across various genres. Our dedicated staff are always ready to assist you in finding your next great read. We also host regular author events and offer a special order service for those hard-to-find titles. Visit us for a unique literary experience! 
                                </p>
                                <a href="">
                                    Read More
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- end about section -->




            <!-- contact section -->

            <section class="contact_section layout_padding">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 ">
                            <div class="heading_container ">
                                <h2 class="">
                                    Contact Us
                                </h2>
                            </div>
                            <form action="#">
                                <div>
                                    <input type="text" placeholder="Name" />
                                </div>
                                <div>
                                    <input type="email" placeholder="Email" />
                                </div>
                                <div>
                                    <input type="text" placeholder="Pone Number" />
                                </div>
                                <div>
                                    <input type="text" class="message-box" placeholder="Message" />
                                </div>
                                <div class="btn-box">
                                    <button>
                                        SEND
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-6">
                            <div class="img-box">
                                <img src="images/contact-img.png" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- end contact section -->

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

            <!-- jQery -->
            <script src="js/jquery-3.4.1.min.js"></script>
            <!-- bootstrap js -->
            <script src="js/bootstrap.js"></script>
            <!-- custom js -->
            <script src="js/custom.js"></script>
            <!-- Google Map -->
            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
            </script>
            <!-- End Google Map -->

        </body>

    </html>
