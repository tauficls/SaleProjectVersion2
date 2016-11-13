<%-- 
    Document   : header
    Created on : Nov 11, 2016, 8:18:39 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="style/header.css" rel="stylesheet" type="text/css"/>
<div class="heading">
	<center><img src="img/logo.png" width= ="60" height="60"></center>
	<p id="user"> Hi, 
            <% 
                if(session.getAttribute("username") != null) {
                    out.println(session.getAttribute("username").toString());
                } 
        %>! </p>
        <form action= "/saleProject/logout" method="POST" id="logout" name="logout" onsubmit="return validateForm()">
            <p id="logout"> 
                <button class="btnLogout" type="submit" value="send">logout</button>
            </p>
        </form>
	<div id="nav">
		<a href="viewKatalog.jsp" >
				<div <?php if ($page=="ViewKatalog") echo 'id ="currentPage"';?>><p class = "center">Catalog</p></div>
		</a>
		<a href="yourproduct.jsp" >
				<div <?php if ($page=="YourProduct") echo 'id ="currentPage"';?>><p class = "center">Your Products</p></div>
		</a>
		<a href="AddProduct.jsp">
				<div <?php if ($page=="AddProduct") echo 'id ="currentPage"';?>><p class = "center">Add Products</p></div>
		</a>
		<a href="sales.jsp" >
				<div <?php if ($page=="Sales") echo 'id ="currentPage"';?>><p class = "center">Sales</p></div>
		</a>
		<a href="purchase.jsp" >
			<div <?php if ($page=="Purchase") echo 'id ="currentPage"';?> ><p class = "center">Purchases</p></div>
		</a>
	</div>
	<div style="clear:both"></div> 

</div>
