<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Board - 게시판</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container" style="margin-top: 1.5rem; margin-bottom: 1.5rem;">
		<div class="row">
			<div class="col-2">
			</div>
			<div class="col-8 text-center">
				<h4>Notice Board Function - <mark>게시판</mark></h4>
				<span><strong>Technologies used:</strong></span><br />
				<span>JSP, Servlet, JSTL, MySQL, Hibernate, Maven, Bootstrap</span><br />
				<span>Welcom, Admin </span><a href="../logout" class="btn btn-link">Logout</a><hr />
			</div>
			<div class="col-2">
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form action="list" method="post">
					<table class="table table-striped">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col" style="width:5%;">Check</th>
					      <th scope="col" style="width:5%;">Index</th>
					      <th scope="col" style="width:50%;">Title</th>
					      <th scope="col" style="width:10%;">Author</th>
					      <th scope="col" style="width:15%;">Date</th>
					      <th scope="col" style="width:5%;">View</th>
					      <th scope="col" style="width:10%;">Action</th>
					    </tr>
					  </thead>
					  <tbody>
					  <c:forEach var="list" items="${notice_result}" varStatus="status">
					  	<tr>
					  	  <th><input type="checkbox" name="del-id" value="${list.id}"></th>
					      <th scope="row">${status.index + 1}</th>
					      <td><a href="list/detail?id=${list.id}">${list.title}</a></td>
					      <td>${list.author}</td>
					      <td>
					      	<fmt:formatDate pattern="yyyy년 MM월 dd일" value="${list.date}"/>
					      </td>
					      <td>
					      	<fmt:formatNumber value="${list.view}"/>
					      </td>
					      <td>
					      	<a href="edit?id=${list.id}">Edit</a>
					      </td>
					    </tr>
					  </c:forEach>
					  </tbody>
					</table>
					<a href="create" class="btn btn-primary" role="button">Create</a>
					<input type="submit" class="btn btn-danger" name="delete" value="Delete ALL">
				</form>
			</div>
		</div>
	</div>
</body>
</html>