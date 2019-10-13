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
<a class="detialbut btn btn-success btn-sm"  href="javascript:void(0)"
	onclick="editInfo()">
  <i class="fa fa-pencil-square-o"></i>&nbsp;&nbsp;修改</a>
<a class="detialbut btn btn-danger btn-sm" href="${pageContext.request.contextPath }/findToBeAuditedGoods?curPage=1">
  <i class="fa fa-anchor"></i>&nbsp;&nbsp;下架</a>
 </div>
 
<!--修改模态窗口 -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" style="width:400px" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">物品信息编辑</h4>
			</div>
			<div class="modal-body modal-li">
				<form enctype="multipart/form-data">
					<ul>
						<li><label for="name">图片&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="file" class="form-control" id="fileinput">
						<li><label for="name">名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control text-input" id="gname"
							placeholder="请输入序号"></li>
						<li><label for="name">描述&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control text-input" id="gdescribe"
							placeholder="请输入序号"></li>
						<li><label for="name">数量&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control text-input" id="gnum"
							placeholder="请输入序号"></li>
						<li><label for="name">价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control text-input" id="gprice"
							placeholder="请输入序号"></li>
							<li><label for="name">所有人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control text-input" id="gowner"
							placeholder="请输入序号"></li>
					</ul>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="update()">保存</button>
			</div>
		</div>
	</div>
</div>
<!--end-修改模态窗口 -->
<script type="text/javascript">

	//获取td内容
	function editInfo() {
		$('#gname').val("${goods.gname }");
		$('#gdescribe').val("${goods.gdescribe }");
		$('#gnum').val("${goods.gnum }");
		$('#gprice').val("${goods.gprice }");
		$('#gowner').val("${goods.gowner }");

		$('#modal').modal('show');
	}
	 //提交更改    
    function update() {    
        //获取模态框数据    
       var gimgurl = $('#fileinput').val();
        var gname = $('#gname').val();    
        var gdescribe = $('#gdescribe').val();    
        var gprice = $('#gprice').val();    
        var gnum = $('#gnum').val();    
        var gowner = $('#gowner').val();    
        $.ajax({    
            type: "post",    
            url: "${pageContext.request.contextPath}/updateUserInfo",    
            data: "cname=" + cname + "&cpassword=" + cpassword + "&cphone=" + cphone + "&cimgurl=" + cimgurl+ "&id=1",    
            dataType: 'html',    
            contentType: "application/x-www-form-urlencoded; charset=utf-8",    
            success: function(result) {    
               location.href="${pageContext.request.contextPath}/findCustomerByid?id=1";    
            }    
        });   
        $('#modal').modal('hide');    
    }    
</script>