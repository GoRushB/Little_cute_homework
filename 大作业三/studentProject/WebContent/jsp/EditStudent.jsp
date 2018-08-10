<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>修改学生</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="../js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<script type="text/javascript">
	function formSubmit1() {
		$('#EditStudentForm').submit();
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
							<b>修改学生信息</b>
						</h4>
					</div>
					<div class="card-body text-center">
						<form id="EditStudentForm" action="EditStudentServlet" method="post">
							<input type="hidden" id="action" name="action">
							<div class="row" style="height: 3rem;"></div>
							<div class="card">
								<div class="card-body">
									<div class="form-group row">
										<label for="sno" class="col-4 col-form-label"> Id： </label>
										<div class="col-8">
											<input type="text" id="sno" name="sno" readonly readonly
												class="form-control-plaintext text-center" value="${Student.sno}" />
										</div>
									</div>
									<div class="form-group row">
										<label for="sname" class="col-4 col-form-label"> 姓名： </label>
										<div class="col-8">
											<input type="text" id="sname" name="sname"
												class="form-control" />
										</div>
									</div>
									<div class="form-group row">
										<label for="sage" class="col-4 col-form-label"> 年龄： </label>
										<div class="col-8">
											<input type="text" id="sage" name="sage"
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