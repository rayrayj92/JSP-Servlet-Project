<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - 로그인</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container" style="margin-top:1.5rem;">
		<div class="row text-center">
			<div class="col-3"></div>
			<div class="col-6">
				<h4>Login - 로그인</h4>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
	<hr />
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<form action="login" method="post" onsubmit="return validateFormInput()">
					<div class="form-group">
						<label for="email" class="control-lable">Email - 이메일</label>
						<input type="text" id="email" name="email" class="form-control" required />
					</div>
					<div class="form-group">
						<label for="password" class="control-lable">Password - 비밀번호</label>
						<input type="password" id="password" name="password" class="form-control" required />
					</div>
					<div class="form-group">
						<input type="submit" value="LOGIN" class="btn btn-info btn-block" />
						<hr />
						<a href="register" class="btn btn-warning btn-block">REGISTER</a>
					</div>
				</form>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
</body>
</html>