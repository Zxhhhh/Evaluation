<%--
  Created by IntelliJ IDEA.
  User: Lhy
  Date: 2017/6/15 0015
  Time: 19:54
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
    <script>
        $(document).ready(function() {
            $(function(){
                for(var i=0;i<5;i++){
              if(i==${question.category}){
                  $("#subject").val(i);
              }


          }

            for(var i=0;i<5;i++){
                if(i==${question.category}){
                    $("#subject").val(i);
                }


            }



})


        })




    </script>


</head>
<body>
<div class="card">

    <div class="card-block">
        <form action="updateQuesion.do?questionId=${question.questionId}" method="post" target="_parent">
        <div class="row">
            <div class="col-sm-6">

                <div class="form-group" style="margin-left: 5%;">
                    <label>试题类型：</label>
                    <select  class="form-control" name="questionType">
                        <option></option>
                        <option value="1">单选</option>
                        <option value="2">简答</option>
                        <option value="3">填空</option>
                    </select>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group" style="margin-left: 2%;">
                    <label>科目：</label>
                    <select  id ="subject" class="form-control" name="category">
                        <option ></option>
                        <option value="1">java</option>
                        <option value="2">html</option>
                        <option value="3">mysql</option>
                    </select>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group" style="margin-left: 5%;">
                    <label >试题分数：</label>
                    <input type="text" class="form-control" name="questionSocre" placeholder="输入题目分值" value="${question.questionSocre}">
                </div>
            </div>

            <div class="col-sm-6">
                <div class="form-group" style="margin-left: 2%;">
                    <label class="col-md-5 form-control-label">难易度</label>
                    <div class="col-md-7">
                        <select  class="form-control" name="questionLevel">
                            <option></option>
                            <option value="1">不分难度</option>
                            <option value="2">低难度</option>
                            <option value="3">中难度</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="form-group row" style="margin-left: 2%;">
                    <label class="col-md- form-control-label" >试题内容</label>
                    <div class="col-md-11">
                        <textarea  name="questionTitle" rows="9" class="form-control" placeholder="Content..">${question.questionTitle}</textarea>
                    </div>
                </div>
            </div>


        </div>
        <div class="card">

            <div class="card-block">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>选项</th>
                        <th>描述</th>
                        <th>正确答案</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td style="text-align: center">A</td>
                        <td>  <textarea  name="optionA" rows="9" class="form-control" >${question.optionA}</textarea></td>
                        <td style="text-align: center"><input name="answerTrue" value="A" type="radio"></td>
                        <td style="text-align: center">
                            <a href="#" >删除</a>

                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: center">B</td>
                        <td>  <textarea  name="optionB" rows="9" class="form-control" >${question.optionB}</textarea></td>
                        <td style="text-align: center"><input name="answerTrue" value="B" type="radio"></td>
                        <td style="text-align: center">
                            <a href="#" >删除</a>

                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: center">C</td>
                        <td>  <textarea  name="optionC" rows="9" class="form-control" >${question.optionC}</textarea></td>
                        <td style="text-align: center"><input name="answerTrue" value="C" type="radio" ></td>
                        <td style="text-align: center">
                            <a href="#" >删除</a>

                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: center">D</td>
                        <td>  <textarea  name="optionD" rows="9" class="form-control" >${question.optionD}</textarea></td>
                        <td style="text-align: center"><input name="answerTrue" value="D" type="radio"></td>
                        <td style="text-align: center">
                            <a href="#" >删除</a>

                        </td>
                    </tr>


                    </tbody>
                </table>

            </div>
        </div>
        <div>
            <button type="button" class="btn btn-outline-secondary">添加选项</button>
        </div>
        <div class="card" style="margin-top: 3%;">
            <div class="card-block">
                <div class="row">

                    <div class="col-sm-12">
                        <div class="form-group row" style="margin-left: 2%;">
                            <label class="col-md- form-control-label" >试题分析</label>
                            <div class="col-md-11">
                                <textarea  name="questionAnalysis" rows="9" class="form-control" placeholder="输入分析内容">${question.questionAnalysis}</textarea>
                            </div>
                        </div>
                    </div>
                    </div>

                </div>
            </div>
            <div style="text-align: center">
                <button type="sumbit" class="btn btn-md btn-primary">更新</button>
                <button type="button" class="btn btn-md btn-primary">关闭</button>

            </div>
        </form>
        </div>
    </div>
</body>
</html>
