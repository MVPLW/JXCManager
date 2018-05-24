<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
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
h3 {
	display: inline;
}
</style>

<body>
	<div class="container-fluid-full">
		<div class="row-fluid">
			<!-- start: Content -->
			<div id="content" class="span10">
				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="gowelcome">首页</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="javascript:;">库存信息</a></li>
				</ul>

				<div class="row-fluid">
					<form action="goStockPile" method="post" class="form-horizontal"
						id="stockPileForm">
						<div class="control-group">
							<div data-condition="search">
								仓库&nbsp;&nbsp;&nbsp;<select id="storeHouseId"
									name="storeHouseId" style="width: 150px;">
									<option value="-1">请选择</option>
									<c:forEach items="${storeHouselist}" var="s">
										<option value="${s.storeHouseId}"
											<c:if test="${s.storeHouseId==storeHouseId }">selected="selected"</c:if>>${s.shName}</option>
									</c:forEach>
								</select>&nbsp;&nbsp;&nbsp;产品 &nbsp;&nbsp;&nbsp;<select id="productId"
									name="productId" style="width: 150px;">
									<option value="-1">请选择</option>
									<c:forEach items="${productList}" var="s">
										<option value="${s.productId}"
											<c:if test="${s.productId==productId }">selected="selected"</c:if>>${s.productName}</option>
									</c:forEach>
								</select>&nbsp;&nbsp;&nbsp; <input type="submit" value="搜索"
									class="btn btn-success" /> <input type="reset" value="清空"
									class="btn btn-warning">
								<div style="float: right;">
									<button class="btn btn-success dropdown-toggle"
										data-toggle="dropdown">
										<span class="caret"></span>&nbsp;导出
									</button>
									<ul class="dropdown-menu">
										<li><a href="javascript:;" onclick="">导出当前数据</a></li>
										<li><a href="javascript:;" onclick="">导出所有数据</a></li>
									</ul>
									<a class="btn btn-danger" href="javascript:void(0)"
										onclick="javascript:location.href='goStockPile';"
										data-command="Refresh"><i class="icon-refresh"></i>&nbsp;刷新</a>
								</div>
							</div>
						</div>
						<div class="box">
							<div class="box-header" data-original-title>
								<h2>
									<i class="halflings-icon white user"></i><span class="break"></span>库存信息
								</h2>
							</div>
							<div style="clear: both;">&nbsp;</div>
							<div style="clear: both;">&nbsp;</div>
							<div class="box-content">
								<table style="table-layout: fixed;"
									class="table table-striped table-bordered bootstrap-datatable">
									<thead>
										<tr>
											<th width="25px"><input type="checkbox"
												id="productCheckAll" /></th>
											<th>仓库</th>
											<th>产品</th>
											<th>存货剩余</th>
											<th>规格</th>
											<th>计量单位</th>
											<th>均价</th>
										</tr>
									</thead>
									<tbody id="productBody">
										<c:forEach items="${stockPileAll.list}" var="s">
											<tr>
												<th><input type="checkbox" name="productCheck"
													value="${s.spId}" /></th>
												<td>${s.storehouse.shName}</td>
												<td>${s.product.productName}</td>
												<td>${s.quantity}</td>
												<td>${s.prosPecification}</td>
												<td>${s.productunit.puName}</td>
												<td>${s.costPrice}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="pagination pagination-centered">
								<ul>
									<li><a href="javascript:;" onclick="goStockPilePage(1)">First</a></li>
									<li><a href="javascript:;"
										onclick="goStockPilePage('prev')">Prev</a></li>
									<c:if test="${stockPileAll.pageNum-2>1}">
										<li><a>...</a></li>
									</c:if>
									<c:forEach begin="1" end="${stockPileAll.pages}" var="s">
										<c:if
											test="${s>=stockPileAll.pageNum-2 && s<=stockPileAll.pageNum+2 }">
											<li
												<c:if test="${s==stockPileAll.pageNum}">class="active"</c:if>>
												<a href="javascript:;" onclick="goStockPilePage(${s})">${s}</a>
											</li>
										</c:if>
									</c:forEach>
									<c:if test="${stockPileAll.pageNum+2<stockPileAll.pages}">
										<li><a>...</a></li>
									</c:if>
									<li><a href="javascript:;"
										onclick="goStockPilePage('next')">Next</a> <!-- 隐藏域 存放当前页码 -->
										<input type="hidden" name="pageNo"
										value="${stockPileAll.pageNum}" /></li>
									<li><a href="javascript:;"
										onclick="goStockPilePage(${stockPileAll.pages})">Last</a></li>
								</ul>
							</div>
						</div>
					</form>
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
	<!-- end: JavaScript-->

	<script src="static/own/purchase.js"></script>

	<script type="text/javascript">
		function goStockPilePage(type){
			var pageNo=parseInt('${stockPileAll.pageNum}');
			var pageCount=parseInt('${stockPileAll.pages}');
			if(type=="next"){  //下一页
				if(pageNo==pageCount){return;}
				pageNo++;
			}else if(type=="prev"){  //上一页
				if(pageNo==1){return;}
				pageNo--;
			}else{
				pageNo=parseInt(type);
			}
			var storeHouseId=$("#storeHouseId").val();//仓库id
			var productId=$("#productId").val();   //产品id
			location.href="goStockPile?pageNo="+pageNo+"&storeHouseId="+storeHouseId+"&productId="+productId;
		}
	</script>
	<script type="text/javascript">
		$(function() {
			
		});
	</script>
</body>
</html>
