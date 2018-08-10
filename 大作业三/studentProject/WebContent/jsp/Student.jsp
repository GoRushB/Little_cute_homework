<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>查看学生</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/echarts.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
<script type="text/javascript">
	function formSubmit1() {
		$('#action').val('Create');
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
							<b>学生信息管理系统 </b>
						</h4>
					</div>
					<div class="card-body">
						<div class="row" style="height: 2rem;"></div>
						<div class="card">
							<div class="card-header bg-light text-left">
								<h6>
									<b> 学生列表 </b>
								</h6>
							</div>
							<div class="row" style="height: 1rem;"></div>
							<div class="text-left">
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnStart"
										onclick="formSubmit1()">创建</button>
								</div>
							</div>
							<script type="text/javascript">
								$.getJSON('StudentServlet?Action=GetAll');
							</script>
							<div class="row" style="height: 1rem;"></div>
							<div class="card-body text-center">
								<table
									class="table table-striped table-hove table-sm table-bordered table-borderless">
									<thead>
										<tr>
											<th scope="col">Id</th>
											<th scope="col">姓名</th>
											<th scope="col">年龄</th>
											<th scope="col">操作</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row">1</th>
											<td>李佩珊</td>
											<td>18</td>
											<td><div class="btn-group">
													<button id="btnGroupDrop1" type="button"
														class="btn btn-outline-primary dropdown-toggle"
														data-toggle="dropdown">选择操作</button>
													<div class="dropdown-menu">
														<a class="dropdown-item"
															href="StuentServlet?action=GetGrade&id=1">查询成绩</a> <a
															class="dropdown-item"
															href="StuentServlet?action=Edit&id=1">修改</a> <a
															class="dropdown-item"
															href="StuentServlet?action=Delete&id=1">删除</a>
													</div>
												</div></td>
										</tr>
										<c:forEach var="student" items="${students}">
											<tr>
												<th scope="row">${student.sno }</th>
												<td>${student.sname }</td>
												<td>${student.sage }</td>
												<td><a
													href="StudentServlet?action=GetGradeByStudent&id=${course.sno}">
														查看成绩</a></td>
												<td><a
													href="StudentServlet?action=Edit&id=${course.sno}"> 修改</a></td>
												<td><a
													href="StudentServlet?action=Delete&id=${course.sno}">
														删除</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="row" style="height: 3rem;"></div>
							<div class="text-center">
								<a href="Menu.jsp">返回菜单页面</a>
							</div>
							<div class="row" style="height: 1rem;"></div>
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
	</div>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>