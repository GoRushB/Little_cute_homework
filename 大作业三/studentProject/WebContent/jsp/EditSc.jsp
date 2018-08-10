<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>修改成绩</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="../js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<script type="text/javascript">
	function formSubmit1() {
		$('#EditScForm').submit();
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="height: 1rem;"></div>
		<c:if test="${not empty message }">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<div class="row justify-content-center">
			<div class="col-md-4 text-center">
				<div class="card">
					<div class="card-header text-white bg-primary text-center">
						<h4>
							<b>修改成绩信息</b>
						</h4>
					</div>
					<div class="card-body text-center">
						<form id="EditScForm" action="EditScServlet" method="post">
							<input type="hidden" id="action" name="action">
							<div class="row" style="height: 3rem;"></div>
							<div class="card">
								<div class="card-body">
									<div class="form-group row">
										<label for="scid" class="col-4 col-form-label"> Id： </label>
										<div class="col-8">
											<input type="text" id="scid" name="scid" readonly readonly
												class="form-control-plaintext text-center" value="${Sc.scid}" />
										</div>
									</div>
									<div class="form-group row">
										<label for="sno" class="col-4 col-form-label"> 学生Id： </label>
										<div class="col-8">
											<input type="text" id="sno" name="sno" readonly readonly
												class="form-control-plaintext text-center" value="${Sc.sno}" />
										</div>
									</div>
									<div class="form-group row">
										<label for="cno" class="col-4 col-form-label"> 课程Id： </label>
										<div class="col-8">
											<input type="text" id="cno" name="cno" readonly readonly
												class="form-control-plaintext text-center" value="${Sc.cno}" />
										</div>
									</div>
									<div class="form-group row">
										<label for="grade" class="col-4 col-form-label"> 成绩： </label>
										<div class="col-8">
											<input type="text" id="grade" name="grade"
												class="form-control" />
										</div>
									</div>
								</div>
							</div>
							<div class="row" style="height: 2rem;"></div>
							<div class="form-group row justify-content-round">
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnStart"
										onclick="formSubmit1()">保存</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<nav class="navbar navbar-inverse navbar-fixed-bottom">
				<div>
					<script type="text/javascript">
						date = new Date();
						year = date.getFullYear();
						document.write("Copyright © 2018-" + year + " 李佩珊");
					</script>
				</div>
			</nav>
		</div>
	</div>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>