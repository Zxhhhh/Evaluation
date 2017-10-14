<script>		
			//t:datagrid标签中会生成的js方法，用于请求后台异步获取数据，显示，分页，查询等
			$(function() {
				//$.localStorage:没有时间限制的本地数据存储，解决了cookie存储空间不足的问题(cookie中每条cookie的存储空间为4k)，localStorage中一般浏览器支持的是5M大小
				storage = $.localStorage;
				if (!storage)
					storage = $.cookieStorage;
				//通过JavaScript方式创建数据网格,相当于<table class="easyui-datagrid">...</table>
				$('#collectControllerList').datagrid({
									idField : 'id',
									title : '采集控制器',
									url : 'collectControllerController.do?datagrid&field=id,collectPointId,collectPointEntity.address,code,sim,dataInterval,serviceIp,trafficThreshold,availTraffic,deviceStatus,',
									fit : true,		//允许表格自动缩放
									loadMsg : '数据加载中...', //加载的提示信息
									pageSize : 10,	//每页显示条数
									pagination : true, 		//显示分页工具栏
									pageList : [ 10, 20, 30 ],
									sortOrder : 'asc',	//排序规则
									rownumbers : true,	//显示行号的列
									singleSelect : true, 
									fitColumns : true,	//自动展开/合同列的大小，以适应的宽度
									striped : true,		//条纹
									showFooter : true,
									frozenColumns : [ [] ],
									columns : [ [
											{
												field : 'id',
												title : '编号',
												hidden : true,
												sortable : true
											},
											{
												field : 'collectPointId',
												title : '采集点ID',
												width : 120,
												hidden : true,
												sortable : true
											},
											{
												field : 'collectPointEntity.address',
												title : '采集点地址',
												width : 120,
												sortable : true
											},
											{
												field : 'code',
												title : '控制器编号',
												width : 100,
												sortable : true
											},
											{
												field : 'sim',
												title : 'SIM卡号码',
												width : 120,
												sortable : true
											},
											{
												field : 'dataInterval',
												title : '运行数据发送间隔(秒)',
												width : 120,
												sortable : true
											},
											{
												field : 'serviceIp',
												title : '服务器IP',
												width : 120,
												sortable : true
											},
											{
												field : 'trafficThreshold',
												title : '流量阀值',
												width : 100,
												sortable : true
											},
											{
												field : 'availTraffic',
												title : '当前可用流量',
												width : 120,
												sortable : true
											},
											{
												field : 'deviceStatus',
												title : '设备状态',
												width : 80,
												sortable : true,
												formatter : function(value,
														rec, index) {
													if (value == undefined)
														return '';
													var valArray = value
															.split(',');
													if (valArray.length > 1) {
														var checkboxValue = '';
														for ( var k = 0; k < valArray.length; k++) {
															if (valArray[k] == '1') {
																checkboxValue = checkboxValue
																		+ '正常'
																		+ ',';
															}
															if (valArray[k] == '2') {
																checkboxValue = checkboxValue
																		+ '报废'
																		+ ',';
															}
														}
														return checkboxValue
																.substring(
																		0,
																		checkboxValue.length - 1);
													} else {
														if (value == '1') {
															return '正常';
														}
														if (value == '2') {
															return '报废';
														} else {
															return value;
														}
													}
												}
											},
											{
												field : 'opt',
												title : '操作',
												width : 160,
												formatter : function(value,rec, index) { //格式化单元格函数,参数:字段值,行数据,行索引
													if (!rec.id) {
														return '';
													}
													var href = '';
													href += "[<a href='#' onclick=delObj('collectControllerController.do?del&id="
															+ rec.id
															+ "','collectControllerList')>";
													href += "删除</a>]";
													if ($.inArray(
															rec.deviceStatus,
															[ '1' ]) >= 0) {
														href += "[<a href='#' onclick=rejectObj('"
																+ rec.id
																+ "','"
																+ rec.code
																+ "','"
																+ index
																+ "')>";
														href += "报废</a>]";
													}
													href += "[<a href='#' onclick=insteadController('"
															+ rec.id
															+ "','"
															+ index + "')>";
													href += "更换</a>]";
													href += "[<a href='#' onclick=hisController('"
															+ rec.id
															+ "','"
															+ index + "')>";
													href += "历史记录</a>]";
													return href;
												}
											} ] ],
									onLoadSuccess : function(data) {  //url请求的路径方法成功后
										$("#collectControllerList").datagrid(
												"clearSelections");
									},
									/*
									onClickRow:点击一行的时候触发，参数包括：
  									rowIndex：点击的行的索引值，该索引值从0开始
  									rowData：对应于点击行的记录。
									*/
									onClickRow : function(rowIndex, rowData) {
										rowid = rowData.id;
										gridname = 'collectControllerList';
									}
								});
				//网格footer增加分页信息
				$('#collectControllerList').datagrid('getPager').pagination({
					beforePageText : '',
					afterPageText : '/{pages}',
					displayMsg : '{from}-{to}共 {total}条',
					showPageList : true,
					showRefresh : true
				});
				
				//网格做分页查询
				$('#collectControllerList').datagrid('getPager').pagination({
					onBeforeRefresh : function(pageNumber, pageSize) {
						$(this).pagination('loading');
						$(this).pagination('loaded');
					}
				});
				try {
					restoreheader();
				} catch (ex) {
				}
			});
			function reloadTable() {
				try {
					$('#' + gridname).datagrid('reload');
					$('#' + gridname).treegrid('reload');
				} catch (ex) {
				}
			}
			
			function reloadcollectControllerList() {
				$('#collectControllerList').datagrid('reload');
			}
			
			function getcollectControllerListSelected(field) {
				return getSelected(field);
			}
			
			function getSelected(field) {
				var row = $('#' + gridname).datagrid('getSelected');
				if (row != null) {
					value = row[field];
				} else {
					value = '';
				}
				return value;
			}
			
			function getcollectControllerListSelections(field) {
				var ids = [];
				var rows = $('#collectControllerList')
						.datagrid('getSelections');
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i][field]);
				}
				ids.join(',');
				return ids
			};
			
			function getSelectRows() {
				return $('#collectControllerList').datagrid('getChecked');
			}
			
			//保存头信息到storage存储中
			function saveHeader() {
				var columnsFields = null;
				var easyextends = false;
				try {
					columnsFields = $('#collectControllerList').datagrid(
							'getColumns');
					easyextends = true;
				} catch (e) {
					columnsFields = $('#collectControllerList').datagrid(
							'getColumnFields');
				}
				//在本地存储中获取列中隐藏的头信息,如id(init判断是否第一次调用)
				var cols = storage.get('collectControllerListhiddenColumns');
				var init = true;
				if (cols) {
					init = false;
				}
				var hiddencolumns = [];
				for ( var i = 0; i < columnsFields.length; i++) {
					if (easyextends) {
						hiddencolumns.push({
							field : columnsFields[i].field,
							hidden : columnsFields[i].hidden
						});
					} else {
						var columsDetail = $('#collectControllerList')
								.datagrid("getColumnOption", columnsFields[i]);
						if (init) {
							hiddencolumns.push({
								field : columsDetail.field,
								hidden : columsDetail.hidden,
								visible : (columsDetail.hidden == true ? false
										: true)
							});
						} else {
							for ( var j = 0; j < cols.length; j++) {
								if (cols[j].field == columsDetail.field) {
									hiddencolumns.push({
										field : columsDetail.field,
										hidden : columsDetail.hidden,
										visible : cols[j].visible
									});
								}
							}
						}
					}
				}
				//保存隐藏的字段数组到storage中
				storage.set('collectControllerListhiddenColumns', JSON
						.stringify(hiddencolumns));
			}
			
			function restoreheader() {
				var cols = storage.get('collectControllerListhiddenColumns');
				if (!cols)
					return;
				for ( var i = 0; i < cols.length; i++) {
					try {
						if (cols.visible != false)
							$('#collectControllerList').datagrid(
									(cols[i].hidden == true ? 'hideColumn'
											: 'showColumn'), cols[i].field);
					} catch (e) {
					}
				}
			}
			
