<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
.tb {
	padding: 40px 100px 10px;
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
	height:570px;
}
.paging{
	margin-left:890px;
}

</style>
<div class="tb">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>序号</th>
				<th>图片</th>
				<th>描述</th>
				<th>价格</th>
				<th>操作</th>
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
					<td>
						<a href="${pageContext.request.contextPath }/mFindGoodsById?id=${good.id }">详情</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
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
				window.location.href = "${pageContext.request.contextPath }/mFindAllGoods?curPage="+v
				
			}
		}
	}
</script>


