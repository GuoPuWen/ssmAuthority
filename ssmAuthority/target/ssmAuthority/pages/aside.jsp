<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<sec:authentication property="name"/></p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control" placeholder="搜索">
				<span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat">
                  <i class="fa fa-search"></i>
                </button>
              </span>
			</div>
		</form>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu" data-widget="tree">
<%--			<li class="header">MAIN NAVIGATION</li>--%>
			<li class="active treeview menu-open">
				<a href="/">
					<i class="fa fa-dashboard"></i> <span>首页</span>
					<span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
				</a>

				<ul class="treeview-menu">
						<li><a href="/user/findAll.do"><i class="fa fa-circle-o"></i> 用户管理</a></li>
						<li class="active"><a href="/role/findAll.do"><i class="fa fa-circle-o"></i> 角色管理</a></li>
						<li class="active"><a href="/permission/findAll.do"><i class="fa fa-circle-o"></i> 资源权限管理</a></li>
						<li class="active"><a href="/sysLog/findAll.do"><i class="fa fa-circle-o"></i> 访问日志</a></li>
				</ul>

			</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-files-o"></i>
					<span>基础数据</span>
					<span class="pull-right-container">
<%--              <span class="label label-primary pull-right">4</span>--%>
            </span>
				</a>
				<ul class="treeview-menu">
						<li><a href="/product/findAll.do?page=1&size=4"><i class="fa fa-circle-o"></i> 产品管理</a></li>
						<li><a href="/orders/findAll.do?page=1&size=4"><i class="fa fa-circle-o"></i> 订单管理</a></li>
				</ul>
			</li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>