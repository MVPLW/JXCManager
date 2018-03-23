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

			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>
						You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> enabled to use this site.
					</p>
				</div>
			</noscript>

			<!-- start: Content右 -->
			<div id="content" class="span10" style="height: 1000px">
				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
						class="icon-angle-right"></i></li>
					<li><i class="icon-edit"></i> <a href="#">Forms</a></li>
				</ul>

				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="row-fluid sortable">
							<div class="box-header" data-original-title>
								<h2>
									<i class="halflings-icon white edit"></i><span class="break"></span>移库新增
								</h2>
								<div class="box-icon">
									<a href="#" class="btn-setting"><i
										class="halflings-icon white wrench"></i></a> <a href="#"
										class="btn-minimize"><i
										class="halflings-icon white chevron-up"></i></a> <!-- <a href="#"
										class="btn-close"><i class="halflings-icon white remove"></i></a> -->
								</div>
							</div>
							<div class="box-content">
								<form class="form-horizontal">
									<fieldset>
										<div class="horizontal-form">
											<div class="row-fluid">
												<div class="span3">
													<div class="control-group">
														<label class="control-label" for="OrderNum">申请人</label>
														<div class="controls">
															<!-- <input type="text" name="OrderNum" class="span12" placeholder="可不填,自动生成" disabled="disabled"> -->
															<input type="text" class="span12"> <input
																type="hidden" name="SnNum" /> <span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="span3">
													<div class="control-group">
														<label class="control-label" for="ContractOrder">审请时间</label>
														<!-- <div class="controls">
															<input type="datetime-local" id="inputSuccess"> <span
																class="help-inline"></span>
														</div> -->
														<div class="controls">
															<input type="datetime-local" name="CreateUserName"
																class="span12" name="">
															<span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="span3">
													<div class="control-group">
														<label class="control-label" for="CreateTime">出库仓库</label>
														<div class="controls">
															<input type="text" class="span12">
															<!-- <input type="text" name="CreateTime" class="span12" placeholder="" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="2018-03-20"> -->
															<span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="span3">
													<div class="control-group">
														<label class="control-label" for="CreateUserName">出库时间</label>
														<div class="controls">
															<input type="datetime-local" name="CreateUserName"
																class="span12" placeholder="" value="administrator">
															<!--  <input type="hidden" name="CreateUser" class="span12" placeholder="" value="A376B2F643084EBB92C04833E1576F8D">
                                                    <span class="help-block"></span> -->
														</div>
													</div>
												</div>
											</div>
											<div class="row-fluid">
												<div class="span3">
													<div class="control-group">
														<label class="control-label" for="StorageNum">出库人</label>
														<div class="controls">
															<select name="StorageNum" class="span12">
																<option value=''>请选择</option>
																<option value='190C610D78134A199D88B26351789239'>111</option>
																<option value='34F3F55103BB468EA1C67D7E39ADAC23'>ccc</option>
															</select> <span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="span3">
													<div class="control-group">
														<label class="control-label" for="StorageNum">入库仓库</label>
														<div class="controls">
															<input type="text" class="span12"> <span
																class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="span3">
													<div class="control-group">
														<label class="control-label" for="StorageNum">入库时间</label>
														<div class="controls">
															<input type="datetime-local" name="CreateUserName"
																class="span12" placeholder="" value="administrator">
															<span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="span3">
													<div class="control-group">
														<label class="control-label" for="StorageNum">入库人
														</label>
														<div class="controls">
															<select name="StorageNum" class="span12">
																<option value=''>请选择</option>
																<option value='190C610D78134A199D88B26351789239'>111</option>
																<option value='34F3F55103BB468EA1C67D7E39ADAC23'>ccc</option>
															</select> <span class="help-block"></span>
														</div>
													</div>
												</div>
											</div>
										</div>
										<table class="table table-striped table-bordered table-hover"
											id="tabList">
											<thead>
												<tr>
													<th></th>
													<th>产品编号</th>
													<th>产品名称</th>
													<th>商品类别</th>
													<th>数量</th>
													<th>操作</th>
												</tr>
											</thead>
										</table>

										<div id="mypager" class="row-fluid"
											style="vertical-align: top;"></div>

										<div class="form-actions formbtn">
											<!-- <a class="btn btn-info btn-setting" href="#"><i class="halflings-icon white zoom-in"></i>
                                	<i class="icon-plus"></i>新增产品
									</a> -->
											<button type="submit" class="btn btn-info btn-setting"
												data-command="Add">
												<!-- halflings-icon white zoom-in -->
												<i class="icon-plus"></i>新增产品
											</button>
											<!-- <button type="submit" class="btn btn-danger" data-command="Add"><i class="icon-plus"></i>新增产品</button> -->
											<button type="submit" class="btn btn-primary"
												data-command="Save">
												<i class="icon-ok"></i>保存
											</button>
											<button type="button" onclick="window.history.back()" class="btn" data-command="Cancel">取消</button>
										</div>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!--/row-->
			</div>
			<!--/.fluid-container-->
		</div>
		<!--/#content.span10-->
	</div>
	<!--/fluid-row-->
	<!-- 调拨产品 -->
	<div class="modal hide fade" id="myModal" style="width: 800px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">Ã</button>
			<h3>调拨产品</h3>
		</div>
		<div class="modal-body">
			<div>
				<table style="width: 100%;" >
					<tr style="height: 30px;">
						<td> <h3>产品单号:</h3><input type="text" name="" placeholder="请输入单号"/></td>
						<td> <h3>产品名称:</h3><input type="text" name="" placeholder="请输入产品名称"/>
							<a class="btn btn-success"
									href="javascript:void(0)" data-command="search"><i
									class="icon-search"></i>&nbsp;搜索</a>
						 </td>
					</tr>
				</table>
			</div>
			<div style="clear: both;">&nbsp;</div>
			<div class="box-content">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th></th>
							<th>产品名称</th>
							<th>产品编号</th>
							<th>规格</th>
							<th>库存数量</th>
							<th>数量</th>
							<th>单价</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox"></td>
							<td>Dennis Ji</td>
							<td class="center">2012/01/01</td>
							<td class="center">Member</td>
							<td class="center">Active</td>
							<td><input type="text" name="" style="width:50px;" value="0"></td>
							<td class="center">sss</td>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>Dennis Ji</td>
							<td class="center">2012/01/01</td>
							<td class="center">Member</td>
							<td class="center">Active</td>
							<td><input type="text" name="" style="width:50px;" value="0"></td>
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
			<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
				class="btn btn-primary">Save changes</a>
		</div>
	</div>
	<!-- /调拨产品 -->
	<div class="common-modal modal fade" id="common-Modal1" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-content">
			<ul class="list-inline item-details">
				<li><a href="#">Admin templates</a></li>
				<li><a href="http://themescloud.org">Bootstrap themes</a></li>
			</ul>
		</div>
	</div>
	<div class="clearfix"></div>
	<!-- 尾部 -->
	<%-- <%@ include file="common/foot.jsp"%> --%>
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