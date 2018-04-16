<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
					<li><i class="icon-home"></i>采购管理<i class="icon-angle-right"></i></li>
					<li><a href="form">采购订单编辑</a></li>
				</ul>
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white edit"></i><span class="break"></span>
								采购订单编辑
							</h2>
						</div>
						<div style="clear: both;">&nbsp;</div>
						<div class="box-content">
							<form class="form-horizontal" action="productRequestUpdate"
								method="post" id="updateform">
								<fieldset>
									<table style="width: 80%; margin: 0px auto;">
										<tr>
											<td><div class="control-group">
													<label class="control-label">采购订单号&nbsp;&nbsp;</label>
													<div class="controls">
														<span class="input-xlarge uneditable-input">${purchase.purchaseRequestId}</span>
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label"
														for="employeeByRequestEmpId.empLoginName">申请人&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="employeeByRequestEmpId.empLoginName"
															name="employeeByRequestEmpId.empLoginName"
															data-rel="chosen">
															<c:forEach items="${employeeAll}" var="s">
																<option value="${s.empLoginName}"
																	<c:if test="${s.empLoginName==purchase.employeeByRequestEmpId.empLoginName}">selected="selected"</c:if>>${s.empLoginName}</option>
															</c:forEach>
														</select>
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="requestTime">订单申请时间</label>
													<div class="controls">
														<input type="text" class="input-xlarge datepicker"
															disabled="disabled" readonly="readonly" id="requestTime"
															name="requestTime" placeholder="申请时间,不能修改" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="supplier.supplierId">供应商&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="supplier.supplierId"
															name="supplier.supplierId" data-rel="chosen">
															<c:forEach items="${supplierAll}" var="s">
																<option value="${s.supplierId}"
																	<c:if test="${s.supplierId==purchase.supplier.supplierId }">selected="selected"</c:if>>${s.suppName}</option>
															</c:forEach>
														</select>
													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="SuppContact">供应商联系人</label>
													<div class="controls">
														<input class="input-xlarge focused" id="SuppContact"
															value="${purchase.suppContact}" name="SuppContact"
															type="text" placeholder="此处填写供货商的联系人" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="SuppPhone">联系人电话</label>
													<div class="controls">
														<input class="input-xlarge focused" id="SuppPhone"
															value="${purchase.suppPhone}" name="SuppPhone"
															type="text" placeholder="此处填写联系人的电话" />
													</div>
												</div></td>
										</tr>
										<tr>
											<td colspan="2">
												<div class="control-group">
													<label class="control-label" for="Remark">
														备&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													</label>
													<div class="controls">
														<input type="text" class="span6 typeahead" id="Remark"
															value="${purchase.remark}" name="Remark"
															data-provide="typeahead" data-items="4" />
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
													<th>单位</th>
													<th>数量</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody id="productTbody">
												<c:forEach items="${purchaseDetails.list}" var="s">
													<tr>
														<td>${s.product.productId}</td>
														<td>${s.product.productName}</td>
														<td><input type='text' style='width: 80%; margin: 0px auto; height: 80%;' value='${s.price}' onkeyup='nan(this)' onchange='nan(this)' /></td>
														<td>${s.productUnit.puName} <input type="hidden" value="${s.productUnit.productUnitId}"/> </td>
														<td>${s.count}</td>
														<td><a class='label label-important'
															href="javascript:;" id='removeproductDetail'
															onclick="removeproductDetail(${s.prdId},this)">移除</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div class="pagination pagination-centered">
											<%-- <ul id="muluUl">
												<li><a href="javascript:;"
													onclick="goProductPageByRID('pre')">Prev</a></li>
												<c:forEach begin="1" end="${purchaseDetails.pages}" var="s">
													<li
														<c:if test="${s==purchaseDetails.pageNum}">class="active"</c:if>><a
														href="javascript:;" onclick="goProductPageByRID(${s})">${s}</a></li>
												</c:forEach>
												<li><a href="javascript:;"
													onclick="goProductPageByRID('next')">Next</a></li>
											</ul> --%>
										</div>
										<!--/span-->
									</div>
									<div class="form-actions">
										<input type="hidden" name="purchaseRequestId"
											value="${purchase.purchaseRequestId}" />
										<input type="hidden" name="products" id="products" />
										<button class="btn btn-info btn-setting" id="addPro"
											onclick="javascript:void(0);">添加产品信息</button>
										<button type="submit" class="btn btn-primary">保存信息</button>
										<button class="btn">取消</button>
										<div style="display: none;">
											<button class="btn btn-primary noty" id="error"
												data-noty-options='{"text":"修改失败","layout":"center","type":"error"}'>
												<i class="halflings-icon white white bell"></i>
											</button>
										</div>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END Content -->

	<!-- 模态框  选择产品以及数量 -->
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
							<th>数量</th>
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
						<li><a href="javascript:;" onclick="goproductpage('pre')">上一页</a>
							<input type="hidden" name="productPageNow"
							value="${productAll.pageNum}" /></li>
						<c:forEach begin="1" end="${productAll.pages}" var="s">
							<li><a href="javascript:;" onclick="goproductpage(${s})"
								<c:if test="${productAll.pageNum==s}">class="active"</c:if>>${s}</a></li>
						</c:forEach>
						<li><a href="javascript:;" onclick="goproductpage('next')">下一页</a></li>
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
	<!-- end: JavaScript-->

	<script src="static/own/purchase.js"></script>

	<script type="text/javascript">
		$(function() {
			whetherPro();
			$("#employeeByRequestEmpId.empLoginName").attr("readonly",
					"readonly"); //设置下拉列表为只读
			/* var date = '${purchase.requestTime}';
			$("#requestTime").val(
					parseInt(date.getMonth()) + 1 + "/" + date.getDate() + "/"
							+ date.getFullYear()); */
		});
		/* $("#removeproduct").live('click', function() {
			
		}); */
		/* 使用ajax实现采购订单详情的删除 */
		function removeproductDetail(id,dom){
			var s=confirm("此操作不可撤销,确认删除吗?");
			if(s==true){
				$(dom).parent().parent("tr").remove();//移除dom元素
				$.ajax({
					type : "POST",
					url : "delPurchaseDetailById",
					data : "id="+id,
					dataType : "text",
					success : function(result) {
						if(result=="1"){  //删除成功
							alert("删除成功");
						}else{
							alert("删除失败");
						}
					},
					error:function(){
						
					}
				});
			}
		}

		//点击选择框  把选中的商品添加到数据库中  使用ajax实现
		/* $("#productChose").live('click',function(){
			
		}); */
		
		/* 表单提交事件 */
		$("#updateform").submit(function(){
			var productTbody = $("#productTbody").find("tr[id!=message]"); // 已经有的产品
			var s = "[";
			for (var i = 0; i < productTbody.length; i++) { // 循环已选择的产品列表
				var tbodytr = $(productTbody[i]).children();
				var proid = tbodytr.eq(0).html(); // 产品编号
				var pronum = parseInt(tbodytr.eq(4).html()); // 产品数量
				var prounit = parseInt(tbodytr.eq(3).find("input").val()); // 产品规格id
				var proprice = parseFloat(tbodytr.eq(2).find("input").val()); // 产品价格
				s += "{\"product\":{\"productId\":\"" + proid
						+ "\"},\"count\":\"" + pronum
						+ "\",\"productUnit\":{\"productUnitId\":\"" + prounit
						+ "\"},\"price\":\"" + proprice + "\"}";
				if (i != productTbody.length - 1) { // 代表不是最后一个
					s += ",";
				}
			}
			s += "]";
			$("#products").val(s); // 为产品隐藏域赋值
			return true;
		});
		
		//根据采购单号分页
		function goProductPageByRID(type) {
			var existPurchaseId = '${purchase.purchaseRequestId}';//当前单号
			var existProductPageNum = parseInt('${purchaseDetails.pageNum}');//当前页码
			var existProductPageTotal = parseInt('${purchaseDetails.pages}');//总页码
			if (type == "pre") {
				existProductPageNum = existProductPageNum - 1 < 1 ? 1
						: existProductPageNum - 1;
			} else if (type == 'next') {
				existProductPageNum = existProductPageNum + 1 > existProductPageTotal ? existProductPageTotal
						: existProductPageNum + 1;
			} else {
				existProductPageNum = parseInt(type);
			}
			//ajax实现分页查看订单明细
			$.ajax({
				type : "POST",
				url : "getExistProductByPage",
				data : "pageNum=" + existProductPageNum
						+ "&purchaseId=" + existPurchaseId,
				dataType : "JSON",
				success : function(result) {
					//为已存在的产品信息赋值
					var existProductHtml = "";
					for (var i = 0; i < result.list.length; i++) {
						existProductHtml += "<tr>"
								+ "<td>"
								+ result.list[i].product.productId
								+ "</td>"
								+ "<td>"
								+ result.list[i].product.productName
								+ "</td>"
								+ "<td>  <input type=\"text\" style=\"width: 80%; margin: 0px auto; height: 80%;\" value=\""+ result.list[i].price+"\" onkeyup=\"nan(this)\" onchange=\"nan(this)\" />"
								+ "</td>"
								+ "<td>"   
								+ result.list[i].productUnit.puName +"<input type=\"hidden\" value=\""+result.list[i].productUnit.productUnitId+"\"/>" 
								+ "</td>"
								+ "<td>"
								+ result.list[i].count
								+ "</td>"
								+ "<td><a class='label label-important' id=\"removeproductDetail\" "
								+" href=\"javascript:;\" onclick=\"removeproductDetail("+result.list[i].prdId+",this)\" >移除</a></td>"
								+ "</tr>";
					}
					/* <a class='label label-important' href="javascript:;"
						id='removeproduct' onclick="removeproduct(${s.prdId})">移除</a> */
					$("#productTbody").html(existProductHtml);
					//为页码目录赋值
					/* var muluUl="<li><a href=\"javascript:;\" onclick=\"goProductPageByRID('pre')\">Prev</a></li>";
					for(var i=1;i<=result.pages;i++){
						muluUl+="<li";
						if(i==result.pageNum){
							muluUl+=" class=\"active\" ";
						}
						muluUl+=" ><a href=\"javascript:;\" onclick=\"goProductPageByRID("+i+")\">"+i+"</a></li >";
					}
					muluUl+="<li><a href=\"javascript:;\" onclick=\"goProductPageByRID('next')\">Next</a></li>";
					$("#muluUl").html(muluUl); */
				}
			});
		}
	</script>

</body>
</html>
