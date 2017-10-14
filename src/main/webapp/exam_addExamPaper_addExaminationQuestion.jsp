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

		$("#select_examType").change(function(){
			
			
			var value = $(this).val();
			var chooseArea = $("#chooseArea");
			
			if(value=="1"){
				
				var question = $("#singleChoice");
				chooseArea.html(question.clone(true));
				
				chooseArea.children().attr("style","");
				
			}else if(value=="2"){
			
				var question = $("#multipleChoice");
				chooseArea.html(question.clone(true));
				
				chooseArea.children().attr("style","");
			
			
			
			}else if(value=="3"){
			
				var question = $("#judge");
				chooseArea.html(question.clone(true));
				
				chooseArea.children().attr("style","");
			
			
			}else if(value=="4"){
			
				var question = $("#essayQuestion");
				chooseArea.html(question.clone(true));
				
				chooseArea.children().attr("style","");
			
			}else if(value=="5"){
				
				var question = $("#fillBlank");
				chooseArea.html(question.clone(true));
				
				chooseArea.children().attr("style","");
			
			}
		
		});

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
				
					<form class="form-horizontal" method="post" action="addQuestionFromBigquestion.do">
					
						<input type="hidden" name="bigquestion_id" value="${param.bigquestion_id}" />
						
						<input type="hidden" name="paper_id" value="${param.paper_id }" />
						
						<!-- 1.考试信息 -->
						<div class="card">
						
							<div class="card-block">
							
								<div class="form-group row">
									<div class="col-md-6">
										<label class="form-control-label" for="select_examType" name="" style="margin-left:30px" >
											<span class="req">*</span>
											试题类型
										</label>
										<select id="select_examType" class="form-control col-md-8" name="questionType" style="margin-left:100px;width:40%;display:inline-block;">
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
										<select id="select_examCatalog" class="form-control col-md-8" name="catalogId" style="margin-left:100px;width:40%;display:inline-block;">
                                                    <option value="0">请选择试题目录</option>
                                                    <c:forEach items="${requestScope.catalogues}" var="catalogue">
                                                    
                                                    	<option value="${catalogue.catalogId}">${catalogue.catalogName}</option>
                                                    
                                                    </c:forEach>
                                        </select>
									</div>
								</div>
								
								
								<div class="form-group row">
									
									<div class="col-md-6">
									
										<label class="form-control-label"  for="input_examScore" style="margin-left:30px">
											<span class="req">*</span>
											试题分值 
										</label>
											  
                                         <input id="input_examScore" name="questionSocre" class="form-control col-md-8"  style="margin-left:100px;width:40%;display:inline-block;"/>
                                              		

                                    </div>
									
									
									
									<div class="col-md-6">
									
										<label class="form-control-label" for="select_examLevels" style="margin-left:30px">
											<span class="req">*</span>
											试题难度
										</label>
									
										<select id="select_examLevels" class="form-control col-md-8" name="questionLevel" style="margin-left:100px;width:40%;display:inline-block;">
                                        	<option value="0">请选择难度</option>
                                            <option value="1">低级</option>
                                            <option value="2">中级</option>
                                            <option value="3">高级</option>
                                        </select>
                                    </div>
                                    
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-2 form-control-label" style="margin-left:30px">
										<span class="req">*</span>
										试题内容(题干)
									</label>
									
									<div class="col-md-9">
										<textarea id="textarea_examNotice" name="questionTitle" rows="5" class="form-control" ></textarea>
										<span class="help-block tip">
											若选填空题:填空符请用三个连续下划线表示，如___
										</span>
									</div>
									
								
								</div>
								
							</div>
						
						</div>
						
						<div id="chooseArea">

						
						
						</div>
						
						
						<div class="card">
							
							<div class="card-block">
								
								<div class="form-group row">
									<label class="col-md-2 form-control-label" style="margin-left:40px">
										<span class="req">*</span>
										试题分析
									</label>
									
									<div class="col-md-9">
										<textarea id="textarea_examNotice" name="questionAnalysis" rows="5" class="form-control" ></textarea>
									</div>
								
								</div>
							</div>	
						</div>
						
						<div class="card-footer">
							<center>
                              <button id="nextBtn" type="submit" class="btn btn-lg btn-success" style="color:white" >
                              		<i class="fa fa-dot-circle-o"></i> 保存&返回
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
		
								
						<!-- 单选题的选项框 -->
						<div class="card" id="singleChoice" style="display:none;">
						
							<div class="card-header">
								<i class="icon-note"></i>
								<span><strong> 选项(单选题)</strong></span>							
							</div>
							
							<div class="card-block">
							
								<table class="table table-bordered table-outline mb-0 hidden-sm-down">
								
									<thead class="thead-default">
									
										<tr>
											<th style="width:10%;">选项</th>
											<th style="width:80%;">描述</th>
											<th style="width:10%;">正确答案</th>
										</tr>
									
									</thead>
									
									<tbody>
										<!-- A选项 -->
										<tr>
											<td>
												<center>
													<strong>A</strong>
												</center>
											</td>
											<td>
												<textarea class="form-control" rows="4" name="optionA"></textarea>
											</td>
											<td>
												<input type="radio" class="form-control" name="answerTrue" value="A" />
											</td>
										
										</tr>
										<!-- B选项 -->
										<tr>
											<td>
												<center>
													<strong>B</strong>
												</center>
											</td>
											<td>
												<textarea class="form-control" rows="4" name="optionB"></textarea>
											</td>
											<td>
												<input type="radio" class="form-control" name="answerTrue" value="B" />
											</td>
										</tr>
										<!-- C选项 -->
										<tr>
											<td>
												<center>
													<strong>C</strong>
												</center>
											</td>
											<td>
												<textarea class="form-control" rows="4" name="optionC"></textarea>
											</td>
											<td>
												<input type="radio" class="form-control" name="answerTrue" value="C" />
											</td>
										</tr>
										<!-- D选项 -->
										<tr>
											<td>
												<center>
													<strong>D</strong>
												</center>
											</td>
											<td>
												<textarea class="form-control" rows="4" name="optionD"></textarea>
											</td>
											<td>
												<input type="radio" class="form-control" name="answerTrue" value="D" />
											</td>
										</tr>
										
									</tbody>
									
								</table>
							
							</div>
						
						
						</div>
						
						<!-- 多选题选项 -->
						<div class="card" id="multipleChoice" style="display:none;">
						
							<div class="card-header">
								<i class="icon-note"></i>
								<span><strong> 选项(多选题)</strong></span>							
							</div>
							
						<div class="card-block">
							
								<table class="table table-bordered table-outline mb-0 hidden-sm-down">
								
									<thead class="thead-default">
									
										<tr>
											<th style="width:10%;">选项</th>
											<th style="width:80%;">描述</th>
											<th style="width:10%;">正确答案</th>
										</tr>
									
									</thead>
									
									<tbody>
										<!-- A选项 -->
										<tr>
											<td>
												<center>
													<strong>A</strong>
												</center>
											</td>
											<td>
												<textarea class="form-control" rows="4" name="optionA"></textarea>
											</td>
											<td>
												<input type="checkbox" class="form-control" name="answerTrue" value="A" />
											</td>
										
										</tr>
										<!-- B选项 -->
										<tr>
											<td>
												<center>
													<strong>B</strong>
												</center>
											</td>
											<td>
												<textarea class="form-control" rows="4" name="optionB"></textarea>
											</td>
											<td>
												<input type="checkbox" class="form-control" name="answerTrue" value="B"   />
											</td>
										</tr>
										<!-- C选项 -->
										<tr>
											<td>
												<center>
													<strong>C</strong>
												</center>
											</td>
											<td>
												<textarea class="form-control" rows="4" name="optionC"></textarea>
											</td>
											<td>
												<input type="checkbox" class="form-control" name="answerTrue" value="C"  />
											</td>
										</tr>
										<!-- D选项 -->
										<tr>
											<td>
												<center>
													<strong>D</strong>
												</center>
											</td>
											<td>
												<textarea class="form-control" rows="4" name="optionD"></textarea>
											</td>
											<td>
												<input type="checkbox" class="form-control" name="answerTrue" value="D"  />
											</td>
										</tr>
										
									</tbody>
									
								</table>
							
							</div>
							
						</div>
						
						
						<!-- 判断题题选项 -->
						<div class="card" id="judge" style="display:none;">
							
							<div class="card-header">
							
								<i class="icon-note"></i>
								<span><strong> 选项(判断题)</strong></span>	
							
							</div>
							
							<div class="card-block">
							
								<div class="form-group row">
								
									<label class="radio-inline col-md-6" for="inline-radio1" >
                                        	<input id="inline-radio1" name="answerTrue" value="true" type="radio" style="margin-left:250px">
                                        	正确
                                    </label>
                                    
                                    <label class="radio-inline col-md-6" for="inline-radio2">
                                         <input id="inline-radio2" name="answerTrue" value="false" type="radio">
                                     	    错误          
                                  	</label>
								
								
								</div>
							
							</div>
						
						</div>
						
						<!-- 问答题选项 -->
						<div class="card" id="essayQuestion" style="display:none">
						
							<div class="card-header">
							
								<div class="card-header">
									<i class="icon-note"></i>
									<span><strong> 选项(问答题)</strong></span>	
								
								</div>
								<div class="card-block">
									
									
									<div class="form-group row">
										<label class="col-md-2 form-control-label" style="margin-left:40px">
											<span class="req">*</span>
											正确答案
										</label>
										
										<div class="col-md-9">
											<textarea id="textarea_rightAnswer" name="answerTrue" rows="5" class="form-control" ></textarea>
										</div>
									
									</div>
								
								
								</div>
							
							
							</div>
						
						
						</div>
						
						<!-- 填空题 -->
						<div class="card" id="fillBlank" style="display:none">
						
							<div class="card-header">
							
								<div class="card-header">
									<i class="icon-note"></i>
									<span><strong> 选项(填空题)</strong></span>	
								
								</div>
								<div class="card-block">
									
									
									<div class="form-group row">
										<label class="col-md-2 form-control-label" style="margin-left:40px">
											<span class="req">*</span>
											正确答案
										</label>
										
										<div class="col-md-9">
											<textarea id="textarea_rightAnswer" name="answerTrue" rows="5" class="form-control" ></textarea>
											<span class="help-block tip ">
												<strong>多个答案间请用 "|" 分隔</strong> 
											</span>
										</div>
									
									</div>
								
								
								</div>
							
							
							</div>
						
						
						</div>



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