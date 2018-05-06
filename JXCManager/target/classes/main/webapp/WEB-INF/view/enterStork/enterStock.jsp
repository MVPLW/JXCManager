<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- start: Meta -->
<meta charset="utf-8">
<title></title>
<meta name="description" content="Bootstrap Metro Dashboard">
<meta name="author" content="Dennis Ji">
<meta name="keyword"
	content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<!-- end: Meta -->
<!-- start: Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- end: Mobile Specific -->

<!-- start: CSS -->
<link id="bootstrap-style" href="static/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet">
<link id="base-style" href="static/css/style.css" rel="stylesheet">
<link id="base-style-responsive" href="static/css/style-responsive.css"
	rel="stylesheet">
<!-- <link rel="stylesheet" href="static/css/bootstrap.css"/> -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
	rel='stylesheet' type='text/css'>
<!-- end: CSS -->

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="static/css/ie.css" rel="stylesheet">
	<![endif]-->

<!--[if IE 9]>
		<link id="ie9style" href="static/css/ie9.css" rel="stylesheet">
	<![endif]-->

<!-- start: Favicon -->
<link rel="shortcut icon" href="static/img/favicon.png">
<!-- end: Favicon -->

</head>
<style type="text/css">
h3 {
	display: inline;
}
</style>

<body>
	<div class="container-fluid-full">
		<div class="row-fluid">
			<!-- start: Content -->
			<div id="content" class="span10">
				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="javascript:;">首页</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="form">入库订单管理</a></li>
				</ul>
				<div class="row-fluid">
					<form action="goenterstock" method="post" class="form-horizontal"
						id="enterMyForm">
						<div class="control-group">
							<div data-condition="search">
								入库单号:<input type="text" name="singleNo" class="input-medium"
									value="${singleNo}" placeholder="请输入入库单号" /> 仓库名字:<input
									type="text" name="shName" value="${shName}"
									class="input-medium" placeholder="请输入仓库名字" /> 时间: <input
									type="text" class="input-small datepicker" readonly="readonly"
									<c:if test="${start!=null}">value="${start }"</c:if> id="start"
									name="start" placeholder="开始日期" /> <input type="text"
									class="input-small datepicker" readonly="readonly"
									<c:if test="${end!=null}">value="${end }"</c:if> id="end"
									name="end" placeholder="结束日期" /> <input type="submit"
									id="searchblueey" value="搜索" class="btn btn-success" />
								<div style="float: right;">
									<a class="btn btn-primary" href="goenterstockadd"
										data-command="Add"><i class="icon-plus"></i>&nbsp;添加</a> <a
										class="btn btn-warning" href="javascript:void(0)"
										onclick="deleteEnterStock()" data-command="Delete"><i
										class="icon-remove"></i>&nbsp;删除</a>
									<div class="btn-group">
										<button class="btn btn-success dropdown-toggle"
											data-toggle="dropdown">
											<span class="caret"></span>&nbsp;导出
										</button>
										<ul class="dropdown-menu">
											<li><a href="javascript:;" onclick="exportCurrentData()">导出当前数据</a></li>
											<li><a href="javascript:;" onclick="exportAllData()">导出所有数据</a></li>
										</ul>
									</div>
									<a class="btn btn-danger" href="javascript:void(0)"
										onclick="javascript:location.href='goenterstock';"
										data-command="Refresh"><i class="icon-refresh"></i>&nbsp;刷新</a>
								</div>
							</div>
						</div>
						<div class="box">
							<div class="box-header" data-original-title>
								<h2>
									<i class="halflings-icon white user"></i><span class="break"></span>入库单管理
								</h2>
							</div>
							<div style="clear: both;">&nbsp;</div>
							<div class="box-content" style="z-index: 1;">
								<table
									class="table table-striped table-bordered bootstrap-datatable">
									<thead>
										<tr>
											<th><input type="checkbox" id="productCheckAll" /></th>
											<th>入库单号</th>
											<th>仓库</th>
											<th>入库时间</th>
											<th>入库类型</th>
											<th>审核人</th>
											<th>审核状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="productBody">
										<c:forEach items="${ess.list}" var="s">
											<tr>
												<th><input type="checkbox" name="productCheck"
													value="${s.enterStockId}" /></th>
												<td>${s.enterStockId }</td>
												<td>${s.storehouse.shName}</td>
												<td><fmt:formatDate value="${s.enterDate}"
														pattern="yyyy-MM-dd" /></td>
												<td>${s.enterstocktype.estName}</td>
												<td>${s.reviewEmp.empLoginName}</td>
												<td><c:if
														test="${s.reviewStatus!=null && s.reviewStatus.rsId==2}">
														<!-- 审核通过 -->
														<span class="label label-success">${s.reviewStatus.rsName}</span>
													</c:if> <c:if
														test="${s.reviewStatus!=null && s.reviewStatus.rsId==3}">
														<!-- 审核拒绝 -->
														<span class="label label-important">${s.reviewStatus.rsName}</span>
													</c:if></td>
												<td><input type="hidden" value="${s.enterStockId}" />
													<a id="detail" href="javascript:;">查看</a> <c:if
														test="${s.reviewStatus.rsId!=2}">
														<a id="updateEnterStock"> 编辑</a>
														<a id="review" href="javascript:;">审核</a>
													</c:if></td>
											</tr>
										</c:forEach>
										<c:if test="${fn:length(ess.list)==0}">
											<tr>
												<th colspan="8">对不起 没有查询到数据</th>
											</tr>
										</c:if>
									</tbody>
								</table>
							</div>
							<div class="pagination pagination-centered">
								<ul>
									<li><a href="javascript:;" onclick="goenterstock(1)">First</a></li>
									<li><a href="javascript:;" onclick="goenterstock('prev')">Prev</a></li>
									<c:if test="${ess.pageNum-2>1}">
										<li><a>...</a></li>
									</c:if>
									<c:forEach begin="1" end="${ess.pages}" var="s">
										<c:if test="${s>=ess.pageNum-2 && s<=ess.pageNum+2 }">
											<li <c:if test="${s==ess.pageNum}">class="active"</c:if>>
												<a href="javascript:;" onclick="goenterstock(${s})">${s}</a>
											</li>
										</c:if>
									</c:forEach>
									<c:if test="${ess.pageNum+2<ess.pages}">
										<li><a>...</a></li>
									</c:if>
									<li><a href="javascript:;" onclick="goenterstock('next')">Next</a>
										<!-- 隐藏域 存放当前页码 --> <input type="hidden" name="pageNo"
										value="${ess.pageNum}" /></li>
									<li><a href="javascript:;"
										onclick="goenterstock(${ess.pages})">Last</a></li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal hide fade" id="myModal" style="width: 800px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">x</button>
			<h2>入库单明细</h2>
		</div>
		<div class="modal-body">
			<!-- 采购订单中所有内容 -->
			<div>
				<table style="width: 100%; table-layout: fixed;">
					<tbody id="enterStockDetail">
						<tr style="height: 30px;">
							<td><h3>入库单号:</h3> <span></span></td>
							<td><h3>申请人:</h3>&nbsp;<span></span></td>
							<td><h3>申请时间:</h3> <span></span></td>
						</tr>
						<tr style="height: 30px;">
							<td><h3>仓库:</h3> <span></span></td>
							<td><h3>入库类型:</h3>&nbsp;<span></span></td>
							<td><h3>上游单号:</h3>&nbsp;&nbsp;<span></span></td>
						</tr>
						<tr style="height: 30px;">
							<td><h3>部门审核人:</h3> <span></span></td>
							<td><h3>审核时间:</h3> <span></span></td>
							<td><h3>审核状态:</h3> <span></span></td>
						</tr>
						<tr style="height: 30px;">
							<td colspan="3">
								<h3>备注:</h3>&nbsp;&nbsp;&nbsp;&nbsp;<span id="remark"></span>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div style="clear: both;">&nbsp;</div>
			<div class="box-content">
				<table class="table table-bordered" style="table-layout: fixed;">
					<thead>
						<tr>
							<th>产品名称</th>
							<th>产品编号</th>
							<th>规格</th>
							<th>应入库</th>
							<th>实际入库</th>
							<th>单价</th>
						</tr>
					</thead>
					<tbody id="enterStockProductDetails">
					</tbody>
				</table>
				<div class="pagination pagination-centered">
					<ul id="enterStockDetailPage">

					</ul>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn btn-primary" data-dismiss="modal">Close</a>
		</div>
	</div>
	<!-- 审核弹框 -->
	<div class="modal hide fade" id="reviewModal" style="width: 800px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">x</button>
			<h2>部门审核</h2>
		</div>
		<div class="modal-body">
			<div>
				<table style="width: 100%; table-layout: fixed;">
					<tbody>
						<tr>
							<th style="width: 120px;">部门审核是否通过</th>
							<th>
								<div class="controls">
									<label class="radio"> <input type="radio"
										name="reviewCheck" value="1" checked="checked" /> 是
									</label> <label class="radio" style="position: relative; top: 3px;">
										<input type="radio" name="reviewCheck" value="0" /> 否
									</label>
								</div>
							</th>
						</tr>
						<tr>
							<th>原因</th>
							<th style="padding-right: 20px;"><textarea rows="4"
									id="reviewReason" cols="30" style="width: 100%;"></textarea></th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="modal-footer">
			<a href="javascript:;" class="btn btn-primary" id="reviewCommit">Save</a>
			<a href="#" class="btn btn-primary" data-dismiss="modal">Close</a>
		</div>
	</div>

	<!-- start: JavaScript-->
	<script src="static/js/jquery-1.9.1.min.js"></script>
	<script src="static/js/jquery-migrate-1.0.0.min.js"></script>
	<script src="static/js/jquery-ui-1.10.0.custom.min.js"></script>
	<script src="static/js/jquery.ui.touch-punch.js"></script>
	<script src="static/js/modernizr.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/jquery.cookie.js"></script>
	<script src="static/js/fullcalendar.min.js"></script>
	<script src="static/js/jquery.dataTables.min.js"></script>
	<script src="static/js/excanvas.js"></script>
	<script src="static/js/jquery.flot.js"></script>
	<script src="static/js/jquery.flot.pie.js"></script>
	<script src="static/js/jquery.flot.stack.js"></script>
	<script src="static/js/jquery.flot.resize.min.js"></script>
	<script src="static/js/jquery.chosen.min.js"></script>
	<script src="static/js/jquery.uniform.min.js"></script>
	<script src="static/js/jquery.cleditor.min.js"></script>
	<script src="static/js/jquery.noty.js"></script>
	<script src="static/js/jquery.elfinder.min.js"></script>
	<script src="static/js/jquery.raty.min.js"></script>
	<script src="static/js/jquery.iphone.toggle.js"></script>
	<script src="static/js/jquery.uploadify-3.1.min.js"></script>
	<script src="static/js/jquery.gritter.min.js"></script>
	<script src="static/js/jquery.imagesloaded.js"></script>
	<script src="static/js/jquery.masonry.min.js"></script>
	<script src="static/js/jquery.knob.modified.js"></script>
	<script src="static/js/jquery.sparkline.min.js"></script>
	<script src="static/js/counter.js"></script>
	<script src="static/js/retina.js"></script>
	<script src="static/js/custom.js"></script>

	<script src="static/own/purchase.js"></script>
	<!-- end: JavaScript-->
	<script type="text/javascript">
		$(function() {
			
		});
		/* 分页跳转页面 */
		function goenterstock(type){
			var pageNo = parseInt($("input[name=pageNo]").val());
			var pagetotal=parseInt('${ess.pages}');
			if(type=='prev'){
				if(pageNo==1) return;
				pageNo-=1;
			}else if(type=='next'){
				if(pageNo==pagetotal) return;
				pageNo+=1;
			}else{
				pageNo=parseInt(type);
			}
			//location.href="goenterstock?pageNo="+pageNo;
			$("input[name=pageNo]").val(pageNo);
			//$("#searchblueey").click();
			$("#enterMyForm").submit();
		}

		/* 导出当前显示的数据 */
		function exportCurrentData() {
			var singleNo = $("input[name=singleNo]").val();
			var shName = $("input[name=shName]").val();
			var pageNo = parseInt($("input[name=pageNo]").val());
			var start=$("#start").val();
			var end=$("#end").val();
			location.href = "enterStockExport?pageNo="+pageNo+"&shName="+shName+"&singleNo="+singleNo+"&start="+start+"&end="+end;
		}
		/* 导出所有数据 */
		function exportAllData() {
			location.href = "enterStockExport";
		}
		
		$("#productBody a").live('mouseover', function() {
			$(this).css("cursor", "pointer");
			$(this).css("color", "#298AEB");
		});
		$("#productBody a").live('mouseout', function() {
			$(this).css("color", "#646464");
		});
		//查看详细信息
		$("#detail").live('click',function() {
			empty();
			/* 每次点击详情之前  清空详情 */
			$("#enterStockProductDetails").html(" ");
			$("#enterStockDetailPage").html(" "); //每次点击之前 目录清空
			$("#myModal").modal("show");
			var singleNo = $(this).parent().find("input:hidden").val();
			$.ajax({
				type:"POST",
				url:"getEnterStockBySingleNo",
				data:"singleNo="+singleNo,
				dataType:"JSON",
				success:function(result){
					enterStockDetailAss(result);
					disDetailPageNum(result);
					assignmentForEnterStock(result);
				}
			});
		});
		/* 显示所有页码 */
		function disDetailPageNum(result) {
			var pageNo = result.pageNum;
			var pageTotal = result.pages;
			//页码数
			var detailPages = "<li><a href='javascript:goDetailPage(-1,"
					+ pageNo + "," + pageTotal + ")'>Prev</a></li>";
			for (var i = 1; i <= result.pages; i++) {
				if (i == result.pageNum) {
					detailPages += "<li class='active'><a href='javascript:goDetailPage("
							+ i
							+ ","
							+ pageNo
							+ ","
							+ pageTotal
							+ ")'>"
							+ i
							+ "</a></li>"
				} else {
					detailPages += "<li><a href='javascript:goDetailPage(" + i
							+ "," + pageNo + "," + pageTotal + ")'>" + i
							+ "</a></li>";
				}
			}
			detailPages += "<li><a href='javascript:goDetailPage(-2," + pageNo
					+ "," + pageTotal + ")'>Next</a></li>";
			$("#enterStockDetailPage").html(detailPages);
		}

		//分页查询明细  ajax实现
		function goDetailPage(type, pageNum, pageTotal) {
			if (type == -1) { //上一页
				if (pageNum == 1) {
					return;
				}
				pageNum -= 1;
			} else if (type == -2) { //下一页
				if (pageNum == pageTotal) {
					return;
				}
				pageNum += 1;
			} else {
				pageNum = type;
			}
			var singleNo = $("#enterStockDetail").children("tr:eq(0)").children(
					"td:eq(0)").find("span").html();
			$.ajax({
				type : "POST",
				url : "getEnterStockBySingleNo",
				data : "singleNo=" + singleNo + "&pageNo=" + pageNum,
				dataType : "JSON",
				success : function(result) {
					//为表格详情赋值
					enterStockDetailAss(result);
					//显示页码目录
					disDetailPageNum(result);
				}
			});
		}
		
		/* 为入库的详情商品赋值 */
		function enterStockDetailAss(result) {
			var s = "";
			for (var i = 0; i < result.list.length; i++) {
				s += "<tr><td>" + result.list[i].product.productName
						+ "</td><td>" + result.list[i].product.productId
						+ "</td><td>" + result.list[i].productUnit.puName
						+ "</td><td>"+result.list[i].shouldCount+"</td><td>" + result.list[i].productCount + "</td>"
						+ "<td>" + result.list[i].productPrice + "</td>" + "</tr>";
			}
			$("#enterStockProductDetails").html(s);
		}
		/* 为入库基本信息的弹框赋值  */
		function assignmentForEnterStock(result){
			$("#enterStockDetail")
				.children("tr:eq(0)")
				.children("td:eq(0)")
				.find("span")
				.html(result.list[0].enterstock.enterStockId);
			$("#enterStockDetail")
				.children("tr:eq(0)")
				.children("td:eq(1)")
				.find("span")
				.html(result.list[0].enterstock.employee.empLoginName);
			var requestTime = dateformat(result.list[0].enterstock.enterDate);
			$("#enterStockDetail").children(
					"tr:eq(0)").children(
					"td:eq(2)").find("span")
					.html(requestTime);
			$("#enterStockDetail")
					.children("tr:eq(1)")
					.children("td:eq(0)")
					.find("span")
					.html(result.list[0].enterstock.storehouse.shName);
			$("#enterStockDetail")
				.children("tr:eq(1)")
				.children("td:eq(1)")
				.find("span")
				.html(result.list[0].enterstock.enterstocktype.estName);
			$("#enterStockDetail")
				.children("tr:eq(1)")
				.children("td:eq(2)")
				.find("span")
				.html(result.list[0].enterstock.upstreamNo);
			$("#enterStockDetail")
				.children("tr:eq(3)")
				.children("td:eq(0)")
				.find("span")
				.html(result.list[0].enterstock.remark);
			$("#enterStockDetail")
				.children("tr:eq(2)")
				.children("td:eq(0)")
				.find("span")
				.html(result.list[0].enterstock.reviewEmp.empLoginName);
			/* 审核时间 */
			var s=dateformat(result.list[0].enterstock.reviewDate);
			$("#enterStockDetail")
				.children("tr:eq(2)")
				.children("td:eq(1)")
				.find("span")
				.html(s);
			$("#enterStockDetail")
				.children("tr:eq(2)")
				.children("td:eq(2)")
				.find("span")
				.html(result.list[0].enterstock.reviewStatus.rsName);
		}
		
		/* 每次点开详情之前清空 */
		function empty(){
			for(var i = 0 ; i < 3 ; i++){
				for(var j = 0 ; j < 3 ; j++){
					$("#enterStockDetail").children("tr:eq("+i+")").children("td:eq("+j+")")
						.find("span").html("");
				}
			}
			$("#enterStockDetail").children("tr:eq(3)").children("td:eq(0)")
				.find("span").html("");
		}
		/* 点击审核按钮 */
		var singleNo;   //全局变量  保存点击的单据单号
		$("#review").live("click",function(){
			$("#reviewModal").modal("show");
			singleNo=$(this).parent().find("input:hidden").val();
		});
		/* 点击保存按钮 */
		$("#reviewCommit").live('click',function() { //点击保存
			var s = $("input[name=reviewCheck]:checked").val(); //审核是否通过 0 表示不通过  1表示通过
			var reason = $("#reviewReason").val(); //审核原因
			if (reason == "" || reason == undefined) {
				alert("请输入原因");
				return;
			}
			location.href = "enterStockReview?singleNo=" + singleNo+ "&no=" + s + "&reason=" + reason;
		});

		$("#updateEnterStock").live('click',function(){
			var s=$(this).parent().find("input:hidden").val();
			location.href="goEnterStockUpdate?singleNo="+s;
		});
		/* 删除入库单 */
		function deleteEnterStock(){
			var s = $("#productBody input[name='productCheck']:checked");
			if (s.length == 0) {
				alert("请选择订单");
				return;
			}
			var aa=confirm("确认删除入库单吗 ? 此操作不可撤销");
			if(aa==true){
				$.ajaxSettings.async = false;
				var enterStocks = "-";
				var flag = false;
				$(s).each(function() { //循环所有选中的框
					var a = $(this).val();
					/* $.get("judgmen", {
						singleNo : $(this).val()
					}, function(result) {
						if (result == "0") {
							alert("处于采购流程中的单据不可以删除");
							flag = true;
							return;
						} else {
							purchases += a + "-";
						}
					}); */
					enterStocks += a + "-";
				});
				//alert(enterStocks);
				/* if (flag == false) {
					location.href = "deletePurchases?singleNos=" + purchases;
				} */
				location.href = "deleteEnterStocks?enterStocks=" + enterStocks;
			}
		}
	</script>
</body>
</html>