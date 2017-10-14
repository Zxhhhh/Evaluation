<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="CoreUI - Open Source Bootstrap Admin Template">
<meta name="author" content="Åukasz Holeczek">
<meta name="keyword"
	content="Bootstrap,Admin,Template,Open,Source,AngularJS,Angular,Angular2,jQuery,CSS,HTML,RWD,Dashboard">
<link rel="shortcut icon" href="img/favicon.png">

<title>欢迎使用蓝鸥it考评系统</title>

<!-- Icons -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/simple-line-icons.css" rel="stylesheet">

<!-- Main styles for this application -->
<link href="css/style.css" rel="stylesheet">

<style type="text/css">
.importantNumber {
	color: red;
	font-weight: 700;
}

.redNumber {
	color: red;
}

.greenNumber {
	color: green;
}
</style>


<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="bower_components/Echarts/echarts.common.min.js"></script>
<script type="text/javascript">
	$(function() {


		$(".addExam").click(function() {

			window.location.href = "exam_addExamInformation.jsp";

		});

		$(".startedBtn").click(function() {

			alert("1");

		});

		$(".unstartBtn").click(function() {

			alert("2");
		})

	});
</script>

<script type="text/javascript">
	$(function() {

		var piechart = echarts.init(document.getElementById("pie"));

		pieoption = {
			title : {
				text : '考生分数情况',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
											orient : "vertical",
											x : "right",
											data : (function() {
												var arr = [];
												$.ajax({
															type : "post",
															async : false,
															url:"getChartData/score.do?exam_id=${examStatistics.examInformation.examId }",
															data : [],
															dataType : "json",
															success : function(
																	json) {
																if (json) {
																	for ( var i = 0; i < json.length; i++) {
																		arr
																				.push(json[i].itemName);
																	}
																}
															}
														});
												return arr;
											})()
										},
			series : [ {
				name : '考试成绩情况',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : (function() {
												var arr = [];
												$
														.ajax({
															type : "post",
															async : false,
															url:"getChartData/score.do?exam_id=${examStatistics.examInformation.examId }",
															data : [],
															dataType : "json",
															success : function(
																	json) {
																if (json) {
																	for ( var i = 0; i < json.length; i++) {
																		arr
																				.push({
																					name : json[i].itemName,
																					value : json[i].itemData
																				});
																	}
																}
															}
														});
												return arr;
											})(),
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};

		var radarchart = echarts.init(document.getElementById("radar"));

		radaroption = {
			title : {
				text : '完成时间情况',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
											orient : "vertical",
											x : "right",
											data : (function() {
												var arr = [];
												$.ajax({
															type : "post",
															async : false,
															url:"getChartData/time.do?exam_id=${examStatistics.examInformation.examId }",
															data : [],
															dataType : "json",
															success : function(
																	json) {
																if (json) {
																	for ( var i = 0; i < json.length; i++) {
																		arr
																				.push(json[i].itemName);
																	}
																}
															}
														});
												return arr;
											})()
										},
			series : [ {
				name : '完成时间访问',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : (function() {
												var arr = [];
												$
														.ajax({
															type : "post",
															async : false,
															url:"getChartData/time.do?exam_id=${examStatistics.examInformation.examId }",
															data : [],
															dataType : "json",
															success : function(
																	json) {
																if (json) {
																	for ( var i = 0; i < json.length; i++) {
																		arr
																				.push({
																					name : json[i].itemName,
																					value : json[i].itemData
																				});
																	}
																}
															}
														});
												return arr;
											})(),
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};
		
		//考试及格率情况
		var barchart = echarts.init(document.getElementById("bar"));
		baroption = {
			title : {
				text : '考试及格率情况',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
											orient : "vertical",
											x : "right",
											data : (function() {
												var arr = [];
												$.ajax({
															type : "post",
															async : false,
															url:"getChartData/pass.do?exam_id=${examStatistics.examInformation.examId }",
															data : [],
															dataType : "json",
															success : function(
																	json) {
																if (json) {
																	for ( var i = 0; i < json.length; i++) {
																		arr
																				.push(json[i].itemName);
																	}
																}
															}
														});
												return arr;
											})()
										},
			series : [ {
				name : '及格率情况',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : (function() {
												var arr = [];
												$
														.ajax({
															type : "post",
															async : false,
															url:"getChartData/pass.do?exam_id=${examStatistics.examInformation.examId }",
															data : [],
															dataType : "json",
															success : function(
																	json) {
																if (json) {
																	for ( var i = 0; i < json.length; i++) {
																		arr
																				.push({
																					name : json[i].itemName,
																					value : json[i].itemData
																				});
																	}
																}
															}
														});
												return arr;
											})(),
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};

		piechart.setOption(pieoption);

		radarchart.setOption(radaroption);

		barchart.setOption(baroption);

	});
</script>


</head>



<body
	class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">

	<jsp:include page="headbar.jsp"></jsp:include>

	<jsp:include page="sidebar.jsp"></jsp:include>

	<!-- Main content -->
	<main class="main"> <!-- Breadcrumb -->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="index.jsp">首页</a></li>
		<li class="breadcrumb-item"><a href="exam_index.jsp">考试</a></li>
		<li class="breadcrumb-item active">成绩统计</li>

	</ol>

	<!-- 正文 -->
	<div class="container-fluid">
		<div class="animated fadeIn">

			<div class="card">

				<div class="card-header">
					<h4>
						考试名: <strong> ${examStatistics.examInformation.examName },${examStatistics.examInformation.examId }
							<span class="greenNumber">(${examStatistics.examInformation.examStatus
								})</span> </strong> <a href="#" style="font-size:13px;margin-left:10px">查看考试信息</a>
						<span style="float:right"> <a type="button"
							href="exam_index.jsp" class="btn btn-outline-primary">返&nbsp;回</a>
						</span>
					</h4>
				</div>
				<div class="card-block">

					<div class="card-group">
						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-people"></i>
								</div>
								<div class="h4 mb-0">
									考试次数: <span class="importantNumber">${examStatistics.examCount
										}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">占总考试次数:
									<span class="greenNumber">25%</span> </small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar bg-info" role="progressbar"
										style="width: 25%" aria-valuenow="25" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-people"></i>
								</div>
								<div class="h4 mb-0">
									考生人数: <span class="importantNumber">${examStatistics.examStudentCount}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">占总考生数:
									<span class="greenNumber">25%</span> </small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar bg-info" role="progressbar"
										style="width: 25%" aria-valuenow="25" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-user-follow"></i>
								</div>
								<div class="h4 mb-0">
									及格次数: <span class="importantNumber">${examStatistics.examPassCount
										}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">及格率:
									<span class="greenNumber">${examStatistics.examPassRate
										}%</span> </small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar bg-success" role="progressbar"
										style="width: ${examStatistics.examPassRate }%"
										aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-basket-loaded"></i>
								</div>
								<div class="h4 mb-0">
									挂科次数: <span class="importantNumber">${examStatistics.examNoPassCount
										}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">挂科率
									<span class="greenNumber">${examStatistics.examNoPassRate}%</span>
								</small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar bg-warning" role="progressbar"
										style="width: ${examStatistics.examNoPassRate}%"
										aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-pie-chart"></i>
								</div>
								<div class="h4 mb-0">
									及格人数: <span class="importantNumber">5</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">占总参考考生数:
									<span class="greenNumber">7</span> </small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar" role="progressbar" style="width: 25%"
										aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>

					</div>

					<div class="card-group">
						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-people"></i>
								</div>
								<div class="h5 mb-0">
									考试最高分: <span class="importantNumber">${examStatistics.highestScore
										}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">占总分的:
									<span class="greenNumber">${examStatistics.highestScoreScale}%</span>
								</small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar bg-info" role="progressbar"
										style="width:${examStatistics.highestScoreScale}%"
										aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-user-follow"></i>
								</div>
								<div class="h5 mb-0">
									考试最低分: <span class="importantNumber">${examStatistics.lowestScore
										}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">占总分的:
									<span class="greenNumber">${examStatistics.lowestScoreScale
										}%</span> </small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar bg-success" role="progressbar"
										style="width:${examStatistics.lowestScoreScale }%"
										aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-basket-loaded"></i>
								</div>
								<div class="h5 mb-0">
									考试平均分: <span class="importantNumber">${examStatistics.avarageScore
										}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">占总分的
									<span class="greenNumber">${examStatistics.avarageScoreScale
										}%</span> </small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar bg-warning" role="progressbar"
										style="width:${examStatistics.avarageScoreScale}%"
										aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>

						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-pie-chart"></i>
								</div>
								<div class="h5 mb-0">
									最快用时(分): <span class="importantNumber">${examStatistics.fastestFinishTime
										}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">占考试时长:
									<span class="greenNumber">${examStatistics.fastestFinishTimeScale
										}%</span> </small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar" role="progressbar"
										style="width: ${examStatistics.fastestFinishTimeScale}%"
										aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-speedometer"></i>
								</div>
								<div class="h5 mb-0">
									最慢用时(分): <span class="importantNumber">${examStatistics.slowestFinishTime
										}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">占考试时长:
									<span class="greenNumber">${examStatistics.slowestFinishTimeScale}%</span>
								</small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar bg-danger" role="progressbar"
										style="width:${examStatistics.slowestFinishTimeScale}%"
										aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>

						<div class="card">
							<div class="card-block">
								<div class="h1 text-muted text-right mb-2">
									<i class="icon-speedometer"></i>
								</div>
								<div class="h5 mb-0">
									平均用时(分): <span class="importantNumber">${examStatistics.avarageFinishTime
										}</span>
								</div>
								<small class="text-muted text-uppercase font-weight-bold">占考试时长:
									<span class="greenNumber">${examStatistics.avarageFinishTimeScale}%</span>
								</small>
								<div class="progress progress-xs mt-1 mb-0">
									<div class="progress-bar bg-danger" role="progressbar"
										style="width:${examStatistics.avarageFinishTimeScale}%"
										aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

			<div class="card">

				<div class="card-header">
					<span class="h5">综合排名</span>
				</div>
				<div class="card-block">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#all" role="tab" aria-controls="home">所有考试</a>
						</li>
						<li class="nav-item" class="unstartBtn"><a class="nav-link"
							data-toggle="tab" href="#pro" role="tab" aria-controls="profile">同职业考试</a>
						</li>
					</ul>
					

					<div class="tab-content">

						<div class="tab-pane active" id="all" role="tabpanel">

							<table class="table table-hover table-condensed ">

								<thead>
									<th></th>
									<th>考试次数</th>
									<th>最高分</th>
									<th>合格率</th>
									<th>平均分</th>
									<th>最快完成时间</th>
									<th>平均完成时间</th>
								</thead>
								<tbody>
									<td>排名</td>
									<td>${examStatistics.examTimeRank }</td>
									<td>${examStatistics.highestScoreRank}</td>
									<td>${examStatistics.passScaleRank}</td>
									<td>${examStatistics.avarageScoreRank }</td>
									<td>${examStatistics.fastestFinishRank }</td>
									<td>${examStatistics.avarageFinishRank }</td>
								</tbody>

							</table>

						</div>

						<div class="tab-pane" id="pro" role="tabpanel">

							<table class="table table-hover table-condensed ">

								<thead>
									<th></th>
									<th>考试次数</th>
									<th>最高分</th>
									<th>合格率</th>
									<th>平均分</th>
									<th>最快完成时间</th>
									<th>平均完成时间</th>
								</thead>
								<tbody>
									<td>排名</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
								</tbody>

							</table>

						</div>

					</div>

				</div>

			</div>


			<div class="col-md-12">
				<ul class="nav nav-tabs" role="tablist">
					<li class="nav-item"><a class="nav-link active startedBtn"
						data-toggle="tab" href="#home" role="tab" aria-controls="home">考生记录</a>
					</li>
					<li class="nav-item" class="unstartBtn"><a class="nav-link"
						data-toggle="tab" href="#profile" role="tab"
						aria-controls="profile">数据统计</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane active" id="home" role="tabpanel">
						<table class="table table-hover table-outline mb-0 hidden-sm-down">
							<thead class="thead-default">
								<tr>
									<th style="text-align: center;"><i class="icon-people"></i>
										考生姓名</th>
									<th class="text-center"><i class="icon-speedometer"></i>
										开始时间/交卷时间</th>
									<th style="text-align: center;">考试用时(分钟 )</th>
									<th style="text-align: center;">总/及格分</th>
									<th style="text-align: center;">成绩</th>
									<th style="text-align: center;">是否合格</th>
									<th style="text-align: center;">考试方式</th>
									<th style="text-align: center;">排名</th>
									<th style="text-align: center;">操作</th>
								</tr>
							</thead>
							
							<tbody id="studentRecord">
								
							<c:forEach items="${records}" var="record">
							  	<tr>
									<td style="text-align: center;">${record.user.userName }</td>
									<td style="text-align: center;">${record.startTime} ~ ${record.finishTime }</td>
									<td style="text-align: center;">${record.duringTime }</td>
									<td style="text-align: center;"><span class="greenNumber">${record.exam.examScore }</span>/<span
										class="redNumber">${record.exam.examPassScore }</span>
									</td>
									<td style="text-align: center;">100</td>
									<td style="text-align: center;">
										<c:choose>
											<c:when test="${record.pass}">
												<i class="fa fa-check fa-lg bg-success"></i>
											</c:when>
											<c:otherwise>
												<i class="fa fa-remove fa-lg bg-danger"></i>
											</c:otherwise>
										</c:choose>
										
									</td>
									<td style="text-align: center;">电脑</td>
									<td style="text-align: center;">1</td>
									<td style="text-align: center;"><a href="#">查看答卷</a> | <a
										href="#">手工评卷</a></td>
								</tr>
							  </c:forEach>


							</tbody>
							
						</table>
						
						<div class="ps0" style="float:right;">

								<span>${sessionScope.StudentRecordPage.pageNum }/${sessionScope.StudentRecordPage.pages}</span>
								<c:choose>
									<c:when test="${sessionScope.StudentRecordPage.hasPreviousPage}">
										<span> <a href="getStudentRecords.do?exam_id=${exam_id}&pageNum=1">首页</a> </span>
										<span> <a
											href="getStudentRecords.do?exam_id=${exam_id}&pageNum=${sessionScope.StudentRecordPage.prePage }">上一页</a>
										</span>
									</c:when>
									<c:otherwise>
										<span>首页 </span>
										<span>上一页</span>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${sessionScope.StudentRecordPage.hasNextPage}">
										<span><a
											href="getStudentRecords.do?exam_id=${exam_id}&pageNum=${sessionScope.StudentRecordPage.nextPage }">下一页</a>
										</span>
										<span><a
											href="getStudentRecords.do?exam_id=${exam_id}&pageNum=${sessionScope.StudentRecordPage.pages }">尾页</a>
										</span>
									</c:when>
									<c:otherwise>
										<span>下一页 </span>
										<span>尾页</span>
									</c:otherwise>
								</c:choose>

								<span> <select id="pageNum" onchange="pageNum()">
										<c:forEach var="index" begin="1"
											end="${sessionScope.StudentRecordPage.pages }">
											<c:choose>
												<c:when test="${sessionScope.StudentRecordPage.pageNum==index }">
													<option value="${index }" selected="selected">${index}</option>
												</c:when>
												<c:otherwise>
													<option value="${index }">${index}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>
								</select> </span>

							</div>
						
						
<%-- 						<nav>
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#">Prev</a></li>
								<li class="page-item"><a class="page-link" href="exam_examStatistics.jsp?pageNum=${StudentRecordPage.nextPage }">Next</a></li>
							</ul>
						</nav> --%>

						<div class="btn-group" style="text-align: right;">
							<center>
								<button type="button" class="btn btn-secondary">按考试时间排序</button>
								<button type="button" class="btn btn-secondary">按排名排序</button>
							</center>
						</div>


					</div>
					<div class="tab-pane" id="profile" role="tabpanel">

						<div id="pie"
							style="width:350px;height:400px;display:inline-block; "></div>

						<div id="radar"
							style="width:350px;height:400px;display:inline-block; "></div>

						<div id="bar"
							style="width:350px;height:400px;display:inline-block; "></div>


					</div>

				</div>
			</div>




		</div>

	</div>
	<!-- /.conainer-fluid --> </main>

	<jsp:include page="asidemenu.jsp"></jsp:include>


	</div>


	<jsp:include page="footer.jsp"></jsp:include>

	<!--不能删除而且必须放到最后  否则sidebar不能展开动态效果 -->
	<!-- Bootstrap and necessary plugins -->

	<script src="bower_components/tether/dist/js/tether.min.js"></script>

	<script src="bower_components/pace/pace.min.js"></script>

	<!-- Plugins and scripts required by all views -->
	<!-- GenesisUI main scripts -->
	<script src="js/app.js"></script>
	<!-- Plugins and scripts required by this views -->
	<!-- Custom scripts required by this view -->
	<script src="js/views/main.js"></script>
	<!--不能删除而且必须放到最后   否则sidebar不能展开动态效果 -->
</body>

</html>