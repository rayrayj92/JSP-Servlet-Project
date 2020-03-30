<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Notice Board List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="//cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
</head>
<body>
	<div class="container" style="margin-top:1.5rem;">
		<div class="row text-center">
			<div class="col-3"></div>
			<div class="col-6">
				<h4>Create Notice Board List - 게시판 작성</h4>
				<a href="list">Back to List</a>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
	<hr />
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<form action="create" method="post" onsubmit="return validateFormInput()">
					<div class="form-group">
						<label for="title" class="control-lable">Title - 제목</label>
						<input type="text" id="title" name="title" class="form-control" placeholder="제목을 입력하세요" />
					</div>
					<div class="form-group">
						<label for="content" class="control-lable">Content - 내용</label>
						<textarea name="content" id="content" class="form-control" placeholder="내용을 입력하세요"></textarea>
					</div>
					<div class="form-group">
						<label for="file" class="control-lable">File - 첨부파일</label>
						<input type="file" name="file" class="form-control" />
					</div>
					<div class="form-group">
						<input type="submit" value="Create" class="btn btn-info" />
						<a ></a>
					</div>
				</form>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
 	CKEDITOR.replace( 'content' );

	function validateFormInput(){
		var fieldTitle = document.getElementById("title");
		var foo = CKEDITOR.instances['content'].getData();
		var fieldContent = document.getElementById("content");
		
		if(fieldTitle.value.length == 0){
			alert("Title is required!");
			fieldTitle.focus();
			return false;
		}
		
		if(foo.length == 0){
			alert("Content is required!");
			fieldContent.focus();
			return false;
		}
			
		return true;
	}
</script>
</script>
</html>