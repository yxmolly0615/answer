<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="iframe-h">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>网站后台管理模板</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css" />
<link rel="stylesheet" type="text/xss"
	href="${pageContext.request.contextPath}/static/admin/css/admin.css" />
<script type="text/css" src="${pageContext.request.contextPath}/static/admin/css/admin" />
</head>

	<body>
		<div class="wrap-container clearfix">
				<div class="column-content-detail">
					<form class="layui-form" action="${pageContext.request.contextPath }/cate/list">
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								<button class="layui-btn layui-btn-small layui-btn-normal addBtn" topTitle="add" data-url="../../admin/index/addCate.jsp"><i class="layui-icon">&#xe654;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-danger delBtn"  data-url="article-add.html"><i class="layui-icon">&#xe640;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="article-add.html"><i class="iconfont">&#xe656;</i></button>
							</div>
							<div class="layui-inline">
								<input type="text" name="name" value="${name}" placeholder="请输入标题" autocomplete="off" class="layui-input">
							</div>
							<button class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
						</div>
					</form>
					<div class="layui-form" id="table-list">
						<table class="layui-table" lay-even lay-skin="nob">
							<colgroup>
								<col width="50">
								<col class="hidden-xs" width="50">
								<col width="180">
								<col width="80">
								<col width="150">
							</colgroup>
							<thead>
								<tr>
									<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
									<th class="hidden-xs">ID</th>
									<th>名称</th>
									<th>描述</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="c" items="${info.list}">
							<tr>
							<td><input type="checkbox" name=""></td>
							</tr>
							</c:forEach>
							</tbody>
						</table>
						<div id="pages"></div> 
					</div>
				</div>
		</div>
		<script src="${pageContext.request.contextPath }/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>