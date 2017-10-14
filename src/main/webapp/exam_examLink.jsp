<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

.req{

	color:red;

}

.tip{

	color:lightgray;
	margin-top:10px;

}

.greenNumber {
	color: green;
}

</style>


<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="bower_components/layer/layer.js"></script>

<script type="text/javascript">
	$(function() {
	

		
	});
</script>


</head>



<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">
		
	<jsp:include page="headbar.jsp"></jsp:include>
	<jsp:include page="sidebar.jsp"></jsp:include>

        <!-- Main content -->
        <main class="main">

            <!-- Breadcrumb -->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                		<a href="index.jsp">首页</a>
                </li>
                <li class="breadcrumb-item active">
                		<a href="exam_index.jsp">考试</a>
                </li>
				<li class="breadcrumb-item active">
						预览考试
				</li> 
            </ol>

	<!-- Main content -->
	
	<div class="container" >
	<!-- 正文 -->
	<div class="container-fluid">
		<div class="animated fadeIn">
			
			<div class="container">
			<div class="card">

				<div class="card-block" id="examPartContentArea">
				
						
						<div class="card">
						
						<div class="card-header">
							
							<div class="h4">
								<span style="text-weight:600"><strong>${exam.examName }</strong></span>
							</div>
						
						</div>
							<div class="card-block">
							
								<div class="form-group row">
								
									<label class="col-md-2 form-control-label" style="margin-left:30px">
										考试开放时间
									</label>
									
									<div class="col-md-7">
										<label class="form-control-label">
											${exam.examStartTime } ~ ${exam.examEndTime }
										</label>
									</div>
								</div>
							
							    <div class="form-group row">
								
									<label class="col-md-2 form-control-label" style="margin-left:30px">
										开始时间
									</label>
									
									<div class="col-md-7">
										<label class="form-control-label">
											2017-05-30 18:21
										</label>
									</div>
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-2 form-control-label" style="margin-left:30px">
										结束时间
									</label>
									
									<div class="col-md-7">
										<label class="form-control-label">
											2017-05-30 19:21
										</label>
									</div>
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-2 form-control-label" style="margin-left:30px">
										试卷分数
									</label>
									
									
									<div class="col-md-7">
										<label class="form-control-label">
											${exam.examScore }分
										</label>
									</div>
								</div>								
							
								<div class="form-group row">
								
									<label class="col-md-2 form-control-label" style="margin-left:30px">
										及格分数
									</label>
									
									<div class="col-md-7">
										<label class="form-control-label">
											${exam.examPassScore }分
										</label>
									</div>
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-2 form-control-label" style="margin-left:30px">
										考试时长
									</label>
									
									<div class="col-md-7">
										<label class="form-control-label">
											${exam.examDuration }分钟
										</label>
									</div>
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-2 form-control-label" style="margin-left:30px">
										注意事项
									</label>
									
									<div class="col-md-7">
										${exam.examNotice }
									</div>
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-2 form-control-label" style="margin-left:30px">
										考试口令
									</label>
									
									<div class="col-md-7">
											<input id="input_examName" type="text" class="form-control" value="${exam.examPassword }" readonly="readonly" />
											<span class="help-block tip">
												必须填写正确考试口令才能参加考试
											</span>
									</div>
								</div>																													

							</div>
						
						</div>
						
						<div class="card-footer">
							<center>
                               <button id="nextBtn" type="submit" class="btn  btn-primary" style="color:white" >
                              		预览试卷
                              </button>
                            </center>

                        </div>
				</div>

			</div>
		</div>

		</div>
		</div>
		</div>
		<!-- /.conainer-fluid -->

	<!--不能删除而且必须放到最后  否则sidebar不能展开动态效果 -->
	<!-- Bootstrap and necessary plugins -->

	<script src="bower_components/tether/dist/js/tether.min.js"></script>

	<script src="bower_components/pace/pace.min.js"></script>

	<!-- Plugins and scripts required by all views -->
	<script src="bower_components/chart.js/dist/Chart.min.js"></script>
	<!-- GenesisUI main scripts -->
	<script src="js/app.js"></script>
	<!-- Plugins and scripts required by this views -->
	<!-- Custom scripts required by this view -->
	<script src="js/views/main.js"></script>
	<!--不能删除而且必须放到最后   否则sidebar不能展开动态效果 -->
</body>

</html>