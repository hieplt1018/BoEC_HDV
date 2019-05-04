<%-- 
    Document   : contentRegister
    Created on : Apr 14, 2019, 4:42:27 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Object error = request.getAttribute("errorRegister");
%>
<div class="row justify-content-center">
    <div class="col-sm-6 mt-5 mb-5">
        <div class="card mx-auto ">
            <div class="card-header text-center">
                Register
            </div>
            <div class="card-body">
                <form  action="${pageContext.request.contextPath}/RegisterServlet"  method="post">
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="firstName">FirstName</label>
                            <input name="firstName" type="text" class="form-control " id="firstName" placeholder="" required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="midName">MidName</label>
                            <input name="midName" type="text" class="form-control " id="midName" placeholder="" >
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="lastName">LastName</label>
                            <input name="lastName" type="text" class="form-control " id="lastName" placeholder="" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="text-center">Email</label>
                        <input name="email" type="text" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Input your email, please!" value="" required autofocus>
                        <small id="emailHelp" class="form-text text-muted">We'll never share your account with anyone else.</small>
                    </div>
                    <div class="form-group" class="text-center">
                        <label for="password">Password</label>
                        <input name="password" type="password" class="form-control" id="password" placeholder="Password" value="" required>
                    </div>
                    <div class="form-group">
                        <label for="address">Address</label>
                        <input name="address" type="text" class="form-control " id="address" required>
                        <small class="form-text text-muted">Please input your full address to deliver correctly!</small>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="telephone">Telephone Number</label>
                            <input name="telephone" type="text" class="form-control " id="telephone" required>
                        </div>
                    </div>
                    <hr class="my-4">
                    <%
                        if (error != null) {%>
                    <div style ="color:tomato; margin-bottom: 5px;">
                        <%=error%>
                    </div>
                    <%}
                    %>
                    
                    <button type="submit" class="btn btn-primary text-uppercase col-md-4 offset-md-4">Register</button>
                    <br>
                    </br>
                    <a class="btn btn-primary text-uppercase col-md-4 offset-md-4" href="${pageContext.request.contextPath}/page/index.jsp" >cancel</a>
                    <hr class="my-4">
                </form>
            </div>
            <div class="card-footer text-muted">
            </div>
        </div>
    </div>
</div>
