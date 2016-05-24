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
<%
    String emptyFields = request.getParameter("emptyFields");
    String passNoMatch = request.getParameter("passNoMatch");
    String usrExists = request.getParameter("usrExists");
    String regSuccess = request.getParameter("regSuccess");
    String regFailed = request.getParameter("regFailed");

%>
<div class="container-fluid backgroundImg">
  <br>
  <div class="jumbotron col-xs-4 col-xs-offset-4">
    <div class="col-xs-offset-4">
      <img id="img" src="img/logo.png" height="100px" >
    </div>
    <%if(emptyFields!=null){%>
    <h5 class="text-red"><%=emptyFields%></h5>
    <%}
      if (passNoMatch!=null){%>
    <h5 class="text-red"><%=passNoMatch%></h5>
    <%}
        if (usrExists!=null){%>
      <h5 class="text-red"><%=usrExists%></h5>
          <%}
          if (regSuccess!=null){%>
      <h5 class="text-blue"><%=regSuccess%></h5>
          <%}
              if (regFailed!=null){%>
      <h5 class="text-red"><%=regFailed%></h5>
      <%}%>

    <h4>Sign up</h4>
    <form class="form-horizontal" method="post" action="/register">
      <input class="form-control gap" type="text" name="username" value="" placeholder="Username">
      <input class="form-control gap" type="password" name="password" value="" placeholder="Password">
      <input class="form-control gap" type="password" name="rePassword" value="" placeholder="Re-Password">
      <input class="form-control btn btn-primary gap" type="submit" name="registerSubmission" value="Sign up">
    </form>
      <button class="form-control btn btn-success gap" onclick='window.location="login.jsp"'>You have an account? please sign in</button>
  </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
