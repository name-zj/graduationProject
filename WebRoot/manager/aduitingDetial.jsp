<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	table{
		margin:70px;
		
	}
	.detialtable{
		width:1000px;
	}
	.detialImg{
		
		width:150px;
		height:150px;
	}
	.detial a{
		width:70px;
		margin-left:960px;
		margin-top:10px;
	}

</style>
<div class="detialtable">
<table class="table">
	<caption>商品详细信息</caption>
	<tbody>
		<tr>	
			<td >图片</td>
			<td><img  class="detialImg"alt="商品头像" 
			src="${pageContext.request.contextPath }/imgs/${goods.gimgurl }"></td>
		</tr>
	</tbody>
	<tbody>
		<tr>
			<td>名称</td>
			<td>${goods.gname }</td>
		</tr>
	</tbody>
	<tbody>
		<tr>
			<td>描述</td>
			<td>${goods.gdescribe }</td>
		</tr>
	</tbody>
	<tbody>
		<tr>
			<td>数量</td>
			<td>${goods.gnum }</td>
		</tr>
	</tbody>
	<tbody>
		<tr>
			<td>价格</td>
			<td>${goods.gprice }</td>
		</tr>
	</tbody>
	<tbody>
		<tr>
			<td>所有人</td>
			<td>${goods.gowner }</td>
		</tr>
	</tbody>
</table>
</div>
<div class="detial">
<a class="detialbut btn btn-success btn-sm" href="${pageContext.request.contextPath }/postedGoods?id=${goods.id }">
  <i class="fa fa-check-square"></i>&nbsp;&nbsp;通过</a>
<a class="detialbut btn btn-danger btn-sm" href="${pageContext.request.contextPath }/findToBeAuditedGoods?curPage=1">
  <i class="fa fa-window-close"></i>&nbsp;&nbsp;不通过</a>
 </div>