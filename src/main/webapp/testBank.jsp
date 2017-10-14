<%--
  Created by IntelliJ IDEA.
  User: Lhy
  Date: 2017/5/25 0025
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <!-- Icons -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" media="all">

    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower_components/layer/layer.js"></script>
<script type="text/javascript" src="bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
//    $(document).ready(function(){
//        $('#datetimepicker').datetimepicker();
    // date time picker
//    if($(".iDate.full").length>0){
//        $(".iDate.full").datetimepicker({
//            locale: "zh-cn",
//            format: "YYYY-MM-DD a hh:mm",
//            dayViewHeaderFormat: "YYYY年 MMMM"
//        });
//    }
//    if($(".iDate.date").length>0){
//        $(".iDate.date").datetimepicker({
//            locale:"zh-cn",
//            format:"YYYY-MM-DD",
//            dayViewHeaderFormat:"YYYY年 MMMM"
//        });
//    }
//})
$(document).ready(function() {
    $(function () {

        $.ajax({
            type: "post",
            async: "true",
            url: "queryAllQuestion.do",
            success: function (data) {
                $("#banktable").html(data);
            },
            beforeSend: function () {
                $("#banktable").append('<div style="text-align: center"><img src="img/ajax-loader.gif"  /> <span>表格数据正在生成中</span></div>');
            }
        });


    })
    $('#import').on('click', function () {
        layer.open({
            type: 2,
            title: '导入试题',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['800px' , '520px'],
            content: 'bank_importSingle.jsp',
            end: function () {
                parent.location.reload();
            }
        });
    });

    $('#addQuestion').on('click', function () {
        layer.open({
            type: 2,
            title: '导入试题',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['1080px' , '700px'],
            content: 'bank_addQuestion.jsp',
            end: function () {
                parent.location.reload();
            }
        });
    });

    $('#addMoreQuestion').on('click', function () {
        layer.open({
            type: 2,
            title: '导入试题',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['1080px' , '700px'],
            content: 'bank_addMoreQuestion.jsp',
            end: function () {
                parent.location.reload();
            }
        });
    });
    $('#reset').on('click', function () {

        $("#bankform")[0].reset();

    })


})
function query() {


    $.ajax({

        type: "POST",
        url: "query.do",
        data: $('#bankform').serialize(),// 你的formid
        async: true,
        error: function (request) {
            alert("Connection error");
        },
        success: function (data) {
            $("#banktable").html(data);
        }
    });


}
    </script>

    <c:if test="${goodInformation!=null }">
        <script>
            layer.msg("${goodInformation}",{
                icon : 1
            });
        </script>
    </c:if>

    <c:if test="${badInformation!=null }">
        <script>
            layer.msg("${badInformation}",{
                icon : 2
            });
        </script>
    </c:if>

</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">

<jsp:include page="headbar.jsp"></jsp:include>
<jsp:include page="sidebar.jsp"></jsp:include>

<!-- Main content -->
<main class="main">

    <!-- Breadcrumb -->
    <ol class="breadcrumb" >
        <li class="breadcrumb-item">试题库</li>
        <!--                 <li class="breadcrumb-item"><a href="#">Admin</a>
                        </li> -->


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
            <div class="card">

                <div class="card-block" >
                    <form action="" id="bankform" method="post" >
                        <div class="row">
                            <div class="col-sm-4">
                        <div class="form-group" style="margin-left: 5%;">
                            <label >关键字搜索：</label>
                            <input type="text" class="form-control" name="keyname" placeholder="输入关键字">
                        </div>
                                </div>
                            <div class="col-sm-4">
                        <div class="form-group" style="margin-left: 2%;">
                            <label >试题分类：</label>
                            <select  class="form-control" name="subject">
                                <option ></option>
                                <option value="1">Java</option>
                                <option value="2">Web</option>
                                <option value="3">Linux</option>
                                <option value="4">Mysql</option>
                                </select>
                        </div>
                                </div>
                            <div class="col-sm-4">
                        <div class="form-group" style="margin-left: 2%;">
                            <label class="col-md-5 form-control-label" >试题类型</label>
                            <div class="col-md-7">
                                <select  class="form-control" name="type">
                                    <option ></option>
                                    <option value="1">单选题</option>
                                    <option value="2">多选题</option>
                                    <option value="3">判断题</option>
                                    <option value="4">问答题</option>
                                    <option value="5">填空题</option>
                                </select>
                            </div>
                        </div>
                                </div>
                            </div>
                        <div class="row">
                            <div class="col-md-4">
                        <div class="form-group">

                                <label class=" form-control-label" >难易度：</label>
                                <div class="col-md-8">
                                    <select  class="form-control" name="level">
                                        <option ></option>
                                        <option value="1">低级</option>
                                        <option value="2">中级</option>
                                        <option value="3">高级</option>
                                    </select>

                            </div>



                        </div>
                                </div>

                            <div class="col-md-4">
                        <div class="form-group">

                                <label class=" form-control-label" >创建时间：</label>
                                    <div class="input-group"  >
                                                    <input type="text" id="starttime" name="startdate"   class="form-control" >
                                                    <span class="input-group-addon"><i class="icon-calendar"></i>
                                                    </span>
                                        -
                                        <input type="text" id="endtime" name="enddate"   class="form-control" >
                                                    <span class="input-group-addon"><i class="icon-calendar"></i>
                                                    </span>
                                                </div>

                                    <script type="text/javascript">
    $("#starttime").datetimepicker({
        language:  'zh-CN',
  minView: "month",//设置只显示到月份
  format : "yyyy-mm-dd",//日期格式
  autoclose:true,//选中关闭
  todayBtn: true//今日按钮

    });

  $("#endtime").datetimepicker({
        language:  'zh-CN',
  minView: "month",//设置只显示到月份
  format : "yyyy-mm-dd",//日期格式
  autoclose:true,//选中关闭
  todayBtn: true//今日按钮

    });
