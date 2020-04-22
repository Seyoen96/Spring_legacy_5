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
	      <li><a href="${pageContext.request.contextPath}/qna/qnaList">QnA</a></li>
	      <li><a href="${pageContext.request.contextPath}/member/memberList">Member List</a></li>
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
		
		
		
		<h1>My Page</h1>
			<img alt="" src="../resources/memberUpload/${member.memberFileDTO.fileName}">
			<div>
				<h3><a href="./fileDelete">File Delete</a></h3>
			</div>
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
	        	$(location).attr('href','./memberDelete?id='+'${member.id}');
	        	
	        	alert("탈퇴 완료되었습니다");
	        }
		});
	
	</script>


</body>
</html>