/* 			function resetheader() {
				var cols = storage.get('collectControllerListhiddenColumns');
				if (!cols)
					return;
				for ( var i = 0; i < cols.length; i++) {
					try {
						$('#collectControllerList').datagrid(
								(cols.visible == false ? 'hideColumn'
										: 'showColumn'), cols[i].field);
					} catch (e) {
					}
				}
			} */
			
			//根据输入的条件进行组合 查询
			function collectControllerListsearch() {
				var queryParams = $('#collectControllerList').datagrid(
						'options').queryParams;
				$('#collectControllerListtb').find('*').each(function() {
					queryParams[$(this).attr('name')] = $(this).val();
				});
				$('#collectControllerList').datagrid(
								{
									url : 'collectControllerController.do?datagrid&field=id,collectPointId,collectPointEntity.address,code,sim,dataInterval,serviceIp,trafficThreshold,availTraffic,deviceStatus,',
									pageNumber : 1
								});
			}
			
			//做查询方法(分页)
			function dosearch(params) {
				var jsonparams = $.parseJSON(params);
				$('#collectControllerList')
						.datagrid(
								{
									url : 'collectControllerController.do?datagrid&field=id,collectPointId,collectPointEntity.address,code,sim,dataInterval,serviceIp,trafficThreshold,availTraffic,deviceStatus,',
									queryParams : jsonparams
								});
			}
			
			function collectControllerListsearchbox(value, name) {
				var queryParams = $('#collectControllerList').datagrid(
						'options').queryParams;
				queryParams[name] = value;
				queryParams.searchfield = name;
				$('#collectControllerList').datagrid('reload');
			}
			
			$('#collectControllerListsearchbox').searchbox({
				searcher : function(value, name) {
					collectControllerListsearchbox(value, name);
				},
				menu : '#collectControllerListmm',
				prompt : '请输入查询关键字'
			});
			
			//在条件框中,当按下Enter键时，进行条件查询
			function EnterPress(e) {
				var e = e || window.event;
				if (e.keyCode == 13) {
					collectControllerListsearch();
				}
			}
			//重置按钮
			function searchReset(name) {
				$("#" + name + "tb").find(":input").val("");
				collectControllerListsearch();
			}
