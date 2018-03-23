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
<link id="bootstrap-style" href="css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link id="base-style" href="css/style.css" rel="stylesheet">
<link id="base-style-responsive" href="css/style-responsive.css"
	rel="stylesheet">
<!-- <link rel="stylesheet" href="css/bootstrap.css"/> -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
	rel='stylesheet' type='text/css'>
<!-- end: CSS -->

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->

<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->

<!-- start: Favicon -->
<link rel="shortcut icon" href="img/favicon.png">
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
					<li><a href="form">入库管理</a></li>
				</ul>

				<div class="row-fluid">
					<form action="#" method="post" class="form-horizontal">
						<div class="control-group">
							<div data-condition="search">
								申请单号:<input type="text" name="OrderNum" class="input-medium"
									placeholder="请输入申请单号" /> 申请人:<input type="text" name="BarCode"
									class="input-medium" placeholder="请输入申请人" /> 申请时间:<input
									type="text" name="ProductName" class="input-medium"
									placeholder="请输入入库申请时间" /> <a class="btn btn-success"
									href="javascript:void(0)" data-command="search"><i
									class="icon-search"></i>&nbsp;搜索</a>
								<div style="float: right;">
									<a class="btn btn-primary" href="goPurchaseRequest" data-command="Add"><i
										class="icon-plus"></i>&nbsp;申请</a> <a class="btn btn-warning"
										href="javascript:void(0)" data-command="Delete"><i
										class="icon-remove"></i>&nbsp;删除</a> <a class="btn btn-danger"
										href="javascript:void(0)" data-command="Refresh"><i
										class="icon-refresh"></i>&nbsp;刷新</a>
								</div>

							</div>
						</div>
					</form>
					<div class="box">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>入库单管理
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
										<th>入库单号</th>
										<th>所在仓库</th>
										<th>入库人</th>
										<th>入库时间</th>
										<th>入库类型</th>
										<th>上游单号</th>
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
										<td>2</td>
										<td>1</td>
										<td class="center"><a class="btn btn-info btn-setting"
											href="goPurchaseDetail"> <i
												class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info btn-success" href="goPurchaseUpdate">
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
			<h2 >入库单明细</h2>
		</div>
		<div class="modal-body">
			<!-- 采购订单中所有内容 -->
			<div>
				<table style="width: 100%;" >
					<tr style="height: 30px;">
						<td> <h3>入库单号:</h3> aaa</td>
						<td> <h3>入库人:</h3>张三 </td>
						<td><h3>入库时间:</h3>2009-8-9</td>
					</tr>
					<tr style="height: 30px;">
						<td><h3>仓库编号:</h3>SSSSSSS</td>
						<td><h3>入库类型:</h3>调拨入库</td>
						<td><h3>上游单号:</h3>198683762</td>
					</tr>
					<tr style="height: 30px;">
						<td><h3>入库产品:</h3>59式魔改版陆战坦克</td>
						<td><h3>入库数量:</h3>123</td>
						<td><h3>产品价格:</h3>98噫</td>
					</tr>
					
					<tr style="height: 30px;"><td colspan="3"> <h3>备注:</h3>今天周二 </td></tr>
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
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/jquery-migrate-1.0.0.min.js"></script>
	<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
	<script src="js/jquery.ui.touch-punch.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/fullcalendar.min.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.js"></script>
	<script src="js/jquery.flot.pie.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<script src="js/jquery.chosen.min.js"></script>
	<script src="js/jquery.uniform.min.js"></script>
	<script src="js/jquery.cleditor.min.js"></script>
	<script src="js/jquery.noty.js"></script>
	<script src="js/jquery.elfinder.min.js"></script>
	<script src="js/jquery.raty.min.js"></script>
	<script src="js/jquery.iphone.toggle.js"></script>
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<script src="js/jquery.gritter.min.js"></script>
	<script src="js/jquery.imagesloaded.js"></script>
	<script src="js/jquery.masonry.min.js"></script>
	<script src="js/jquery.knob.modified.js"></script>
	<script src="js/jquery.sparkline.min.js"></script>
	<script src="js/counter.js"></script>
	<script src="js/retina.js"></script>
	<script src="js/custom.js"></script>

	<script src="js/bootstrap-transition.js"></script>
	<script src="js/bootstrap-modal.js"></script>
	<!-- end: JavaScript-->

</body>
</html>
