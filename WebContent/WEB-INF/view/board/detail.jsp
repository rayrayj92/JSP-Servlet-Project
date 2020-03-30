<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container" style="margin-top: 1.5rem; margin-bottom: 1.5rem;">
		<div class="row">
			<div class="col-3">
				<a href="../list">Back to List</a>
			</div>
			<div class="col-6">
				<h3>${notice.title}</h3>
				<hr />
				<div>
					<ul>
						<li>Author: ${notice.author}</li>
						<li>Date: ${notice.date}</li>
						<li>View: ${notice.view}</li>
					</ul>
				</div>
				<hr />
				<div style="height:400px; overflow:auto;">
					${notice.content}
				</div>
				<hr />
				<span style="font-size:1.2rem; font-weight: 700;">Files</span><br />
				<c:if test="${notice.file != ''}">
					<span>${notice.file}</span>
				</c:if>
				<c:if test="${notice.file == ''}">
					<span style="color:red;">No files</span>
				</c:if>
			</div>
			<div class="col-3">
			
			</div>
		</div>
	</div>
</body>
</html>