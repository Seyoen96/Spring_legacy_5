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
<c:import url="../template/header.jsp"></c:import>

<div class="container">
<div class="row">
<h1>${board} Select Page</h1>
	  <div class="panel panel-default">
	    <div class="panel-heading">TITLE</div>
	    <div class="panel-body">${dto.title}</div>
	  </div>
	  
	    <div class="panel panel-default">
	    <div class="panel-heading">Writer</div>
	    <div class="panel-body">${dto.writer}</div>
	  </div>
	  
	      <div class="panel panel-default">
	    <div class="panel-heading">Contents</div>
	    <div class="panel-body">${dto.contents}</div>
	  </div>
	  
	  <div class="panel panel-default">
	  <div class="panel-heading">Date</div>
	  <div class="panel-body">${dto.regDate}</div>
	</div>
	
		<div>
			<a href="./${board}Update?num=${dto.num}" class="btn btn-default">Update</a>
			<a href="./${board}Delete?num=${dto.num}" class="btn btn-danger">Delete</a>
			<c:if test="${board ne 'notice'}">
				<a href="./${board}Reply?num=${dto.num}" class="btn btn-info">Reply</a>
			</c:if>
			
		</div>
		<h1>${board} Select Page</h1>
</div>
</div>


</body>
</html>