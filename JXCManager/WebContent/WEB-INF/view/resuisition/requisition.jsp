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
			<!-- start: Main Menu -->
			<!-- end: Main Menu -->
			<!-- start: Content -->
			<div id="content" class="span10">
				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="form">移库管理</a></li>
				</ul>

				<div class="row-fluid sortable">
					<form action="" method="post">
						<div style="float: left;">
							移库单号：<input type="text" /> 审核状态：<select name="">
								<option value="0">请选择</option>
								<option value="1">待审核</option>
								<option value="2">审核通过</option>
								<option value="3">审核失败</option>
							</select>
							<button type="submit" class="btn btn-info"
								onclick="javascript:void(0)" data-command="search">
								<i class="icon-search"></i>&nbsp;搜索
							</button>
						</div>
						<div style="float: right;">
							<a class="btn btn-primary" href="gorequisitionadd"
								data-command="Add"><i class="icon-plus"></i>&nbsp;新增</a> <a
								class="btn btn btn-success" href="gorequisitionupdate"
								data-command="Edit"><i class="icon-edit"></i>&nbsp;编辑</a> <a
								class="btn btn-warning" href="" data-command="Delete"><i
								class="icon-remove"></i>&nbsp;删除</a> <a class="btn btn-danger"
								href="form" data-command="Refresh"><i class="icon-refresh"></i>&nbsp;刷新</a>
						</div>
					</form>
					<div class="clear:both">&nbsp;</div>
					<div class="box">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>移库管理
							</h2>
						</div>
						<div class="box-content">
							<table
								class="table table-striped table-bordered bootstrap-datatable datatable">
								<thead>
									<tr>
										<th><input type="checkbox"></th>
										<th>移库单号</th>
										<th>申请人</th>
										<!-- 制单人 -->
										<th>申请时间</th>
										<th>审核人</th>
										<th>审核时间</th>
										<th>审核状态</th>
										<th>调出仓库</th>
										<!-- 出库仓库 -->
										<th>出库时间</th>
										<th>出库人</th>
										<th>调入仓库</th>
										<!-- 入库仓库 -->
										<th>入库时间</th>
										<th>入库人</th>
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
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-info btn-setting"
											href="form1"> 查看&nbsp;<i
												class="halflings-icon white zoom-in"></i>
										</a>  <a class="btn btn-info" href="form2"> 编辑&nbsp;<i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> 删除&nbsp;<i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/01/01</td>
										<td class="center">Member</td>
										<td class="center"><span class="label label-success">Active</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/01/01</td>
										<td class="center">Member</td>
										<td class="center"><span class="label label-success">Active</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/01/01</td>
										<td class="center">Member</td>
										<td class="center"><span class="label label-success">Active</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/02/01</td>
										<td class="center">Staff</td>
										<td class="center"><span class="label label-important">Banned</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/02/01</td>
										<td class="center">Staff</td>
										<td class="center"><span class="label label-important">Banned</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/03/01</td>
										<td class="center">Member</td>
										<td class="center"><span class="label label-warning">Pending</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/03/01</td>
										<td class="center">Member</td>
										<td class="center"><span class="label label-warning">Pending</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/01/21</td>
										<td class="center">Staff</td>
										<td class="center"><span class="label label-success">Active</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/01/21</td>
										<td class="center">Staff</td>
										<td class="center"><span class="label label-success">Active</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/01/21</td>
										<td class="center">Staff</td>
										<td class="center"><span class="label label-success">Active</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/01/21</td>
										<td class="center">Staff</td>
										<td class="center"><span class="label label-success">Active</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/08/23</td>
										<td class="center">Staff</td>
										<td class="center"><span class="label label-important">Banned</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/08/23</td>
										<td class="center">Staff</td>
										<td class="center"><span class="label label-important">Banned</span>
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
										</a></td>
									</tr>
									<tr>
										<th><input type="checkbox"></th>
										<td>Dennis Ji</td>
										<td class="center">2012/06/01</td>
										<td class="center">Admin</td>
										<td class="center"><span class="label">Inactive</span></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td class="center"><a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
										</a> <a class="btn btn-info" href="#"> <i
												class="halflings-icon white edit"></i>
										</a> <a class="btn btn-danger" href="#"> <i
												class="halflings-icon white trash"></i>
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
					<!--/span-->
				</div>
				<!--/row-->
			</div>
			<!--/.fluid-container-->

			<!-- end: Content -->
		</div>
		<!--/#content.span10-->
	</div>
	<!--/fluid-row-->

	<div class="modal hide fade" id="myModal" style="width: 800px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">x</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>abc</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
				class="btn btn-primary">Save changes</a>
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
	<!-- end: JavaScript-->

</body>
</html>
