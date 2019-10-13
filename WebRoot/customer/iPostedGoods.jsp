<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
.tb {
	padding: 30px 80px 10px;
	font-size: 17px;
}

table {
	table-layout: fixed;
	width: 100%;
}
.table th, .table td { 
text-align: center;
vertical-align: middle!important;
}

td {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

table #amend {
	background: url(imgs/change4.png) no-repeat;
	cursor: pointer;
}

table #amend:hover {
	background: url(imgs/change3.png) no-repeat;
}

table #del {
	background: url(imgs/del3.png) no-repeat;
	cursor: pointer;
}

table #del:hover {
	background: url(imgs/del4.png) no-repeat;
}

label{
	font-size:15px;
}
.tb{
	overflow-y:auto; 
	overflow-x:hidden; 
	width:100%; 
	height:550px;
}
.paging{
	margin-left:890px;
}
.ipos{
	width:100%;
	height:50px;
	
}
.ipos_title{
	width:575px;
	line-height:50px;
	margin:0 auto;
}

.ipos_title li {
	float:left;
	margin-right:60px;
}
.ipos_title li a {
	display: inline-block;
	width: 100%;
	height: 100%;
	font-size:17px;
	color:#888888;
	
}
.ipos_title li a:hover{
	color:#59D78D;
	border-style:none none solid none;
	border-color: #59D78D;
}
.addbut{
		margin-left:60px;
	}
	.addbut a{
		display: inline-block;
		width: 65px;
		height:28px;
	}
</style>

<div class="tb">
<div class="ipos">
	<div class="ipos_title">
		<ul>
			<li><a href="#">全部</a></li>
			<li><a href="#">审核通过</a></li>
			<li><a href="#">待审核</a></li>
		</ul>
	</div>
</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>序号</th>
				<th>图片</th>
				<th>描述</th>
				<th>价格</th>
				<th>查看详情</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${goods }" var="good">
				<tr>
					<td>${good.id }</td>					
					<td>
					<img width="60px" height="60px" alt="" 
					src="${pageContext.request.contextPath }/imgs/${good.gimgurl }">
					<td>${good.gdescribe }</td>
					<td>${good.gprice }</td>
					<td><a href="${pageContext.request.contextPath }/iPostedDetial?id=${good.id}">查看详情</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
<div class="addbut  layui-inline">
<a class=" btn btn-success btn-sm layui-inline" href="${pageContext.request.contextPath }/toAddGoods">
<i class="fa fa-plus-square"></i>&nbsp;&nbsp;发布</a>
</div>
		<div class="paging layui-inline">
			<a href="#">上一页</a>
			<a href="#">下一页</a>		
			跳转至<input type="text" id="skip" value="" style="width:30px;height:20;"
		autocomplete="off" autofocus="autofocus" onkeydown="skip()">页
		</div>
		
<script language="javascript">   
	function skip () {
		var e=window.event||arguments.callee.caller.arguments[0];
		var v = document.getElementById("skip").value;
		if(e.keyCode==13){
			if(v!=""){
				window.location.href = "${pageContext.request.contextPath }/findGoodsByUserid?curPage="+v+"&id="+1
				document.getElementById("search").value=""
			}
		}
	}
</script>
