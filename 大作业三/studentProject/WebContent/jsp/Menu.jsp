<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>菜单界面</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="../js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<script type="text/javascript">
	function formSubmit1() {
		$('#action').val('Student');
		$('#MenuForm').submit();
	}
	function formSubmit2() {
		$('#action').val('Course');
		$('#MenuForm').submit();
	}
	function formSubmit3() {
		$('#action').val('Sc');
		$('#MenuForm').submit();
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="height: 1rem;"></div>
		<div class="row justify-content-center">
			<div class="col-md-4 text-center">
				<div class="card">
					<div class="card-header text-white bg-primary text-center">
						<h4>
							<b>选择子系统</b>
						</h4>
					</div>
					<div class="card-body">
						<form id="MenuForm" action="MenuServlet" method="post">
							<input type="hidden" id="action" name="action">
							<div class="row" style="height: 3rem;"></div>
							<div class="form-group row justify-content-round">
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnStart"
										onclick="formSubmit1()">学生信息管理系统</button>
								</div>
							</div>
							<div class="row" style="height: 3rem;"></div>
							<div class="form-group row justify-content-round">
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnStart"
										onclick="formSubmit2()">课程信息管理系统</button>
								</div>
							</div>
							<div class="row" style="height: 3rem;"></div>
							<div class="form-group row justify-content-round">
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnStart"
										onclick="formSubmit3()">成绩信息管理系统</button>
								</div>
								<div class="row" style="height: 3rem;"></div>
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