</script>







                        </div>
                                </div>
                            </div>

                    </form>
                </div>
                <div class="card-footer">
                     <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" id="addMoreQuestion">+ 批量新增</button>
                     <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" id="addQuestion">+ 新增</button>
                    <button type="button" class="btn btn-sm btn-primary" id="import">导入试题</button>
                    <div style="float:right; display:inline">
                    <button onclick="query()" class="btn btn-sm btn-primary"><i class="fa fa-dot-circle-o"></i> 查询</button>
                    <button type="reset" class="btn btn-sm btn-danger" id="reset"><i class="fa fa-ban"></i>重置</button>
                        </div>
                </div>




            </div>


                <div class="card">

                    <div class="card-block" id="banktable">
                      
                    </div>

            </div>
            <!--/.col-->

        </div>

        </div>

    </div>
    <!-- 批量新增模态窗口-->

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">批量新增试题</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                     <div class="card">
                         <div class="card-block">
                             <form action="" method="post" enctype="multipart/form-data" class="form-horizontal ">
                                 <div class="form-group row">
                                     <label class="col-md-3 form-control-label">试题分类</label>
                                     <div class="col-md-9">
                                         <select name="select" class="form-control">
                                             <option value="0">Please select</option>
                                             <option value="1">Option #1</option>
                                             <option value="2">Option #2</option>
                                             <option value="3">Option #3</option>
                                         </select>

                                     </div>
                                 </div>

                                 <div class="form-group row">
                                     <label class="col-md-3 form-control-label">快速添加</label>
                                     <div class="col-md-9">
                                        <button type="button" class="btn btn-primary">单选题</button>
                                            <button type="button" class="btn btn-primary">多选题</button>
                                         <button type="button" class="btn btn-primary">判断题</button>
                                         <button type="button" class="btn btn-primary">填空题</button>
                                         <button type="button" class="btn btn-primary">问答题</button>

                                     </div>


                                 </div>
                                 <div class="form-group row">

                                            <div class="col-md-12">
                                                <textarea id="textarea-input" name="textarea-input" rows="18" class="form-control" placeholder="(题型:单选题)(标准答案:A)(分数:5)(试题分析:无)
公益性文化事业是保障公民及泵文化权益的重要途径。大力发展公益性文化事业，始终坚持放在首位的是（ ）
A.繁荣文化市场
B.经济效益
C.社会效益
D.创新文化体制

(题型:多选题)(标准答案:B,C)(分数:2)(试题分类:自然科学/医疗机械类)
各类安全工器具应经过国家规定的()和使用中的周期性试验，并做好记录。
A.出厂试验
B.型式试验
C.外观检验
D.耐压试验

(题型:填空题)(标准答案:神经和体液|作用时间较长&作用时间长)(分数:2)
运动员出发后心跳加快，是___调节的结果；运动停止后心跳并不立即恢复到正常水平，原因之一是激素调节具有___的特点。

(题型:判断题)(标准答案:B)(分数:5)
在同一个圆里 半径的数量是直径的一半。
A.正确
B.错误

(题型:问答题)(标准答案:在车轨上)(分数:5)(试题分类:百科知识/脑筋急转弯类)
火车由北京到上海需要6小时,行使3小时后,火车该在什么地方?
"></textarea>
                                            </div>
                                        </div>
        </form>
                             </div>
                     </div>
                </div>
                <div class="modal-footer" style="text-align: center">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">检查格式</button>
                    <button type="button" class="btn btn-primary">导入</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>

    <!-- 新增模态窗口-->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

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
