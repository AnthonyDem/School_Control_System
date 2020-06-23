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
<title>Register</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="wrapper">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 col-lg-push-3">
          <h3>Register your profile</h3>
         

          <form method="POST" action="${pageContext.request.contextPath}/register">
          <h2>User Name</h2>
            <div class="form-group">      
              <input type="text" name="userName" value="${user.userName}" placeholder="your name" class="form-control input-lg">
            </div>
           <h2>Password</h2>
            <div class="form-group">
              <input type="text" name="password" value="${user.password}" placeholder="your password" class="form-control input-lg">
            </div>
            <h2>Work Experience</h2>
            <div class="form-group">
              <input type="text" name="workExp" value="${user.workExp}" placeholder="your experience" class="form-control input-lg">
            </div>
            <input type="submit" value="Register">
            <a href="${pageContext.request.contextPath}/">Cancel</a>

          </form>
          </div>
         </div>
        </div>
       </div>
      <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>