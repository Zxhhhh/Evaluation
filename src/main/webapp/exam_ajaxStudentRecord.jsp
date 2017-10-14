<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'exam_ajaxStudentRecord.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="img/favicon.png">


    <!-- Icons -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">

    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">
    
  <style type="text/css">
    
    .importantNumber{
    
    	color:red;
    	font-weight: 700;
    
    }
    
    .redNumber{
    
    	color:red;
    
    }
    
    .greenNumber{
    
    	color:green;
    	
    }
        
    </style>
    
    <script type="text/javascript">
    
    $(function(){
    	

    	
    })
    
    
    
    
    </script>

</head>

<body>

	<table class="table table-hover table-outline mb-0 hidden-sm-down">
		<thead class="thead-default">
			<tr>
				<th style="text-align: center;"><i class="icon-people"></i>
					考生姓名</th>
				<th class="text-center"><i class="icon-speedometer"></i>
					开始时间/交卷时间</th>
				<th style="text-align: center;">考试用时(分钟 )</th>
				<th style="text-align: center;">总/及格分</th>
				<th style="text-align: center;">成绩</th>
				<th style="text-align: center;">是否合格</th>
				<th style="text-align: center;">考试方式</th>
				<th style="text-align: center;">排名</th>
				<th style="text-align: center;">操作</th>
			</tr>
		</thead>
		<tbody>
			


		</tbody>
	</table>

</body>
</html>
