<%-- 
    Document   : contentIndex
    Created on : Mar 30, 2019, 5:18:39 PM
    Author     : asus
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ClothesDaoImpl"%>
<%@page import="model.Clothes"%>
<%
    ClothesDaoImpl clothesDaoImpl = new ClothesDaoImpl();
    int category_id = 1;
    if (request.getParameter("category") != null) {
        category_id = Integer.parseInt(request.getParameter("category"));
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Hero section -->
<section class="hero-section">
    <div class="hero-slider owl-carousel">
        <div class="hs-item set-bg" data-setbg="${pageContext.request.contextPath}/img/bg.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-6 col-lg-7 text-white">
                        <span>New Arrivals</span>
                        <h2>BRIGHT JACKET</h2>
                        <p>Cool - Comfortable - Reasonable - Fashionable!.</p>
                        <a href="${pageContext.request.contextPath}/page/product.jsp?ID=708" class="site-btn sb-line">DISCOVER</a>
                        <a href="${pageContext.request.contextPath}/GioHangServlet?command=insert&ID=708&cartID=<%=System.currentTimeMillis()%>" class="site-btn sb-white">ADD TO CART</a>
                    </div>
                </div>
                <div class="offer-card text-white">
                    <span>from</span>
                    <h2>$29</h2>
                    <p>SHOP NOW</p>
                </div>
            </div>
        </div>
        <div class="hs-item set-bg" data-setbg="${pageContext.request.contextPath}/img/bg-2.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-6 col-lg-7 text-white">
                        <span>New Arrivals</span>
                        <h2>SEXY WHITE BLOUSE</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum sus-pendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. </p>
                        <a href="${pageContext.request.contextPath}/page/product.jsp?ID=709" class="site-btn sb-line">DISCOVER</a>
                        <a href="${pageContext.request.contextPath}/GioHangServlet?command=insert&ID=709&cartID=<%=System.currentTimeMillis()%>" class="site-btn sb-white">ADD TO CART</a>
                    </div>
                </div>
                <div class="offer-card text-white">
                    <span>from</span>
                    <h2>$38</h2>
                    <p>SHOP NOW</p>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="slide-num-holder" id="snh-1"></div>
    </div>
</section>
<!-- Hero section end -->



<!-- Features section -->
<section class="features-section">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4 p-0 feature">
                <div class="feature-inner">
                    <div class="feature-icon">
                        <img src="${pageContext.request.contextPath}/img/icons/1.png" alt="#">
                    </div>
                    <h2>Fast Secure Payments</h2>
                </div>
            </div>
            <div class="col-md-4 p-0 feature">
                <div class="feature-inner">
                    <div class="feature-icon">
                        <img src="${pageContext.request.contextPath}/img/icons/2.png" alt="#">
                    </div>
                    <h2>Premium Products</h2>
                </div>
            </div>
            <div class="col-md-4 p-0 feature">
                <div class="feature-inner">
                    <div class="feature-icon">
                        <img src="${pageContext.request.contextPath}/img/icons/3.png" alt="#">
                    </div>
                    <h2>Free & fast Delivery</h2>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Features section end -->


<!-- letest product section -->
<section class="top-letest-product-section">
    <div class="container">
        <div class="section-title">
            <h2>LATEST PRODUCTS</h2>
        </div>
        <div class="product-slider owl-carousel">
            <%
                for (Clothes clothes : clothesDaoImpl.getAllClothesByCategory(2)) {
            %>                            
            <div class="product-item">
                <div class="pi-pic">
                    <img src="<%=clothes.getImage()%>" alt="<%=clothes.getName()%>">
                    <div class="pi-links">
                        <a href="${pageContext.request.contextPath}/GioHangServlet?command=insert&ID=<%=clothes.getClothId()%>&cartID=<%=System.currentTimeMillis()%>" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
                        <a href="${pageContext.request.contextPath}/page/product.jsp?ID=<%=clothes.getClothId()%>" class="wishlist-btn"><i class="flaticon-heart"></i></a>
                    </div>
                </div>
                <div class="pi-text">
                    <h6><%=clothes.getPrice()%> $</h6>
                    <p><%=clothes.getName()%></p>
                </div>
            </div>
            <%
                };
            %>                                                
        </div>
    </div>
</section>
<!-- letest product section end -->



<!-- Product filter section -->
<section class="product-filter-section">
    <div class="container">
        <div class="section-title">
            <h2>BROWSE TOP SELLING PRODUCTS</h2>
        </div>
        <ul class="product-filter-menu">
            <li><a href="${pageContext.request.contextPath}/page/index.jsp">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/page/category.jsp">Category</a></li>
            <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=1">Skirt</a></li>
            <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=2">Dress</a></li>
            <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=3">Winter Dress</a></li>
            <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=4">Blouse</a></li>
            <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=5">Jacket</a></li>
            <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=6">Sweater</a></li>
        </ul>
        <div class="row">
            <%
                ArrayList<Clothes> list = clothesDaoImpl.getAllClothesByCategory(3);
                for (int i = 8; i > 0; i--) {
                    Clothes clothes = list.get(i);
            %>
            <div class="col-lg-3 col-sm-6">                            
                <div class="product-item">
                    <div class="pi-pic">
                        <img src="<%=clothes.getImage()%>" alt="<%=clothes.getName()%>">
                        <div class="pi-links">
                            <a href="${pageContext.request.contextPath}/GioHangServlet?command=insert&ID=<%=clothes.getClothId()%>&cartID=<%=System.currentTimeMillis()%>" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
                            <a href="${pageContext.request.contextPath}/page/product.jsp?ID=<%=clothes.getClothId()%>" class="wishlist-btn"><i class="flaticon-heart"></i></a>
                        </div>
                    </div>
                    <div class="pi-text">
                        <h6><%=clothes.getPrice()%> $</h6>
                        <p><%=clothes.getClothId() %></p>
                    </div>
                </div>
            </div>
                <%
            };
        %> 
        </div>
              
    </div>
</section>
<!-- Product filter section end -->
