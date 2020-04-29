<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		<h1>${fn:toUpperCase(board)} ${board} Update Page</h1>
		
		<form action="../${board}/${board}Update?num=${dto.num}" method="POST" enctype="multipart/form-data">
		
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
		
		<input type="button" id="add" class="btn btn-info" value="AddFile">
			<div id="file">
				
			</div>
		
		<div class="form-group">
			<label for="files">Files:</label>
			<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
				<p class="">${fileDTO.oriName}<i class="glyphicon glyphicon-remove remove fileDelete" id="${fileDTO.fileNum}" title="${fileDTO.board}"></i></p>			
			</c:forEach>
		</div>
		
		
		<button type="submit" class="btn btn-default">Update</button>
		</form>
		
		
	</div>
</div>
	
	
	
	<script type="text/javascript" src="../resources/js/boardForm.js"></script>	
	<script type="text/javascript">
	$(document).ready(function() {
        $('#contents').summernote({
			height:400	  
		  });
    });
	
	
	//리스트 항목 갯수 받아오기 3가지 방법
	var size=${size};
	size = ${dto.boardFileDTOs.size()};
	size = ${fn:length(dto.boardFileDTOs)};
	
	
	//alert("file :"+size);
	
	cnt = cnt+size;
	$(".fileDelete").click(function(){	
		var check=confirm("삭제 확인");
		if(check){
			var s = $(this);		
			$.post("../boardFile/fileDelete",{fileNum:$(this).attr("id"), board:$(this).attr("title")},function(result){			
				if(result>0){
					s.parent().remove();	
					cnt--;
				} else{
					alert("delete fail");
				}
			});		
		}
	});
	
	</script>

</body>
</html>