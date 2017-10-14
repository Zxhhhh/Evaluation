<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <style type="text/css">
        ul li a{
            cursor:pointer
        }



    </style>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script >
        $(document).ready(function() {
            //checkbox 全选/取消全选
            var isCheckAll = false;

            $("#checkAll").on("click",function(){

                if (isCheckAll) {
                    $("input[type='checkbox']").each(function () {
                        this.checked = false;
                    });
                    isCheckAll = false;
                } else {
                    $("input[type='checkbox']").each(function () {
                        this.checked = true;
                    });
                    isCheckAll = true;
                }

            } )

            $("#Delete").click(function(){
                var pageNum = $(this).attr('pageNum');

                   if(confirm('确定要删除所选吗?')){
                        var checks = $("input[name='check[]']:checked");
                         if(checks.length == 0){ alert('未选中任何项！');return false;}
                       //将获取的值存入数组
                         var checkData = new Array();
                          checks.each(function(){
                              alert("选中"+$(this).val());
                                checkData.push($(this).val());
                              });

                       $.ajax({
                           type:'post',
                           url :'delete.do',
                           data:{
                               pageNum:pageNum,
                               checks : checkData
                           },
                           success: function (data) {

                               $("#pageHtml").html(data);
                           }
                       })
                         }
                  })

            $("#export li a").click(function(){
                var pageNum = $(this).attr('pageNum');



//                    $.ajax({
//                        type:'post',
//                        url :'delete.do',
//                        data:{
//                            pageNum:pageNum,
//                            checks : checkData
//                        },
//                        success: function (data) {
//
//                            $("#pageHtml").html(data);
//                        }
//                    })

            })


            $("#pageul li a").on("click",function(){

                var url = $(this).attr('for');
                $.ajax({
                    type:'post',
                    url :url,

                    success: function (data) {
                    $("#pageHtml").html(data);
                    }
                })





            })
            $("table tr td a").on("click",function(){

                var id = $(this).attr('for');
                $.ajax({
                    type:'post',
                            url :"queryById.do?Id="+id,

                            success: function (data) {
                                layer.open({
                                    type: 1,
                            title: '编辑试题',
                            maxmin: true,
                            shadeClose: true, //点击遮罩关闭层
                            area : ['1080px' , '700px'],
                            content: data
                        });
                    }
                })





            })



        })




    </script>
</head>
<body>
<div id="pageHtml">
 <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th><input type="checkbox"  name="checkall" id="checkAll" ></th>
                                <th>试题内容</th>
                                <th>题型</th>
                                <th>试题分类</th>
                                <th>试题难度</th>
                                <th>标准答案</th>
                                <th>分数</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${list}">
        <tr>
            <td><input type="checkbox" name="check[]" value="${list.questionId}"></td>
<td>${list.questionTitle}</td>
<td>${list.questionType}</td>
<td>${list.subject}</td>
<td>${list.questionLevel}</td>
<td>${list.answerTrue}</td>
<td>${list.questionSocre}</td>
<td>${list.createTime}</td>
<td><a for="${list.questionId}">编辑</a></td>
        </tr>
    </c:forEach>
                            </tbody>
                        </table>
        <div>

            <div style="float: left;margin-right: 2%;">
            <button type="button" class="btn btn-md btn-primary" id="Delete" pageNum="${pageInfo.pageNum}">批量删除</button>
                <div class="btn-group dropup">
                    <button type="button" class="btn btn-md btn-primary dropdown-toggle"
                            data-toggle="dropdown">
                        导出当前查询结果 <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" id="export">
                        <li><a  class="dropdown-item" href="export.do?pageNum=${pageInfo.pageNum}" action="txt">导出Txt</a></li>
                        <li><a class="dropdown-item"  href="export.do?pageNum=${pageInfo.pageNum}" action="doc">导出Doc</a></li>
                        <li><a class="dropdown-item"  href="export.do?pageNum=${pageInfo.pageNum}" action="excel">导出Excel</a></li>

                    </ul>
                </div>
            </div>
            <div >
                <ul class="pagination" id="pageul">
                    <c:choose>
                        <c:when test="${pageInfo.hasPreviousPage}">
                            <li class="page-item"><a class="page-link" for="pageQuestion.do?pageNum=${pageInfo.pageNum}&hasPre=${pageInfo.hasPreviousPage}" >上一页</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled"><a class="page-link" href="#" >上一页</a>
                            </li>
                        </c:otherwise>

                    </c:choose>

                    <c:forEach var="index" begin="1" end="${pageInfo.pages }">
                        <c:choose>
                        <c:when test="${pageInfo.pageNum==index }">
                            <li class="page-item active">
                                <a class="page-link" for="pageQuestion.do?pageNum=${index}">${index}</a>
                            </li>

                        </c:when>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" for="pageQuestion.do?pageNum=${index}">${index}</a>
                </li>
            </c:otherwise>
                        </c:choose>
                  </c:forEach>
                    <c:choose>
                        <c:when test="${pageInfo.hasNextPage}">
                            <li class="page-item"><a class="page-link" for="pageQuestion.do?pageNum=${pageInfo.pageNum}&hasNext=${pageInfo.hasNextPage}" >下一页</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled"><a class="page-link" href="#" >下一页</a>
                            </li>
                        </c:otherwise>

                    </c:choose>

                </ul>
            </div>
        </div>
</div>
</body>
</html>