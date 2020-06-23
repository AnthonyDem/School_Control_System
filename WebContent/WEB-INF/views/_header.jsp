<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
<%@include file="/WEB-INF/css/style.css"%>
<%@include file="/WEB-INF/css/bootstrap.min.css"%>
</style>
<div class="container-fluid">
      <div class="row">
        <nav role="navigation" class="navbar navbar-inverse">
          <div class="container">
            <div class="navbar-header header">
              <div class="container">
                <div class="row">
                  <div class="col-lg-12">
                  
                    <h1>School Marks Control</h1>
                    <p>You can tracking how study your child</p>
                  </div>
                </div>
              </div>
               <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                 <span class="sr-only">Toggle navigation</span>
                 <span class="icon-bar"></span>
                 <span class="icon-bar"></span>
                 <span class="icon-bar"></span>
               </button>
            </div>
            <div id="navbarCollapse" class="collapse navbar-collapse navbar-right">
              <ul class="nav nav-pills">
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
             	<li><a href="${pageContext.request.contextPath}/studentList">Students</a></li>  
                <li><a href="${pageContext.request.contextPath}/teacherinfo">Teacher Account</a></li>     
                <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                <li><a href="${pageContext.request.contextPath}/register">Sign Up</a></li>
              </ul>
            </div>
          </div>
          
        </nav>
      </div>
 </div>
