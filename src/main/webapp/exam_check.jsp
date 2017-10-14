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
    
     <link href="css/exam.css" rel="stylesheet">
    
    <style type="text/css">
    
    
    
    .importantNumber{
    
    	color:red;
    
    }
    
    .greenNumber{
    
    	color:green;
    	
    }
        
    </style>

	<script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	
		$(function(){
			
			var exam_status = "${param.status}";
			
			//一进入页面执行的方法
			$.ajax({
				async:true,
				type:"post",
				url:"getExamsBySelect.do",
				data:{exam_status:exam_status},
				success:function(data){
					$("#examListPlace").html(data);
					var status = $(".statusBtn");
					status.each(function(){
						if($(this).attr("title")===exam_status){
							$(this).attr("class","course-nav-item statusBtn on");
						}else{
							$(this).attr("class","course-nav-item statusBtn");
						}
					});
				}
			
			});
			
			
			$(".statusBtn").click(function(){
			
				var currentStatus = $(this);
				
				//1.ajax异步搜索考试记录
				$.ajax({
				
					async:true,
					type:"post",
					data:{exam_status:$(this).attr("title"),createTime:$("li[class$='yearBtn on']").attr("title")},
					url:"getExamsBySelect.do",
					success:function(data){
						
						//2.显示数据
						$("#examListPlace").html(data);
						
						//3.改变样式
						var status = $(".statusBtn");
						status.each(function(){
							
							if($(this).attr("title")===currentStatus.attr("title")){
								$(this).attr("class","course-nav-item statusBtn on");
							}else{
								$(this).attr("class","course-nav-item statusBtn");
							}
						});
	
					}
				
				});
			});
			
			$(".yearBtn").click(function(){
			
				var currentYear = $(this);
				
				//1.ajax异步搜索考试记录
				$.ajax({
				
					async:true,
					type:"post",
					data:{createTime:$(this).attr("title"),exam_status:$("li[class$='statusBtn on']").attr("title") },
					url:"getExamsBySelect.do",
					success:function(data){
						
						//2.显示数据
						$("#examListPlace").html(data);
						
						//3.改变样式
						var status = $(".yearBtn");
						status.each(function(){
							
							if($(this).attr("title")===currentYear.attr("title")){
								$(this).attr("class","course-nav-item yearBtn on");
							}else{
								$(this).attr("class","course-nav-item yearBtn");
							}
						});
	
					}
				
				});				
			
			
			});
			
			$(".paginationBtn").click(function(){

				var currentYear = $(this);
				
				//1.ajax异步搜索考试记录
				$.ajax({
				
					async:true,
					type:"post",
					data:{pageNum:$(this).attr("title"),createTime:$("li[class$='yearBtn on']").attr("title"),exam_status:$("li[class$='statusBtn on']").attr("title") },
					url:"getExamsBySelect.do",
					success:function(data){
						
						//2.显示数据
						$("#examListPlace").html(data);
						
						//3.改变样式
						
					}
				
				});				
			
			})
			
		
		});
	</script>
	

	</head>

<body class="app header-fixed sidebar-fixed aside-menu-fixed">

	<jsp:include page="headbar.jsp"></jsp:include>


        <!-- Main content -->
        <main >

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
                
                	<div class="card" >
                		
                		<div class="card-header">
                		
                			<div class="course-nav-row ">
                			<span style="float:right;">
                				<a type="button" href="exam_index.jsp" class="btn btn-outline-primary">返&nbsp;回</a>
                			</span>
								<span class="hd l">状态：</span>
								<div class="bd">
									<ul>
										<li class="course-nav-item statusBtn on"><a
											href="#">全部</a></li>
										<li class="course-nav-item statusBtn" title="1">
											<a href="#" >进行中</a></li>
										<li class="course-nav-item statusBtn" title="2">
											<a href="#">未开始</a></li>
										<li class="course-nav-item statusBtn" title="3">
											<a href="#">已结束</a></li>
										<li class="course-nav-item statusBtn" title="4">
											<a  href="#">已删除</a></li>
									</ul>
								</div>
								<span class="hd l">年份：</span>
								<div class="bd">
									<ul>
										<li class="course-nav-item yearBtn on"><a
											href="#">全部</a></li>
										<li class="course-nav-item yearBtn" title="2017"><a
											href="#">2017</a></li>
										<li class="course-nav-item">
											<div class="input-group">
                                              <input id="input_examStartTime" name="" class="form-control" placeholder="更早" type="email">
                                              <span class="input-group-addon">
                                              		<i class="fa fa-calendar"></i>
                                              </span>
                                        	</div>
										</li>
	
									</ul>
								</div>
							</div>
                		
                		</div>
                		<div class="card-block" id="examListPlace">
                		
                		</div>
                		<div style="width:100%" id="paginationDiv">
                		
	                		<div class="ps0" style="float:right;margin:20px">
								<span>${sessionScope.queryExamPageInfo.pageNum}
									/${sessionScope.queryExamPageInfo.pages}</span>
								<c:choose>
									<c:when test="${sessionScope.queryExamPageInfo.hasPreviousPage}">
										<span> <a href="#" title="1" >首页</a> </span>
										<span> <a
											href="#" class="paginationBtn" title="${sessionScope.queryExamPageInfo.prePage }">上一页</a>
										</span>
									</c:when>
									<c:otherwise>
										<span>首页 </span>
										<span>上一页</span>
									</c:otherwise>
								</c:choose>
						
								<c:choose>
									<c:when test="${sessionScope.queryExamPageInfo.hasNextPage}">
										<span>
											<a href="#" class="paginationBtn" title="${sessionScope.queryExamPageInfo.nextPage }">下一页</a>
										</span>
										<span>
											<a href="#" class="paginationBtn" title="${sessionScope.queryExamPageInfo.pages }">尾页</a>
										</span>
									</c:when>
									<c:otherwise>
										<span>下一页 </span>
										<span>尾页</span>
									</c:otherwise>
								</c:choose>
						
								<span> <select id="pageNum" onchange="pageNum()">
										<c:forEach var="index" begin="1"
											end="${sessionScope.queryExamPageInfo.pages }">
											<c:choose>
												<c:when test="${sessionScope.queryExamPageInfo.pageNum==index }">
													<option value="${index }" selected="selected">${index}</option>
												</c:when>
												<c:otherwise>
													<option value="${index }">${index}</option>
												</c:otherwise>
											</c:choose>
						
										</c:forEach>
								</select> </span>
						
							</div>
                		
                		
                		</div>
                		

                	
                	</div>
                    
					
                </div>

            </div>
            <!-- /.conainer-fluid -->
        </main>

        <jsp:include page="exam_asidemenu.jsp"></jsp:include>


    </div>

	<jsp:include page="footer.jsp"></jsp:include>


    <script src="bower_components/tether/dist/js/tether.min.js"></script>

    <script src="bower_components/pace/pace.min.js"></script>

    <script src="bower_components/chart.js/dist/Chart.min.js"></script>
    <script src="js/app.js"></script>
    <script src="js/views/main.js"></script>
	<!--不能删除而且必须放到最后   否则sidebar不能展开动态效果 -->
</body>

</html>