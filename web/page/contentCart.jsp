<%-- 
    Document   : contentCart
    Created on : Mar 30, 2019, 5:24:11 PM
    Author     : asus
--%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ClothesDaoImpl"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page import="model.Clothes"%>
<%@page import="model.Cart"%>
<%
    ClothesDaoImpl clothesDao = new ClothesDaoImpl();
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMinimumIntegerDigits(0);
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
        cart = new Cart();
        session.setAttribute("cart", cart);
    }
    String username = "no";
    if (session.getAttribute("user") != null) {
        username = String.valueOf(session.getAttribute("user"));
    }
    HashMap<Long, Clothes> list = cart.getList();
    HashMap<Long, Integer> quantity = cart.getQuantity();
    int so_luong = 0;
    float total = 0;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Page info -->
<div class="page-top-info">
    <div class="container">
        <h4>Your cart</h4>
        <div class="site-pagination">
            <a href="#">Home</a> /
            <a href="#">Your cart</a>
        </div>
    </div>
</div>
<!-- Page info end -->


<!-- cart section end -->
<section class="cart-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="cart-table">
                    <h3>Your Cart</h3>
                    <div class="cart-table-warp">
                        <table>
                            <thead>
                                <tr>
                                    <th class="product-th">Product</th>
                                    <th class="quy-th">Quantity</th>
                                    <th class="size-th">Size</th>
                                    <th class="total-th">Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Map.Entry<Long, Clothes> ds : list.entrySet()) {
                                        Long key = ds.getKey();
                                %>
                                <tr>
                                    <td class="product-col">
                                        <img src="<%=ds.getValue().getImage()%>" alt="">
                                        <div class="pc-title">
                                            <h4><a href="${pageContext.request.contextPath}/page/product.jsp?ID=<%=ds.getValue().getClothId() %>"><%=ds.getValue().getName()%></h4>
                                            <p>$ <%=ds.getValue().getPrice()%></p>
                                            <p><%=nf.format(ds.getValue().getPrice() * 24000)%> VNĐ</p>
                                        </div>
                                    </td>
                                    <td class="quy-col">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                <% long cartID = System.currentTimeMillis() ; 
                                                    session.setAttribute("cartid", cartID);
                                                %>
                                                <a class="dec qtybtn" href="${pageContext.request.contextPath}/GioHangServlet?command=sub&ID=<%=ds.getValue().getClothId()%>&cartID=<%=cartID %>">-</a>
                                                <input type="text" value="<%=quantity.get(key) %>">
                                                <a class="inc qtybtn" href="${pageContext.request.contextPath}/GioHangServlet?command=insert&ID=<%=ds.getValue().getClothId()%>&cartID=<%=cartID %>">+</a>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="size-col"><h4><%=ds.getValue().getSize()%></h4></td>
                                    <td class="total-col"><h4><%=nf.format(quantity.get(key) * ds.getValue().getPrice() * 24000)%> </h4></td>
                                    <td class="cart_delete">
                                        <a class="cart_quantity_delete" href="${pageContext.request.contextPath}/GioHangServlet?command=remove&ID=<%=ds.getValue().getClothId()%>&cartID=<%=cartID %>"><i class="fa fa-times"></i></a>
                                    </td>
                                </tr>
                                <%
                                        so_luong += quantity.get(key);
                                        total += quantity.get(key) * ds.getValue().getPrice();
                                        session.setAttribute("total", total);
                                    }
                                %>

                            </tbody>
                        </table>
                    </div>

                    <div class="total-cost">
                        <h6>Total <span>Quantity: <%=so_luong%></span><span>Price($): <%=total%></span><span>Price(VNĐ): <%=nf.format(total * 24000)%></span></h6>

                    </div>
                </div>
            </div>
            <div class="col-lg-4 card-right">
                <form class="promo-code-form">
                    <input type="text" placeholder="Enter promo code">
                    <button>Submit</button>
                </form>
                <% 
                if(username.equalsIgnoreCase("no")) {
                    String thongBao = "You must login to checkout!!!";
                    session.setAttribute("thongBao", thongBao);
                %>
                    <a href="${pageContext.request.contextPath}/page/login.jsp" class="site-btn">Proceed to checkout</a>
                    <a href="${pageContext.request.contextPath}/page/category.jsp?" class="site-btn sb-dark">Continue shopping</a>
                <% } else { %>
                    <a href="${pageContext.request.contextPath}/page/checkout.jsp" class="site-btn">Proceed to checkout</a>
                    <a href="${pageContext.request.contextPath}/page/category.jsp?" class="site-btn sb-dark">Continue shopping</a>
                <% } %>
            </div>
        </div>
    </div>
</section>
<!-- cart section end -->

<!-- Related product section -->
<section class="related-product-section">
    <div class="container">
        <div class="section-title text-uppercase">
            <h2>Continue Shopping</h2>
        </div>
        <!--<div class="row">-->
        <div class="row">
            <%
                ArrayList<Clothes> list1 = clothesDao.getAllClothesByCategory(5);
                for (int i = 8; i > 0; i--) {
                    Clothes clothes1 = list1.get(i);
            %>
            <div class="col-lg-3 col-sm-6">                            
                <div class="product-item">
                    <div class="pi-pic">
                        <img src="<%=clothes1.getImage()%>" alt="<%=clothes1.getName()%>">
                        <div class="pi-links">
                            <a href="${pageContext.request.contextPath}/GioHangServlet?command=insert&ID=<%=clothes1.getClothId()%>&cartID=<%=System.currentTimeMillis()%>" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
                            <a href="${pageContext.request.contextPath}/page/product.jsp?ID=<%=clothes1.getClothId() %>" class="flaticon-heart"></i></a>

                        </div>
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

        <!--</div>-->
    </div>
</section>
<!-- Related product section end -->

