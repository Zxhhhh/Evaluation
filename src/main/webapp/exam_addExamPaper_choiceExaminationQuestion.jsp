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


<script src="bower_components/calendar/jquery-1.9.1.js"></script>
<script src="bower_components/calendar/calendar.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function() {
		
		
		var bigquestion_id = "${requestScope.bigquestion_id}";
	
		$.ajax({
			
			type:"post",
			async:true,
			url:"getAllQuestionsExceptBigquestionHave.do",
			dataType:"json",
			data:{bigquestion_id:bigquestion_id},
			success:function(json){
				
				var tbody = $("#examinationList");
				
				$.each(json,function(index,content){
				
					var tr = "<tr>"
								+"<td style='width:7%'><input type='checkbox' class='form-control' name='question_ids' value='"+content.questionId+"' /></td>"
								+"<td style='width:20%'>"+content.questionTitle+"</td>"
								+"<td style='width:10%'>"+content.questionType+"</td>"
								+"<td style='width:15%'>Java/Java基础</td>"
								+"<td style='width:15%'>"+content.questionLevel+"</td>"
								+"<td style='width:10%'>"+content.answerTrue+"</td>"
								+"<td style='width:7%'>"+content.questionSocre+"</td>"
								+"<td style='width:10%'>"+content.createTime+"</td>"
								+"<td style='width:7%'> <a href='#'>详细</a> &nbsp;<a href='#'>删除</a></td>"							 
							+"</tr>";
					
					tbody.append(tr);
				
				})
			
			}
		
		})
        

		
	});
</script>


</head>



<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">



	<!-- Main content -->
	
	<div class="container">
	<!-- 正文 -->
	<div class="container-fluid">
		<div class="animated fadeIn">
			
			
			<div class="card">

				<div class="card-block" id="examPartContentArea">
				
					<form class="form-horizontal" method="post" action="choiceQuestionsToBigquestion.do">
					
						<input name="bigquestion_id" value="${requestScope.bigquestion_id}" type="hidden" />
						<input name="paper_id" value="${requestScope.paper_id}" type="hidden" />
						
						<div class="card">
						
							<div class="card-header">
							
								搜索试题
							
							</div>
						
							<div class="card-block">
							
								<div class="form-group row">
									<div class="col-md-6">
										<label class="form-control-label" for="select_examType" style="margin-left:30px" >
											<span class="req">*</span>
											试题类型
										</label>
										<select id="select_examType" class="form-control col-md-8" style="margin-left:100px;width:40%;display:inline-block;">
                                                    <option value="0">请选择试题类型</option>
                                                    <option value="1">单选题</option>
                                                    <option value="2">多选题</option>
                                                    <option value="3">判断题</option>
                                                    <option value="4">问答题</option>
                                                    <option value="5">填空题</option>
                                        </select>
									</div>
									
									<div class="col-md-6">
										<label class="form-control-label" for="select_examCatalog" style="margin-left:30px" >
											<span class="req">*</span>
											所属科目
										</label>
										<select id="select_examCatalog" class="form-control col-md-8" style="margin-left:100px;width:40%;display:inline-block;">
                                                    <option value="0">请选择试题目录</option>
                                                    <c:forEach items="${requestScope.catalogues}" var="catalogue">
                                                    
                                                    	<option value="${catalogue.catalogId}">${catalogue.catalogName}</option>
                                                    
                                                    </c:forEach>
                                        </select>
									</div>
								</div>
								
								
								<div class="form-group row">
									
									<div class="col-md-6">
									
										<label class="form-control-label" for="input_examScore" style="margin-left:30px">
											<span class="req">*</span>
											试题题干(关键字) 
										</label>
											  
                                         <input id="input_examScore" name="" class="form-control col-md-8"  style="margin-left:100px;width:40%;display:inline-block;"/>
                                              		

                                    </div>
									
									
									
									<div class="col-md-6">
									
										<label class="form-control-label" for="select_examLevels" style="margin-left:30px">
											<span class="req">*</span>
											试题难度
										</label>
									
										<select id="select_examLevels" class="form-control col-md-8" style="margin-left:100px;width:40%;display:inline-block;">
                                        	<option value="0">请选择难度</option>
                                            <option value="1">低级</option>
                                            <option value="2">中级</option>
                                            <option value="3">高级</option>
                                        </select>
                                    </div>
                                    
								</div>
								
								<div class="form-group row">
									<label class="col-md-2  form-control-label" for="input_examStartTime" style="margin-left:30px">
										<span class="req">*</span>
										创建时间
									</label>
									<div class="col-md-3">
									
										<div class="input-group">
                                              <input id="startIpt" name="" class="form-control calendarIpt" placeholder="" type="text" >
                                              <span class="input-group-addon">
                                              	<i class="fa fa-calendar"></i>
                                              </span>
                                        </div>
                                    </div>
									<i class="fa fa-arrow-right" style="margin-top:10px"></i>                              
                                    <div class="col-md-3">    
                                       <div class="input-group">
                                              <input id="endIpt" name="" class="form-control calendarIpt" placeholder="" type="text" >
                                              <span class="input-group-addon">
                                              	<i class="fa fa-calendar"></i>
                                              </span>
                                        </div>
                                        <script>
                                             	$('#endIpt').each(function(){
                                             		alert("hello");
													var a = new Calendar({
														targetCls: $(this),
														type: 'yyyy-mm-dd HH:MM:SS',
														wday:2
													},function(val){
														console.log(val);
													});
													
													a.attr("position","absolute");
													a.attr("z-index","9999");
													
												});
										</script>
                                    </div>
										
								</div>
								
								<div class="form-group row">
								
                                    <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                                    <button type="button" class="btn btn-outline-primary" style="margin-left:30px;margin-right: 10px">搜索试题</button>

                                    <!-- Secondary, outline button -->
                                    <button type="button" class="btn btn-outline-secondary">重置条件</button>
								
								</div>
								
							</div>
						
						</div>
						
						
						
						<div class="card">
						
								<table class="table table-bordered table-outline mb-0 hidden-sm-down">
								
									<thead class="thead-default">
										
										<tr>
											<th style="width:10%">选择</th>
											<th style="width:20%">内容</th>
											<th style="width:10%">题型</th>
											<th style="width:15%">分类</th>
											<th style="width:15%">难度</th>
											<th style="width:10%">答案</th>
											<th style="width:7%">分值</th>
											<th style="width:10%">创建时间</th>
											<th style="width:7%">操作</th>
										</tr>
									
									</thead>
									
									<tbody id="examinationList">
									
									</tbody>
									
								</table>
								
								<div class="pages" style="width:100%;margin-top:50px">
						                <div  style="margin-left:40%">
						                    <span>共有&nbsp;<span style="color:red" >9</span>&nbsp;条记录 &nbsp; </span>
						                    <button id="" class="btn btn-secondary">显示全部记录 </button>
						                </div>
					            </div>
											
							
						</div>
						
						<div class="card-footer">
							<center>
                              <button id="nextBtn" type="submit" class="btn  btn-success" style="color:white" >
                              		<i class="fa fa-dot-circle-o"></i> 选择并保存
                              </button>
                              <button id="nextBtn"  class="btn  btn-success" style="color:white" >
                              		<i class="fa fa-dot-circle-o"></i> 退出
                              </button>
                            </center>

                        </div>
					
					</form>
					
				</div>

			</div>

		</div>
		</div>
		</div>
		<!-- /.conainer-fluid -->
		
	</div>


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