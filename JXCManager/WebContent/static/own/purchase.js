//产品信息分页实现  
function goproductpage(type) {
	// 移除全选的选中
	$("#productCheckAll").removeAttr("checked");
	$("#productCheckAll").parent().removeClass("checked");
	var pageNum = parseInt($("[name=productPageNow]").val()); // 获取当前的页码
	var pagePageTotal = parseInt('${productAll.pages}'); // 总页数
	if (type == "next") { // 下一页
		pageNum = pageNum + 1 > pagePageTotal ? pagePageTotal : pageNum + 1;
	} else if (type == "pre") { // 上一页
		pageNum = pageNum - 1 < 1 ? 1 : pageNum - 1;
	} else {
		pageNum = parseInt(type);
	}
	$
			.ajax({
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
								+ "<input type='hidden' value='"
								+ result[i].productunit.productUnitId
								+ "' />"
								+ "</td>"
								+ "<td><input type='number' min='0' value='0' style='width: 80%; margin: 0px auto; height: 80%;' /></td>"
								+ "</tr>";
					}
					$("#productBody").html(s);
				}
			});
}

// 产品全选
$("#productCheckAll").change(function() {
	var flage = $(this).prop('checked');
	$("#productBody").find("input[name='productCheck']").each(function(i, n) {
		if (flage == true) {
			$(n).prop("checked", true);
			$(n).parent().addClass("checked");
		} else {
			$(n).removeAttr("checked");
			$(n).parent().removeClass("checked");
		}
	})
});

// 点击选中框 如果有false值 取消全选框
$("[name=productCheck]").live('change', function() {
	var flag = true;
	$("#productBody").find("input[name='productCheck']").each(function(i, n) {
		var s = $(n).prop("checked");
		if (s == false) {
			flag = false;
		}
	})
	if (flag == true) {
		$("#productCheckAll").prop("checked", true);
		$("#productCheckAll").parent().addClass("checked");
	} else {
		$("#productCheckAll").removeAttr("checked");
		$("#productCheckAll").parent().removeClass("checked");
	}
});

// 移除按钮点击实现产品移除
$("#removeproduct").live('click', function() {
	$(this).parent().parent("tr").remove();
	// 判断是否还有产品 如果没有 加上提示字样
	whetherPro();
});

// 点击选择 把选中的产品添加到采购订单中
$("#productChose")
		.click(
				function() {
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
								var pronum = tbodytr.eq(4).html(); // 已经存在的产品数量
								var sum = parseInt(parseInt(pronum)
										+ toadd[j].num); // 两个数量相加
								tbodytr.eq(4).html(sum); // 赋值
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
									+ "<td><input type='text' style='width: 80%; margin: 0px auto; height: 80%;' value='0'; onkeyup='nan(this)' onchange='nan(this)' /></td>"
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
// 文本框只能输入数字和小数
function nan(obj) {
	// t.value=t.value.replace(/[^\d]/g,"");
	// 得到第一个字符是否为负号
	var t = obj.value.charAt(0);
	// 先把非数字的都替换掉，除了数字和.
	obj.value = obj.value.replace(/[^\d\.]/g, '');
	// 必须保证第一个为数字而不是.
	obj.value = obj.value.replace(/^\./g, '');
	// 保证只有出现一个.而没有多个.
	obj.value = obj.value.replace(/\.{2,}/g, '.');
	// 保证.只出现一次，而不能出现两次以上
	obj.value = obj.value.replace('.', '$#$').replace(/\./g, '').replace('$#$',
			'.');
	// 如果第一位是负号，则允许添加
	if (t == '-') {
		obj.value = '-' + obj.value;
	}
}

// 判断是否有产品如果没有则添加提示字样
function whetherPro() {
	var prompt = "<tr id='message'><td colspan='6' rowspan='2' align='center'"
			+ "height='50px' ><h2 style='margin-left: 420px;'>请添加采购产品</h2>"
			+ "</td>" + "</tr>";
	var pros = $("#productTbody").find("tr");
	if (pros.length < 1) {
		$("#productTbody").html(prompt);
	}
}

// 移除提示字样
function removeWhether() {
	var pro = $("#productTbody").find("#message");
	$(pro).remove();
}

// 表单提交 封装好json字符串带到后台
$("#myform").submit(
		function() {
			var productTbody = $("#productTbody").find("tr[id!=message]"); // 已经有的产品
			var s = "[";
			for (var i = 0; i < productTbody.length; i++) { // 循环已选择的产品列表
				var tbodytr = $(productTbody[i]).children();
				var proid = tbodytr.eq(0).html(); // 产品编号
				var pronum = parseInt(tbodytr.eq(4).html()); // 产品数量
				var prounit = parseInt(tbodytr.eq(3).find("input").val()); // 产品规格id
				var proprice = parseInt(tbodytr.eq(2).find("input").val()); // 产品价格
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

// 点击选择产品时 把checkbox和数量框清空
$("#addPro").click(function() {
	var tbody = $("#productBody").find("tr");
	for (var i = 0; i < tbody.length; i++) {
		var tbodytr = $(tbody[i]).children();
		var s = tbodytr.eq(0).find("input[name=productCheck]");
		/* tbodytr.eq(0).find("input[name=productCheck]").prop("checked",false); */
		$(s).removeAttr("checked");
		$(s).parent().removeClass("checked");
		$("#productCheckAll").removeAttr("checked");
		$("#productCheckAll").parent().removeClass("checked");
		tbodytr.eq(5).find("input").val(0);
	}
});
// 时间戳日期转换
function dateformat(str) {
	if (str == null || str == "" || typeof (str) == "undefined") {
		return "";
	}
	var now = new Date(str);
	var year = now.getFullYear();
	var month = (now.getMonth() + 1).toString();
	var day = (now.getDate()).toString();
	if (month.length == 1) {
		month = "0" + month;
	}
	if (day.length == 1) {
		day = "0" + day;
	}
	var dateTime = year + "-" + month + "-" + day;
	return dateTime;
}