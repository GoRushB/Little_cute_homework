<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>查看学生成绩</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/echarts.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="height: 1rem;"></div>
		<div class="row justify-content-center">
			<div class="col-md-4 text-center">
				<div class="card">
					<div class="card-header text-white bg-primary text-center">
						<h4>
							<b>查看所有课程成绩</b>
						</h4>
					</div>
					<div class="card-body">
						<div class="row" style="height: 2rem;"></div>
						<div class="card">
							<div class="card-header bg-light text-left">
								<h6>
									<b> 成绩折线图</b>
								</h6>
							</div>
							<div class="card-body text-left">
								<div id="chengji" style="width: 280px; height: 216px;"></div>
								<script type="text/javascript">
									var myChart = echarts.init(document
											.getElementById('Courses'));
									myChart.setOption({
										title : {
											text : '${sname} 同学各科成绩情况'
										},
										tooltip : {},
										legend : {
											data : []
										},
										xAxis : {
											data : []
										},
										yAxis : {},
										series : [ {
											name : '成绩',
											type : 'line',
											data : []
										} ]
									});
									// 异步加载数据
									$
											.getJSON(
													'StudentServlet?id=${id}&action=GetGrade',
													function(data) {
														// 填入数据
														myChart
																.setOption({
																	xAxis : {
																		data : data.cno
																	},
																	series : [ {
																		name : '分数',
																		type : 'line',
																		data : data.grade
																	} ]
																});
													});
								</script>
							</div>
						</div>
						<div class="card">
							<div class="card-header bg-light text-left">
								<h6>
									<b> 成绩列表 </b>
								</h6>
							</div>
							<div class="row" style="height: 1rem;"></div>
							<div class="card-body text-center">
								<table
									class="table table-striped table-hove table-sm table-bordered table-borderless">
									<thead>
										<tr>
											<th scope="col">Id</th>
											<th scope="col">课程Id</th>
											<th scope="col">成绩</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="course" items="${Courses}">
											<tr>
												<th scope="row">${course.scid }</th>
												<td>${course.cno }</td>
												<td>${course.grade }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="row" style="height: 3rem;"></div>
							<div class="text-center">
								<a href="Student.jsp">返回</a>
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