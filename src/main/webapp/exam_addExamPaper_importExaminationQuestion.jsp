<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		
			$.getJSON("json/examinationFormat.json",function(data){ 
				
				var examination = data.singleChoice;
				
				examination+="\n\n";
				
				examinationArea.append(examination);
			
			});
			
			layer.msg("成功添加单选题模板");
		
		});
		
		//增加多选题模板
		$("#addMultipleChoice").click(function(){
		
			$.getJSON("json/examinationFormat.json",function(data){ 
			
				var examination = data.multipleChoice;
				
				examination+="\n\n";

				examinationArea.append(examination);
			});
			
			layer.msg("成功添加多选题模板");
		
		});
		
		//增加判断题模板
		$("#addJudge").click(function(){
		
			$.getJSON("json/examinationFormat.json",function(data){ 
			
				
				var examination = data.judge;
				
				examination+="\n\n";
				
				
				examinationArea.append(examination);
			
			
			});	
			
			layer.msg("成功添加判断题模板");
							
		});
		
		//增加填空题模板
		$("#addFillInBlanksQuestion").click(function(){

			$.getJSON("json/examinationFormat.json",function(data){ 
			
				var examination = data.fillInBlanksQuestion;
				
				examination+="\n\n";
				
				examinationArea.append(examination);
			});				
			
			layer.msg("成功添加填空题模板");
			
			
		});
		
		//增加问答题模板
		$("#addEssayQuestion").click(function(){
		
			$.getJSON("json/examinationFormat.json",function(data){ 
			
				var examination = data.essayQuestion;
				
				examination+="\r\n \r\n";
				
				examinationArea.append(examination);
			
			});	
			
			layer.msg("成功添加问答题模板");
			
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
				
					<form class="form-horizontal" method="post" action="saveExamInformation.do">
						
						<div class="card">
						
							<div class="card-block">
							
							    <div class="form-group row">
								
									<label class="col-md-3 form-control-label" style="margin-left:30px">
										下载模板
									</label>
									
									<div class="col-md-7">
		                                    <button id="addSingleChoice" type="button" class="btn btn-primary"><i class="fa fa-star"></i>下载Word模板</button>
		                                    <button id="addSingleChoice" type="button" class="btn btn-primary"><i class="fa fa-star"></i>下载Excel模板</button>
		                                    <button id="addSingleChoice" type="button" class="btn btn-primary"><i class="fa fa-star"></i>下载TXT模板</button>
									</div>
									
								
								</div>
							
								<div class="form-group row">
								
									<label class="col-md-3  form-control-label" for="input_examContinued " style="margin-left:40px">
										指定试题分类
									</label>
									
									<div class="col-md-7">
										
										<div class="input-group">
											
											<input id="input_examContinued" type="text" class="form-control" name="" value="60" />
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
										上传文件
									</label>
									
									<div class="col-md-7">
										<input id="file-input" name="file-input" type="file">										
									</div>
									
								
								</div>
								
							</div>
						
						</div>
						
						<div class="card">
							
							<div class="card-block">
								
								<div class="form-group row">
									
									<div class="col-md-12">
										<textarea id="textarea_examinationArea" name="" rows="14" class="form-control" ></textarea>
									</div>
								
								</div>
							</div>	
						</div>
						
						<div class="card-footer">
							<center>
                              <button id="nextBtn" type="submit" class="btn  btn-primary" style="color:white" >
                              		 清空
                              </button>							
                              <button id="nextBtn" type="submit" class="btn  btn-primary" style="color:white" >
                              		检查格式
                              </button>
                               <button id="nextBtn" type="submit" class="btn  btn-primary" style="color:white" >
                              		导入&返回
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