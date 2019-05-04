<%-- 
    Document   : contentCategory
    Created on : Mar 30, 2019, 5:30:28 PM
    Author     : asus
--%>

<%@page import="model.Clothes"%>
<%@page import="dao.ClothesDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ClothesDaoImpl clothesDaoImpl = new ClothesDaoImpl();
    int category_id = 1;
    if(request.getParameter("category")!=null){
        category_id = Integer.parseInt(request.getParameter("category"));
    }
    %>
<!-- Page info -->
	<div class="page-top-info">
		<div class="container">
			<h4>Category Page</h4>
			<div class="site-pagination">
				<a href="${pageContext.request.contextPath}/page/index.jsp">Home</a> /
				<a href="">Category</a> /
			</div>
		</div>
	</div>
	<!-- Page info end -->


	<!-- Category section -->
	<section class="category-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 order-2 order-lg-1">
					<div class="filter-widget">
						<h2 class="fw-title">Categories</h2>
                                                <ul class="category-menu">
                                                    <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=1">Skirt <span>(<%=clothesDaoImpl.getNumberClothesByCategory(1) %>)</span></a></li>
                                                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=2">Dress<span>(<%=clothesDaoImpl.getNumberClothesByCategory(2) %>)</span></a></li>
                                                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=3">Winter Dress<span>(<%=clothesDaoImpl.getNumberClothesByCategory(3) %>)</span></a></li>
                                                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=4">Blouse <span>(<%=clothesDaoImpl.getNumberClothesByCategory(4) %>)</span></a></li>
                                                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=5">Jacket<span>(<%=clothesDaoImpl.getNumberClothesByCategory(5) %>)</span></a></li>
                                                        <li><a href="${pageContext.request.contextPath}/page/category.jsp?category=6">Sweater<span>(<%=clothesDaoImpl.getNumberClothesByCategory(6) %>)</span></a></li>
                                                </ul>
					</div>
				</div>
     
				<div class="col-lg-9  order-1 order-lg-2 mb-5 mb-lg-0">
					<div class="row">
                                        <%
                                            for (Clothes clothes : clothesDaoImpl.getAllClothesByCategory(category_id)) {
                                        %>
						<div class="col-lg-4 col-sm-6">
							<div class="product-item">
								<div class="pi-pic">
                                                                    <img src="<%=clothes.getImage() %>" alt="<%=clothes.getName() %>">
									<div class="pi-links">
										<a href="${pageContext.request.contextPath}/GioHangServlet?command=insert&ID=<%=clothes.getClothId()%>&cartID=<%=System.currentTimeMillis()%>" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
										<a href="${pageContext.request.contextPath}/page/product.jsp?ID=<%=clothes.getClothId()%>" class="wishlist-btn"><i class="flaticon-heart"></i></a>
									</div>
								</div>
								<div class="pi-text">
									<h6><%=clothes.getPrice() %> $</h6>
									<p><%=clothes.getName() %></p>
								</div>
							</div>
						</div>
                                        <%
                                            };
                                        %>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Category section end -->
