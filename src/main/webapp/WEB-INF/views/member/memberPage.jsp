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
		<h1>My Page</h1>
			<table class="table table-hover">
			<thead>
				<tr>
					<td>ID</td><td>Name</td><td>Age</td>
					<td>Phone</td><td >Email</td>
				</tr>
			</thead>
				<tr>
					<td>${member.id}</td><td>${member.name}</td><td>${member.age}</td>
					<td>${member.phone}</td><td>${member.email}</td>
				</tr>
			</table>
			
		<button class="btn btn-primary" id="updateBtn">Update</button>
		<button class="btn btn-danger" id="deleteBtn">Delete</button>
		</div>
	</div>
	
	
	<script type="text/javascript">
		$("#updateBtn").on("click",function(){
			location.href='./memberUpdate';
		});
	
		$("#deleteBtn").on("click",function(){
			var result = confirm("회원 탈퇴하시겠습니까?");
	        if(!result){  	
	        	return false;
	        }
	        else{
	        	$(location).attr('href','./memberDelete');
	        	alert("탈퇴 완료되었습니다");
	        }
		});
	
	</script>


</body>
</html>