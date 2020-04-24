<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/summer.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>


	<div class="container">
		<div class="row">
		<h1>${board} Update Page</h1>
		
		<form action="../${board}/${board}Update?num=${dto.num}" method="POST">
		
		<div class="form-group">
		  <label for="title">Title:</label>
		  <input type="text" class="form-control" name="title" value="${dto.title}">
		</div>
		<div class="form-group">
		  <label for="wrtier">Writer:</label>
		  <input type="text" class="form-control" name="writer" value="${dto.writer}" readonly="readonly">
		</div>
		<input type="hidden" class="form-control" name="num" value="${dto.num}">	
			
		<div class="form-group">
		  <label for="contents">Contents:</label>
		  <textarea class="form-control" rows="5" id="contents" name="contents">${dto.contents}</textarea>
		</div>
		
		<button type="submit" class="btn btn-default">Update</button>
		</form>
		
	
	</div>
</div>

	<script type="text/javascript">
	$(document).ready(function() {
        $('#contents').summernote({
			height:400	  
		  });
    });
	</script>

</body>
</html>