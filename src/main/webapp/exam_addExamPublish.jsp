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

<script type="text/javascript">
	$(function() {

		$(".startedBtn").click(function() {

			alert("1");

		});

		$(".unstartBtn").click(function() {

			alert("2");
		})

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

		<li class="breadcrumb-item"><a href="index.jsp">首页</a>
		</li>
		<li class="breadcrumb-item"><a href="exam_index.jsp">考试</a>
		</li>
		<li class="breadcrumb-item active">增加考试</li>

	</ol>

	<!-- 正文 -->
	<div class="container-fluid">
		<div class="animated fadeIn">
			
			
			<div class="card">
				<div class="card-header">

					<div class="row">
						<div class="col-sm-4">
							<div class="callout">
								<center>
									<strong class="h3">1.填写考试信息</strong>
								</center>
							</div>
						</div>
						<!--/.col-->
						<div class="col-sm-4">
							<div class="callout">
								<center>
									<strong class="h3">2.创建试卷</strong>
								</center>
							</div>
						</div>
						<!--/.col-->
						<div class="col-sm-4 card-primary">
							<div class="callout">
								<center>
									<strong class="h3" style="color:white">3.发布考试</strong>
								</center>
							</div>
						</div>
					</div>
				</div>
				<div class="card-block" id="examPartContentArea">
				
					<form class="form-horizontal" method="post" action="">
						
						<div class="card">
						
						<div >
                            <div class="social-box linkedin">
                            
                            <div class="card card-inverse card-primary">
                                <div class="card-block">
                                    <div class="h4 m-0">成功创建考试!请通过以下方式发布</div>
                                </div>
                            </div>
                            
                                <ul>
                                    <li style="width:33%">
                                       <strong class="h4">复制考试二维码</strong>
                                    <div class="btn-group">
                                        <button type="button" style="display:inline-block;" class="btn btn-default active dropdown-toggle p-0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <img src=${exam.examQcodeUrl } width="150" height="150" />
                                        </div>
                                    </div>
                                    </li>
                                    <li style="width:33%;">
                                        <strong class="h4">发送考试通知</strong>
                                     
	                                     <div class="btn-group">
	                                        <button type="button" style="display:inline-block;" class="btn btn-default active dropdown-toggle p-0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                                        </button>
	                                        <div class="dropdown-menu dropdown-menu-right">
	                                            <a class="dropdown-item" href="#">发送通知邮件</a>
                                            	<a class="dropdown-item" href="#">发送通知短信</a>
	                                        </div>
	                                    </div>
                                    </li>
                                    
                                     <li style="width:33%">
                                         <strong class="h4">复制考试链接</strong>
                                       	  <div class="btn-group">
	                                        <button type="button" style="display:inline-block;" class="btn btn-default active dropdown-toggle p-0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                                        </button>
	                                        <div class="dropdown-menu dropdown-menu-right">
													
													<center>
														<strong>考试链接:</strong>
													</center>
													<a href="${exam.examUrl }"><c:out value="${exam.examUrl }"></c:out></a> 
	                                        </div>
	                                    </div>
                                    </li>
                                    
                                </ul>
                            </div>
                            <!--/social-box-->
                        </div>
						
						
						<div class="card-footer">
							<center>
                              <a  class="btn btn-lg btn-success" id="backBtn" href="exam_index.jsp" style="color:white">
                              		<i class="fa fa-dot-circle-o"></i>
                              	 	返回考试列表
                              </a>
                             <!--  <button type="reset" class="btn btn-lg btn-danger"><i class="fa fa-ban"></i>重置信息</button> -->
                            </center>
                        </div>
							
						</div>
						
					
					</form>
					
				</div>

			</div>
			
			</div>


		</div>
		<!-- /.conainer-fluid -->
	</main>

	<jsp:include page="asidemenu.jsp"></jsp:include>


	</div>

	<jsp:include page="footer.jsp"></jsp:include>

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