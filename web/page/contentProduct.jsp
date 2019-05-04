<%-- 
    Document   : contentProduct
    Created on : Mar 30, 2019, 5:35:28 PM
    Author     : asus
--%>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="model.Clothes"%>
<%@page import="dao.ClothesDaoImpl"%>

<%
    ClothesDaoImpl clothesDao = new ClothesDaoImpl();
    Clothes clothes = clothesDao.getClothesDetails(Integer.parseInt(request.getParameter("ID")));
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMinimumIntegerDigits(0);

    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
        cart = new Cart();
        session.setAttribute("cart", cart);
    }
    String ten_danh_muc = "";
    int ma_danh_muc = clothes.getCategoryId();
    if (ma_danh_muc == 1) {
        ten_danh_muc = "Skirt";
    } else if (ma_danh_muc == 2) {
        ten_danh_muc = "Dress";
    } else if (ma_danh_muc == 3) {
        ten_danh_muc = "Winter Dress";
    } else if (ma_danh_muc == 4) {
        ten_danh_muc = "Blouse";
    } else if (ma_danh_muc == 5) {
        ten_danh_muc = "Jacket";
    } else {
        ten_danh_muc = "Sweater";
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Page info -->

<div class="page-top-info">
    <div class="container">
        <h4>Product Details</h4>
        <div class="site-pagination">
            <a href="${pageContext.request.contextPath}/page/index.jsp">Home</a> /
            <a href="${pageContext.request.contextPath}/page/category.jsp?">Category</a> /
            <a href="">Product Details</a> /
            <a><%=clothes.getName()%></a>
        </div>
    </div>
</div>
<!-- Page info end -->


<!-- product section -->
<section class="product-section">
    <div class="container">
        <div class="back-link">
            <a href="${pageContext.request.contextPath}/page/category.jsp?category=<%=clothes.getCategoryId()%>"> &lt;&lt; BACK TO CATEGORY</a>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <img class="product-big-img" src="<%=clothes.getImage()%>" alt="">
            </div>
            <div class="col-lg-6 product-details">
                <h2 class="p-title"><%=clothes.getName()%></h2>
                <h3 class="p-price"><%=clothes.getPrice()%> $ ( <%=nf.format(clothes.getPrice() * 24000)%> VNĐ ) </h3> 
                <h4 class="p-stock">Available: <span>In Stock</span></h4>
                <div class="p-rating">
                    <i class="fa fa-star-o"></i>
                    <i class="fa fa-star-o"></i>
                    <i class="fa fa-star-o"></i>
                    <i class="fa fa-star-o"></i>
                    <i class="fa fa-star-o fa-fade"></i>
                </div>
                <div class="p-review">
                    <a href="">3 reviews</a>|<a href="">Add your review</a>
                </div>
                <div class="fw-size-choose">
                    <a>Size</a> |
                    <a><%=clothes.getSize()%></a>
                </div>
                <div class="quantity">
                    <p>Quantity</p>
                    <div class="pro-qty">
                        <a class="dec qtybtn">-</a>
                        <input type="text" value="1">
                        <a class="inc qtybtn">+</a>
                    </div>
                </div>

                <a href="${pageContext.request.contextPath}/GioHangServlet?command=insert&ID=<%=clothes.getClothId()%>&cartID=<%=System.currentTimeMillis()%>" class="site-btn">ADD TO CART</a>
                <div id="accordion" class="accordion-area">
                    <div class="panel">
                        <div class="panel-header" id="headingOne">
                            <button class="panel-link active" data-toggle="collapse" data-target="#collapse1" aria-expanded="true" aria-controls="collapse1">information</button>
                        </div>
                        <div id="collapse1" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                            <div class="panel-body">
                                <p>Mã sản phẩm: <%=clothes.getClothId()%></p>
                                <p>Mã danh mục: <%=ten_danh_muc%></p>

                                <p>Tên sản phẩm: <%=clothes.getName()%></p>
                                <p>Size: <%=clothes.getSize()%></p>
                                <!--<p>Giá sản phẩm: <%=clothes.getPrice()%></p>-->
                                <p>Xuất xứ: <%=clothes.getCountry()%></p>


                            </div>
                        </div>
                    </div>
                    <div class="panel">
                        <div class="panel-header" id="headingTwo">
                            <button class="panel-link" data-toggle="collapse" data-target="#collapse2" aria-expanded="false" aria-controls="collapse2">PAYMENT </button>
                        </div>
                        <div id="collapse2" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                            <div class="panel-body">
                                <img src="${pageContext.request.contextPath}/img/cards.png" alt="">
                                <p></p>
                            </div>
                        </div>
                    </div>
                    <div class="panel">
                        <div class="panel-header" id="headingThree">
                            <button class="panel-link" data-toggle="collapse" data-target="#collapse3" aria-expanded="false" aria-controls="collapse3">shipping & Returns</button>
                        </div>
                        <div id="collapse3" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                            <div class="panel-body">
                                <h4>7 Days Returns</h4>
                                <p>Cash on Delivery Available<br>Home Delivery <span>3 - 4 days</span></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="social-sharing">
                    <a href=""><i class="fa fa-google-plus"></i></a>
                    <a href=""><i class="fa fa-pinterest"></i></a>
                    <a href=""><i class="fa fa-facebook"></i></a>
                    <a href=""><i class="fa fa-twitter"></i></a>
                    <a href=""><i class="fa fa-youtube"></i></a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- product section end -->


<!-- RELATED PRODUCTS section -->
<section class="related-product-section">
    <div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/comments#configurator" data-width="100px" data-numposts="8"></div>
    <div class="container">
        <div class="section-title">
            <h2>RELATED PRODUCTS</h2>
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
        <div class="product-slider owl-carousel">
            <%
                for (Clothes clothes1 : clothesDao.getAllClothesByCategory(5)) {
            %>                            
            <div class="product-item">
                <div class="pi-pic">
                    <img src="<%=clothes1.getImage()%>" alt="<%=clothes1.getName()%>">
                    <div class="pi-links">
                        <a href="${pageContext.request.contextPath}/GioHangServlet?command=insert&ID=<%=clothes1.getClothId()%>&cartID=<%=System.currentTimeMillis()%>" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
                        <a href="${pageContext.request.contextPath}/page/product.jsp?ID=<%=clothes1.getClothId()%>" class="wishlist-btn"><i class="flaticon-heart"></i></a>
                    </div>
                </div>
                <div class="pi-text">
                    <h6><%=clothes1.getPrice()%> $</h6>
                    <p><%=clothes1.getName()%></p>
                </div>
            </div>
            <%
                };
            %>                                                
        </div>
    </div>


</div>
</section>
<!-- RELATED PRODUCTS section end -->
