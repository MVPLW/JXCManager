<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	h3{
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
					<form action="#" method="post" class="form-horizontal">
						<div class="control-group">
							<div data-condition="search">
								调拨单号:<input type="text" name="OrderNum" class="input-medium"
									placeholder="请输入调拨单号" /> 审核状态: <select><option>请选择审核状态</option>
									<c:forEach var="rs" items="${rslist }">
										<option value="${rs.rsId }">${rs.rsName }</option>
									</c:forEach>
									<!-- <option>待审核</option><option>审核成功</option><option>审核失败</option> -->
									</select>  <!-- <input type="text" name="BarCode"
										class="input-medium" placeholder="请输入审核状态" /> --> <!-- 供应商:<input
										type="text" name="ProductName" class="input-medium"
										placeholder="请输入供应商" /> --> <a class="btn btn-success"
									href="javascript:void(0)" data-command="search"><i
									class="icon-search"></i>&nbsp;搜索</a>
								<div style="float: right;">
									<a class="btn btn-primary" href="gorequisitionadd" data-command="Add"><i
										class="icon-plus"></i>&nbsp;新增调拨</a> <a class="btn btn-warning"
										href="javascript:void(0)" data-command="Delete"><i
										class="icon-remove"></i>&nbsp;删除</a> <a class="btn btn-danger"
										href="gorequisition" data-command="Refresh"><i
										class="icon-refresh"></i>&nbsp;刷新</a>
								</div>
							</div>
						</div>
					</form>
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
								<!-- table table-bordered table-striped table-condensed
								 -->
								<thead>
									<tr>
										<th><input type="checkbox"></th>
										<th>调拨单号</th>
										<th>制单人</th><!-- 申请人 -->
										<th>制单时间</th><!-- 申请时间 -->
										<th>审核人</th>
										<th>审核时间</th>
										<th>审核状态</th>
										<th>调出仓库</th>
										<th>出库时间</th>
										<th>出库经办人</th>
										<th>调入仓库</th>
										<th>入库时间</th>
										<th>入库经办人</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/01/01</td>
										<td class="center">Member</td>
										<td class="center"><span class="label label-success">Active</span>
										</td>
										<!-- <td></td>
										<td></td>
										<td></td> -->
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td>2</td>
										<td>1</td>
										<td>1</td>
										<td class="center"><a class="btn btn-info btn-setting"
											href="goPurchaseDetail"> <i
												class="halflings-icon white zoom-in"></i>
										</a><a class="btn btn-info btn-success" href="gorequisitionupdate">
												<i class="halflings-icon white edit"></i>
										</a></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="pagination pagination-centered">
							<ul>
								<li><a href="#">上一页</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">下一页</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal hide fade" id="myModal" style="width: 800px;">
		<div class="modal-header" >
			<button type="button" class="close" data-dismiss="modal">x</button>
			<h2 >采购订单明细</h2>
		</div>
		<div class="modal-body">
			<!-- 采购订单中所有内容 -->
			<div>
				<table style="width: 100%;" >
					<tr style="height: 30px;">
						<td> <h3>调拨单号:</h3> aaa</td>
						<td> <h3>制单人:</h3>张三 </td>
						<td><h3>制单时间:</h3>2009-8-9</td>
					</tr>
					<tr style="height: 30px;">
						<td><h3>审核人:</h3>SSSSSSS</td>
						<td><h3>审核时间:</h3>张三</td>
						<td><h3>审核状态:</h3>198683762</td>
					</tr>
					<tr style="height: 30px;">
						<td><h3>调出仓库:</h3>啊啊啊</td>
						<td><h3>出库时间:</h3>123</td>
						<td><h3>出库经办人:</h3>啊</td>
					</tr>
					<tr style="height: 30px;">
						<td><h3>调入仓库:</h3>阿斯蒂芬</td>
						<td><h3>入库时间:</h3>的方式</td>
						<td><h3>入库经办人:</h3>地方</td>
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
							<th>单价</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Dennis Ji</td>
							<td class="center">2012/01/01</td>
							<td class="center">Member</td>
							<td class="center">Active</td>
							<td class="center">sss</td>
						</tr>
						<tr>
							<td>Dennis Ji</td>
							<td>2012/01/01</td>
							<td class="center">Member</td>
							<td class="center">Active</td>
							<td class="center">sss</td>
						</tr>
					</tbody>
				</table>
				<div class="pagination pagination-centered">
					<ul>
						<li><a href="#">上一页</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">下一页</a></li>
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

	<script src="static/js/bootstrap-transition.js"></script>
	<script src="static/js/bootstrap-modal.js"></script>
	<!-- end: JavaScript-->

</body>
</html>
