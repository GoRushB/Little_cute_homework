<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>开始新答题</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="../js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.css">
<script type="text/javascript">
	function formClickFirst() {
		$('#question_num').val(1);
		$('#action').val('goFirst');
		$('#startForm').submit();
	}
	function formClickPrev() {
		var num = parseInt($("#question_num").val());
		if (num > 1) {
			num = num - 1;
			$("#question_num").val(num);
			$("#action").val("goPrev");
			$("#startForm").submit();
		}
	}
	function formClickNext() {
		var num = parseInt($("#question_num").val());
		var count = parseInt($("#question_count").val());
		if (num < count) {
			num = num + 1;
			$("#question_num").val(num);
			$("#action").val("goNext");
			$("#startForm").submit();
		}
	}
	function formClickLast() {
		var num = parseInt($("#question_count").val());
		$("#question_num").val(num);
		$("#action").val("goLast");
		$("#startForm").submit();
	}
	function formClickResult() {
		$("#action").val("gotoResult");
		$("#startForm").submit();
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="height: 4rem;">
			<c:choose>
				<c:when test="${empty users }">
					<c:redirect url="home.jsp" />
				</c:when>
				<c:otherwise>
					<div class="alert alert-success col-12">
						<h5>
							<b>第 ${question_num} 题</b>
						</h5>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="row justify-content-center">
			<div class="col-12 text-center">
				<form id="startForm" action="StartServlet" method="post" role="form">
					<div class="card">
						<div class="card-header text-white bg-primary text-left">
							<h4>
								<b>${users.uname} 正在作答</b>
							</h4>
						</div>
						<div class="card-body">
							<!--如果要与手机屏幕匹配，则应把下一句的col-10改成col-->
							<input type="hidden" id="question_num" name="question_num"
								value="${question_num}"> <input type="hidden" id="qid"
								name="qid" value="${questions.qid}"> <input
								type="hidden" id="question_count" name="question_count"
								value="${question_count}"> <input type="hidden"
								id="uname" name="uname" value="${users.uname}"> <input
								type="hidden" id="action" name="action">
							<div class="row" style="height: 3rem;"></div>
							<div class="form-group row text-left">
								<label id="question_no" class="col-12 col-form-label">
									问题 ${question_num}：<!--来自数据库查询-->
								</label>
							</div>
							<div class="form-group row">
								<div class="col-12">
									<label id="question_desp" class="col col-form-label text-left">
										${questions.qdesp}<!--来自数据库查询-->
									</label>
								</div>
							</div>
							<div class="form-group row text-left">
								<label class="col-12 col-form-label"> 备选项： </label>
							</div>
							<div class="form-group row">
								<div class="col-12 text-left">
									<div class="form-check">
										<label class="col col-form-label text-left"> <input
											class="form-check-input" type="radio" name="answers"
											id="ans1" value="1" checked> ${questions.qans1} <!--来自数据库查询-->
										</label>
									</div>
									<div class="form-check">
										<label class="col col-form-label text-left"> <input
											class="form-check-input" type="radio" name="answers"
											id="ans2" value="2"> ${questions.qans2}<!--来自数据库查询-->
										</label>
									</div>
									<div class="form-check">
										<label class="col col-form-label text-left"> <input
											class="form-check-input" type="radio" name="answers"
											id="ans3" value="3"> ${questions.qans3}<!--来自数据库查询-->
										</label>
									</div>
									<div class="form-check">
										<label class="col col-form-label text-left"> <input
											class="form-check-input" type="radio" name="answers"
											id="ans4" value="4"> ${questions.qans4}<!--来自数据库查询-->
										</label>
									</div>
								</div>
								<c:if test="${not empty anscheck }">
									<script type="text/javascript">
										$("#ans1").attr("checked", false);
										$("#ans2").attr("checked", false);
										$("#ans3").attr("checked", false);
										$("#ans4").attr("checked", false);
										switch ("${anscheck}") {
										case "1":
											$("#ans1").attr("checked", true);
											break;
										case "2":
											$("#ans2").attr("checked", true);
											break;
										case "3":
											$("#ans3").attr("checked", true);
											break;
										case "4":
											$("#ans4").attr("checked", true);
											break;
										}
									</script>
								</c:if>
							</div>
							<div class="row" style="height: 3rem;"></div>
							<div class="form-group row justify-content-round">
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnFirst"
										onclick="formClickFirst()">首题</button>
									<!--页面跳转-->
								</div>
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnPrev"
										onclick="formClickPrev()">上一题</button>
									<!--页面跳转-->
								</div>
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnNext"
										onclick="formClickNext()">下一题</button>
									<!--页面跳转-->
								</div>
							</div>
							<div class="form-group row justify-content-round">
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnLast"
										onclick="formClickLast()">末题</button>
									<!--页面跳转-->
								</div>
								<div class="col">
									<button type="button" class="btn btn-primary" id="btnResult"
										onclick="formClickResult()">结束答题</button>
									<!--页面跳转-->
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>