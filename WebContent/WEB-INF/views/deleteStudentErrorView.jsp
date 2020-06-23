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
<title>Delete Error</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="wrapper">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 col-lg-push-3">
          <h3>Delete Student</h3>
          <p>${errorString}</p>
          <a href="studentList">Students</a>
          </div>
         </div>
        </div>
       </div>
         
</body>
</html>