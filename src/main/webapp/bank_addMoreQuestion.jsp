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
	
		var examinationArea = $("#textarea_examinationArea"); 
		
		//增加单选题模板
		$("#addSingleChoice").click(function(){
		
			var examination = "题型:单选题   标准答案:A(只能选一个选项作为正确答案)   分数:   难度:低级,中级,高级   试题分析:无   \n题干:\nA.选项:\nB.选项:\nC.选项:\nD.选项:";
			
			examination+="\n\n";
				
			examinationArea.append(examination);
		
/* 			$.getJSON("json/examinationFormat.json",function(data){ 
				
				var examination = data.singleChoice;
				
				examination+="\n\n";
				
				examinationArea.append(examination);
			
			}); */
			
			layer.msg("成功添加单选题模板");
		
		});
		
		//增加多选题模板
		$("#addMultipleChoice").click(function(){
		
			var examination = "题型:多选题   标准答案:A,B,C(多个正确答案中间用逗号分隔)   分数:   难度:低级,中级,高级   试题分析:无   \n题干:\nA.选项:\nB.选项:\nC.选项:\nD.选项:";
			
			examination+="\n\n";
				
			examinationArea.append(examination);
		
/* 			$.getJSON("json/examinationFormat.json",function(data){ 
			
				var examination = data.multipleChoice;
				
				examination+="\n\n";

				examinationArea.append(examination);
			}); */
			
			layer.msg("成功添加多选题模板");
		
		});
		
		//增加判断题模板
		$("#addJudge").click(function(){

			var examination = "题型:判断题   标准答案:true(true或false)   分数:   难度:低级,中级,高级   试题分析:无   \n题干:";
			
			examination+="\n\n";
				
			examinationArea.append(examination);		
			
			
			
/* 			$.getJSON("json/examinationFormat.json",function(data){ 
			
				
				var examination = data.judge;
				
				examination+="\n\n";
				
				
				examinationArea.append(examination);
			
			
			});	 */
			
			layer.msg("成功添加判断题模板");
							
		});
		
		//增加填空题模板
		$("#addFillInBlanksQuestion").click(function(){
		
			var examination = "题型:填空题   标准答案:(多个答案间用逗号分隔)   分数:   难度:低级,中级,高级   试题分析:无   \n题干:(填空处请用3个_标识)";
			
			examination+="\n\n";
				
			examinationArea.append(examination);		
		
			
/* 			$.getJSON("json/examinationFormat.json",function(data){ 
			
				var examination = data.fillInBlanksQuestion;
				
				examination+="\n\n";
				
				examinationArea.append(examination);
			});	 */			
			
			layer.msg("成功添加填空题模板");
			
			
		});
		
		//增加问答题模板
		$("#addEssayQuestion").click(function(){
			
			var examination = "题型:问答题   标准答案:   分数:   难度:低级,中级,高级   试题分析:无   \n题干:";
			
			examination+="\n\n";
				
			examinationArea.append(examination);
	
/* 			$.getJSON("json/examinationFormat.json",function(data){ 
			
				var examination = data.essayQuestion;
				
				examination+="\n\n";
				
				examinationArea.append(examination);
			
			});	 */
			
			layer.msg("成功添加问答题模板");
			
		});
		
		$("#checkBtn").click(function(){
			
			$.ajax({
			
				type:"post",
				async:true,
				url:"checkMoreQuestions.do",
				dataType:"json",
				data:{str:$("#textarea_examinationArea").val()},
				success:function(json){
					
					var checkResult = $("#checkResult");
					
					var notPastQuestionCount = json[0].notPastQuestionCount;
					
					if(notPastQuestionCount==0){
					
						var information = "<span>共有 "+json[0].questionCount+" 道试题,格式都正确</span>";
						checkResult.html(information);
					
					}else{
					
						var information = "<span>共有 "+json[0].questionCount+" 道试题,第"+json[0].notPastNumStr+"试题格式错误,新增失败</span>";
						checkResult.html(information);	
					
					}
					
				
				}
			
			
			});
		
		});
		
		$("#submitBtn").click(function(){
		
			var check = $("#checkResult").html();
			
			if(check==null||check==undefined||check==""){
			
					layer.confirm('试题尚没有检查格式,可能会导致增加失败,确认新增试题吗',{
						  	btn:['确定','取消'],
						  },function(){
						  
						  	$("#form1").submit();
								
						  },function(){
						  
						  	layer.msg('取消',{
									icon : 2	  		
				  			});
						  
					  });
			
			}else{
			
				$("#form1").submit();
			
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
				
					<form id="form1" class="form-horizontal" method="post" action="bank_addMoreQuestions.do" target="_parent">

						
						<!-- 1.考试信息 -->
						<div class="card">
						
							<div class="card-block">
							
								<div class="form-group row">
								
									<label class="col-md-3  form-control-label" style="margin-left:40px">
										指定试题科目
									</label>
									
									<div class="col-md-7">
										
										<div class="input-group">
											
											<select id="select_examType" class="form-control col-md-8" name="questions_catalog" >
	                                                    <option value="0">请选择试题科目</option>
												<option value="1">Java</option>
												<option value="2">Web</option>
												<option value="3">Linux</option>
												<option value="4">Mysql</option>

	                                        </select>
											<span class="input-group-btn">
                                                <button class="btn btn-default" type="button">选择</button>
                                            </span>
										</div>
										<span class="help-block tip">
											如果没有指定试题分类，将默认归类到Java分类下
										</span>								
									
									</div>
								
								</div>
								
								<div class="form-group row">
								
									<label class="col-md-3 form-control-label" style="margin-left:30px">
										<span class="req">*</span>
										单击快速添加
									</label>
									
									<div class="col-md-7">
										
		                                    <button id="addSingleChoice" type="button" class="btn btn-primary"><i class="fa fa-star"></i>&nbsp;单选题</button>
		                                    <button id="addMultipleChoice" type="button" class="btn btn-secondary"><i class="fa fa-lightbulb-o"></i>&nbsp; 多选题</button>
		                                    <button id="addJudge" type="button" class="btn btn-success"><i class="fa fa-magic"></i>&nbsp; 判断题</button>
		                                    <button id="addFillInBlanksQuestion" type="button" class="btn btn-warning"><i class="fa fa-map-marker"></i>&nbsp; 填空题</button>
		                                    <button id="addEssayQuestion" type="button" class="btn btn-danger"><i class="fa fa-rss"></i>&nbsp;问答题</button>
									</div>
									
								
								</div>
								
							</div>
						
						</div>
						
						<div class="card">
							
							<div class="card-block">
								
								<div class="form-group row">
									
									<div class="col-md-12">
										<textarea id="textarea_examinationArea" name="str" rows="14" class="form-control" ></textarea>
									</div>
								
								</div>
								<div>
									<center id="checkResult"></center>
								</div>
							</div>
						</div>
						

					
					</form>
					
						<div class="card-footer">
							<center>
                              <button id="nextBtn" type="submit" class="btn  btn-primary" style="color:white" >
                              		 清空
                              </button>							
                              <button id="checkBtn"  class="btn  btn-primary" style="color:white" >
                              		检查格式
                              </button>
                               <button id="submitBtn" type="submit" class="btn  btn-primary" style="color:white" >
                              		导入&返回
                              </button>
                            </center>
                        </div>
					

					
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