</script>

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>采集控制器</title>
<script type="text/javascript" src="plug-in/mutiLang/zh-cn.js"></script>
<script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="plug-in/jquery/jquery.cookie.js"></script>
<script type="text/javascript"
	src="plug-in/jquery-plugs/storage/jquery.storageapi.min.js"></script>
<script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
<link id="easyuiTheme" rel="stylesheet"
	href="plug-in/easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="plug-in/easyui/themes/icon.css"
	type="text/css"></link>
<link rel="stylesheet" type="text/css"
	href="plug-in/accordion/css/accordion.css">
<script type="text/javascript"
	src="plug-in/easyui/jquery.easyui.min.1.3.2.js"></script>
<script type="text/javascript" src="plug-in/easyui/locale/zh-cn.js"></script>
<script type="text/javascript" src="plug-in/tools/syUtil.js"></script>
<script type="text/javascript"
	src="plug-in/easyui/extends/datagrid-scrollview.js"></script>
<script type="text/javascript"
	src="plug-in/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="plug-in/tools/css/common.css"
	type="text/css"></link>
<script type="text/javascript" src="plug-in/lhgDialog/lhgdialog.min.js"></script>
<script type="text/javascript" src="plug-in/tools/curdtools_zh-cn.js"></script>
<script type="text/javascript" src="plug-in/tools/easyuiextend.js"></script>
<script type="text/javascript"
	src="plug-in/jquery-plugs/hftable/jquery-hftable.js"></script>
