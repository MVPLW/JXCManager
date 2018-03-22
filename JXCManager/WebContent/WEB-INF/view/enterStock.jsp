<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="static/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="static/css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
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
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- end: Favicon -->
	
		
		
		
</head>

<body>
		<!-- start: Header -->
	<%@ include file="common/head.jsp" %>
	<!-- start: Header -->
	
	
		<div class="container-fluid-full">
		<div class="row-fluid">
				
			<!-- start: Main Menu -->
			<%@ include file="common/Menu.jsp" %>	
			<!-- end: Main Menu -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<!-- start: Content右 -->
			<div id="content" class="span10" style=" height:1000px ">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.html">Home</a>
					<i class="icon-angle-right"></i> 
				</li>
				<li>
					<i class="icon-edit"></i>
					<a href="#">Forms</a>
				</li>
			</ul>
			
			<div class="row-fluid sortable">
				<div class="box span12">
			<div class="row-fluid sortable">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>入库</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
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
                                                    <input type="text" class="span12">
                                                    <input type="hidden" name="SnNum"/>
                                                    <span class="help-block"></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="span3">
                                            <div class="control-group">
                                                <label class="control-label" for="ContractOrder">审请时间</label>
                                                <div class="controls">
												  <input type="datetime-local" id="inputSuccess">
												  <span class="help-inline"></span>
												</div>
                                            </div>
                                        </div>
                                        <div class="span3">
                                            <div class="control-group">
                                                <label class="control-label" for="CreateTime">入库仓库</label>
                                                <div class="controls">
                                                    <input type="text" class="span12">
                                                    <!-- <input type="text" name="CreateTime" class="span12" placeholder="" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="2018-03-20"> -->
                                                    <span class="help-block"></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="span3">
                                            <div class="control-group">
                                                <label class="control-label" for="CreateUserName">入库时间</label>
                                                <div class="controls">
                                                    <input type="datetime-local" name="CreateUserName" class="span12" placeholder="" value="administrator">
                                                   <!--  <input type="hidden" name="CreateUser" class="span12" placeholder="" value="A376B2F643084EBB92C04833E1576F8D">
                                                    <span class="help-block"></span> -->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row-fluid">
                                        <div class="span3">
                                            <div class="control-group">
                                                <label class="control-label" for="StorageNum">入库人</label>
                                                <div class="controls">
                                                    <select name="StorageNum" class="span12">
                                                        <option value=''>请选择</option><option value='190C610D78134A199D88B26351789239' >111</option><option value='34F3F55103BB468EA1C67D7E39ADAC23' >ccc</option>
                                                    </select>
                                                    <span class="help-block"></span>
                                                </div>
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
							    <table class="table table-striped table-bordered table-hover" id="tabList">
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

                                <div id="mypager" class="row-fluid" style="vertical-align:top;">

                                </div>

                                <div class="form-actions formbtn">
                                    <button type="submit" class="btn btn-danger" data-command="Add"><i class="icon-plus"></i>新增产品</button>
                                    <button type="submit" class="btn btn-primary" data-command="Save"><i class="icon-ok"></i>保存</button>
                                    <button type="button" class="btn" data-command="Cancel">取消</button>
                                </div>
							</fieldset>
						  </form>
					</div>
			</div><!--/row-->
	</div><!--/.fluid-container-->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
	<div class="clearfix"></div>
	<!-- 尾部 -->
	<%@ include file="common/foot.jsp" %>
	<!-- start: JavaScript-->

		<script src="static/jsjquery-1.9.1.min.js"></script>
	<script src="static/jsjquery-migrate-1.0.0.min.js"></script>
	
		<script src="static/jsjquery-ui-1.10.0.custom.min.js"></script>
	
		<script src="static/jsjquery.ui.touch-punch.js"></script>
	
		<script src="static/jsmodernizr.js"></script>
	
		<script src="static/jsbootstrap.min.js"></script>
	
		<script src="static/jsjquery.cookie.js"></script>
	
		<script src='static/jsfullcalendar.min.js'></script>
	
		<script src='static/jsjquery.dataTables.min.js'></script>

		<script src="static/jsexcanvas.js"></script>
	<script src="static/jsjquery.flot.js"></script>
	<script src="static/jsjquery.flot.pie.js"></script>
	<script src="static/jsjquery.flot.stack.js"></script>
	<script src="static/jsjquery.flot.resize.min.js"></script>
	
		<script src="static/jsjquery.chosen.min.js"></script>
	
		<script src="static/jsjquery.uniform.min.js"></script>
		
		<script src="static/jsjquery.cleditor.min.js"></script>
	
		<script src="static/jsjquery.noty.js"></script>
	
		<script src="static/jsjquery.elfinder.min.js"></script>
	
		<script src="static/jsjquery.raty.min.js"></script>
	
		<script src="static/jsjquery.iphone.toggle.js"></script>
	
		<script src="static/jsjquery.uploadify-3.1.min.js"></script>
	
		<script src="static/jsjquery.gritter.min.js"></script>
	
		<script src="static/jsjquery.imagesloaded.js"></script>
	
		<script src="static/jsjquery.masonry.min.js"></script>
	
		<script src="static/jsjquery.knob.modified.js"></script>
	
		<script src="static/jsjquery.sparkline.min.js"></script>
	
		<script src="static/jscounter.js"></script>
	
		<script src="static/jsretina.js"></script>

		<script src="static/jscustom.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>
