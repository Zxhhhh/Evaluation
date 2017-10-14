<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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


	<script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	</head>



<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">

	<jsp:include page="headbar.jsp"></jsp:include>
	<jsp:include page="sidebar.jsp"></jsp:include>

        <!-- Main content -->
        <main class="main">

            <!-- Breadcrumb -->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">wmail</li>
<!--                 <li class="breadcrumb-item"><a href="#">Admin</a>
                </li> -->
                <li class="breadcrumb-item active">标题</li>

                <!-- Breadcrumb Menu-->
<!--                 <li class="breadcrumb-menu hidden-md-down">
                    <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                        <a class="btn btn-secondary" href="#"><i class="icon-speech"></i></a>
                        <a class="btn btn-secondary" href="./"><i class="icon-graph"></i> &nbsp;Dashboard</a>
                        <a class="btn btn-secondary" href="#"><i class="icon-settings"></i> &nbsp;Settings</a>
                    </div>
                </li> -->
                
                
            </ol>


            <div class="container-fluid">
                <div class="animated fadeIn">
					正文
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