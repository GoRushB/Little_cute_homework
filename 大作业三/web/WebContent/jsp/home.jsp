<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>登陆界面</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="../js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.css">
<script type="text/javascript">
	function formSubmit1() {
		$('#action').val('doquestion');
		$('#loginForm').submit();
	}
	function formSubmit2() {
		$('#action').val('gotoresult');
		$('#loginForm').submit();
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="height: 3rem;"></div>
		<c:if test="${not empty message }">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<div class="row justify-content-center">
			<div class="col-10 text-center">
				<div class="card">
					<div class="card-header text-white bg-primary text-left">
						<h4>
							<b>登陆</b>
						</h4>
					</div>
					<div class="card-body">
						<form id="loginForm" action="LoginServlet" method="post">
							<input type="hidden" id="action" name="action">
							<div class="row" style="height: 3rem;"></div>
							<div class="form-group row">
								<label for="uname" class="col-4 col-form-label"> 用户名： </label>
								<div class="col-8">
									<input type="text" id="uname" name="uname" class="form-control" />
								</div>
							</div>
							<div class="row" style="height: 6rem;"></div>
							<div class="form-group row justify-content-round">
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnStart"
										onclick="formSubmit1()">开始新答题</button>
								</div>
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnResult"
										onclick="formSubmit2()">查看成绩</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>