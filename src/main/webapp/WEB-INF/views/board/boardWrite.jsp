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
		<h1>${board} Write Page</h1>
		
		<form action="../${board}/${board}Write" id="frm" method="POST" enctype="multipart/form-data">
		
			<div class="form-group">
			  <label for="title">Title:</label>
			  <input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
			  <label for="wrtier">Writer:</label>
			  <input type="text" class="form-control" value="${member.id}" readonly="readonly" name="writer">
			</div>
				
			<div class="form-group">
			  <label for="contents">Contents:</label>
			  <textarea class="form-control cont" id="contents" rows="5" name="contents"></textarea>
			</div>
			
			<input type="button" id="add" class="btn btn-info" value="AddFile">
			<div id="file">
				
			</div>
			
	
			
			<button type="button" id="wrBtn" class="btn btn-default">Submit</button>
		</form>
		<h1>${board} Write Page</h1>
	
	</div>
</div>



	<!-- <script type="text/javascript" src="../resources/js/boardForm.js"></script> -->
	<script type="text/javascript">
	
	$(document).ready(function() {
        $('#contents').summernote({
			height:400,	
			callbacks: {
			    onImageUpload: function(files) {
			    	$.ajax({
			    		type:"POST",
			    		url : "../boardFile/fileInsert"
			    		
			    	});
			    }
			  }
		  });
    });
	</script>
	


</body>
</html>