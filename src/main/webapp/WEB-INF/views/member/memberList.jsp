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
	<h1>Member List Page</h1>
		 <form action="./memberList" class="form-inline">
		  <div class="input-group input-group-sm col-xs-2">
		    	<select class="form-control" id="sel1" name ="kind">
				    <option value="ii">ID</option>
				    <option value="nn">Name</option>
				    <option value="pp">Phone</option>
				    <option value="ee">Email</option>
				  </select>	  
			 </div>
		    	<div class="input-group input-group-sm col-xs-4">
		      <input type="text" class="form-control" placeholder="Search" name="search">
		      <div class="input-group-btn">
		        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
		      
		    </div>
		    </div>
		  </form>
	
	<div id ="result">
		<table class="table table-hover">
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Phone</td>
				<td>Email</td>
				<td>Age</td>
				<td><input type="checkbox" id="ch1"> <button class="btn btn-danger" id="btnD">Delete</button> </td>
			</tr>
		</thead>
			<c:forEach items="${list}" var="dto" varStatus="i">
				<tr>
					<td id="id${i.index}"><a href="./memberPage?id=${dto.id}">${dto.id}</a></td>
					<td>${dto.name}</td>
					<td>${dto.phone}</td>
					<td>${dto.email}</td>
					<td>${dto.age}</td>
					<td><input type="checkbox" name="del" title="id${i.index}" id="${dto.id}" class="ch2"></td>
					<td><input type="hidden" class="ids" value="${dto.id}"></td>
				</tr>
			</c:forEach>			
		</table>
		
		<div>
			<ul class="pagination">
			<c:if test="${pager.curBlock > 1}">
				<li><a href="./memberList?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><a href="./memberList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			</c:forEach>
			<c:if test="${pager.curBlock lt pager.totalBlock}">
			<li><a href="./memberList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
			</c:if>
			</ul>
		</div>
		
		</div>
	
	</div>
</div>

	
	<script type="text/javascript">
	
		$("#result").on("click", "#btnD", function() {
			var ids = [];//빈 배열 생성
			$(".ch2").each(function() {
				if($(this).prop("checked")){
					//var id = $(this).attr("title");
					//alert($("#"+id).text());
					
					ids.push($(this).attr("id"));
				}
			});
			
			console.log(ids);
			//foreach 끝
			$.ajax({
				type:"get",
				traditional:true,
				url:"./memberDeletes",
				data: {
					ids:ids
				},
				success:function(data){
					$.get("./memberLists", function(data) {
						$("#result").html(data.trim());
					});
				}
				
			});
		});
		
		
		//////////////////////////////////
		$("#result").on("click", "#ch1", function() {
			$(".ch2").prop("checked", $(this).prop("checked"));
			
		});
		
		
		///////////////////////////////////
		$("#result").on("click", ".ch2", function() {
			
			var result=true;
			$(".ch2").each(function() {
				if(!$(this).prop("checked")){
					result=false;
				}
			});
			
			$("#ch1").prop("checked", result);
		});
		


		/////////////////////////////////////////////////////////
		// 인덱스 번호로 id 찾아오기 - my
//		$("#btnD").click(function(){
//			$(".ch2").each(function(){
//				if($(this).prop("checked")==true){
//					var num = $(".ch2").index(this);
//					
//					$(".ids").each(function(){
//						if($(".ids").index(this)==num){
//							alert($(this).val());	
//						}
//					});
//				}
//			});
//		});
				
		
		
	</script>
	


</body>
</html>