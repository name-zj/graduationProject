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
	.detialbut{
		margin-left:960px;
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
<a class="detialbut btn btn-success btn-sm" href="#">
  <i class="fa fa-cart-plus"></i>&nbsp;&nbsp;加入购物车</a>