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