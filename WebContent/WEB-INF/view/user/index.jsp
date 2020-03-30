<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Area</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container" style="margin-top:1.5rem;">
		<div class="row text-center">
			<div class="col-3"></div>
			<div class="col-6">
				<h4>User Area - 일반 사용자</h4>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
	<hr />
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<p>
					세션을 이용하여 사용자 정보 전달
				</p>
				<p>
					Name : ${info.fullname}
				</p>
				<p>
					Email : ${info.email}
				</p>
				<p>
					Gender : ${info.gender}
				</p>
				<a href="logout" class="btn btn-danger btn-block">Logout</a>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
	
</body>
</html>