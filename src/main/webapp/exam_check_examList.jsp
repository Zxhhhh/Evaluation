<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link href="css/exam.css" rel="stylesheet">

<style type="text/css">
.importantNumber {
	color: red;
}

.greenNumber {
	color: green;
}
</style>

<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function() {
	
		

		//一进入页面执行的方法
		$.ajax({



		});

		$(".paginationBtn").click(function() {
		
			$.ajax({
			
				async:true,
				type:"post",
				url:"getExamsBySelect_ajax.do",
			
			
			});


		});

	});
</script>


</head>

<body class="app header-fixed sidebar-fixed aside-menu-fixed">

	<div class="row" id="listPlace">

		<c:forEach items="${requestScope.exams}" var="exam">

			<div class="col-sm-6 col-md-3">
				<c:choose>
					<c:when test="${exam.examStatus=='未开始' }">
						<div class="card card-accent-primary">
					</c:when>
					<c:when test="${exam.examStatus=='进行中' }">
						<div class="card card-accent-success">
					</c:when>
					<c:when test="${exam.examStatus=='已结束' }">
						<div class="card card-accent-warning">
					</c:when>
					<c:otherwise>
						<div class="card card-accent-danger">
					</c:otherwise>			
				</c:choose>				
				<!-- success primary warning danger -->
				
					<div class="card-block p-1 clearfix">
						<div class="btn-group float-right">
							<button type="button" class="btn   dropdown-toggle p-0"
								style="background-color: white" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">
								<i class="icon-settings"></i>
							</button>
							<div class="dropdown-menu dropdown-menu-right">
								<a class="dropdown-item" href="#">查看考试</a> <a
									class="dropdown-item" href="#">编辑考试</a> <a
									class="dropdown-item" href="#">查看成绩</a> <a
									class="dropdown-item" href="#">删除考试</a>
							</div>
						</div>
						
						<c:choose>
							<c:when test="${exam.examStatus=='未开始' }">
								<i class="fa fa-list-alt  bg-primary p-1 font-2xl mr-1 float-left"></i>
							</c:when>
							<c:when test="${exam.examStatus=='进行中' }">
								<i class="fa fa-list-alt  bg-success p-1 font-2xl mr-1 float-left"></i>
							</c:when>
							<c:when test="${exam.examStatus=='已结束' }">
								<i class="fa fa-list-alt  bg-warning p-1 font-2xl mr-1 float-left"></i>
							</c:when>
							<c:otherwise>
								<i class="fa fa-list-alt  bg-danger p-1 font-2xl mr-1 float-left"></i>
							</c:otherwise>			
						</c:choose>	
						
						<!-- <i class="fa fa-list-alt  bg-success p-1 font-2xl mr-1 float-left"></i> -->
						<div class="h4 mb-0 mt-h">
							<strong>${exam.examName}</strong>
						</div>
						<div class="text-muted text-uppercase font-weight-bold font-xs">
							创建时间:${exam.createTime }<a>点击查看</a>
						</div>
					</div>
					<div class="card-footer px-1 py-h">
						<span class="font-weight-bold font-xs btn-block text-muted"
							href="#">
							<center>考试信息</center> </span>
						<hr class="mx-1 my-0">
						<div class="col-md-12">
							<span>考试时长：${exam.examDuration}分钟</span>
						</div>
						<div class="col-md-12">
							<span>考试总分：<span class='greenNumber'>${exam.examScore
									}</span> 分&nbsp;</span>
						</div>
						<div class="col-md-12">
							<span>及格分数：<span class='importantNumber'>${exam.examPassScore
									}</span> 分</span>
						</div>
						<div class="col-md-12">
							<span>开始时间：<strong>${exam.examStartTime }</strong>
							</span>
						</div>
						<div class="col-md-12">
							<span>结束时间：<strong>${exam.examEndTime }</strong>
							</span>
						</div>
					</div>
				</div>
			</div>

		</c:forEach>

	</div>




<!-- 	<script src="bower_components/tether/dist/js/tether.min.js"></script>

	<script src="bower_components/pace/pace.min.js"></script>

	<script src="bower_components/chart.js/dist/Chart.min.js"></script>
	<script src="js/app.js"></script>
	<script src="js/views/main.js"></script> -->
	<!--不能删除而且必须放到最后   否则sidebar不能展开动态效果 -->
</body>

</html>