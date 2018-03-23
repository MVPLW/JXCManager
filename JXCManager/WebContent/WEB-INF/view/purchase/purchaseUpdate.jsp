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
			<!-- start: Content -->
			<div id="content" class="span10">
				<ul class="breadcrumb">
					<li><i class="icon-home"></i>首页 <i class="icon-angle-right"></i></li>
					<li><a href="form">采购订单修改</a></li>
				</ul>
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white edit"></i><span class="break"></span>
								采购订单修改
							</h2>
						</div>
						<div style="clear: both;">&nbsp;</div>
						<div class="box-content">
							<form class="form-horizontal" action="#" method="post">
								<fieldset>
									<table style="width: 80%; margin: 0px auto;">
										<tr>
											<td><div class="control-group">
													<label class="control-label">采购订单号&nbsp;&nbsp;</label>
													<div class="controls">
														<span class="input-xlarge uneditable-input">订单号SSSSSSS</span>
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="selectError">申请人&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="selectError" data-rel="chosen">
															<option>Option 1</option>
															<option>Option 2</option>
															<option>Option 3</option>
															<option>Option 4</option>
															<option>Option 5</option>
														</select>
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="date01">订单申请时间</label>
													<div class="controls">
														<input type="text" class="input-xlarge datepicker"
															id="date01" placeholder="申请日期" readonly="readonly" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="selectError1">供应商&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="selectError1" data-rel="chosen">
															<option>Option 1</option>
															<option>Option 2</option>
															<option>Option 3</option>
															<option>Option 4</option>
															<option>Option 5</option>
														</select>
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="focusedInput">供应商联系人</label>
													<div class="controls">
														<input class="input-xlarge focused" id="focusedInput"
															type="text" placeholder="此处填写供货商的联系人">
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="focusedInput">联系电话</label>
													<div class="controls">
														<input class="input-xlarge focused" id="focusedInput"
															type="text" placeholder="此处填写供应商联系人的电话">
													</div>
												</div></td>
										</tr>
										<tr>
											<td colspan="2">
												<div class="control-group">
													<label class="control-label" for="typeahead">
														备&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													</label>
													<div class="controls">
														<input type="text" class="span6 typeahead" id="typeahead"
															data-provide="typeahead" data-items="4"
															placeholder="此处填写有关订单的备注信息" />
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
													<th>数量</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Dennis Ji</td>
													<td>A</td>
													<td>M</td>
													<td>ABC</td>
													<td>A</td>
													<td><a class="label label-important" href="#">移除</a></td>
												</tr>
											</tbody>
										</table>
										<div class="pagination pagination-centered">
											<ul>
												<li><a href="#">Prev</a></li>
												<li class="active"><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#">Next</a></li>
											</ul>
										</div>
										<!--/span-->
									</div>
									<div class="form-actions">
										<button class="btn btn-info btn-setting"
											onclick="javascript:void(0);">添加产品信息</button>
										<button type="submit" class="btn btn-primary">提交申请</button>
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

	<div class="modal hide fade" id="myModal" style="width: 800px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">x</button>
			<h2>选择产品</h2>
		</div>
		<div style="clear: both;"></div>
		<div class="modal-body">
			<!-- 采购订单中所有内容 -->
			<div class="box-content">
				<table class="table table-bordered" style="table-layout: fixed;">
					<thead>
						<tr>
							<th width="20px;"><input type="checkbox" /></th>
							<th>产品名称</th>
							<th>产品编号</th>
							<th>类别</th>
							<th>计量单位</th>
							<th>数量</th>
						</tr>
					</thead>
					<tbody>
						<tr height="20px;">
							<td><input type="checkbox" /></td>
							<td>Dennis Ji</td>
							<td>2012/01/01</td>
							<td>Member</td>
							<td>Active</td>
							<td><input type="number" min="0"
								style="width: 80%; margin: 0px auto; height: 80%;" /></td>
						</tr>
						<tr>
							<td><input type="checkbox" /></td>
							<td>Dennis Ji</td>
							<td>2012/01/01</td>
							<td>Member</td>
							<td>Active</td>
							<td><input type="number" min="0"
								style="width: 80%; margin: 0px auto; height: 80%;" /></td>
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
			<a href="#" class="btn btn-primary">选择</a> <a href="#" class="btn"
				data-dismiss="modal">关闭</a>
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
