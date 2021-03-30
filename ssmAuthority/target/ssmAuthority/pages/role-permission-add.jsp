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


	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<link rel="stylesheet"  href="/css/bootstrap.min.css">
	<link rel="stylesheet"  href="/css/font-awesome.css">
	<link rel="stylesheet"  href="/css/ionicons.min.css">
	<link rel="stylesheet"  href="/css/jquery-jvectormap.css">
	<link rel="stylesheet"  href="/css/AdminLTE.min.css">
	<link rel="stylesheet"  href="/css/_all-skins.min.css">
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
				角色管理 <small>添加权限表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/role/findAll.do">角色管理</a></li>
				<li class="active">添加权限表单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<form
				action="${pageContext.request.contextPath}/role/addPermissionToRole.do"
				method="post">
				<!-- 正文区域 -->
				<section class="content"> 
				
				<input type="hidden" name="roleId" value="${role.id}">
				
					<table id="dataList"
							class="table table-bordered table-striped table-hover dataTable">
							<thead>
								<tr>
									<th class="" style="padding-right: 0px">
									<input id="selall" 
										type="checkbox" class="icheckbox_square-blue"></th>
									<th class="sorting_asc">ID</th>
									<th class="sorting">权限名称</th>
									<th class="sorting">权限URL</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${permissionList}" var="permission">
									<tr>
										<td>
										
										<input name="ids" type="checkbox" value="${permission.id}">
										
										</td>
										<td>${permission.id}</td>
										<td>${permission.permissionName }</td>
										<td>${permission.url}</td>
										
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
		<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.8
		</div>
		<strong>Copyright &copy; 2014-2017 <a
			href="http://www.itcast.cn">研究院研发部</a>.
		</strong> All rights reserved. </footer>
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

		$(document)
				.ready(
						function() {

							// 激活导航位置
							setSidebarActive("admin-datalist");

							// 列表按钮
							$("#dataList td input[type='checkbox']")
									.iCheck(
											{
												checkboxClass : 'icheckbox_square-blue',
												increaseArea : '20%'
											});
							// 全选操作
							$("#selall")
									.click(
											function() {
												var clicks = $(this).is(
														':checked');
												if (!clicks) {
													$(
															"#dataList td input[type='checkbox']")
															.iCheck(
																	"uncheck");
												} else {
													$(
															"#dataList td input[type='checkbox']")
															.iCheck("check");
												}
												$(this).data("clicks",
														!clicks);
											});
						});
	</script>


</body>

</html>