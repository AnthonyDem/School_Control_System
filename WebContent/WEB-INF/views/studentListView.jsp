<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
<%@include file="/WEB-INF/css/style.css"%>
<%@include file="/WEB-INF/css/bootstrap.min.css"%>
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Account</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="wrapper">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 col-lg-push-3">
          <div class="margin-8"></div>
             	<h1>Teacher account information</h1>
             	<hr>
                <h2>Hey: ${user.userName}</h2>
                <hr>
                <h3>User Name: ${user.userName}</h3>
                <hr>
                <h3>Your Work experience is ${user.workExp} years</h3>
         </div>
        </div>
       </div>
      </div>
     <jsp:include page="_footer.jsp"></jsp:include>
               

</body>
</html>