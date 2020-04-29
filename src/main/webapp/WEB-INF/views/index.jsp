<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>﻿
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/boot.jsp"></c:import>
</head>
<body>
<c:import url="./template/header.jsp"></c:import>
	
	<button id="btn">BUTTON</button>
	<button id="btn2">BUTTON2</button>
	
	<h1>Board Index Page</h1>
	
	<script type="text/javascript">
		$('#btn2').click(function(){
			$.get("https://api.manana.kr/exchange/rate.json?base=KRW&code=KRW,USD,JPY",function(data){
				console.log(data[1].rate);
			});	
			
		});
	
	
		$('#btn').click(function(){			
			$.get("./json/json1", function(result){
				//0. result가 String인지 json Object인지 판별
				//console.log(result);
				//결과 값이  "name":"sy"	->	String
				//결과 값이    object			->	String
				
				//1. String 이라면 json Object로 변환
				//result = result.trim();
				//console.log(result.num);
				//console.log(result.title);
				
				console.log(result);
			});
	
		});
		
	</script>	
		
</body>
</html>

