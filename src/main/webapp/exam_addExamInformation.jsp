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

<link rel="stylesheet" href="bower_components/calendar/css/cxcalendar.css">
<link rel="shortcut icon" href="img/favicon.png">

<title>新增/编辑 考试</title>

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


<script src="bower_components/calendar/jquery-1.9.1.js"></script>
<script src="bower_components/calendar/calendar.js"></script>
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
		<li class="breadcrumb-item active">增加/编辑 考试</li>

	</ol>

	<!-- 正文 -->
	<div class="container-fluid">
		<div class="animated fadeIn">
			
			
			<div class="card">
				<div class="card-header">

					<div class="row">
						<div class="col-sm-4 card-primary" >
							<div class="callout">
								<center>
									<strong class="h3" style="color:white">1.填写考试信息</strong>
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
						<div class="col-sm-4">
							<div class="callout">
								<center>
									<strong class="h3">3.发布考试</strong>
								</center>
							</div>
						</div>
					</div>
				</div>
				<div class="card-block" id="examPartContentArea">
					
					<c:choose>
						<c:when test="${exam==null }">
							<form class="form-horizontal" method="post" action="addExam_Information.do">
						</c:when>
						<c:otherwise>
							<form class="form-horizontal" method="post" action="updateExam_Information.do">
								
								<input type="hidden" name="exam_id" value="${exam.examId }" />
								
						</c:otherwise>
					</c:choose>
					
					
					
						
						<!-- 1.考试信息 -->
						<div class="card">
						
							<div class="card-header">
								<i class="icon-calculator"></i>
								<span>(1)<strong> 设置考试基本信息</strong></span>
							</div>
							<div class="card-block">
							
								<div class="form-group row">
									<label class="col-md-1  form-control-label" for="input_examName" style="margin-left:30px">
										<span class="req">*</span>
										考试名称
									</label>
									<div class="col-md-7">
										<input id="input_examName" type="text" class="form-control" name="exam_name" value="${exam.examName }" />
										<span class="help-block tip">
											必须填写
										</span>
									</div>
								</div>
								
								<div class="form-group row">
									<label class="col-md-1  form-control-label" for="input_examStartTime" style="margin-left:30px">
										<span class="req">*</span>
										考试时间
									</label>
									<div class="col-md-3">
									
										<div class="input-group">
                                              <input id="input_examStartTime" name="exam_start_time" class="form-control" value="${exam.examStartTime }" placeholder="开始时间" type="text" required="required">
                                              <span class="input-group-addon">
                                              	<i class="fa fa-calendar"></i>
                                              </span>
                                        </div>
                                        <script>
											$('#input_examStartTime').each(function(){
												var a = new Calendar({
													targetCls: $(this),
													type: 'yyyy-mm-dd HH:MM:SS',
													wday:2
												},function(val){
													console.log(val);
												});
											});
										</script>
                                        
                                        <span class="help-block tip">
											允许考生参与考试的时间段
										</span>
                                    </div>
									<i class="fa fa-arrow-right" style="margin-top:10px"></i>                              
                                    <div class="col-md-3">    
                                       <div class="input-group">
                                              <input id="input_examEndTime" name="exam_end_time" class="form-control" value="${exam.examEndTime }" placeholder="结束时间" type="text" required="required">
                                              <span class="input-group-addon">
                                              	<i class="fa fa-calendar"></i>
                                              </span>
                                        </div>

                                    </div>
										
								</div>
								<script>
									$('#input_examEndTime').each(function(){
										var a = new Calendar({
											targetCls: $(this),
											type: 'yyyy-mm-dd HH:MM:SS',
											wday:2
										},function(val){
											console.log(val);
										});
									});
								</script>
								
								<div class="form-group row">
								
									<label class="col-md-1  form-control-label" for="input_examContinued " style="margin-left:40px">
										考试时长
									</label>
									
									<div class="col-md-7">
										
										<div class="input-group">
											
											<input id="input_examContinued" type="text" class="form-control" name="exam_duration" value="${exam.examDuration }" required="required"  />
											<span class="input-group-addon">
												分钟
											</span>
										</div>
										<span class="help-block tip">
											考试时长,默认为60分钟
										</span>								
									
									</div>
								
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-1 form-control-label" for="input_examScore" style="margin-left:40px">
										总分										
									</label>
									
									<div class="col-md-7">
										
										<div class="input-group">
											
											<input id="input_examContinued" type="text" class="form-control" name="exam_score" value="${exam.examScore }" required="required" />
											<span class="input-group-addon">
												分
											</span>
										</div>
										<span class="help-block tip">
											设置考试总分
										</span>								
									
									</div>
								
								</div>									
								
								<div class="form-group row">
								
									<label class="col-md-1 form-control-label" for="input_examScore" style="margin-left:40px">
										及格分数										
									</label>
									
									<div class="col-md-7">
										
										<div class="input-group">
											
											<input id="input_examContinued" type="text" class="form-control" name="exam_pass_score" value="${exam.examPassScore}" required="required" />
											<span class="input-group-addon">
												分
											</span>
										</div>
										<span class="help-block tip">
											设置考试的及格分数,推荐为总分的60%
										</span>								
									
									</div>
								
								</div>
								
							</div>
						
						</div>
						
						<!-- 2.考生授权 -->
						<div class="card">
						
							<div class="card-header">
								<i class="icon-lock-open "></i>
								<span>(2)<strong> 设置考生授权方式</strong></span>							
							</div>
							
							<div class="card-block">
							
								<div class="form-group row">
								
									<label class="col-md-1 form-control-label" for="input_authWay" style="margin-left:30px">
										<span class="req">*</span>
										授权方式									
									</label>
									
									<div class="col-md-7">
									
										<div class="radio">
                                          <label for="input_authWay">
                                              <input id="needCommand"  value="y" name="exam_needPassword" type="radio" checked="checked" >
                                                                                    考生须输入口令才可参加考试(防止陌生人参加)
                                          </label>
                                       </div>
