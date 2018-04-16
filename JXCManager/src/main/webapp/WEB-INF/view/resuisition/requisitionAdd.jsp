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
					<li><a href="form">调拨新增管理</a></li>
				</ul>
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white edit"></i><span class="break"></span>
								新增调拨单
							</h2>
						</div>
						<div style="clear: both;">&nbsp;</div>
						<div class="box-content">
							<form class="form-horizontal" action="requisitionAdd"
								method="post" id="myform">
								<fieldset>
									<table style="width: 80%; margin: 0px auto;">
										<tr>
											<td><div class="control-group">
													<label class="control-label">调拨单号&nbsp;&nbsp;</label>
													<div class="controls">
														<span class="input-xlarge uneditable-input">单号自动生成</span>
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label"
														for="employeeByRequestEmpId.empLoginName">制单人&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="employeeByRequestEmp.empLoginName"
															name="employeeByRequestEmp.empLoginName"
															data-rel="chosen">
															<c:forEach items="${employees}" var="s">
																<option value="${s.empLoginName}"
																	<c:if test="${s.empLoginName==sessionScope.loginEmp.empLoginName }">selected="selected"</c:if>>${s.empLoginName}</option>
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
															placeholder="申请时间" />
													</div>
												</div></td>
											<td><div class="control-group">
													<label class="control-label" for="supplier.supplierId">调出仓库&nbsp;&nbsp;</label>
													<div class="controls">
														<select id="supplier.supplierId"
															name="storehouseByOutboundStoreHouse.storeHouseId" data-rel="chosen">
															<c:forEach items="${storehouse}" var="s">
																<option value="${s.storeHouseId }">${s.shName}</option>
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
																<option value="${s.storeHouseId }">${s.shName}</option>
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
											</tbody>
										</table>
										<!-- <div class="pagination pagination-centered">
											<ul>
												<li><a href="#">Prev</a></li>
												<li class="active"><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#">Next</a></li>
											</ul>
										</div> -->
										<!--/span-->
									</div>
									<div class="form-actions">
										<input type="hidden" name="products" id="products" />
										<button class="btn btn-info btn-setting" id="addPro"
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
						<li><a href="javascript:goproductpage('pre');">上一页</a> <input
							type="hidden" name="productPageNow" value="${productAll.pageNum}" />
						</li>
						<c:forEach begin="1" end="${productAll.pages}" var="s">
							<li><a href="javascript:goproductpage(${s});"
								<c:if test="${productAll.pageNum==s}">class="active"</c:if>>${s}</a></li>
						</c:forEach>
						<li><a href="javascript:goproductpage('next');">下一页</a></li>
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

	<script type="text/javascript">
		$(function() {
			whetherPro();
			$("#employeeByRequestEmpId.empLoginName").attr("readonly",
					"readonly"); //设置下拉列表为只读
			//设置时间控件默认为当前时间
			var date = new Date();
			$("#requestTime").val(
					parseInt(date.getMonth()) + 1 + "/" + date.getDate() + "/"
							+ date.getFullYear());
		});
		//产品信息分页实现  
		function goproductpage(type) {
			//移除全选的选中
			$("#productCheckAll").removeAttr("checked");
			$("#productCheckAll").parent().removeClass("checked");
			var pageNum = parseInt($("[name=productPageNow]").val()); //获取当前的页码
			var pagePageTotal = parseInt('${productAll.pages}'); //总页数
			if (type == "next") { //下一页
				pageNum = pageNum + 1 > pagePageTotal ? pagePageTotal
						: pageNum + 1;
			} else if (type == "pre") { //上一页
				pageNum = pageNum - 1 < 1 ? 1 : pageNum - 1;
			} else {
				pageNum = parseInt(type);
			}
			
			$.ajax({
						type : "POST",
						url : "getProductByPage",
						data : "pageNum=" + pageNum,
						dataType : "JSON",
						success : function(result) {
							var s = "";
							for ( var i in result) {
								s += "<tr height='20px;'>"
										+ "<td><input type='checkbox' name='productCheck' /></td>"
										+ "<td>"
										+ result[i].productName
										+ "</td>"
										+ "<td>"
										+ result[i].productId
										+ "</td>"
										+ "<td>"
										+ result[i].producttype.productTypeName
										+ "</td>"
										+ "<td>"
										+ result[i].productunit.puName
										+ "<input type='hidden' value='"+result[i].productunit.productUnitId+"' />"
										+ "</td>"
										+ "<td><input type='number' min='0' value='0' style='width: 80%; margin: 0px auto; height: 80%;' /></td>"
										+ "</tr>";
							}
							$("#productBody").html(s);
						}
					});
		}

		/* 
		 $("#productCheckAll").change(function(){//判断全选框的改变
			 var flage =$(this).is(":checked");//全选选中为true，否则为false
			 $("input[type=checkbox]").each(function(){
				 $(this).prop("checked",flage);
			 });
		 )};
		 */

		//产品全选
		$("#productCheckAll").change(function() {
			var flage = $(this).prop('checked');
			$("#productBody").find("input[name='productCheck']").each(function(i,n){
				if(flage==true){
					$(n).prop("checked",true);
					$(n).parent().addClass("checked");
				}else{
					$(n).removeAttr("checked");
					$(n).parent().removeClass("checked");
				}
			})
		});
		
		//点击选中框  如果有false值  取消全选框 
		$("[name=productCheck]").live('change',function(){
			var flag = true;
			$("#productBody").find("input[name='productCheck']").each(function(i,n){
				var s=$(n).prop("checked");
				if(s==false){
					flag=false;
				}
			})
			if(flag==true){
				$("#productCheckAll").prop("checked",true);
				$("#productCheckAll").parent().addClass("checked");
			}else{
				$("#productCheckAll").removeAttr("checked");
				$("#productCheckAll").parent().removeClass("checked");
			}
		});

		//移除按钮点击实现产品移除
		$("#removeproduct").live('click', function() {
			$(this).parent().parent("tr").remove();
			//判断是否还有产品  如果没有 加上提示字样
			whetherPro();
		});

		//点击选择  把选中的产品添加到调拨订单中
		$("#productChose")
				.click(
						function() {
							var tbody = $("#productBody").find("tr");
							var toadd = new Array();
							for (var i = 0; i < tbody.length; i++) {
								var tbodytr = $(tbody[i]).children(); //获取tr中所有子元素
								//获取第一个复选框的值    判断是否选中  选中的值为true  未选中值为false
								var checkBox = tbodytr.eq(0).find('input')
										.prop('checked');
								//获取数字框的值
								var num = parseInt(tbodytr.eq(5).find('input')
										.val());
								//如果复选框选中或者数量大于0的时候
								if (checkBox == true && num > 0) {
									var product = new Object();
									product.id = tbodytr.eq(2).html(); //产品编号
									product.name = tbodytr.eq(1).html(); //产品名称
									product.unit = tbodytr.eq(4).html(); //产品计量单位名称
									product.unitid = tbodytr.eq(4)
											.find("input").val(); //产品计量单位id
									product.num = num; //为对象的数量赋值
									//创建的对象添加到数组中
									toadd.push(product);
								}
							}
							if (toadd.length < 1) {
								alert("请选择产品或者输入数量");
								return;
							}

							//合并产品的方法   如果选择重复的  则直接更改数量  向已选择产品添加的时候  判断是否已经包含  如果包含  则合并
							//toadd  是 从模态框中选择的产品
							var productHtml = "";
							//var flag=new Array();
							var productTbody = $("#productTbody").find(
									"tr[id!=message]"); //已经有的产品
							for (var i = 0; i < productTbody.length; i++) { //循环已选择的产品列表
								var tbodytr = $(productTbody[i]).children();
								var proid = tbodytr.eq(0).html();
								for (var j = 0; j < toadd.length; j++) { //循环选择的产品
									if (proid == toadd[j].id) { //则把已经选择的产品数量修改 
										//flag.push();
										var pronum = tbodytr.eq(4).html(); //已经存在的产品数量
										var sum = parseInt(parseInt(pronum)
												+ toadd[j].num); //两个数量相加
										tbodytr.eq(4).html(sum); //赋值
										toadd[j].flag = true;
										break;
									}
								}
							}

							//根据在模态框中选择的商品拼接成html
							for (var i = 0; i < toadd.length; i++) {
								//判断是否包含某个属性对象.属性 !==undefined  包含属性返回true  不包含返回false
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
							//调用移除提示字样方法
							removeWhether();
							//在已选择的产品中添加已选择的
							$("#productTbody").append(productHtml);
							$("#myModal").modal("hide");
						});
		//文本框只能输入数字和小数
		function nan(obj) {
			//t.value=t.value.replace(/[^\d]/g,"");
			//得到第一个字符是否为负号
			var t = obj.value.charAt(0);
			//先把非数字的都替换掉，除了数字和. 
			obj.value = obj.value.replace(/[^\d\.]/g, '');
			//必须保证第一个为数字而不是. 
			obj.value = obj.value.replace(/^\./g, '');
			//保证只有出现一个.而没有多个. 
			obj.value = obj.value.replace(/\.{2,}/g, '.');
			//保证.只出现一次，而不能出现两次以上 
			obj.value = obj.value.replace('.', '$#$').replace(/\./g, '')
					.replace('$#$', '.');
			//如果第一位是负号，则允许添加
			if (t == '-') {
				obj.value = '-' + obj.value;
			}
		}

		//判断是否有产品如果没有则添加提示字样
		function whetherPro() {
			var prompt = "<tr id='message'><td colspan='6' rowspan='2' align='center'"+ 
							"height='50px' ><h2 style='margin-left: 420px;'>请添加采购产品</h2>"
					+ "</td>" + "</tr>";
			var pros = $("#productTbody").find("tr");
			if (pros.length < 1) {
				$("#productTbody").html(prompt);
			}
		}

		//移除提示字样
		function removeWhether() {
			var pro = $("#productTbody").find("#message");
			$(pro).remove();
		}

		//表单提交  封装好json字符串带到后台
		$("#myform").submit(
				function() {
					var productTbody = $("#productTbody").find("tr[id!=message]"); //已经有的产品
					var s = "[";
					for (var i = 0; i < productTbody.length; i++) { //循环已选择的产品列表
						
						var tbodytr = $(productTbody[i]).children();
						var proid = tbodytr.eq(0).html(); //产品编号
						var pronum = parseInt(tbodytr.eq(3).html()); //产品数量
						var prounit = parseInt(tbodytr.eq(2).find("input").val()); //产品规格id
						s += "{\"product\":{\"productId\":\"" + proid
								+ "\"},\"count\":\"" + pronum
								+ "\",\"productUnit\":{\"productUnitId\":\""
								+ prounit + "\"}}";
						if (i != productTbody.length - 1) { //代表不是最后一个
							s += ",";
						}
					}
					s += "]";
					$("#products").val(s); //为产品隐藏域赋值
					return true;
				});

		//点击选择产品时  把checkbox和数量框清空  
		$("#addPro").click(function() {
			var tbody = $("#productBody").find("tr");
			for (var i = 0; i < tbody.length; i++) {
				var tbodytr = $(tbody[i]).children();
				var s=tbodytr.eq(0).find("input[name=productCheck]");
				/* tbodytr.eq(0).find("input[name=productCheck]").prop("checked",false); */
				$(s).removeAttr("checked");
				$(s).parent().removeClass("checked");
				$("#productCheckAll").removeAttr("checked");
				$("#productCheckAll").parent().removeClass("checked");
				tbodytr.eq(5).find("input").val(0);
			}
		});
		/* 
		 *	为什么下拉列表变成disable后台就不能读取到
		 */
	</script>

</body>
</html>
