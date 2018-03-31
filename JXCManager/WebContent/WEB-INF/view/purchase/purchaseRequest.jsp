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
					<li><i class="icon-home"></i> <a href="index.html">首页</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="form">采购订单管理</a></li>
				</ul>

				<div class="row-fluid">
					<form action="gopurchase" method="post" class="form-horizontal">
						<div class="control-group">
							<div data-condition="search">
								采购单号:<input type="text" name="singleNo" class="input-medium"
									placeholder="请输入申请单号" value="${singleNo}" /> 申请人:<input
									type="text" name="empNo" value="${empNo}" class="input-medium"
									placeholder="请输入申请人" /> 供应商:<input type="text" name="suppName"
									class="input-medium" value="${suppName}" placeholder="请输入供应商" />
								<input type="submit" value="搜索" class="btn btn-success" />
								<div style="float: right;">
									<a class="btn btn-primary" href="goPurchaseRequest"
										data-command="Add"><i class="icon-plus"></i>&nbsp;申请</a> <a
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
									<i class="halflings-icon white user"></i><span class="break"></span>采购订单管理
								</h2>
							</div>
							<div style="clear: both;">&nbsp;</div>
							<div style="clear: both;">&nbsp;</div>
							<div class="box-content">
								<table
									class="table table-striped table-bordered bootstrap-datatable">
									<thead>
										<tr>
											<th><input type="checkbox" id="productCheckAll" /></th>
											<th>采购单号</th>
											<th>申请人</th>
											<th>申请时间</th>
											<th>供应商</th>
											<th>部门审核状态</th>
											<th>部门审核人</th>
											<th>部门审核时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="productBody">
										<c:forEach items="${prbb.list}" var="s">
											<tr>
												<th><input type="checkbox" name="productCheck" /></th>
												<td>${s.purchaseRequestId}</td>
												<td>${s.employeeByRequestEmpId.empLoginName}</td>
												<td><fmt:formatDate value="${s.requestTime}"
														pattern="yyyy-MM-dd" /></td>
												<td><span class="label label-success">${s.supplier.suppName}</span>
												</td>
												<td>${s.reviewstatusByDeptReviewStatus.rsName}</td>
												<td>${s.employeeByDeptReviewEmp.empLoginName}</td>
												<td><fmt:formatDate value="${s.deptReviewTime}"
														pattern="yyyy-MM-dd" /></td>
												<td><a class="btn btn-info btn-setting" id="detail">
														<input type="hidden" value="${s.purchaseRequestId}" /> <i
														class="halflings-icon white zoom-in"></i>
												</a> <a class="btn btn-info btn-success" id="update"> <input
														type="hidden" value="${s.purchaseRequestId}" /> <i
														class="halflings-icon white edit"></i>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="pagination pagination-centered">
								<ul>
									<li><a href="javascript:goproductpage(1);">First</a></li>
									<li><a href="javascript:goproductpage('pre');">Prev</a></li>
									<c:if test="${prbb.pageNum-2>1}">
										<li><a>...</a></li>
									</c:if>
									<c:forEach begin="1" end="${prbb.pages}" var="s">
										<c:if test="${s>=prbb.pageNum-2 && s<=prbb.pageNum+2 }">
											<li <c:if test="${s==prbb.pageNum}">class="active"</c:if>>
												<a href="javascript:goproductpage(${s});">${s}</a>
											</li>
										</c:if>
									</c:forEach>
									<c:if test="${prbb.pageNum+2<prbb.pages}">
										<li><a>...</a></li>
									</c:if>
									<li><a href="javascript:goproductpage('next');">Next</a> <!-- 隐藏域 存放当前页码 -->
										<input type="hidden" name="pageNo" value="${prbb.pageNum}" /></li>
									<li><a href="javascript:goproductpage(${prbb.pages});">Last</a></li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 模态框  显示采购详情 -->
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
	<!-- 提示弹框 -->
	<div style="display: none;">
		<button class="btn btn-primary noty" id="success"
			data-noty-options='{"text":"修改成功","layout":"center","type":"success"}'>
			<i class="halflings-icon white white bell"></i>
		</button>
		<button class="btn btn-primary noty" id="error"
			data-noty-options='{"text":"修改失败","layout":"center","type":"error"}'>
			<i class="halflings-icon white white bell"></i>
		</button>
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
	<!-- end: JavaScript-->

	<script src="static/own/purchase.js"></script>

	<script type="text/javascript">
		function goproductpage(type) {
			var pageNum = parseInt($("input[name=pageNo]").val()); //获取当前的页码
			var pagePageTotal = parseInt('${prbb.pages}'); //总页数
			if (pageNum == 1 && type == 'pre') {
				return;
			}
			if (pageNum == pagePageTotal && type == 'next') {
				return;
			}
			if (type == "next") { //下一页
				pageNum = pageNum + 1;
			} else if (type == "pre") { //上一页
				pageNum = pageNum - 1;
			} else {
				pageNum = parseInt(type);
			}
			location.href = "gopurchase?pageNo=" + pageNum;
		}
		$("#detail")
				.live(
						'click',
						function() {
							empty();
							//获取选中的订单号
							var singleNo = $(this).find("input:hidden").val();
							$
									.ajax({
										type : "POST",
										url : "getPurchaseRequestBySingleNo",
										data : "singleNo=" + singleNo,
										dataType : "JSON",
										success : function(result) {
											//采购详情表格赋值
											puchaseDetailAss(result);
											//显示所有页码
											disPageNum(result);
											//alert(result.list[0].purchaserequest.remark);
											//为采购订单各种信息赋值
											$("#purchaseDetail")
													.children("tr:eq(0)")
													.children("td:eq(0)")
													.find("span")
													.html(
															result.list[0].purchaserequest.purchaseRequestId);
											$("#purchaseDetail")
													.children("tr:eq(0)")
													.children("td:eq(1)")
													.find("span")
													.html(
															result.list[0].purchaserequest.employeeByRequestEmpId.empLoginName);
											var requestTime = dateformat(result.list[0].purchaserequest.requestTime);
											$("#purchaseDetail").children(
													"tr:eq(0)").children(
													"td:eq(2)").find("span")
													.html(requestTime);
											$("#purchaseDetail")
													.children("tr:eq(1)")
													.children("td:eq(0)")
													.find("span")
													.html(
															result.list[0].purchaserequest.supplier.supplierId);
											$("#purchaseDetail")
													.children("tr:eq(1)")
													.children("td:eq(1)")
													.find("span")
													.html(
															result.list[0].purchaserequest.suppContact);
											$("#purchaseDetail")
													.children("tr:eq(1)")
													.children("td:eq(2)")
													.find("span")
													.html(
															result.list[0].purchaserequest.suppPhone);
											//为备注赋值
											$("#purchaseDetail")
													.children("tr:eq(4)")
													.children("td:eq(0)")
													.find("span")
													.html(
															result.list[0].purchaserequest.remark);

											$("#purchaseDetail")
													.children("tr:eq(2)")
													.children("td:eq(0)")
													.find("span")
													.html(
															result.list[0].purchaserequest.employeeByDeptReviewEmp.empLoginName);
											var deptreviewTime = dateformat(result.list[0].purchaserequest.deptReviewTime);
											$("#purchaseDetail").children(
													"tr:eq(2)").children(
													"td:eq(1)").find("span")
													.html(deptreviewTime);
											$("#purchaseDetail")
													.children("tr:eq(2)")
													.children("td:eq(2)")
													.find("span")
													.html(
															result.list[0].purchaserequest.reviewstatusByDeptReviewStatus.rsName);
											$("#purchaseDetail")
													.children("tr:eq(3)")
													.children("td:eq(0)")
													.find("span")
													.html(
															result.list[0].purchaserequest.employeeByFinancialAuditEmp.empLoginName);
											var finTime = dateformat(result.list[0].purchaserequest.financialAuditTime);
											$("#purchaseDetail").children(
													"tr:eq(3)").children(
													"td:eq(1)").find("span")
													.html(finTime);
											$("#purchaseDetail")
													.children("tr:eq(3)")
													.children("td:eq(2)")
													.find("span")
													.html(
															result.list[0].purchaserequest.reviewstatusByFinancialAuditStatus.rsName);
											/* $("#purchaseDetail").children("tr:eq(4)").children("td:eq(0)").find("span")
												.html("今天周二"); */
											//$("#remark").html(result.list[0].purchaserequest.remark);
										}
									});
						});

		//跳到修改的页面
		$("#update").live('click', function() {
			var singleNo = $(this).find("input:hidden").val();
			location.href = "goPurchaseUpdate?singleNo=" + singleNo;
		});

		function empty() {
			$("#purchaseDetail").children("tr:eq(0)").children("td:eq(0)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(0)").children("td:eq(1)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(0)").children("td:eq(2)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(1)").children("td:eq(0)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(1)").children("td:eq(1)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(1)").children("td:eq(2)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(2)").children("td:eq(0)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(2)").children("td:eq(1)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(2)").children("td:eq(2)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(3)").children("td:eq(0)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(3)").children("td:eq(1)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(3)").children("td:eq(2)")
					.find("span").html("");
			$("#purchaseDetail").children("tr:eq(4)").children("td:eq(0)")
					.find("span").html("");
		}

		function puchaseDetailAss(result) {
			var s = "";
			for (var i = 0; i < result.list.length; i++) {
				s += "<tr>" + "<td>" + result.list[i].product.productName
						+ "</td>" + "<td>" + result.list[i].product.productId
						+ "</td>" + "<td>" + result.list[i].productUnit.puName
						+ "</td>" + "<td>" + result.list[i].count + "</td>"
						+ "<td>" + result.list[i].price + "</td>" + "</tr>";
			}
			$("#purchaseRequestDetail").html(s);
		}
		//显示所有页码
		function disPageNum(result) {
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
			$("#purchaseRequestDetailPage").html(detailPages);
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
			var singleNo = $("#purchaseDetail").children("tr:eq(0)").children(
					"td:eq(0)").find("span").html();
			$.ajax({
				type : "POST",
				url : "getPurchaseRequestBySingleNo",
				data : "singleNo=" + singleNo + "&pageNo=" + pageNum,
				dataType : "JSON",
				success : function(result) {
					//为表格详情赋值
					puchaseDetailAss(result);
					//显示页码目录
					disPageNum(result);
				}
			});
		}
	</script>
	<script type="text/javascript">
		$(function(){
			var msg='${msg}';
			if(msg=='a'){
				$("#success").click();
			}
		});
	</script>
</body>
</html>
