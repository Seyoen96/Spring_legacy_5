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
	      <li><a href="${pageContext.request.contextPath}/member/memberList">MemberList</a></li>
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
	<h1>Member List Page</h1>
		 <form action="./memberList" class= "col-xs-6">
		    <div class="input-group">
		    	<select class="form-control" id="sel1" name ="kind">
				    <option value="ii">ID</option>
				    <option value="nn">Name</option>
				    <option value="pp">Phone</option>
				    <option value="ee">Email</option>
				  </select>
		    
		      <input type="text" class="form-control" placeholder="Search" name="search">
		      <div class="input-group-btn">
		        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
		      </div>
		    </div>
		  </form>
	
	
		<table class="table table-hover">
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Phone</td>
				<td>Email</td>
				<td>Age</td>
			</tr>
		</thead>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href="./memberPage?id=${dto.id}">${dto.id}</a></td>
					<td>${dto.name}</td>
					<td>${dto.phone}</td>
					<td>${dto.email}</td>
					<td>${dto.age}</td>
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



</body>
</html>