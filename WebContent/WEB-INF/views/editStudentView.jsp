<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style>
<%@include file="/WEB-INF/css/style.css"%>
<%@include file="/WEB-INF/css/bootstrap.min.css"%>
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
	<div class="wrapper">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 col-lg-push-3">
          
			<h1>Edit Student</h1>
			<c:if test="${not empty student}">
			 <form method="POST" action="${pageContext.request.contextPath}/editStudent">
          <h2>Student Id</h2>
            <div class="form-group">      
              <input type="text" name="id" value="${student.id}"  class="form-control input-lg">
            </div>
           <h2>Name</h2>
            <div class="form-group">
              <input type="text" name="name" value="${student.name}" placeholder="your name" class="form-control input-lg">
            </div>
            <h2>Mark</h2>
            <div class="form-group">
              <input type="text" name="avgMark" value="${student.avgMark}"  class="form-control input-lg">
            </div>
            <h2>Parent</h2>
            <div class="form-group">
              <input type="text" name="parent" value="${student.parent}"  class="form-control input-lg">
            </div>
            <input type="submit" value="Submit">
            <a href="${pageContext.request.contextPath}/studentList">Cancel</a>

          </form>
          </c:if>
          </div>
         </div>
        </div>
       </div>
<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>