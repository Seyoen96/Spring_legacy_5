<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>

<body>
<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">WebSiteName</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
	      
	      <li><a href="${pageContext.request.contextPath}/notice/noticeList">Notice</a></li>
	      <li><a href="${pageContext.request.contextPath}/notice/noticeList?id=${member.id}">QnA</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	    	<c:if test="${empty sessionScope.member}">
		      <li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		      <li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	     	</c:if>	
	     	
	      	<c:if test="${not empty member}">
		      <li><a href="${pageContext.request.contextPath}/member/memberPage"><span class="glyphicon glyphicon-user"></span> MyPage</a></li>
		      <li><a href="${pageContext.request.contextPath}/member/memberLogout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
	    	</c:if>
	    </ul>
	  </div>
	</nav>
	
<div class="container">
	<div class="row">
	<h1>${board} List Page</h1>
		<table class="table table-hover">
		<thead>
			<tr>
				<td>Num</td>
				<td>Title</td>
				<td>Writer</td>
				<td>Date</td>
				<td>Hit</td>
			</tr>
		</thead>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td><a href="./${board}Select?num=${dto.num}">${dto.title}</td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>			
		</table>
		
		<div>
			<a href="./${board}Write" class="btn btn-danger">Write</a>
		</div>
		
	
	</div>
</div>



</body>
</html>