<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<li><i class="icon-home"></i> <a href="index.jsp">首页</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="gorequisition">调拨订单管理</a></li>
				</ul>

				<div class="row-fluid">
					<form action="getbyrsid" method="post" class="form-horizontal">
						<div class="control-group">
							<div data-condition="search">
								调拨单号:<input type="text" name="requisitionId"
									class="input-medium" placeholder="请输入调拨单号" /> 审核状态: <select
									name="rs_id">
									<option value="0">请选择</option>
									<c:forEach var="rs" items="${rslist }">
										<option value="${rs.rsId}">${rs.rsName }</option>
									</c:forEach>
								</select>
								<button type="submit" class="btn btn-success"
									data-command="search">
									<i class="icon-search"></i>&nbsp;搜索
								</button>
								<div style="float: right;">
									<a class="btn btn-primary" href="gorequisitionadd"
										data-command="Add"><i class="icon-plus"></i>&nbsp;新增调拨</a> <a
										class="btn btn-warning" href="javascript:void(0)"
										data-command="Delete"><i class="icon-remove"></i>&nbsp;删除</a>
									<a class="btn btn-danger" href="gorequisition"
										data-command="Refresh"><i class="icon-refresh"></i>&nbsp;刷新</a>
								</div>
							</div>
						</div>
					</form>
					<div class="box">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>调拨订单管理
							</h2>
						</div>
						<div style="clear: both;">&nbsp;</div>
						<div style="clear: both;">&nbsp;</div>
						<div class="box-content">
							<table
								class="table table-striped table-bordered bootstrap-datatable">
								<!-- table table-bordered table-striped table-condensed
								 -->
								<thead>
									<tr>
										<th><input type="checkbox"></th>
										<th>调拨单号</th>
										<th>制单人</th>
										<!-- 申请人 -->
										<th>制单时间</th>
										<!-- 申请时间 -->
										<th>审核人</th>
										<th>审核时间</th>
										<th>审核状态</th>
										<th>调出仓库</th>
										<th>调入仓库</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="res" items="${reslist.list}">
										<tr>
											<th><input type="checkbox"></th>
											<!--  -->
											<td>${res.requisitionId }</td>
											<!-- 调拨单号 -->
											<td class="center">${res.employeeByRequestEmp.empLoginName }</td>
											<!-- 制单人 -->
											<td class="center"><fmt:formatDate
													value="${res.requestTime }" pattern="yyyy-MM-dd" /></td>
											<!-- 制单时间 -->
											<td class="center">${res.employeeByReviewEmp.empLoginName }<!-- <span class="label label-success">Active</span> -->
											</td>
											<!-- 审核人 -->
											<td><fmt:formatDate value="${res.reviewTime }"
													pattern="yyyy-MM-dd" /></td>
											<!-- 审核时间 -->
											<td>${res.reviewstatus.rsName }</td>
											<!-- 审核状态 -->
											<td>${res.storehouseByOutboundStoreHouse.shName }</td>
											<td>${res.storehouseByStorageStoreHouse.shName }</td>
											<td class="center"><a class="btn btn-info btn-setting"
												href="requisitionId?requisitionId=${res.requisitionId }">查看
											</a><a class="btn btn-info btn-success"
												href="gorequisitionupdate?requisitionId=${res.requisitionId }">
													修改
											</a><a class="btn btn-info btn-success"
												href="gorequisitionupdate?requisitionId=${res.requisitionId }">审核</a>
												<a class="btn btn-info btn-success"
												href="gorequisitionupdate?requisitionId=${res.requisitionId }">删除</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="pagination pagination-centered">
							<ul id="productPageButton">
								<li><a href="gorequisition?pageNo=1">首页</a></li>
								<li><a href="javascript:goproductpage('pre');">上一页</a> <input
									type="hidden" name="pageNo"
									value="${reslist.pageNum}" /></li>
								<c:if test="${reslist.pageNum-2>1}">
									<li><a>...</a></li>
								</c:if>
								<c:forEach begin="1" end="${reslist.pages}" var="s">
									<c:if test="${s>=reslist.pageNum-2 && s<=reslist.pageNum+2 }">
										<li <c:if test="${s==reslist.pageNum}">class="active"</c:if>> 
											<a href="javascript:goproductpage(${s});">${s}</a> 
										</li> 
									</c:if>
								</c:forEach>
								<c:if test="${reslist.pageNum+2<reslist.pages}">
									<li><a>...</a></li>
								</c:if>
								<li><a href="javascript:goproductpage('next');">下一页</a></li>
								<li><a href="gorequisition?pageNo=${reslist.pages}">尾页</a></li>
								<li><h2>当前第${reslist.pageNum}页/共${reslist.pages}页</h2></li>
							</ul>
						</div>
					</div>
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
				<table style="width: 100%;">
					<tr style="height: 30px;">
						<td>
							<h3>调拨单号:</h3>${requisition.requisitionId }
						</td>
						<td>
							<h3>制单人:</h3>${requisition.employeeByRequestEmp.empLoginName }
						</td>
						<td><h3>制单时间:</h3><fmt:formatDate
							value="${requisition.requestTime }" pattern="yyyy-MM-dd" /></td>
					</tr>
					<tr style="height: 30px;">
						<td><h3>审核人:</h3>${requisition.employeeByReviewEmp.empLoginName }</td>
						<td><h3>审核时间:</h3><fmt:formatDate value="${requisition.reviewTime }"
								pattern="yyyy-MM-dd" /></td>
						<td><h3>审核状态:</h3>${requisition.reviewstatus.rsName }</td>
					</tr>
					<tr style="height: 30px;">
						<td><h3>调出仓库:</h3>${requisition.storehouseByOutboundStoreHouse.storeHouseId }</td>
						<td><h3>出库时间:</h3><fmt:formatDate
								value="${requisition.outboundStoreHouseTime }" pattern="yyyy-MM-dd" /></td>
						<td><h3>出库经办人:</h3>${requisition.employeeByOutboundEmp.empLoginName }</td>
					</tr>
					<tr style="height: 30px;">
						<td><h3>调入仓库:</h3>${requisition.storehouseByStorageStoreHouse.storeHouseId }</td>
						<td><h3>入库时间:</h3><fmt:formatDate
								value="${requisition.storageStoreHouseTime }" pattern="yyyy-MM-dd" /></td>
						<td><h3>入库经办人:</h3>${requisition.employeeByStorageStoreHouseEmp.empLoginName }</td>
					</tr>
				</table>
			</div>
			<div style="clear: both;">&nbsp;</div>
			<div class="box-content">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>产品名称</th>
							<th>产品编号</th>
							<th>规格</th>
							<th>数量</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Dennis Ji</td>
							<td class="center">2012/01/01</td>
							<td class="center">Member</td>
							<td class="center">Active</td>
						</tr>
						<tr>
							<td>Dennis Ji</td>
							<td>2012/01/01</td>
							<td class="center">Member</td>
							<td class="center">Active</td>
						</tr>
					</tbody>
				</table>
				<div class="pagination pagination-centered">
					<ul id="productPageButton">
						<li><a href="javascript:goproductpage('pre');">上一页</a> <input
							type="hidden" name="pageNo" value="${reslist.pageNum}" />
						</li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="javascript:goproductpage('next');">下一页</a></li>
					</ul>
				</div>
			</div>

		</div>
		<div class="modal-footer">
			<a href="#" class="btn btn-primary" data-dismiss="modal">关闭</a>
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

	<script src="static/js/bootstrap-transition.js"></script>
	<script src="static/js/bootstrap-modal.js"></script>
	<!-- end: JavaScript-->
	<script type="text/javascript">
		//产品信息分页实现  
		function goproductpage(type) {
			var pageNum = parseInt($("[name=pageNo]").val()); //获取当前的页码
			var pagePageTotal = parseInt('${reslist.pages}'); //总页数
			if(pageNum==1 && type=="pre"){
				return;
			}
			if(pageNum==pagePageTotal && type=="next"){
				return;
			}
			if (type == "next") { //下一页
				pageNum = pageNum + 1;
			} else if (type == "pre") { //上一页
				pageNum = pageNum - 1;
			} else {
				pageNum = parseInt(type);
			}
			location.href="gorequisition?pageNo="+pageNum;
		}
		/* 
		$.ajax({
			type : "POST",
			url :  "getProductByPage",
			data : "pageNum=" + pageNum,
			dataType : "JSON",
			success : function(result) {
				var s = "";
				for ( var i in result) {
					s += "<tr height='20px;'>"
							+ "<td><input type='checkbox' /></td>"
							+ "<td>"
							+ result[i].productName
							+ "</td>"
							+ "<td>"
							+ result[i].productId
							+ "</td>"
							+ "<td>"
							+ result[i].producttype.productTypeName
							+ "</td>"
							+ "<td>"
							+ result[i].productunit.puName 
							+ "<input type='hidden' value='"+result[i].productunit.productUnitId+"' />"
							+ "</td>"
							+ "<td><input type='number' min='0' value='0' style='width: 80%; margin: 0px auto; height: 80%;' /></td>"
							+ "</tr>";
				}
				$("#productBody").html(s);
			}
		});*/
	</script>
</body>
</html>
