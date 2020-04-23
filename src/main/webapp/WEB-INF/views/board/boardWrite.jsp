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
		<h1>${board} Write Page</h1>
		
		<form action="../${board}/${board}Write" method="POST" enctype="multipart/form-data">
		
			<div class="form-group">
			  <label for="title">Title:</label>
			  <input type="text" class="form-control" name="title">
			</div>
			<div class="form-group">
			  <label for="wrtier">Writer:</label>
			  <input type="text" class="form-control" name="writer">
			</div>
				
			<div class="form-group">
			  <label for="contents">Contents:</label>
			  <textarea class="form-control" rows="5" name="contents"></textarea>
			</div>
			<div class="form-group">
			  <label for="files">File:</label>
			  <input type="file" class="form-control" name="files">
			  <input type="file" class="form-control" name="files">
			</div>
			
			
			
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
		<h1>${board} Write Page</h1>
	
	</div>
</div>


</body>
</html>