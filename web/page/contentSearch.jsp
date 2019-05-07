
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.Clothes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Clothes> list = (List) session.getAttribute("nameSearch");
    session.setAttribute("nameSearch", "");
    System.out.print(list);
    NumberFormat nf = NumberFormat.getInstance();
%>
<!-- Page info -->
<div class="page-top-info">
    <div class="container">
        <h4>Search Result</h4>
        <div class="site-pagination">
            <a href="#">Home</a> /
            <a href="#">Search Result</a>
        </div>
    </div>
</div>
<!-- Page info end -->


<!-- cart section end -->
<section class="cart-section spad">
    <div class="container">
        <div class="row">
            <%
                for (Clothes clothes : list) {
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
                        <p><%=clothes.getName()%></p>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</section>
<!-- cart section end -->