<script type="text/javascript" src="plug-in/tools/json2.js"></script>
</head>
<body style="overflow-y: hidden" scroll="no">
	<form id="formobj" action="collectControllerController.do?save"
		name="formobj" method="post">
		<input type="hidden" id="btn_sub" class="btn_sub" /> 
		<!-- id隐藏域，用于区分添加与更新 -->
		<input id="id" name="id" type="hidden" value="${collectControllerPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1"
			class="formtable">

			<tr>
				<td align="right">
					<label class="Validform_label">
						采集点地址: 
					</label>
				</td>
				<td class="value">
						<c:choose>
							<c:when test="${address!=null }">
								<input  name="collectPointEntity.id"  value="${id}" type="hidden"  id="collectPointId">
								${address}
							</c:when>
							<c:otherwise>
								<input name="collectPointEntity.id" value="${id}" type="hidden" id="collectPointId"> 
								<input name="collectPointEntity.address" class="inputxt" value="${address}" id="address" readonly="readonly" datatype="*" /> 
								<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose_8a8a8a135d3e9722015d3e9722ce0000()">选择</a>
								<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll_8a8a8a135d3e9722015d3e9722ce0000();">清空</a>
							</c:otherwise>
						</c:choose>
					<span class="Validform_checktip"></span>
				</td>
				<script type="text/javascript">
					var windowapi = frameElement.api, W = windowapi.opener;
					function choose_8a8a8a135d3e9722015d3e9722ce0000() {
						var url = 'collectPointController.do?collectPoints';
						var initValue = $('#collectPointId').val();
						url += '&ids=' + initValue;
						if (typeof (windowapi) == 'undefined') {
							$.dialog({
										content : 'url:' + url,
										zIndex : 2100,
										title : '采集点选择',
										lock : true,
										width : 400,
										height : 350,
										left : '85%',
										top : '65%',
										opacity : 0.4,
										button : [
												{
													name : '确定',
													callback : clickcallback_8a8a8a135d3e9722015d3e9722ce0000,
													focus : true
												}, {
													name : '取消',
													callback : function() {
													}
												} ]
									});
						} else {
							$.dialog({
										content : 'url:' + url,
										zIndex : 2100,
										title : '采集点选择',
										lock : true,
										parent : windowapi,
										width : 400,
										height : 350,
										left : '85%',
										top : '65%',
										opacity : 0.4,
										button : [
												{
													name : '确定',
													callback : clickcallback_8a8a8a135d3e9722015d3e9722ce0000,
													focus : true
												}, {
													name : '取消',
													callback : function() {
													}
												} ]
									});
						}
					}
					function clearAll_8a8a8a135d3e9722015d3e9722ce0000() {
						if ($('#address').length >= 1) {
							$('#address').val('');
							$('#address').blur();
						}
						if ($("input[name='address']").length >= 1) {
							$("input[name='address']").val('');
							$("input[name='address']").blur();
						}
						$('#collectPointId').val("");
					}
					function clickcallback_8a8a8a135d3e9722015d3e9722ce0000() {
						iframe = this.iframe.contentWindow;
						var address = iframe
								.getcollectPointsListSelections('address');
						if ($('#address').length >= 1) {
							$('#address').val(address);
							$('#address').blur();
						}
						if ($("input[name='address']").length >= 1) {
							$("input[name='address']").val(address);
							$("input[name='address']").blur();
						}
						var id = iframe.getcollectPointsListSelections('id');
						if (id !== undefined && id != "") {
							$('#collectPointId').val(id);
						}
					}
				</script><br>
					
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">
						控制器编号: </label>
				</td>
				<td class="value">
						
						<c:if test="${collectControllerPage.code!=null }">
								${collectControllerPage.code}
						</c:if>
						<c:if test="${collectControllerPage.code==null }">
							<input class="inputxt" id="code" name="code" 
								   value="${collectControllerPage.code}" maxlength="32"  datatype="notzh" validType="collect_controller,code,id">
							<span class="Validform_checktip"></span>
						</c:if>
				</td>
			</tr>
			
			<c:if test="${collectControllerPage!=null}">
					<tr>
						<td align="right">
							<label class="Validform_label">
								SIM卡号码:
							</label>
						</td>
						<td class="value">
							${collectControllerPage.sim }
						</td>
					</tr>
			</c:if>

			<tr>
				<td align="right">
					<label class="Validform_label">运行数据发送间隔(秒): </label>
				</td>
				<td class="value">
					<input class="inputxt" id="dataInterval" name="dataInterval" datatype="n" value="${collectControllerPage.dataInterval}" maxlength="5" ignore="ignore">
					 <span class="Validform_checktip"></span>
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label class="Validform_label"> 密钥: </label>
				</td>
				<td class="value">
					<input class="inputxt" id="secretKey" name="secretKey" datatype="notzh" value="${collectControllerPage.secretKey}" maxlength="128" ignore="ignore"> 
					<span class="Validform_checktip"></span></td>
			</tr>
			
			<tr>
				<td align="right">
					<label class="Validform_label">
						服务器IP(三个固定IP","间隔):
					 </label>
				</td>
				<td class="value">
					<input class="inputxt" id="ip" name="serviceIp" style="width:60%" datatype="*" value="${collectControllerPage.serviceIp}" maxlength="64" ignore="ignore">
					<span class="Validform_checktip"></span></td>
			</tr>
			
			<tr>
				<td align="right">
					<label class="Validform_label">
						流量阀值(单位:MB): 
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="trafficThreshold" name="trafficThreshold" value="${collectControllerPage.trafficThreshold}" maxlength="5" datatype="n" ignore="ignore">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			
			<c:if test="${collectControllerPage!=null}">
				<tr>
					<td align="right">
						<label class="Validform_label">
							当前可用流量(单位:MB):
						</label>
					</td>
					<td class="value">
						${collectControllerPage.availTraffic}
					</td>
				</tr>
			</c:if>

		</table>
		
		<link rel="stylesheet" href="plug-in/Validform/css/style.css" type="text/css" />
		<link rel="stylesheet" href="plug-in/Validform/css/tablefrom.css" type="text/css" />
		<script type="text/javascript" src="plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
		<script type="text/javascript" src="plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
		<script type="text/javascript" src="plug-in/Validform/js/datatype_zh-cn.js"></script>
		<SCRIPT type="text/javascript" src="plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></SCRIPT>
		<script type="text/javascript">
			$(function() {
				$("#formobj")
						.Validform(
								{
									tiptype : 4,
									btnSubmit : "#btn_sub",
									btnReset : "#btn_reset",
									ajaxPost : true,
									usePlugin : {
										passwordstrength : {
											minLen : 6,
											maxLen : 18,
											trigger : function(obj, error) {
												if (error) {
													obj
															.parent()
															.next()
															.find(
																	".Validform_checktip")
															.show();
													obj
															.find(
																	".passwordStrength")
															.hide();
												} else {
													$(".passwordStrength")
															.show();
													obj
															.parent()
															.next()
															.find(
																	".Validform_checktip")
															.hide();
												}
											}
										}
									},
									callback : function(data) {
										var win = frameElement.api.opener;
										if (data.success == true) {
											frameElement.api.close();
											win.tip(data.msg);
										} else {
											if (data.responseText == ''
													|| data.responseText == undefined) {
												$.messager
														.alert('错误', data.msg);
												$.Hidemsg();
											} else {
												try {
													var emsg = data.responseText
															.substring(
																	data.responseText
																			.indexOf('错误描述'),
																	data.responseText
																			.indexOf('错误信息'));
													$.messager
															.alert('错误', emsg);
													$.Hidemsg();
												} catch (ex) {
													$.messager.alert('错误',
															data.responseText
																	+ "");
													$.Hidemsg();
												}
											}
											return false;
										}
										win.reloadTable();
									}
								});
			});
		</script>
	</form>
</body>