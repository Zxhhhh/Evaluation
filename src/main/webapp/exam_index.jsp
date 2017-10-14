<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
    <meta name="author" content="Åukasz Holeczek">
    <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,AngularJS,Angular,Angular2,jQuery,CSS,HTML,RWD,Dashboard">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>欢迎使用蓝鸥it考评系统</title>

    <!-- Icons -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">

    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">
    
    <style type="text/css">
    
    .importantNumber{
    
    	color:red;
    
    }
    
    .greenNumber{
    
    	color:green;
    	
    }
    
    .indexA{
    	
    	color:white;
    	text-decoration:none;
    
    }
        
    </style>

	<script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower_components/layer/layer.js"></script>
	
	<script type="text/javascript">
	
		$(function(){
		
			$.ajax({
				type:"post",
				url:"getAllExamStatusCount.do",
				dataType:"json",
				success:function(json){
					$("#startCount").html(json[0].startCount);
					$("#unstartCount").html(json[0].unstartCount);
					$("#endCount").html(json[0].endCount);
					$("#deleteCount").html(json[0].deleteCount);
				}
			});	
		
			function getExams(exam_status,pageInfo,place){
			
				$.ajax({
			
					async:true,
					type:"post",
					url:"getExamsByStatus.do",
					data:{exam_status:exam_status,pageNum:pageInfo},
					dataType:"json",
					success:function(json){
						
						//var tbody = $("#home").children().children();
						
						var tbody = place;
						
						var exam;
									
						$.each(json,function(index,content){
						
							exam+="<tr>"
	                                                +"<td>"
	                                                    +"<div class='avatar'>"
	                                                        +"<img src='"+content.exam.examQcodeUrl+"' width='90' height='90'>"
	                                                    +"</div>"
	                                                +"</td>"
	                                                +"<td>"
	                                                    +"<div>"
	                                                    	+"<a href='previewExam.do?exam_id="+content.exam.examId+"'>"+content.exam.examName+"</a>"
	                                                    +"</div>"
	                                                    +"<div>"
	                                                        +"<span>考试时长："+content.exam.examDuration+"分钟</span>"
	                                                    +"</div>"
	                                                    +"<div>"
	                                                        +"<span>考试总分：<span class='greenNumber'>"+content.exam.examScore+"</span> 分&nbsp;</span>" 
	                                                        +"<span>&nbsp;及格分数：<span class='importantNumber'>"+content.exam.examPassScore+"</span> 分</span>"
	                                                    +"</div>"
	                                                    +"<div>"
	                                                        +"<span>有效时间：<strong>"+content.exam.examStartTime+"</strong> ~ <strong>"+content.exam.examEndTime+"</strong></span>"
	                                                    +"</div>"
	                                                +"</td>"
	                                                +"<td>"
	                                                    +"<div class='clearfix'>"
	                                                        +"<div class='float-left'>"
	                                                            +"<strong>共"+content.examUserCount+"人参加考试</strong>"
	                                                        +"</div>"
	                                                        +"<div class='float-right'>"
	                                                            +"<small class='text-muted'>合格率:<span class='importantNumber'>"+content.examPassRate+"%</span></small>"
	                                                        +"</div>"
	                                                    +"</div>"
	                                                    +"<div class='progress progress-xs'>"
	                                                        +"<div class='progress-bar bg-success' role='progressbar' style='width:"+content.examPassRate+"%' aria-valuenow='60' aria-valuemin='0' aria-valuemax='100'></div>"
	                                                    +"</div>"
	                                                +"</td>"
	                                                +"<td class='text-center'>"
	                                                	+"<div class='btn-group'>"
					                                        +"<button type='button' class='btn btn-success  dropdown-toggle ' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>"
					                                           +"<i class='icon-settings'></i> &nbsp;考试选项"
					                                        +"</button>"
					                                        +"<div class='dropdown-menu dropdown-menu-right'>"
					                                            +"<a class='dropdown-item' href='updateExam.do?exam_id="+content.exam.examId+"'>"
					                                            	+"<i class='icon-pin'></i>"
					                                            	+"<strong>编辑考试</strong>"
					                                           	+"</a>"
					                                           	+"<a class='dropdown-item' href='previewExam.do?exam_id="+content.exam.examId+"'>"
					                                           		+"<i class='icon-pin'></i>"
					                                           		+"<strong>预览考试</strong>"
					                                            +"</a>"
					                                            +"<a class='dropdown-item'  href='getExamStatistics.do?exam_id="+content.exam.examId+"'>"
																	+"<i class='icon-pin'></i>"
																	+"<strong>查看成绩</strong>"
																+"</a>"
					                                            +"<a class='dropdown-item link' title='"+content.exam.examUrl+"' >"
					                                            	+"<i class='icon-pin'></i>"
					                                            	+"<strong>考试链接</strong>"
					                                            +"</a>"
					                                       		+"<a class='dropdown-item delete' title='"+content.exam.examId+"'  >"
					                                            	+"<i class='icon-pin'></i>"
					                                            	+"<strong>删除考试</strong>"
					                                            +"</a>"
					                                        +"</div>"
					                                    +"</div>"
	                                                +"</td>"
	                                            +"</tr>";
						});
						
						tbody.html(exam);
					
				}
			});
			
			
			}
			
			
			//一进入页面执行的方法
			getExams("1", 1, $("#startedTbody"));
			
			function showExamLink(url){
				alert(url);
			}
			
			$("body").on("click",".delete",function(){
				
				var id = $(this).attr("title");
				
				layer.confirm('是否删除考试(不可逆)',{
				  	btn:['确定','取消'],
				  },function(){
				  	
				  	window.location.href="deleteExam.do?exam_id="+id;
				  	
				  },function(){
				  	
				  	layer.msg("取消",{
				  		icon:2
				  	});
				  	
				  });
				
				
			})
			
			$("body").on("click",".link",function(){
			
				layer.msg('考试路径:'+$(this).attr("title"));
				
			
			})
		
		
		   $(".addExam").click(function(){
		   
		      window.location.href="exam_addExamInformation.jsp";
		   
		   });
		
			$(".startedBtn").click(function(){
			
			    getExams("1", 1, $("#startedTbody"))
		
			});
			
			$(".unstartBtn").click(function(){
			
				getExams("2", 1, $("#unstartTbody"))
			
			});
			
			$(".endedBtn").click(function(){
				
				getExams("3", 1, $("#endedTbody"));	
			
			});
			
			$(".deletedBtn").click(function(){
				
				getExams("4", 1, $("#deletedTbody"));	
			
			});			
			
		
		
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
                		考试
                </li>

            </ol>

			<!-- 正文 -->
            <div class="container-fluid">
                <div class="animated fadeIn">
                
					<div class="row">
                        <div class="col-sm-3 col-lg-3">
                            <div class="card card-inverse  card-success" style="height:100px">
                                <div class="card-block pb-0">
                                    <div class="btn-group float-right">
                                        <button type="button" class="btn btn-transparent active dropdown-toggle p-0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="icon-settings"></i>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="#">查看</a>
                                            <a class="dropdown-item" href="#">考试情况</a>
                                            <a class="dropdown-item" href="#">全部清空</a>
                                        </div>
                                    </div>
                                    <h2 class="mb-0">
                                    	<a href="exam_check.jsp?status=1" class="indexA">进行中</a>
                                    	(<span id="startCount"></span>)
                                    </h2>
                                    <p>正开通的考试</p>
                                </div>
                                <div class="chart-wrapper px-1" style="height:70px;">
                                    <canvas id="card-chart1" class="chart" height="70"></canvas>
                                </div>
                            </div>
                        </div>
                        <!--/.col-->

                        <div class="col-sm-6 col-lg-3">
                            <div class="card card-inverse card-info" style="height:100px">
                                <div class="card-block pb-0">
                                    <div class="btn-group float-right">
                                        <button type="button" class="btn btn-transparent active dropdown-toggle p-0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="icon-settings"></i>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="#">查看</a>
                                            <a class="dropdown-item" href="#">考试情况</a>
                                            <a class="dropdown-item" href="#">全部清空</a>
                                        </div>
                                    </div>
                                    <h2 class="mb-0">
                                    	<a href="exam_check.jsp?status=2" class="indexA">未开始</a>
                                    	(<span id="unstartCount"></span>)
                                    </h2>
                                    <p>未到开放时间的考试</p>
                                </div>
                                <div class="chart-wrapper px-1" style="height:70px;">
                                    <canvas id="card-chart2" class="chart" height="70"></canvas>
                                </div>
                            </div>
                        </div>
                        <!--/.col-->

                        <div class="col-sm-6 col-lg-3">
                            <div class="card card-inverse card-warning" style="height:100px">
                                <div class="card-block pb-0">
                                    <div class="btn-group float-right">
                                        <button type="button" class="btn btn-transparent active dropdown-toggle p-0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="icon-settings"></i>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="#">查看</a>
                                            <a class="dropdown-item" href="#">考试情况</a>
                                            <a class="dropdown-item" href="#">全部清空</a>
                                        </div>
                                    </div>
                                    <h2 class="mb-0">
                                    	<a href="exam_check.jsp?status=3" class="indexA">已结束</a>
                                    	(<span id="endCount"></span>)
                                    </h2>
                                    <p>已过结束时间的考试</p>
                                </div>
                                <div class="chart-wrapper" style="height:70px;">
                                    <canvas id="card-chart3" class="chart" height="70"></canvas>
                                </div>
                            </div>
                        </div>
                        <!--/.col-->
                        
                        <div class="col-sm-6 col-lg-3">
                            <div class="card card-inverse card-danger" style="height:100px">
                                <div class="card-block pb-0">
                                    <div class="btn-group float-right">
                                        <button type="button" class="btn btn-transparent active dropdown-toggle p-0" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="icon-settings"></i>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="#">查看</a>
                                            <a class="dropdown-item" href="#">考试情况</a>
                                            <a class="dropdown-item" href="#">全部恢复</a>
                                            <a class="dropdown-item" href="#">全部清空</a>
                                        </div>
                                    </div>
                                    <h2 class="mb-0">
                                    	<a href="exam_check.jsp?status=4" class="indexA">已删除</a>
                                    	(<span id="deleteCount"></span>)
                                    </h2>
                                    <p>被删除的考试</p>
                                </div>
                                <div class="chart-wrapper px-1" style="height:70px;">
                                    <canvas id="card-chart4" class="chart" height="70"></canvas>
                                </div>
                            </div>
                            
                        </div>
                        <!--/.col-->
                    </div>
                    
                    <div style="margin-bottom:20px">
	                    <center>
	                      	<button  type="button" class="btn btn-secondary btn-lg btn-block addExam" style="width:40%; ">
	                      	<i class="fa fa-pencil"></i>
	                      	     <a href="exam_addExamInformation.jsp">新增考试</a>
	                      	</button>
	                    </center>
	               </div>
                    
                    <div class="col-md-12">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active startedBtn" data-toggle="tab" href="#started" role="tab" aria-controls="home">进行中</a>
                                </li>
                                <li class="nav-item" class="unstartBtn">
                                    <a class="nav-link unstartBtn" data-toggle="tab" href="#unstart" role="tab" aria-controls="profile">未开始</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link endedBtn" data-toggle="tab" href="#ended" role="tab" aria-controls="messages">已结束</a>
                                </li>
                                <li class="nav-item">
                                	<a class="nav-link deletedBtn" data-toggle="tab" href="#deleted" role="tab" aria-controls="messages">已删除</a>
                                </li>
                            </ul>

                            <div class="tab-content">
                                <div class="tab-pane active" id="started" role="tabpanel">
                                	<table class="table table-hover table-outline mb-0 hidden-sm-down">

                                        <tbody id="startedTbody">
          
                                        </tbody>
                                    </table>
                                    
	                                 <div id="startedPage" class="pages" style="width:100%;margin-top:20px">
	                                 <div  style='margin-left:40%'>
							                    <a href="exam_check.jsp" class="btn btn-secondary">显示全部记录 </a>
							         </div>

						            </div>
                                    
                                    
                                </div>
                                
                                <div class="tab-pane" id="unstart" role="tabpanel">
                                
                                	<table class="table table-hover table-outline mb-0 hidden-sm-down">

                                        <tbody id="unstartTbody">
          
                                        </tbody>
                                    </table>
                                    
                                 	<div id="unstartPage" class="pages" style="width:100%;margin-top:20px">
	                                 <div  style='margin-left:40%'>
							                <a href="exam_check.jsp" class="btn btn-secondary">显示全部记录 </a>
							         </div>
						            </div>
                                
                                	

                                </div>
                                
                                <div class="tab-pane" id="ended" role="tabpanel">
                                
                                	<table class="table table-hover table-outline mb-0 hidden-sm-down">

                                        <tbody id="endedTbody">
          
                                        </tbody>
							                                                
                                    </table>
                                    
	                                <div id="endedPage" class="pages" style="width:100%;margin-top:20px">
	                                 <div  style='margin-left:40%'>
							                     <a href="exam_check.jsp" class="btn btn-secondary">显示全部记录 </a>
							         </div>	
							        </div>                                      
                                
                                </div>
                                
                                <div class="tab-pane" id="deleted" role="tabpanel">
                                
                                	<table class="table table-hover table-outline mb-0 hidden-sm-down">

                                        <tbody id="deletedTbody">
          
                                        </tbody>
                                    </table> 
                                    
	                                <div id="deletedPage" class="pages" style="width:100%;margin-top:20px">
	                                 <div  style='margin-left:40%'>
							                    <a href="exam_check.jsp" class="btn btn-secondary">显示全部记录 </a>
							         </div>	
							        </div>                                                                     
                                
                                </div>                                
                            </div>
                        </div>
                    
                    
                    
					
                </div>

            </div>
            <!-- /.conainer-fluid -->
        </main>

        <jsp:include page="asidemenu.jsp"></jsp:include>


    </div>

	<jsp:include page="footer.jsp"></jsp:include>


    <script src="bower_components/tether/dist/js/tether.min.js"></script>

    <script src="bower_components/pace/pace.min.js"></script>

    <script src="bower_components/chart.js/dist/Chart.min.js"></script>
    <script src="js/app.js"></script>
    <script src="js/views/main.js"></script>
	<!--不能删除而且必须放到最后   否则sidebar不能展开动态效果 -->
</body>

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

</html>