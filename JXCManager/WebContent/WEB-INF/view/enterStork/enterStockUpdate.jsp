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

<body>
	<div class="container-fluid-full">
		<div class="row-fluid">
			<!-- start: Content -->
			<div id="content" class="span10">
				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="javascript:;">Home</a>
						<i class="icon-angle-right"></i></li>
					<li><a href="javascript:;">入库单修改</a></li>
				</ul>
				<div class="row-fluid sortable">
					<div class="clear:both">&nbsp;</div>
					<div class="box">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>修改入库单
							</h2>
						</div>
						<div style="clear: both;">&nbsp;</div>
						<div class="box-content">
							<form class="form-horizontal" action="enterStockUpdate"
								method="post" id="enterStockUpdateForm">
								<fieldset>
									<table style="width: 80%; margin: 0px auto;">
										<tr>
											<td><div class="control-group">
													<label class="control-label">入库单号</label>
													<div class="controls">
														<span class="input-large uneditable-input">${enterStock.enterStockId}</span>
														<input type="hidden" name="enterStockId" value="${enterStock.enterStockId}"/>
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="storehouse.storeHouseId">仓&nbsp;&nbsp;库&nbsp;&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="storehouse.storeHouseId"
															name="storehouse.storeHouseId" data-rel="chosen">
															<c:forEach items="${storeHouseAll }" var="s">
																<option value="${s.storeHouseId}"
																	<c:if test="${s.storeHouseId==enterStock.storehouse.storeHouseId }">selected="selected"</c:if>>${s.shName}</option>
															</c:forEach>
														</select>
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="enterDate">入库时间</label>
													<div class="controls">
														<input type="text" class="input-large datepicker"
															readonly="readonly" id="enterDate" name="enterDate"
															value="<fmt:formatDate value="${enterStock.enterDate}" pattern="MM/dd/yyyy"/>" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="enterStockType">入库类型</label>
													<div class="controls">
														<select id="enterStockType" data-rel="chosen"
															disabled="disabled" name="enterstocktype.estId">
															<option>${enterStock.enterstocktype.estName}</option>
														</select>
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="upstreamNo">上游单号</label>
													<div class="controls">
														<!-- <input class="input-xlarge focused" id="upstreamNo"
															name="upstreamNo" type="text" placeholder="此处填写上游单号" /> -->
														<select id="upstreamNo" name="upstreamNo"
															disabled="disabled">
															<option>${enterStock.upstreamNo}</option>
														</select>
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="employee.empLoginName">入库人&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="employee.empLoginName" data-rel="chosen"
															name="employee.empLoginName">
															<c:forEach items="${employeeAll }" var="s">
																<option value="${s.empLoginName}"
																	<c:if test="${s.empLoginName==enterStock.employee.empLoginName }">selected="selected"</c:if>>${s.empLoginName}</option>
															</c:forEach>
														</select>
													</div>
												</div></td>
										</tr>
										<tr>
											<td colspan="2">
												<div class="control-group">
													<label class="control-label" for="remark">备注</label>
													<div class="controls">
														<input type="text" class="span6 typeahead" id="remark"
															name="remark" data-provide="typeahead" data-items="4"
															placeholder="此处填写备注" value="${enterStock.remark}"
															data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
														<input type="hidden" id="enterStockProducts"
															name="enterStockProducts" />
													</div>
												</div>
											</td>
										</tr>
									</table>
									<div class="box-content">
										<table
											class="table table-bordered table-striped table-condensed"
											style="width: 90%; margin: 0px auto; table-layout: fixed;">
											<thead>
												<tr>
													<th>产品编号</th>
													<th>产品名称</th>
													<th>单价</th>
													<th>规格</th>
													<th>应入库</th>
													<th>实际入库数量</th>
												</tr>
											</thead>
											<tbody id="productTbody">
												<c:forEach items="${enterStockDetails}" var="s">
													<tr>
														<td>${s.product.productId }</td>
														<td>${s.product.productName }</td>
														<td>${s.productPrice }</td>
														<td>${s.productUnit.puName }</td>
														<td>${s.shouldCount}</td>
														<td><input type="text"
															style="width: 80%; margin: 0px auto; height: 80%;"
															value="${s.productCount}" onkeyup="nan(this)"
															onchange="nan(this)" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="form-actions">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="submit" class="btn btn-primary">保存入库单</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button class="btn" type="button"
											onclick="javascript:history.go(-1);">取消</button>
									</div>
								</fieldset>
							</form>
							<table
								class="table table-striped table-bordered bootstrap-datatable">
								<thead>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
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
	<script src='static/js/fullcalendar.min.js'></script>
	<script src='static/js/jquery.dataTables.min.js'></script>
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
		$("#enterStockUpdateForm").submit(function() {
			var productTbody = $("#productTbody").find("tr");
			var s="[";
			for (var i = 0; i < productTbody.length; i++) {
				var tbodytr = $(productTbody[i]).children(); //获取子元素
				var proid = tbodytr.eq(0).html(); // 产品编号
				var pronum = parseInt(tbodytr.eq(5).find("input").val()); // 实际入库数量
				s += "{\"product\":{\"productId\":\""
						+ proid
						+ "\"},\"productCount\":\""
						+ pronum
						+ "\"}";
				if (i != productTbody.length - 1) { // 代表不是最后一个
					s += ",";
				}
			}
			s+="]";
			$("#enterStockProducts").val(s);
			return true;
		});
	</script>
</body>
</html>


