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
	<h1>${board} List Page</h1>
		 <form action="./${board}List" class= "col-xs-6">
		    <div class="input-group">
		    	<select class="form-control" id="sel1" name ="kind">
				    <option value="bt">Title</option>
				    <option value="bc">Contents</option>
				    <option value="bw">Writer</option>
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
				<td>Num</td>
				<td>Title</td>
				<td>Writer</td>
				<td>Date</td>
				<td>Hit</td>
			</tr>
		</thead>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td>
					
					<c:catch>
					<c:forEach begin="1" end="${dto.depth}">
						&nbsp;&nbsp;→
					</c:forEach>
					</c:catch>
					
					<a href="./${board}Select?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>			
		</table>
		
		
		<div>
			<ul class="pagination">
			<c:if test="${pager.curBlock gt 1}">
			<li><a href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><a href="./${board}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			</c:forEach>
			<c:if test="${pager.curBlock lt pager.totalBlock}">
			<li><a href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
			</c:if>
			</ul>
		</div>
		
		
		<a href="./${board}Write" class="btn btn-danger">Write</a>
		
		
		<c:catch>
		<c:if test="${not empty member}">
			<c:if test="${board eq 'qna'}">
				<div>
					<a href="./${board}Write" class="btn btn-danger">Write</a>
				</div>
			</c:if>
			
			<c:if test="${board eq 'notice'}">
				<c:if test="${member.id eq 'admin'}">
					<div>
					<a href="./${board}Write" class="btn btn-danger">Write</a>
					</div>
				</c:if>
			</c:if>	
		</c:if>
		</c:catch>
		
		
	
	</div>
</div>



</body>
</html>