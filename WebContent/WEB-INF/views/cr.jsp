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
<title>Students</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
	<div class="wrapper">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 col-lg-push-3">
          <h2>Students List</h2>
          <table class="table table-striped">
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Name</th>
                  <th class="text-center">Avg Mark</th>
                  <th class="text-center">Parent</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${studentList}" var="student">
                <tr>
                  <td>
                   ${student.id}
                  </td>
                  <td>${student.name}</td>
                  <td>${student.avgMark}</td>
                  <td>${student.parent}</td>
                  <td class="text-center vert-align">
                  	<a href="editStudent?name=${student.name}">Edit</a>
                  </td>
                  <td class="text-center vert-align">
                  <a href="deleteStudent?name=${student.name}">Delete</a>
                  </td>
                </tr>
			</c:forEach>
              </tbody>
	
            </table>
            <a href="createStudent">Add Student</a>
            </div>
           </div>
          </div>
         </div>
 <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>