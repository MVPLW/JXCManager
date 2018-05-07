<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!-- start: Main Menu -->
<div id="sidebar-left" class="span2">
	<div class="nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu" id="menu">
			<li><a href="gowelcome" target="page-Content"> <i
					class="icon-bar-chart"></i> <span class="hidden-tablet"> 首页</span>
			</a></li>
			<c:forEach items="${navibar}" var="s">
				<li><a
					href="${pageContext.request.contextPath}${s.permissionUrl}"
					target="page-Content"> <i class="icon-eye-open"></i><span
						class="hidden-tablet">${s.permissionDesc}</span>
				</a></li>
			</c:forEach>
			<!-- <li><a href="gopurchase" target="page-Content"> <i
					class="icon-envelope"></i> <span class="hidden-tablet">采购订单</span>
			</a></li>
			<li><a href="supplier" target="page-Content"> <i
					class="icon-tasks"></i> <span class="hidden-tablet">供应商管理</span>
			</a></li>
			<li><a href="goenterstock" target="page-Content"> <i
					class="icon-eye-open"></i> <span class="hidden-tablet">入库管理</span>
			</a></li>
			<li><a href="javascript:;" target="page-Content"> <i
					class="icon-dashboard"></i> <span class="hidden-tablet">仓库管理</span>
			</a></li>
			<li><a href="gorequisition" target="page-Content"><i
					class="icon-edit"></i><span class="hidden-tablet"> 调拨管理 </span></a></li>
			<li><a href="gosales" target="page-Content"><i
					class="icon-list-alt"></i><span class="hidden-tablet"> 销售</span></a></li>
			<li><a href="goenterstock" target="page-Content"><i
					class="icon-font"></i><span class="hidden-tablet"> 入库</span></a></li>
			<li><a href="godamaged" target="page-Content"><i
					class="icon-picture"></i><span class="hidden-tablet"> 报损</span></a></li>
			<li><a href="goleaveStock" target="page-Content"><i
					class="icon-align-justify"></i><span class="hidden-tablet">
						出库</span></a></li> -->
			<li><a class="dropmenu" href="javascript:;"><i
					class="icon-folder-close-alt"></i><span class="hidden-tablet">
						系统设置</span></a>
				<ul>
					<shiro:hasPermission name="employee:list">
						<li><a class="submenu" href="goEmployee"
							target="page-Content"><i class="icon-file-alt"></i><span
								class="hidden-tablet"> 员工管理</span></a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="role:list">
						<li><a class="submenu" href="goRole" target="page-Content"><i
								class="icon-file-alt"></i><span class="hidden-tablet">
									角色管理</span></a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="permission:list">
						<li><a class="submenu" href="gopermission"
							target="page-Content"><i class="icon-file-alt"></i><span
								class="hidden-tablet"> 资源管理</span></a></li>
					</shiro:hasPermission>
				</ul></li>
		</ul>
	</div>
</div>
<!-- end: Main Menu -->