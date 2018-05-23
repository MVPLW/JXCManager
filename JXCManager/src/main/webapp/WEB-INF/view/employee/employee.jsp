<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
					<li><i class="icon-home"></i> <a href="javascript:;">首页</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="javascript:;">员工管理</a></li>
				</ul>
				<div class="row-fluid">
					<div class="control-group">
						<div data-condition="search">
							<div style="float: right;">
								<shiro:hasPermission name="employee:add">
									<a class="btn btn-primary" href="javascript:;" id="employeeAdd"
										onclick="javascript:location.href='goEmployeeAdd';"
										data-command="Add"><i class="icon-plus"></i>&nbsp;添加</a>
								</shiro:hasPermission>
								<shiro:hasPermission name="employee:delete">
									<a class="btn btn-warning" href="javascript:;" onclick="javascript:del();"
										data-command="Delete"><i class="icon-remove"></i>&nbsp;删除</a>
								</shiro:hasPermission>
								<a class="btn btn-danger" href="javascript:;"
									data-command="Refresh"><i class="icon-refresh"></i>&nbsp;刷新</a>
							</div>
						</div>
					</div>
					<div style="clear: both;">&nbsp;&nbsp;&nbsp;</div>
					<div class="box">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>查看员工
							</h2>
						</div>
						<div style="clear: both;">&nbsp;</div>
						<div class="box-content" style="z-index: 1;">
							<table
								class="table table-striped table-bordered bootstrap-datatable">
								<thead>
									<tr>
										<th><input type="checkbox" id="productCheckAll" /></th>
										<th>登录名</th>
										<th>姓名</th>
										<th>加入时间</th>
										<th>性别</th>
										<th>生日</th>
										<th>地址</th>
										<th>联系方式</th>
										<th>Email</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="productBody">
									<c:forEach items="${employeeAll.list}" var="s">
										<tr>
											<th><input type="checkbox" name="productCheck"
												value="${s.empLoginName}" /></th>
											<td>${s.empLoginName}</td>
											<td>${s.empName}</td>
											<td><fmt:formatDate value="${s.joinDate}"
													pattern="yyyy-MM-dd" /></td>
											<td>${s.gender}</td>
											<td><fmt:formatDate value="${s.birthday}"
													pattern="yyyy-MM-dd" /></td>
											<td>${s.address }</td>
											<td>${s.telephone }</td>
											<td>${s.email }</td>
											<td><input type="hidden" value="${s.empLoginName}" /> <a
												href="javascript:;"
												onclick="modalAssignRole('${s.empLoginName}')">查看角色</a></td>
										</tr>
									</c:forEach>
									<c:if test="${fn:length(employeeAll.list)==0}">
										<tr>
											<th colspan="8">对不起 没有查询到数据</th>
										</tr>
									</c:if>
								</tbody>
							</table>
						</div>
						<div class="pagination pagination-centered">
							<ul>
								<li><a href="javascript:;" onclick="goemployeepage(1)">First</a></li>
								<li><a href="javascript:;" onclick="goemployeepage('prev')">Prev</a></li>
								<c:if test="${employeeAll.pageNum-2>1}">
									<li><a>...</a></li>
								</c:if>
								<c:forEach begin="1" end="${employeeAll.pages}" var="s">
									<c:if
										test="${s>=employeeAll.pageNum-2 && s<=employeeAll.pageNum+2 }">
										<li
											<c:if test="${s==employeeAll.pageNum}">class="active"</c:if>>
											<a href="javascript:;" onclick="goemployeepage(${s})">${s}</a>
										</li>
									</c:if>
								</c:forEach>
								<c:if test="${employeeAll.pageNum+2<employeeAll.pages}">
									<li><a>...</a></li>
								</c:if>
								<li><a href="javascript:;" onclick="goemployeepage('next')">Next</a>
									<!-- 隐藏域 存放当前页码 --> <input type="hidden" name="pageNo"
									value="${employeeAll.pageNum}" /></li>
								<li><a href="javascript:;"
									onclick="goemployeepage(${employeeAll.pages})">Last</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 添加角色 -->
	<div class="modal hide fade" id="assignRolesModals"
		style="width: 800px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">x</button>
			<h2>分配角色</h2>
		</div>
		
		<div class="modal-body">
			<div>
				<form method="post" action="goEmpRoleAssign" id="assignRoleForm">
					<table style="width: 100%; table-layout: fixed;">
						<tbody>
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label">谨慎分配</label> <input type="hidden"
											name="empLoginName" />
										<div class="controls" id="haveRoles">
											<!-- <label class="checkbox inline"> <input
												name="assignRole" type="checkbox" id="inlineCheckbox1"
												value="option1"> Option 1
											</label>-->
											<c:forEach items="${roleAll}" var="s" varStatus="a">
												<label class="checkbox inline"> <input
													name="assignRole" type="checkbox"
													id="checkboxRoles${s.roleId}" value="${s.roleId}">
													${s.roleName}
												</label>
												<%-- <c:if test="${a.index+1%4==0}"><div style="clear: both;">&nbsp;</div> </c:if> --%>
											</c:forEach>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<a href="javascript:;" class="btn btn-primary" id="commitAssignRoles">Save</a>
			<a href="javascript:;" class="btn btn-primary" data-dismiss="modal">Close</a>
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

	<script src="static/own/purchase.js"></script>

	<!-- end: JavaScript-->
	<script type="text/javascript">
		function goemployeepage(type){
			var pageNum = parseInt($("input[name=pageNo]").val()); //获取当前的页码
			var pagePageTotal = parseInt('${employeeAll.pages}'); //总页数
			if (pageNum == 1 && type == 'prev') {
				return;
			}
			if (pageNum == pagePageTotal && type == 'next') {
				return;
			}
			if (type == "next") { //下一页
				pageNum = pageNum + 1;
			} else if (type == "prev") { //上一页
				pageNum = pageNum - 1;
			} else {
				pageNum = parseInt(type);
			}
			location.href = "goEmployee?pageNo=" + pageNum;
		}
		
		//显示分配角色的弹框同时加载所有角色
		function modalAssignRole(emploginname){
			//先把所有复选框回复默认
			$("#haveRoles").find("input[name='assignRole']").each(function(i, n) {
				$(n).removeAttr("checked");
				$(n).parent().removeClass("checked");
			})
			$.ajax({
				type:"POST",
				url:"findRolesByEmp",
				data:"emploginname="+emploginname,
				dataType:"JSON",
				success:function(result){
					//拥有的角色选中
					for(var i = 0 ; i < result.length ; i++){
						$("#checkboxRoles"+result[i].roleId).prop("checked",true);
						$("#checkboxRoles"+result[i].roleId).parent().addClass("checked");
					}
				}
			});
			$("input[name=empLoginName]:hidden").val(emploginname);
			$("#assignRolesModals").modal("show");
		}

		/* 删除员工 */
		function del(){
			/* empJudgmen  判断员工是否有被引用 */
		}
		
		$(function(){
			/* 分配角色提交 */
			$("#commitAssignRoles").click(function(){
				var s = confirm("确认分配权限吗?");
				if(s==false){
					return;
				}
				//var a = $("#haveRoles").find("input[name='assignRole']");
				$("#assignRoleForm").submit();/* 提交表单 */
			});
			
		});
	</script>
</body>
</html>