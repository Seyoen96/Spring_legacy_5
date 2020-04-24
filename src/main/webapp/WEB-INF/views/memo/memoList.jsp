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
<c:import url="../template/header_sub.jsp"></c:import>

	<div class="container">
		<div class="row">
			<h1>Memo List</h1>
			<div class="form-group">
			  <label for="writer">Writer:</label>
			  <input type="text" class="form-control" id="writer" name="writer">
			</div>
			<div class="form-group">
	  			<label for="contents">Contents:</label>
	 			 <textarea class="form-control" rows="5" id="contents" name="contents"></textarea>
			</div>
			<button id="btn" class="btn btn-danger">WRITE</button>		
		</div>
		
		
		<div class="row">
			<table class="table table-striped" id="result">
			<tr>
				<td>NUM</td>
				<td>Contents</td>
				<td>Writer</td>
				<td>Date</td>
			</tr>			
			</table>	
		</div>
		
		<div>
			<button id="more">더보기</button>
		</div>
		
		
	</div>
	
	<script type="text/javascript">
		var count=1;	
		
		function getList(curPage){
			$.get("getList?curPage="+curPage, function(result){
				$('#result').append(result);
			});
		}
		
		getList(count);
		
	
		//글 쓰고 버튼 눌렀을 때
		$("#btn").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			
			$("#writer").val('');
			$("#contents").val('');
			
			//$.get("url?name=value")
			//$.post()
			$.post("./memoInsert", {writer:writer, contents:contents}, function(result) {
					result = result.trim();
					if(result>0){
						location.reload();
						//count=1;
						//getList(count);
					}else {
						alert("Write Fail");
					}
			});	
		});
		
		
		
		$("#more").click(function(){
			count++;
			getList(count);
		});
		

	</script>


</body>
</html>