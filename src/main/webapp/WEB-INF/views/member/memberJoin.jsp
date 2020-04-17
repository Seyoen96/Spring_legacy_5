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
	  <h2>Member Join Form</h2>
	  <form class="form-horizontal" action="../member/memberJoin" method="POST">
	  
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=id>ID:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="pwd">PWD:</label>
	      <div class="col-sm-10">          
	        <input type="text" class="form-control" id="pwd" placeholder="Enter pwd" name="pwd">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=name>Name:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="eng">Email:</label>
	      <div class="col-sm-10">          
	        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=math>Phone:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=age>Age:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="age" placeholder="Enter age" name="age">
	      </div>
	    </div>
	    
	    
	    
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">Submit</button>
	        <!-- <input type="submit" class="btn btn-default">Submit2 -->
	      </div>
	    </div>
	  </form>
	</div>

	
	
	
		
	
</body>
</html>


