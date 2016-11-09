<%-- 
    Document   : index
    Created on : Nov 3, 2016, 11:36:07 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="width=device-width,initial-scale=1.0" name="viewport">
        <title>Login Page</title>
        <link href="style/style.css" rel="stylesheet" type="text/css"/>
        <script type = "text/javascript" src="index.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
       <% 
          if (request.getAttribute("servletName") != null)  {
            out.print(request.getAttribute("servletName").toString());
          }
        %>
       <div class="heading">
           <img src="img/logo.png" width= ="60" height="60">
       </div>
       <form action= "/saleProject/login" method="POST" id="login" name="login" onsubmit="return validateForm()">
            <div class="content">
            <div class="bold">Please Login</div>
            <hr></hr>
            <input type="hidden" name="task" value="login">
            <label for="username">Email or Username</label>
            <div class="input-list style-1 clearfix"><input type="text" name="username" id="username" placeholder="Type your username" onblur="return validateUsername()"></div>
            <div id = "alertUsername" class="red"></div>
            <%-- do username validation here --%>
            <div class="space"></div>
            <label for="username">Password</label>
            <div class="input-list style-1 clearfix"><input type="password" name="password" id="password" placeholder="Type your password" onblur="return validatePassword()"></div>
            <div id = "alertPassword" class="red"></div>
            <%-- do password validation here --%>
            <button class="btnSubmit" type="submit" value="send">LOGIN</button>
            </div>
       </form>
            
       <br>
       <div class="register">Don't have account yet? Register <a href="register.jsp">here</a></div>
    </body>
</html>
