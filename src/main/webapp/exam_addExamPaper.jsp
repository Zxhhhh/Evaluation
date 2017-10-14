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
<script src="bower_components/layer/layer.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<script src="bower_components/calendar/calendar.js"></script>

<script type="text/javascript">
	$(function() {
		
		alert("${paper_id}");
	
		//大题题数
		var partId = 1;
		
		//试卷id
		var paperId = "${requestScope.paper_id}";
		
		alert(paperId);

		
		var scoreCount = 0;
		
		
		$.ajax({
			async:true,
			type:"post",
			url:"getBigquestions.do",
			data:{paper_id:paperId},
			dataType:"json",
			success:function(bigquestionJson){
				
				
				
				$.each(bigquestionJson,function(index,content){
				
					var tbodyId = content.paperId+""+content.bigquestionN+"tbody";
					
					var questionCountId = content.paperId+""+content.bigquestionN+"questionCount";
					
					var bigquestion_id = content.bigquestionId;
					
					var question_ids = content.questionIds;
					
					//alert(tbodyId);
				
					var examPartContentArea = $("#examPartContentArea");
					
					var newPart = "<div class='card' id='"+content.bigquestionN+"part'>"
			                		+"<div class='card-header'>"
									+"<i class='fa fa-align-justify'></i>"
									+"<span class='h6'>第 <strong class='partId'>"+partId+"</strong> 大题</span>"
									+"<span style='font-size: 12px;'>"
										+"（<em  style='color: red; font-size: 14px;' id='"+questionCountId+"' >0</em>  道试题，共 <em  style='color: red; font-size: 14px;'>"+content.bigquestionScore+"</em> 分）"
									+"</span>"
									+"<div class='float-right'>"
		                                    +"<button type='button' class='btn btn-sm btn-outline-primary addExaminationQuestionBtn' lang='"+content.bigquestionId+"'><i class='icon-plus'></i>&nbsp; 新增试题</button> "
		                                    +"<button type='button' class='btn btn-sm btn-outline-primary addMoreExaminationQuestionsBtn' lang='"+content.bigquestionId+"'><i class='fa fa-magic'></i>&nbsp; 批量新增</button> "
		                                    +"<button type='button' class='btn btn-sm btn-outline-primary chooseExaminationQuestionsFromRepertoryBtn' lang='"+content.bigquestionId+"'><i class='fa fa-map-marker'></i>&nbsp; 选择试题</button> "
		                                    +"<button type='button' class='btn btn-sm btn-outline-primary importExaminationQuestionsBtn'><i class='fa fa-upload' lang='"+content.bigquestionId+"'></i>&nbsp; 导入试题</button> "
		                                    +"<button type='button' class='btn btn-sm btn-outline-danger deletePartBtn' lang='"+content.bigquestionId+"'><i class='icon-close'></i>&nbsp; 删除大题</button> "
									+"</div>"
			                	+"</div>"
			                		+"<table class='table table-hover table-outline mb-0 hidden-sm-down'>"
										+"<thead class='thead-default'>"
		                                           +" <tr>"
		                                            	+"<th style='width:5%'>"
		                                            		+"编号"
		                                            	+"</th>"
		                                              +"<th style='width:10%'>"
		                                                	+"试题类型"
		                                               +"</th>"
		                                              +"<th style='width:30%'>"
		                                                	+"题干"
		                                               +"</th>"
		                                               +"<th style='width:30%'>"
		                                               	 +"标准答案"
		                                                +"</th>"
		                                                +"<th style='width:10%'>"
		                                                	+"分数"
		                                                +"</th>"
		                                                +"<th style='width:15%'>"
		                                                	+"操作"
		                                                +"</th>"
		                                            +"</tr>"
		                                +"</thead>"
		                                +"<tbody id='"+tbodyId+"'></tbody>"
			                		+"</table>"
			                +"</div>";
						
					
					$.ajax({
					
						type:"post",
						async:true,
						url:"getQuestionsFromBigquestion.do",
						data:{question_ids:question_ids},
						dataType:"json",
						success:function(questionJson){
						
							//alert("tbody的id:"+tbodyId);
							
							
							//设置题目总数							
							$("#"+questionCountId).html(questionJson.length);
							
							//设置各小题内容
							$.each(questionJson,function(index,content){
								
								var qs = "<tr>"
											+"<td>"+(parseInt(index)+1)+"</td>"
											+"<td>"+content.questionType+"</td>"
											+"<td>"+content.questionTitle+"</td>"
											+"<td>"+content.answerTrue+"</td>"
											+"<td>"+content.questionSocre+"</td>"
											+"<td>"
												+"<a href=''>查看</a>&nbsp;<a class='editQuestion' lang='"+content.questionId+"' >编辑</a>&nbsp;<a class='deleteQuestion' title='"+bigquestion_id+"' lang='"+content.questionId+"' href='#'>删除</a>"
											+"</td>"
	                                	+"</tr>";
								
								$("#"+tbodyId).append(qs);
							
							});
						}
					
					
					});	
					
					
					examPartContentArea.append(newPart);
					
					partId = partId+1;				
				
					scoreCount = scoreCount+content.bigquestionScore;
				
				});
				
				$("#bigquestionCount").html(partId-1);
				
				$("#scoreCount").html(scoreCount);
			
			}
		});
		
		$("body").on("click",".editQuestion",function(){
		
			var question_id = $(this).attr("lang");
		
		});
		
		
		$("#publishBtn").click(function(){
			
			var exam_score = "${sessionScope.exam_score}";
			
			alert(":"+paperId);
			window.location.href="publishExam.do?paper_id="+paperId+"&exam_score="+exam_score;
			
		
		});
		
		
		//新增大题模块
		$("#addNewPart").click(function(){
		
			//插入大题的sql
			$.ajax({
			
				type:"post",
				async:true,
				url:"addBigquestion.do",
				data:{paper_id:paperId,part_id:partId},
				dataType:"json",
				success:function(newJson){
				
					var examPartContentArea = $("#examPartContentArea");
					
					var newPart = "<div class='card' id='part_1'>"
			                		+"<div class='card-header'>"
									+"<i class='fa fa-align-justify'></i>"
									+"<span class='h6'>第 <strong class='partId'>"+partId+"</strong> 大题</span>"
									+"<span style='font-size: 12px;'>"
										+"（<em  style='color: red; font-size: 14px;'>0</em>  道试题，共 <em  style='color: red; font-size: 14px;'>0</em> 分）"
									+"</span>"
									+"<div class='float-right'>"
		                                    +"<button type='button' class='btn btn-sm btn-outline-primary addExaminationQuestionBtn' lang='"+newJson[0].bigquestionId+"'><i class='icon-plus'></i>&nbsp; 新增试题</button> "
		                                    +"<button type='button' class='btn btn-sm btn-outline-primary addMoreExaminationQuestionsBtn' lang='"+newJson[0].bigquestionId+"'><i class='fa fa-magic'></i>&nbsp; 批量新增</button> "
		                                    +"<button type='button' class='btn btn-sm btn-outline-primary chooseExaminationQuestionsFromRepertoryBtn' lang='"+newJson[0].bigquestionId+"'><i class='fa fa-map-marker'></i>&nbsp; 选择试题</button> "
		                                    +"<button type='button' class='btn btn-sm btn-outline-primary importExaminationQuestionsBtn' lang='"+newJson[0].bigquestionId+"'><i class='fa fa-upload'></i>&nbsp; 导入试题</button> "
		                                    +"<button type='button' class='btn btn-sm btn-outline-danger deletePartBtn' lang='"+newJson[0].bigquestionId+"'><i class='icon-close'></i>&nbsp; 删除大题</button> "
									+"</div>"
			                	+"</div>"
			                		+"<table class='table table-hover table-outline mb-0 hidden-sm-down'>"
										+"<thead class='thead-default'>"
		                                           +" <tr>"
		                                            	+"<th style='width:5%'>"
		                                            		+"编号"
		                                            	+"</th>"
		                                              +"<th style='width:10%'>"
		                                                	+"试题类型"
		                                               +"</th>"
		                                              +"<th style='width:30%'>"
		                                                	+"题干"
		                                               +"</th>"
		                                               +"<th style='width:30%'>"
		                                               	 +"标准答案"
		                                                +"</th>"
		                                                +"<th style='width:10%'>"
		                                                	+"分数"
		                                                +"</th>"
		                                                +"<th style='width:15%'>"
		                                                	+"操作"
		                                                +"</th>"
		                                            +"</tr>"
		                                +"</thead>"
			                		+"</table>"
			                +"</div>";
					
					
					examPartContentArea.append(newPart);
					
					partId = partId+1;
					
					layer.msg("新增大题成功",{icon:1});
					
					$("#bigquestionCount").html(partId-1);		
				
				}
			
			
			});
			
			
		
		});
		
		//在大题里创建新试题
		$("body").on("click",".addExaminationQuestionBtn",function(){
			
			var bigquestion_id = $(this).attr("lang");
			var currentPartId =  parseInt($(this).parent().prev().prev().children().html());
			
			layer.msg("大题"+currentPartId+"创建新试题");
						
			$.ajax({
				
				type:"post",
				url:"addQuestionPage.do",
				data:{bigquestion_id:bigquestion_id,paper_id:paperId},
				async:true,
				success:function(data){
					layer.open({
						type : 1,
						title : '新增试题',
						closeBtn : 1,
						scrollbar : false,
						shadeClose : true,
						area : [ '1140px', '700px' ],
						skin : 'yourclass',
						content : data
					});
				}
			});
		
		});
		
		//在大题里批量新增试题
		$("body").on("click",".addMoreExaminationQuestionsBtn",function(){
		
			var currentPartId =  parseInt($(this).parent().prev().prev().children().html());
			layer.msg("大题"+currentPartId+"批量新增试题");
			
			var currentBigquestion_id = $(this).attr("lang");
			
			
			$.ajax({
				
				type:"post",
				url:"addMoreQuestionsPage.do",
				data:{bigquestion_id:currentBigquestion_id,paper_id:paperId},
				async:true,
				success:function(data){
					layer.open({
						type : 1,
						title : '批量新增试题',
						closeBtn : 1,
						scrollbar : false,
						shadeClose : true,
						area : [ '1140px', '700px' ],
						skin : 'yourclass',
						content : data
					});
				}
			});			
			
			
		});
		
		//在试题库中选择试题到大题中
		$("body").on("click",".chooseExaminationQuestionsFromRepertoryBtn",function(){
		
			var currentPartId =  parseInt($(this).parent().prev().prev().children().html());
			
			var currentBigquestion_id = $(this).attr("lang");
			
			$.ajax({
				
				type:"post",
				url:"choiceQuestionPage.do",
				async:true,
				data:{bigquestion_id:currentBigquestion_id,paper_id:paperId},
				success:function(data){
					layer.open({
						type : 1,
						title : '从试题库中选择试题',
						closeBtn : 1,
						scrollbar : false,
						shadeClose : true,
						area : [ '1140px', '700px' ],
						skin : 'yourclass',
						content : data
					});
				}
			});	
		
		});
		
		//通过文件导入大题
		$("body").on("click",".importExaminationQuestionsBtn",function(){
			
			var currentPartId =  parseInt($(this).parent().prev().prev().children().html());
			layer.msg("大题"+currentPartId+"通过文件导入试题");
			
					
			$.ajax({
				
				type:"post",
				url:"exam_addExamPaper_importExaminationQuestion.jsp",
				async:true,
				success:function(data){
					layer.open({
						type : 1,
						title : '从试题库中选择试题',
						closeBtn : 1,
						scrollbar : false,
						shadeClose : true,
						area : [ '1140px', '700px' ],
						skin : 'yourclass',
						content : data
					});
				}
			});
		
		});
		
		//删除试题
		$("body").on("click",".deleteQuestion",function(){
			
			var bigquestion_id = $(this).attr("title");
			var question_id = $(this).attr("lang");
			
			
			var question = $(this).parent().parent();
			
			var scoreElement = $(this).parent().parent().parent().parent().prev().children().next().next().children().next("em");
			var countElement = scoreElement.prev("em");
			
			var oldCount = parseInt(countElement.html());
			
			
			
			var oldScore = parseInt(scoreElement.html());
			
			var questionScore =parseInt($(this).parent().prev().html());
			
			var oldScoreCount = $("#scoreCount").html();
			
			
			$.ajax({
			
				url:"deleteQuestionFromBigquestion.do",
				type:"post",
				data:{bigquestion_id:bigquestion_id,question_id:question_id},
				success:function(){
				
					var newScore = oldScore - questionScore;
					
					var newCount = oldCount-1;
					
					var newScoreCount = oldScoreCount-questionScore;
					
					scoreElement.html(newScore);
					countElement.html(newCount);
					$("#scoreCount").html(newScoreCount);
					
					question.remove();
					
					layer.msg('删除试题成功',{
									icon : 1	  		
				  			});
				
				}
			});
		});
		
		
		//删除大题,用异步实现，不去刷新页面
		$("body").on("click",".deletePartBtn",function(){
		
 
			
			if(partId===2){
			
				layer.msg("你的考试总不能一道大题都没有吧?");
				
			}else{
					
					var score = $(this).parent().prev().children().next().html();
					
					
					//获取当前要删除的大题对象
					var deletePart = $(this).parent().parent().parent();
					
					//获取当前要删除的大题序号
					var deletedPartId = parseInt($(this).parent().prev().prev().children().html());
					
					var deletedBigquestionId = $(this).attr("lang");
					
					var partIds = $(".partId");
					
					
					layer.confirm('确认删除大题?',{
						  	btn:['确定','取消'],
						  },function(){
						  
						  
						$.ajax({
													
						type:"post",
						async:true,
						dataType:"json",
						url:"deleteBigquestion.do",
						data:{paper_id:paperId,part_id:deletedPartId,bigquestion_id:deletedBigquestionId},
						success:function(data){
						
							
							partIds.each(function(){
							
								var currentPartId = parseInt($(this).html());
								
								
								if(currentPartId>deletedPartId){
									currentPartId--;
								}
								
								$(this).html(currentPartId);
							
							});
							
							deletePart.remove();
							
							layer.msg('删除大题成功',{
									icon : 1	  		
				  			});
							
							 partId = partId-1;
							 
							 scoreCount = scoreCount - score;
				
							$("#scoreCount").html(scoreCount);
							
							$("#bigquestionCount").html(partId-1);					
						
						}
					
					});
						  },function(){
						  
						  	layer.msg('取消',{
									icon : 2	  		
				  			});
						  
					  });
			}
			
			
		

		});

	});
