<%--
  Created by IntelliJ IDEA.
  User: lahiru
  Date: 5/17/2016
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register</title>
  <%@include file="headerScripts.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container-fluid backgroundImg">
  <br>
  <div class="jumbotron col-xs-4 col-xs-offset-4">
    <h4>Register Form</h4>
    <form class="form-horizontal" method="post" action="/register">
      <input class="form-control gap" type="text" name="username" value="" placeholder="Username">
      <input class="form-control gap" type="password" name="password" value="" placeholder="Password">
      <input class="form-control gap" type="password" name="re-password" value="" placeholder="Re-Password">
      <input class="form-control btn btn-primary gap" type="submit" name="registerSubmission" value="Register">
    </form>
  </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
