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
	  <h2>Member Update Form</h2>
	  
	  <form class="form-horizontal" action="../member/memberUpdate" method="POST">
	  
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=id>ID:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="id" value="${member.id}" placeholder="Enter id" name="id" readonly="readonly">
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="pwd">PWD:</label>
	      <div class="col-sm-10">          
	        <input type="password" class="form-control" id="pwd" value="${member.pwd}" placeholder="Enter pwd" name="pwd" readonly="readonly">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=name>Name:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="name" value="${member.name}" placeholder="Enter name" name="name">
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="eng">Email:</label>
	      <div class="col-sm-10">          
	        <input type="email" class="form-control" id="email" value="${member.email}" placeholder="Enter email" name="email">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=math>Phone:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="phone" value="${member.phone}" placeholder="Enter phone" name="phone">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=age>Age:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="age" value="${member.age}" placeholder="Enter age" name="age">
	      </div>
	    </div>
	    
	    
	    
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">Confirm</button>
	        <!-- <input type="submit" class="btn btn-default">Submit2 -->
	      </div>
	    </div>
	  </form>
	</div>

</body>
</html>