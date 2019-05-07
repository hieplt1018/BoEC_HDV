<%-- 
    Document   : header
    Created on : Mar 30, 2019, 5:09:13 PM
    Author     : asus
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Clothes Store Divisima</title>
        <meta charset="UTF-8">
        <meta name="description" content=" Divisima | eCommerce Template">
        <meta name="keywords" content="divisima, eCommerce, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Favicon -->
        <link href="${pageContext.request.contextPath}/img/favicon.ico" rel="shortcut icon"/>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">


        <!-- Stylesheets -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flaticon.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slicknav.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylePage.css"/>
    </head>
    <body>

        <div id="fb-root"></div>
        <script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v3.2&appId=365882470690125&autoLogAppEvents=1"></script>
        <%
            Account account = null;
            if (session.getAttribute("account") != null) {
                account = (Account) session.getAttribute("account");
            }
            String username = "no";
            if (session.getAttribute("user") != null) {
                username = String.valueOf(session.getAttribute("user"));
            }
        %>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Header section -->
        <header class="header-section">
            <div class="header-top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-2 text-center text-lg-left">
                            <!-- logo -->
                            <a href="${pageContext.request.contextPath}/page/index.jsp" class="site-logo">
                                <img src="${pageContext.request.contextPath}/img/logo.png" alt="">
                            </a>
                        </div>
                        <div class="col-xl-6 col-lg-5">
                            <form class="header-search-form" action="${pageContext.request.contextPath}/SearchServlet"  method="post">
                                <input type="text" placeholder="Search on divisima ...." name="searchProduct">
                                <button  type="submit"><i class="flaticon-search"></i></button>
                            </form>
                        </div>
                        <div class="col-xl-4 col-lg-5">
                            <div class="user-panel">
                                <%
                                    if (account != null) {
                                %>
                                <span id="welcome" style="margin-right: 3%">Welcome <%=account.getEmail() %></span>
                                <span id="logout" style="margin: 0 6% 0 3%"><a href="${pageContext.request.contextPath}/LogoutServlet">Log out</a></span>    
                                <%
                                } else {
                                %>
                                <div class="up-item">
                                    <i class="flaticon-profile"></i>
                                    <a href="${pageContext.request.contextPath}/page/login.jsp">Sign In</a> or <a href="${pageContext.request.contextPath}/page/register.jsp">Create Account</a>
                                </div>
                                <% }%>
                                <div class="up-item">
                                    <div class="shopping-card">
                                        <i class="flaticon-bag"></i>
                                    </div>
                                    <a href="${pageContext.request.contextPath}/page/cart.jsp">Shopping Cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <nav class="main-navbar">
                <div class="container">
                    <!-- menu -->
                    <ul class="main-menu">
                        <li><a href="${pageContext.request.contextPath}/page/index.jsp">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=1">Skirt</a></li>
                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=2">Dress</a></li>
                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=3">Winter Dress
                                <span class="new">New</span>
                            </a></li>
                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=4">Blouse</a></li>
                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=5">Jacket</a></li>
                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=6">Sweater</a></li>
                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=1">Pages</a>
                            <ul class="sub-menu">
                                <li><a href="${pageContext.request.contextPath}/page/product.jsp">Product Page</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/category.jsp">Category Page</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/cart.jsp">Cart Page</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/checkout.jsp">Checkout Page</a></li>
                                <li><a href="${pageContext.request.contextPath}/page/contact.jsp">Contact Page</a></li>
                            </ul>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/page/contact.jsp">Contact</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- Header section end -->

