<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  


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