</script>


</head>

<c:if test="${requestScope.goodInformation!=null }">
	<script>
		layer.msg("${requestScope.goodInformation}",{
							icon : 1	  		
		  			});
	</script>
</c:if>

<c:if test="${requestScope.badInformation!=null }">
	<script>
		layer.msg("${requestScope.badInformation}",{
							icon : 2	  		
		  			});
	</script>
</c:if>



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
									<i class="fa fa-check"></i>
								</center>
							</div>
						</div>
						<!--/.col-->
						<div class="col-sm-4 card-primary">
							<div class="callout">
								<center>
									<strong class="h3" style="color:white">2.创建试卷</strong>
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
					
					<!-- 增加大题块 -->
					<div class="card">
						<div class="card-block p-1 clearfix">
	                       <i class="icon-plus  p-1 font-2xl  float-left"></i>
	                       <div class="h4 text-primary mb-0 mt-h" >
	                       		<a id="addNewPart" style="margin-top:20px">新增试卷大题</a>
	                       	</div>
	                       	<div class="float-right">
	                       	
	                       		<span style="margin-top: 5px; float: right;">共 
	                       		<em id="lNum" style="color: red; font-size: 14px;">
	                       			<span id="bigquestionCount">0</span>
	                       		</em>  
	                       		道大题，共 
	                       		<em id="lTotalScore" style="color: red; font-size: 14px;">
	                       			<span id="scoreCount">0.00</span>
	                       		</em> 分/<em style="color: red; font-size: 16px;" id="examScore"><strong>${sessionScope.exam_score}总分</strong></em></span>
	                       	
	                       	</div>
	                   </div>
	                </div>
	                
					
				</div>
				<div class="card-footer">
					<center>
                       <button id="publishBtn" class="btn btn-lg btn-success"><i class="fa fa-dot-circle-o"></i> 生成/修改试卷&下一步</button>
                             <!--  <button type="reset" class="btn btn-lg btn-danger"><i class="fa fa-ban"></i>重置信息</button> -->
                    </center>
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