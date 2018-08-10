<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>查看成绩</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/echarts.js"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="height: 3rem;"></div>
		<div class="row justify-content-center">
			<!--如果要与手机屏幕匹配，则应把下一句的col-x改成col-12 -->
			<div class="col-12 text-center">
				<div class="card">
					<div class="card-header text-white bg-primary text-left">
						<h4>
							<b>成绩 </b>
						</h4>
					</div>
					<div class="card-body">
						<div class="card">
							<div class="card-header bg-light text-left">
								<h6>
									<b> 个人成绩 </b>
								</h6>
							</div>
							<div class="card-body text-left">
								<!--img class=" rounded card-img-top img-fluid" src="../img/grcj.jpg" alt="Card image cap" -->
								<div id="chengji" style="width: 280px; height: 216px;"></div>
								<script type="text/javascript">
								<!-- 基于准备好的dom，初始化echarts实例 -->
									var myChart = echarts.init(document
											.getElementById('chengji'));
									myChart.setOption({
										title : {
											text : '${users.uname} 同学各题得分情况'
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
											name : '分数',
											type : 'line',
											data : []
										} ]
									});
									// 异步加载数据
									$
											.getJSON(
													'ResultServlet?uid=${users.uid}&rtype=person',
													function(data) {
														// 填入数据
														myChart
																.setOption({
																	xAxis : {
																		data : data.qid
																	},
																	series : [ {
																		// 根据名字对应到相应的系列
																		name : '分数',
																		type : 'line',
																		data : data.grade
																	} ]
																});
													});
								</script>
							</div>
						</div>
						<br>
						<div class="card">
							<div class="card-header bg-light text-left">
								<h6>
									<b> 全部成绩 </b>
								</h6>
							</div>
							<div class="card-body text-left">
								<table class="table table-striped table-hover table-bordered">
									<thead>
										<tr>
											<th scope="col">#</th>
											<th scope="col">姓名</th>
											<th scope="col">成绩</th>
											<th scope="col">编辑</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cj" items="${chengjis}">
											<tr>
												<th scope="row">${cj.cjid }</th>
												<td>${cj.uname }</td>
												<td>${cj.grade}</td>
												<td><a href="ResultServlet?rtype=delete&uid=${cj.uid}">
														删除该用户信息</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="text-center">
			<a href="home.jsp">返回首页</a>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>