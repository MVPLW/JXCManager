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
					<li><i class="icon-home"></i>首页<i class="icon-angle-right"></i></li>
					<li><a href="form">调拨管理</a></li>
				</ul>
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white edit"></i><span class="break"></span>
								修改调拨单
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
													<label class="control-label">调拨单号&nbsp;&nbsp;</label>
													<div class="controls">
														<input value="${requisition.requisitionId }" name="" disabled="disabled">
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="employeeByRequestEmpId.empLoginName">制单人&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="employeeByRequestEmp.empLoginName"
														name="employeeByRequestEmp.empLoginName"
															data-rel="chosen">
														<c:forEach items="${employees}" var="s">
															<option value="${s.empLoginName}"
															<c:if test="${s.empLoginName==requisition.employeeByRequestEmp.empLoginName }">selected="selected"</c:if>>${s.empLoginName}</option>
														</c:forEach>
														</select>
													</div>
											</div></td>
										</tr>
										<tr>
											<td><div class="control-group">
													<label class="control-label" for="requestTime">制单日期&nbsp;&nbsp;</label>
													<div class="controls">
														<input type="text" class="input-xlarge datepicker"
															readonly="readonly" id="requestTime" name="requestTime"
															placeholder="制单时间" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="supplier.supplierId">调出仓库&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="supplier.supplierId"
															name="storehouseByOutboundStoreHouse.storeHouseId" data-rel="chosen">
															<c:forEach items="${storehouse}" var="s">
																<option value="${s.storeHouseId }"
																<c:if test="${s.storeHouseId==requisition.storehouseByOutboundStoreHouse.shName }">selected="selected"</c:if>>${s.shName}</option>
															</c:forEach>
														</select>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="control-group">
													<label class="control-label" for="supplier.supplierId">调入仓库&nbsp;&nbsp;</label>
													<div class="controls">
														<select id=""
															name="storehouseByStorageStoreHouse.storeHouseId" data-rel="chosen">
															<c:forEach items="${storehouse}" var="s">
																<option value="${s.storeHouseId }"
																<c:if test="${s.storeHouseId==requisition.storehouseByStorageStoreHouse.shName}">selected="selected"</c:if>>${s.shName}</option>
															</c:forEach>
														</select>
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
													<th>单位</th>
													<th>数量</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody id="productTbody">
												<c:forEach items="${requisitionDetail.list}" var="r">
													<tr>
														<td>${r.product.productId}</td>
														<td>${r.product.productName}</td>
														<td>${r.productUnit.puName}<%-- ${s.productUnit.puName}  --%> <input type="hidden" value="${s.productUnit.productUnitId}"/></td>
														<td>${r.count}</td>
														<td><a class='label label-important'
															href="javascript:;" id='removeproductDetail'
															onclick="removeproductDetail(${r.reId},this)">移除</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<!-- <div class="pagination pagination-centered"> -->
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
										<!-- </div> -->
										<!--/span-->
									</div>
									<div class="form-actions">
										<input type="hidden" name="purchaseRequestId"
											value="${purchase.purchaseRequestId}" />
										<input type="hidden" name="products" id="products" />
										<button class="btn btn-info btn-setting" id="addPro"
											onclick="javascript:void(0);">添加产品信息</button>
										<button type="submit" class="btn btn-primary">保存信息</button>
										<button class="btn" type="button" onclick="javascript:history.go(-1);">取消</button>
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
			<a href="#" class="btn btn-primary" id="requisitionproductChose">选择</a> <a
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
					url : "delrequisitionDetailById",
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
				var pronum = parseInt(tbodytr.eq(3).html()); // 产品数量
				var prounit = parseInt(tbodytr.eq(2).find("input").val()); // 产品规格id
				//var proprice = parseFloat(tbodytr.eq(2).find("input").val()); // 产品价格
				s += "{\"product\":{\"productId\":\"" + proid
						+ "\"},\"count\":\"" + pronum
						+ "\",\"productUnit\":{\"productUnitId\":\"" + prounit
						+ "\"}}";
				if (i != productTbody.length - 1) { // 代表不是最后一个
					s += ",";
				}
			}
			s += "]";
			alert("asadadadasdadsaadadsadsa");
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
		

		// 点击选择 把选中的产品添加到采购订单中
		$("#requisitionproductChose").click(function() {
			var tbody = $("#productBody").find("tr");
			var toadd = new Array();
			for (var i = 0; i < tbody.length; i++) {
				var tbodytr = $(tbody[i]).children(); // 获取tr中所有子元素
				// 获取第一个复选框的值 判断是否选中 选中的值为true 未选中值为false
				var checkBox = tbodytr.eq(0).find('input').prop(
						'checked');
				// 获取数字框的值
				var num = parseInt(tbodytr.eq(5).find('input').val());
				// 如果复选框选中或者数量大于0的时候
				if (checkBox == true && num > 0) {
					var product = new Object();
					product.id = tbodytr.eq(2).html(); // 产品编号
					product.name = tbodytr.eq(1).html(); // 产品名称
					product.unit = tbodytr.eq(4).html(); // 产品计量单位名称
					product.unitid = tbodytr.eq(4).find("input").val(); // 产品计量单位id
					product.num = num; // 为对象的数量赋值
					// 创建的对象添加到数组中
					toadd.push(product);
				}
			}
			if (toadd.length < 1) {
				alert("请选择产品或者输入数量");
				return;
			}
			
			// 合并产品的方法 如果选择重复的 则直接更改数量 向已选择产品添加的时候 判断是否已经包含 如果包含 则合并
			// toadd 是 从模态框中选择的产品
			var productHtml = "";
			// var flag=new Array();
			var productTbody = $("#productTbody").find(
					"tr[id!=message]"); // 已经有的产品
			for (var i = 0; i < productTbody.length; i++) { // 循环已选择的产品列表
				var tbodytr = $(productTbody[i]).children();
				var proid = tbodytr.eq(0).html();
				for (var j = 0; j < toadd.length; j++) { // 循环选择的产品
					if (proid == toadd[j].id) { // 则把已经选择的产品数量修改
						// flag.push();
						var pronum = tbodytr.eq(3).html(); // 已经存在的产品数量
						var sum = parseInt(parseInt(pronum)+toadd[j].num); // 两个数量相加
						alert(pronum);
						alert(sum);
						tbodytr.eq(3).html(sum); // 赋值
						toadd[j].flag = true;
						break;
					}
				}
			}
			
			// 根据在模态框中选择的商品拼接成html
			for (var i = 0; i < toadd.length; i++) {
				// 判断是否包含某个属性 对象.属性 !==undefined 包含属性返回true 不包含返回false
				if ((toadd[i].flag !== undefined) == false) {
					productHtml += "<tr>"
							+ "<td>"
							+ toadd[i].id
							+ "</td>"
							+ "<td>"
							+ toadd[i].name
							+ "</td>"
							+ "<td>"
							+ toadd[i].unit
							+ "</td>"
							+ "<td>"
							+ toadd[i].num
							+ "</td>"
							+ "<td><a class='label label-important' id='removeproduct' >移除</a></td>"
							+ "</tr>";
				}
			}
			// 调用移除提示字样方法
			removeWhether();
			// 在已选择的产品中添加已选择的
			$("#productTbody").append(productHtml);
			$("#myModal").modal("hide");
		});
	</script>

</body>
</html>
