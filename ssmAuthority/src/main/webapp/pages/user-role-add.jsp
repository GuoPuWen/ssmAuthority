<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- 页面meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<title>SSM权限管理系统</title>
	<meta name="description" content="Spring SpringMVC Mybatis 权限管理 SpringSecurity">
	<meta name="keywords" content="Spring SpringMVC Mybatis 权限管理 SpringSecurity">

	<!-- Tell the browser to be responsive to screen width -->
	<meta
			content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
			name="viewport">


	<link rel="stylesheet"  href="/css/bootstrap.min.css">
	<link rel="stylesheet"  href="/css/font-awesome.css">
	<link rel="stylesheet"  href="/css/ionicons.min.css">
	<link rel="stylesheet"  href="/css/jquery-jvectormap.css">
	<link rel="stylesheet"  href="/css/AdminLTE.min.css">
	<link rel="stylesheet"  href="/css/_all-skins.min.css">
	<link rel="stylesheet"  href="/css/style.css">
</head>
<body class="hold-transition skin-purple sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->
		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				用户管理 <small>添加角色表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/user/findAll.do">用户管理</a></li>
				<li class="active">${user.username}</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<form
				action="${pageContext.request.contextPath}/user/addRoleToUser.do"
				method="post">
				<!-- 正文区域 -->
				<section class="content"> 
				
				<input type="hidden" name="userId" value="${user.id}">
				
					<table id="dataList"
							class="table table-bordered table-striped table-hover dataTable">
							<thead>

								<tr>
									<th class="" style="padding-right: 0px">
									<input id="selall" 
										type="checkbox" class="icheckbox_square-blue"></th>
									<th class="sorting_asc">ID</th>
									<th class="sorting">角色名称</th>
									<th class="sorting">角色描述</th>									
								</tr>
							</thead>
							<tbody>


								<c:forEach items="${roleList}" var="role">
									<tr>
										<td>
										
										<input name="ids" type="checkbox" value="${role.id}">
										
										</td>
										<td>${role.id}</td>
										<td>${role.roleName }</td>
										<td>${role.roleDesc}</td>
										
									</tr>
								</c:forEach>
							</tbody>

						</table>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">保存</button>
					<button type="button" class="btn bg-default"
						onclick="history.back(-1);">返回</button>
				</div>
				<!--工具栏/--> </section>
				<!-- 正文区域 /-->
			</form>
		</div>
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- 底部导航 /-->
	</div>


	<script  src="/js/jquery.min.js"></script>
	<script  src="/js/bootstrap.min.js"></script>
	<script  src="/js/fastclick.js"></script>
	<script  src="/js/adminlte.min.js"></script>
	<script  src="/js/jquery.sparkline.min.js"></script>
	<script  src="/js/jquery-jvectormap-1.2.2.min.js"></script>
	<script  src="/js/jquery-jvectormap-world-mill-en.js"></script>
	<script  src="/js/jquery.slimscroll.min.js"></script>
	<script  src="/js/Chart.js"></script>
	<script  src="/js/dashboard2.js"></script>
	<script  src="/js/demo.js"></script>

	<script>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});
		});

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}

	</script>


</body>

</html>