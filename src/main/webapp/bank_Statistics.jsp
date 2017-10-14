<%--
  Created by IntelliJ IDEA.
  User: Lhy
  Date: 2017/6/21 0021
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" media="all">

    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">
<jsp:include page="headbar.jsp"></jsp:include>
<jsp:include page="sidebar.jsp"></jsp:include>
<main class="main">
<ol class="breadcrumb">
    <li class="breadcrumb-item">首页</li>
    <li class="breadcrumb-item"><a href="#">试题库</a>
    </li>
    <li class="breadcrumb-item active">试题统计</li>

</ol>
    <div class="container-fluid">
        <div class="animated fadeIn">
    <div class="row">
    <div class="card">
        <div class="card-footer">
            <ul>
                <li>
                    <div class="text-muted">考生数</div>
                    <strong>500</strong>

                </li>
                <li class="hidden-sm-down">
                    <div class="text-muted">试题数</div>
                    <strong>540</strong>

                </li>
                <li>
                    <div class="text-muted">科目数</div>
                    <strong>5</strong>

                </li>
                <li class="hidden-sm-down">
                    <div class="text-muted">考试数</div>
                    <strong>1</strong>

                </li>
                <li class="hidden-sm-down">
                    <div class="text-muted">试卷数</div>
                    <strong>40</strong>

                </li>
            </ul>
        </div>


    </div>
        </div>
<div class="row">
    <div class="col-md-12">
        <div class="card">

            <div class="card-block">

                <table class="table table-hover table-outline mb-0 hidden-sm-down">
                    <thead class="thead-default">
                    <tr>
                        <th class="text-center">题目</th>
                        <th>科目</th>
                        <th >试题类型</th>
                        <th class="text-center">正确率</th>
                        <th class="text-center">难度</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="text-center">
                           题目测试1
                        </td>
                        <td>
                            Java
                        </td>
                        <td>
                            单选
                        </td>
                        <td>
                            <div class="clearfix">
                                <div class="float-left">
                                    <strong>50%</strong>
                                </div>
                                <div class="float-right">
                                    <small class="text-muted">2017-6-17 20:21:55</small>
                                </div>
                            </div>
                            <div class="progress progress-xs">
                                <div class="progress-bar bg-success" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </td>
                        <td class="text-center">
                          低难度
                        </td>
                        <td>
                            <a href="#">查看</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">
                            题目测试1
                        </td>
                        <td>
                            Java
                        </td>
                        <td>
                            单选
                        </td>
                        <td>
                            <div class="clearfix">
                                <div class="float-left">
                                    <strong>80%</strong>
                                </div>
                                <div class="float-right">
                                    <small class="text-muted">2017-6-17 20:21:55</small>
                                </div>
                            </div>
                            <div class="progress progress-xs">
                                <div class="progress-bar bg-success" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </td>
                        <td class="text-center">
                            低难度
                        </td>
                        <td>
                            <a href="#">查看</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">
                            题目测试2
                        </td>
                        <td>
                            Web
                        </td>
                        <td>
                            多选
                        </td>
                        <td>
                            <div class="clearfix">
                                <div class="float-left">
                                    <strong>40%</strong>
                                </div>
                                <div class="float-right">
                                    <small class="text-muted">2017-6-15 20:21:55</small>
                                </div>
                            </div>
                            <div class="progress progress-xs">
                                <div class="progress-bar bg-warning" role="progressbar" style="width: 40%" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </td>
                        <td class="text-center">
                            高难度
                        </td>
                        <td>
                            <a href="#">查看</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">
                            题目测试1
                        </td>
                        <td>
                            Java
                        </td>
                        <td>
                            单选
                        </td>
                        <td>
                            <div class="clearfix">
                                <div class="float-left">
                                    <strong>20%</strong>
                                </div>
                                <div class="float-right">
                                    <small class="text-muted">2017-6-17 20:21:55</small>
                                </div>
                            </div>
                            <div class="progress progress-xs">
                                <div class="progress-bar bg-danger" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </td>
                        <td class="text-center">
                            中难度
                        </td>
                        <td>
                            <a href="#">查看</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!--/.col-->
</div>
</div>
    </div>
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
