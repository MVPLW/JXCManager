<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- start: Meta -->
<meta charset="utf-8">
<title>入库单申请</title>
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
					<li><i class="icon-home"></i>首页 <i class="icon-angle-right"></i></li>
					<li><a href="form">入库单管理</a></li>
				</ul>
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white edit"></i><span class="break"></span>
								入库申请单填写
							</h2>
						</div>
						<div style="clear: both;">&nbsp;</div>
						<div class="box-content">
							<form class="form-horizontal" action="#" method="post">
								<fieldset>
									<table style="width: 80%; margin: 0px auto;">
										<tr>
											<td><div class="control-group">
													<label class="control-label">入库单号</label>
													<div class="controls">
														<span class="input-large uneditable-input">随机生成
															可不填</span>
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="focusedInput">仓&nbsp;&nbsp;库&nbsp;&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="storeHouse" data-rel="chosen">
															<c:forEach items="${storeHouseAll }" var="s">
																<option value="${s.storeHouseId}">${s.shName}</option>
															</c:forEach>
														</select>
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="date01">入库时间</label>
													<div class="controls">
														<input type="text" class="input-large datepicker"
															readonly="readonly" id="date01" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="enterStockType">入库类型</label>
													<div class="controls">
														<select id="enterStockType" data-rel="chosen">
															<c:forEach items="${estAll}" var="s">
																<option value="${s.estId}">${s.estName}</option>
															</c:forEach>
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
														<select id="upstreamNo" data-rel="chosen">
															<option>1</option>
														</select>
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="selectError1">入库人&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="employee" data-rel="chosen">
															<c:forEach items="${employeeAll }" var="s">
																<option value="${s.empLoginName}">${s.empLoginName}</option>
															</c:forEach>
														</select>
													</div>
												</div></td>
										</tr>
										<tr>
											<td colspan="2">
												<div class="control-group">
													<label class="control-label" for="typeahead">备注</label>
													<div class="controls">
														<input type="text" class="span6 typeahead" id="typeahead"
															data-provide="typeahead" data-items="4" placeholder="此处填写备注"
															data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
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
													<th>实际入库数量</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody id="productTbody">
												
											</tbody>
										</table>
										<!-- <div class="pagination pagination-centered">
											<ul>
												<li><a href="#">Prev</a></li>
												<li class="active"><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#">Next</a></li>
											</ul>
										</div> -->
										<!--/span-->
									</div>
									<div class="form-actions">
										<button class="btn btn-info btn-setting"
											onclick="javascript:void(0);">添加入库信息</button>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="submit" class="btn btn-primary">提交申请</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button class="btn">取消</button>
									</div>
								</fieldset>
							</form>
						</div>
						<!--/span-->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END Content -->

	<div class="modal hide fade" id="myModal" style="width: 800px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">x</button>
			<h2>选择产品</h2>
		</div>
		<div style="clear: both;"></div>
		<div class="modal-body">
			<!-- 采购订单中所有内容 -->
			<div class="box-content">
				<table class="table table-bordered" style="table-layout: fixed;"
					id="productChoseModal">
					<thead>
						<tr>
							<th width="20px;"><input type="checkbox"
								id="productCheckAll" /></th>
							<th>产品名称</th>
							<th>产品编号</th>
							<th>类别</th>
							<th>计量单位</th>
							<th>入库数量</th>
						</tr>
					</thead>
					<tbody id="productBody">
						<c:forEach items="${productAll.list}" var="s">
							<tr height="20px;">
								<td><input type="checkbox" name="productCheck" /></td>
								<td>${s.productName}</td>
								<td>${s.productId}</td>
								<td>${s.producttype.productTypeName}</td>
								<td>${s.productunit.puName}<input type="hidden"
									value="${s.productunit.productUnitId}" />
								</td>
								<td><input type="number" min="0" value="0"
									style="width: 80%; margin: 0px auto; height: 80%;" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pagination pagination-centered">
					<ul id="productPageButton">
						<li><a href="javascript:goproductpage('pre');">上一页</a> <input
							type="hidden" name="productPageNow" value="${productAll.pageNum}" />
						</li>
						<c:forEach begin="1" end="${productAll.pages}" var="s">
							<li><a href="javascript:goproductpage(${s});"
								<c:if test="${productAll.pageNum==s}">class="active"</c:if>>${s}</a></li>
						</c:forEach>
						<li><a href="javascript:goproductpage('next');">下一页</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn btn-primary" id="productChose">选择</a> <a
				href="#" class="btn" data-dismiss="modal">关闭</a>
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
		$("#enterStockType").live('change',function(){    //入库类型改变事件
			var id=$(this).val();
			$("#upstreamNo").append("<option>"+id+"</option>");
			$("#upstreamNo").next().find("ul").append("<li id='upstreamNo_chzn_o_3' class='active-result' style>"+id+"</li>");
			/* var s=$("#upstreamNo").next().find("ul li");
			alert(s.length); */
			//$("#upstreamNo").html("<option>a</option>");
		});
	</script>

</body>
</html>
