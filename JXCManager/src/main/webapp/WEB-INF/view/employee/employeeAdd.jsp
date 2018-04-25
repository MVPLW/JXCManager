<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li><a href="javascript:;">员工信息管理</a></li>
				</ul>
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white edit"></i><span class="break"></span>
								员工添加
							</h2>
						</div>
						<div style="clear: both;">&nbsp;</div>
						<div class="box-content">
							<form class="form-horizontal" action="goEmployeeInsert"
								method="post" id="empForm">
								<fieldset>
									<table style="width: 80%;">
										<tr>
											<td align="right"><div class="control-group">
													<label class="control-label" for="empLoginName">登录名&nbsp;&nbsp;</label>
													<div class="controls">
														<input class="input-xlarge focused" id="empLoginName"
															name="empLoginName" type="text" placeholder="登录名" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="dept.deptId">部&nbsp;&nbsp;&nbsp;门&nbsp;&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="dept.deptId" name="dept.deptId"
															data-rel="chosen">
															<c:forEach items="${deptAll}" var="s">
																<option value="${s.deptId}">${s.deptName}</option>
															</c:forEach>
														</select>
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="joinDate">入职时间</label>
													<div class="controls">
														<input type="text" class="input-xlarge datepicker"
															readonly="readonly" id="joinDate" name="joinDate"
															placeholder="加入时间" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="empLoginPwd">登录密码</label>
													<div class="controls">
														<input class="input-xlarge focused" id="empLoginPwd"
															name="empLoginPwd" type="password" placeholder="登录密码" />
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="empName">员工姓名</label>
													<div class="controls">
														<input class="input-xlarge focused" id="empName"
															name="empName" type="text" placeholder="员工姓名" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="telephone">联系电话</label>
													<div class="controls">
														<input class="input-xlarge focused" id="telephone"
															name="telephone" type="text" placeholder="联系电话" />
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="birthday">出生日期</label>
													<div class="controls">
														<input type="text" class="input-xlarge datepicker"
															readonly="readonly" id="birthday" name="birthday"
															placeholder="出生日期" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="gender">性&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;&nbsp;</label>
													<div class="controls">
														<label class="radio"> <input type="radio"
															name="gender" value="男" checked="checked" /> 男
														</label> <label class="radio"
															style="top: 3px; position: relative;"> <input
															type="radio" name="gender" value="女" /> 女
														</label>
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="email">邮&nbsp;&nbsp;&nbsp;箱&nbsp;&nbsp;&nbsp;</label>
													<div class="controls">
														<input class="input-xlarge focused" id="email"
															name="email" type="text" placeholder="常用邮箱" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="address">住&nbsp;&nbsp;&nbsp;址&nbsp;&nbsp;&nbsp;</label>
													<div class="controls">
														<input class="input-xlarge focused" id="address"
															name="address" type="text" placeholder="目前住址" />
													</div>
												</div></td>
										</tr>
									</table>
									<div class="form-actions">
										<button class="btn btn-info btn-setting"
											onclick="javascript:goEmpInsert();">确认添加</button>
										<button class="btn" type="button" onclick="javascript:history.go(-1);">取消</button>
									</div>
								</fieldset>
							</form>
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
	<!-- end: JavaScript-->

	<script src="static/own/purchase.js"></script>

	<script type="text/javascript">
		/* 表单验证  成功之后表单提交 */
		function goEmpInsert() {
			var emploginname = $("#empLoginName").val();
			var empLoginPwd = $("#empLoginPwd").val();
			var empName = $("#empName").val();
			var joinDate = $("#joinDate").val();
			var birthday = $("#birthday").val();
			var address = $("#address").val();
			var telephone = $("#telephone").val();
			var email = $("#email").val();
			if (emploginname.trim() == "" || empLoginPwd.trim() == ""
					|| empName.trim() == "" || joinDate.trim() == ""
					|| birthday.trim() == "" || address.trim() == ""
					|| telephone.trim() == "" || email.trim() == "") {
				alert("请填写完整表单");
				return;
			} else {
				$("#empForm").submit();//提交表单
			}

		}
		$(function() {

		});
	</script>
</body>
</html>