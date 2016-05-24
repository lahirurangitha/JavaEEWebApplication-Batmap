<%--
  Created by IntelliJ IDEA.
  User: lahiru
  Date: 5/17/2016
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="headerScripts.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container-fluid backgroundImg">
    <br>
    <%

    String emptyFields = request.getParameter("emptyFields");
    String invalidCred = request.getParameter("invalidCred");
    %>
    <div class="jumbotron col-xs-4 col-xs-offset-4">
        <div class="col-xs-offset-4">
            <img id="img" src="img/logo.png" height="100px" >
        </div>
        <%if(emptyFields!=null){%>
        <h5 class="text-red">*<%=emptyFields%></h5>
        <%}
            if (invalidCred!=null){%>
        <h5 class="text-red">*<%=invalidCred%></h5>
        <%}%>
        <h4>Sign in</h4>
        <form class="form-horizontal" method="post" action="/login">
            <input class="form-control gap" type="text" name="username" value="" placeholder="Username">
            <input class="form-control gap" type="password" name="password" value="" placeholder="Password">
            <input class="form-control btn btn-primary gap" type="submit" name="loginSubmission" value="Sign in">
        </form>
        <button class="form-control btn btn-success gap" onclick='window.location="register.jsp"'>You don't have an account? please sign up</button>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
