<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


</head>

<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
			<!-- 页面头部 /-->

		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>


		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

<%--			<img src="/img/center.jpg"--%>
<%--				width="100%" height="100%" />--%>
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

		$(document).ready(function() {
			// 激活导航位置
			setSidebarActive("admin-index");
		});
	</script>
</body>

</html>