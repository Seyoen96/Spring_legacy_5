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
	  <form class="form-horizontal" action="../member/memberJoin" method="POST" enctype="multipart/form-data">
	  
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
	      <label class="control-label col-sm-2" for=pic>Photo:</label>
	      <div class="col-sm-10">
	        <input type="file" class="form-control" id="pic" placeholder="Enter age" name="pic">
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

	<script type="text/javascript">
		$("#id").on("blur",function(){		
			var id = $('#id').val();
			
			$.ajax({
				type: "post", 			//method 형식
				url : "./memberIdCheck",
				data: {id:id},			//parameter
				success:function(data){
					alert(data);
				},
				error:function(){
					alert("error 발생");
				}
				
			});

//			$.post("./memberIdCheck",{id:id}, function(result){
//				result = result.trim();
//				if(result>0){
//					alert("사용 가능한 ID입니다");
//				} else{
//					alert("중복된 ID 입니다");
//				}	
//			});

		});	
	</script>
	
	
		
	
</body>
</html>


