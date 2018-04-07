<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
					<form action="goenterstock" method="post" class="form-horizontal">
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
									value="搜索" class="btn btn-success" />
								<div style="float: right;">
									<a class="btn btn-primary" href="goenterstockadd"
										data-command="Add"><i class="icon-plus"></i>&nbsp;添加</a> <a
										class="btn btn-warning" href="javascript:void(0)"
										data-command="Delete"><i class="icon-remove"></i>&nbsp;删除</a>
									<a class="btn btn-danger" href="javascript:void(0)"
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
												<td>${s.reviewEmp.empLoginName }</td>
												<td>${s.reviewStatus.rsName}</td>
												<td><input type="hidden" value="${s.enterStockId}" />
													<a id="detail">查看</a> <a id="update"> 编辑</a> <a id="commit">
														提交</a> <a id="cancelOrder">取消</a> <a id="cancelOrder">入库</a> <a
													id="deptreview">审核</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="pagination pagination-centered">
								<ul>
									<li><a href="#">First</a></li>
									<li><a href="#">Prev</a></li>
									<c:if test="${ess.pageNum-2>1}">
										<li><a>...</a></li>
									</c:if>
									<c:forEach begin="1" end="${ess.pages}" var="s">
										<c:if test="${s>=ess.pageNum-2 && s<=ess.pageNum+2 }">
											<li <c:if test="${s==ess.pageNum}">class="active"</c:if>>
												<a href="javascript:goproductpage(${s});">${s}</a>
											</li>
										</c:if>
									</c:forEach>
									<c:if test="${ess.pageNum+2<ess.pages}">
										<li><a>...</a></li>
									</c:if>
									<li><a href="javascript:goproductpage('next');">Next</a> <!-- 隐藏域 存放当前页码 -->
										<input type="hidden" name="pageNo" value="${ess.pageNum}" /></li>
									<li><a href="#">Last</a></li>
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
			<h2>采购订单明细</h2>
		</div>
		<div class="modal-body">
			<!-- 采购订单中所有内容 -->
			<div>
				<table style="width: 100%; table-layout: fixed;">
					<tbody id="purchaseDetail">
						<tr style="height: 30px;">
							<td><h3>订单编号:</h3> <span></span></td>
							<td><h3>申请人:</h3>&nbsp;<span></span></td>
							<td><h3>申请时间:</h3> <span></span></td>
						</tr>
						<tr style="height: 30px;">
							<td><h3>供应商编号:</h3> <span></span></td>
							<td><h3>联系人:</h3>&nbsp;<span></span></td>
							<td><h3>电话:</h3>&nbsp;&nbsp;<span></span></td>
						</tr>
						<tr style="height: 30px;">
							<td><h3>部门审核人:</h3> <span></span></td>
							<td><h3>审核时间:</h3> <span></span></td>
							<td><h3>审核状态:</h3> <span></span></td>
						</tr>
						<tr style="height: 30px;">
							<td><h3>财务审核:</h3> <span></span></td>
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
							<th>数量</th>
							<th>单价</th>
						</tr>
					</thead>
					<tbody id="purchaseRequestDetail">
					</tbody>
				</table>
				<div class="pagination pagination-centered">
					<ul id="purchaseRequestDetailPage">

					</ul>
				</div>
			</div>
		</div>
		<div class="modal-footer">
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
	</script>
</body>
</html>