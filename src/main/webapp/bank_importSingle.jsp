<%--
  Created by IntelliJ IDEA.
  User: Lhy
  Date: 2017/6/9 0009
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>导入试题</title>
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/simple-line-icons.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" media="all">

    <!-- Main styles for this application -->
    <link href="css/style.css" rel="stylesheet">
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="layer/layer.js"></script>

    <script>
        $(document).ready(function() {

            $('#file').on('change', function () {
                var options = {
                    url:"test.do",
                    success: function (data) {
                        layer.msg(data);
                    }
                };

                // ajaxForm
                $("#importform").ajaxForm(options);

                $("#importform").ajaxSubmit(options);


                });

            $('#import').on('click', function () {
                var options_import = {
                    url:"importQuestion.do",
                    success: function (data) {
                        layer.msg(data);
                        $("#flag").append(data);
                    }
                };

                // ajaxForm
                $("#importform").ajaxForm(options_import);

                $("#importform").ajaxSubmit(options_import);


            });



            })







    </script>
</head>
<body>
<div class="card">
    <div class="card-block">
        <form  method="post" enctype="multipart/form-data" class="form-horizontal" id="importform" >
            <div class="form-group row">
                <label class="col-md-3 form-control-label">下载模板文件</label>
                <div class="col-md-9">
                    <a    class="btn btn-outline-primary" href="downloadExample.do?type=txt">下载Txt模板</a>
                    <a    class="btn btn-outline-primary" href="downloadExample.do?type=doc">下载Doc模板</a>
                    <a   class="btn btn-outline-primary" href="downloadExample.do?type=xls">下载Excel模板</a>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 form-control-label">科目</label>
                <div class="col-md-9">
                    <select name="subject" class="form-control">
                        <option>请选择科目</option>
                        <option value="1">java</option>
                        <option value="2">html5</option>
                        <option value="3">c++</option>
                    </select>

                </div>
            </div>

            <div class="form-group row">
                <label class="col-md-3 form-control-label">点击上传试题文件</label>
                <div class="col-md-9">
                    <input type="file"  id="file" name="filename"/>


                </div>


            </div>
            <div class="form-group row">

                <div class="col-md-12">
                    <div style="height:300px;border: 1px solid #9FA3A6 ;" id="flag"></div>
                </div>
            </div>
            <div style="text-align: center">
            <button type="button" class="btn btn-primary" >关闭</button>
            <button type="button" class="btn btn-primary" id="import">导入</button>
                </div>
        </form>
    </div>
</div>
</body>
</html>
