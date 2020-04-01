<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - 회원가입</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container" style="margin-top:1.5rem;">
		<div class="row text-center">
			<div class="col-3"></div>
			<div class="col-6">
				<h4>Register - 회원가입</h4>
				<a href="login">Back to login</a>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
	<hr />
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<form action="register" method="post" onsubmit="return validateFormInput()">
					<div class="form-group">
						<label for="email" class="control-lable">Email - 이메일</label>
						<input type="text" id="email" name="email" class="form-control" placeholder="이메일을 입력하세요" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required />
					</div>
					<div class="form-group">
						<label for="fullName" class="control-lable">Full Name - 이름</label>
						<input type="text" id="fullName" name="fullName" class="form-control" placeholder="이름을 입력하세요 예) 홍길동" required />
					</div>
					<div class="form-group">
						<label for="email" class="control-lable">Gender - 성별</label>
						<select class="form-control" name="gender" required>
						  <option value="Male">Male</option>
						  <option value="Female">Female</option>
						</select>
					</div>
					<div class="form-group">
						<label for="password" class="control-lable">Password - 비밀번호</label>
						<input type="password" id="password" name="password" class="form-control" placeholder="최소 6자" pattern=".{6,}" required title="최소 6자를 입력하세요." />
					</div>
					<div class="form-group">
						<label for="passwordConfirm" class="control-lable">Confirm Password - 비밀번호 확인</label>
						<input type="password" id="passwordConfirm" class="form-control" placeholder="위와 동일한 비밀번호를 입력하세요" pattern=".{6,}" required title="최소 6자를 입력하세요."  />
					</div>
					<div class="form-group">
						<input type="submit" value="REGISTER" class="btn btn-warning" />
						<a ></a>
					</div>
				</form>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function validateFormInput(){
		var password = document.getElementById("password");
		var passwordConfirm = document.getElementById("passwordConfirm");
		
		if(password.value != passwordConfirm.value){
			alert("비밀번호가 일치하지 않습니다. Password & Confirm Password are not identical.");
			passwordConfirm.focus();
			return false;
		}
		return true;
		
	}
</script>
</html>