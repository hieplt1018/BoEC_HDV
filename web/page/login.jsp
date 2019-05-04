<%-- 
    Document   : login
    Created on : Mar 30, 2019, 5:41:57 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Object error = request.getAttribute("errorMessage");
    Object thongBao = session.getAttribute("thongBao");
    Cookie[] cookies = request.getCookies();
    String username = "", password = "", rememberVal = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cookuser")) {
                System.out.println("cookuser: " + cookie.getValue());
                username = cookie.getValue();
            }
            if (cookie.getName().equals("cookpass")) {
                password = cookie.getValue();
            }
            if (cookie.getName().equals("cookrem")) {
                rememberVal = cookie.getValue();
            }
        }
    }
%>
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


        <!--[if lt IE 9]>
                  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body class="bg-dark">
        <div class="section" style="margin: 10% 0">
            <div class="container ">
                <div class="row">
                    <div class="card mx-auto">
                        <div class="card-header text-center">
                            Login
                        </div>
                        <div class="card-body">
                            <form  action="${pageContext.request.contextPath}/LoginServlet"  method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1" class="text-center">Username</label>
                                    <input name="username" type="text" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Email" value="<%=username%>" required autofocus>
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your account with anyone else.</small>
                                </div>
                                <div class="form-group" class="text-center">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" value="<%=password%>" required>
                                </div>
                                <div class="form-check" style="margin-bottom: 10px">
                                    <input name="remember" type="checkbox" class="form-check-input" id="exampleCheck1" value="1" <%= "1".equals(rememberVal.trim()) ? "checked='checked'" : ""%> />
                                    <label class="form-check-label" for="exampleCheck1">Remember me</label>
                                </div>
                                <%
                                if (error != null) {%>
                                <div style ="color:tomato; margin-bottom: 5px;">
                                    <%=error%>
                                </div>
                                <%} else if (thongBao != null) {
                                %>
                                <div style ="color:tomato; margin-bottom: 5px; margin: auto">
                                    <%=thongBao%>
                                </div>    
                                <% } %>
                                <button type="submit" class="btn btn-primary btn-block text-uppercase">Login</button>

                                <hr class="my-4">
                            </form>
                            <a class="btn btn-primary btn-block text-uppercase" href="${pageContext.request.contextPath}/page/register.jsp" >   Create a new account</a>
                            <a class="btn btn-primary btn-block text-uppercase" href="${pageContext.request.contextPath}/page/index.jsp" >cancel</a>
                            <a class="btn btn-google btn-block text-uppercase" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/BoEC/LoginGoogleServlet&response_type=code
                               &client_id=195354969374-h9grrl5m89i87m8n76ep33vh6pe70d4r.apps.googleusercontent.com&approval_prompt=force" style="color: white; background-color: #ea4335;">Login With Google +</a>
                        </div>
                        <div class="card-footer text-muted">
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!--====== Javascripts & Jquery ======-->
        <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.slicknav.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.nicescroll.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.zoom.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>

    </body>
</html>