<!--                                        <div class="radio">
                                          <label for="input_authWay">
                                              <input id="noCommand"  value="n" name="exam_needPassword" type="radio">
                                               	公开考试,不需要授权
                                          </label>
                                       </div> -->
									</div>
								</div>
								
								<div class="form-group row" id="commandPart">
								
									<label class="col-md-1 form-control-label" for="input_authCode" style="margin-left:30px" required="required">
										<span class="req">*</span>
										考试口令								
									</label>
									<div class="col-md-7">
										
										<div class="input-group">
                                            <input id="input_authCode" name="exam_password" class="form-control" value="${exam.examPassword }"  size="6" type="text">
                                            <span class="input-group-btn">
                                               <button class="btn btn-default" type="button">生成口令</button>
                                            </span>
                                         </div>
                                         <span class="help-block tip">
											考生必须填写6位口令才能参加考试,口令可自己设定或系统生成
										</span>
									</div>
								</div>
							</div>
						</div>
						
						<!-- 3.其他设置 -->
						<div class="card">
						
							<div class="card-header">
								<i class="icon-note"></i>
								<span>(3)<strong> 设置考试规则</strong></span>							
							</div>
							
							<div class="card-block">
								
								<div class="form-group row">
								
									<label class="col-md-1 form-control-label" for="check_allSubmit" style="margin-left:30px">
										<span class="req">*</span>
										其他设置								
									</label>
									
									<div class="col-md-4">
									
										<label class="switch switch-icon switch-primary">
	                                       
	                                       <c:choose>
	                                       	<c:when test="${exam.examCompleted=='on' }">
	                                       		<input id="check_allSubmit" class="switch-input" name="exam_completed" checked="checked" type="checkbox">
	                                       	</c:when>
	                                       	<c:when test="${exam.examCompleted=='off' }">
	                                       		<input id="check_allSubmit" class="switch-input" name="exam_completed" type="checkbox">
	                                       	</c:when>
	                                       	<c:otherwise>
	                                       		<input id="check_allSubmit" class="switch-input" name="exam_completed" checked="checked" type="checkbox">
	                                       	</c:otherwise>
	                                       </c:choose>
	                                        
	                                       
	                                       
	                                        <span class="switch-label" data-on="" data-off=""></span>
	                                        <span class="switch-handle"></span>
	                                    </label>
	                                    <label for="check_allSubmit">必须完成所有答题才可提交试卷</label>
									
									</div>
									
									<div class="col-md-4">
									
										<label class="switch switch-icon switch-primary">
	                                       
	                                       <c:choose>
	                                       
		                                       	<c:when test="${exam.checkAns=='on'}">
		                                       		<input id="check_allowCheckAnswer" class="switch-input" name="check_ans" checked="" type="checkbox">
		                                       	</c:when>
		                                       	<c:when test="${exam.checkAns=='off' }">
		                                       		<input id="check_allowCheckAnswer" class="switch-input" name="check_ans"  type="checkbox">
		                                       	</c:when>
		                                       	<c:otherwise>
		                                       		<input id="check_allowCheckAnswer" class="switch-input" name="check_ans" checked="" type="checkbox">
		                                       	</c:otherwise>
	                                       
	                                       </c:choose>
	                                       
	                                       
	                                       
	                                        <span class="switch-label" data-on="" data-off=""></span>
	                                        <span class="switch-handle"></span>
	                                    </label>
	                                    <label for="check_allSubmit">考生交卷后允许查看答案和试题解析</label>
									
									</div>
								
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-1 form-control-label" for="textarea_examNotice" style="margin-left:40px">
										考试须知								
									</label>
									<div class="col-md-7">
										<textarea id="textarea_examNotice" name="exam_notice" rows="7" class="form-control"  placeholder="如:考试不准借助网络">${exam.examNotice }</textarea>
									</div>
								
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-1 form-control-label" style="margin-left:40px">
										及格提示
									</label>
									
									<div class="col-md-7">
										<textarea id="textarea_examNotice" name="exam_pass_tips" rows="3" class="form-control" >${exam.examPassTips}</textarea>
									</div>
								
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-1 form-control-label" style="margin-left:40px">
										挂科提示
									</label>
									
									<div class="col-md-7">
										<textarea id="textarea_examNotice" name="exam_nopass_tips" rows="3" class="form-control" >${exam.examNopassTips}</textarea>
									</div>
								
								</div>
								
							
							</div>
						
						
						</div>
						
						<div class="card-footer">
							<center>
                              <button id="nextBtn" type="submit" class="btn btn-lg btn-success" style="color:white" >
                              		<i class="fa fa-dot-circle-o"></i> 保存&下一步(固定试卷)
                              </button>
                            </center>
                        </div>
					
					</form>
					
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