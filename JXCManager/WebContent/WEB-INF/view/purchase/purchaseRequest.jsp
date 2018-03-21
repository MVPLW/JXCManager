<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- start: Meta -->
<meta charset="utf-8">
<title>采购订单申请</title>
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
					<li><a href="form">采购申请管理</a></li>
				</ul>
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white edit"></i><span class="break"></span>
								采购申请单填写
							</h2>
						</div>
						<div class="box-content">
							<form class="form-horizontal">
								<fieldset>
									<div class="control-group">
										<label class="control-label" for="focusedInput">Focused
											input</label>
										<div class="controls">
											<input class="input-xlarge focused" id="focusedInput"
												type="text" value="This is focused…">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Uneditable input</label>
										<div class="controls">
											<span class="input-xlarge uneditable-input">Some value
												here</span>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="disabledInput">Disabled
											input</label>
										<div class="controls">
											<input class="input-xlarge disabled" id="disabledInput"
												type="text" placeholder="Disabled input here…" disabled="disabled">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="optionsCheckbox2">Disabled
											checkbox</label>
										<div class="controls">
											<label class="checkbox"> <input type="checkbox"
												id="optionsCheckbox2" value="option1" disabled="disabled">
												This is a disabled checkbox
											</label>
										</div>
									</div>
									<div class="control-group warning">
										<label class="control-label" for="inputWarning">Input
											with warning</label>
										<div class="controls">
											<input type="text" id="inputWarning"> <span
												class="help-inline">Something may have gone wrong</span>
										</div>
									</div>
									<div class="control-group error">
										<label class="control-label" for="inputError">Input
											with error</label>
										<div class="controls">
											<input type="text" id="inputError"> <span
												class="help-inline">Please correct the error</span>
										</div>
									</div>
									<div class="control-group success">
										<label class="control-label" for="inputSuccess">Input
											with success</label>
										<div class="controls">
											<input type="text" id="inputSuccess"> <span
												class="help-inline">Woohoo!</span>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="selectError3">Plain
											Select</label>
										<div class="controls">
											<select id="selectError3">
												<option>Option 1</option>
												<option>Option 2</option>
												<option>Option 3</option>
												<option>Option 4</option>
												<option>Option 5</option>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="selectError">Modern
											Select</label>
										<div class="controls">
											<select id="selectError" data-rel="chosen">
												<option>Option 1</option>
												<option>Option 2</option>
												<option>Option 3</option>
												<option>Option 4</option>
												<option>Option 5</option>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="selectError1">Multiple
											Select / Tags</label>
										<div class="controls">
											<select id="selectError1" multiple data-rel="chosen">
												<option>Option 1</option>
												<option selected>Option 2</option>
												<option>Option 3</option>
												<option>Option 4</option>
												<option>Option 5</option>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="selectError2">Group
											Select</label>
										<div class="controls">
											<select data-placeholder="Your Favorite Football Team"
												id="selectError2" data-rel="chosen">
												<option value=""></option>
												<optgroup label="NFC EAST">
													<option>Dallas Cowboys</option>
													<option>New York Giants</option>
													<option>Philadelphia Eagles</option>
													<option>Washington Redskins</option>
												</optgroup>
												<optgroup label="NFC NORTH">
													<option>Chicago Bears</option>
													<option>Detroit Lions</option>
													<option>Green Bay Packers</option>
													<option>Minnesota Vikings</option>
												</optgroup>
												<optgroup label="NFC SOUTH">
													<option>Atlanta Falcons</option>
													<option>Carolina Panthers</option>
													<option>New Orleans Saints</option>
													<option>Tampa Bay Buccaneers</option>
												</optgroup>
												<optgroup label="NFC WEST">
													<option>Arizona Cardinals</option>
													<option>St. Louis Rams</option>
													<option>San Francisco 49ers</option>
													<option>Seattle Seahawks</option>
												</optgroup>
												<optgroup label="AFC EAST">
													<option>Buffalo Dennis Jis</option>
													<option>Miami Dolphins</option>
													<option>New England Patriots</option>
													<option>New York Jets</option>
												</optgroup>
												<optgroup label="AFC NORTH">
													<option>Baltimore Ravens</option>
													<option>Cincinnati Bengals</option>
													<option>Cleveland Browns</option>
													<option>Pittsburgh Steelers</option>
												</optgroup>
												<optgroup label="AFC SOUTH">
													<option>Houston Texans</option>
													<option>Indianapolis Colts</option>
													<option>Jacksonville Jaguars</option>
													<option>Tennessee Titans</option>
												</optgroup>
												<optgroup label="AFC WEST">
													<option>Denver Broncos</option>
													<option>Kansas City Chiefs</option>
													<option>Oakland Raiders</option>
													<option>San Diego Chargers</option>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="form-actions">
										<button type="submit" class="btn btn-primary">Save
											changes</button>
										<button class="btn">Cancel</button>
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
