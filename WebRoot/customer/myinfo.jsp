<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
table {
	margin: 70px;
}

.detialtable {
	width: 1000px;
}

.detialImg {
	width: 150px;
	height: 150px;
}
.updatebut{
	margin:130px 0px 0px 950px;
}
</style>
<div class="detialtable">
	<table class="table">
		<caption>用户详细信息</caption>
		<tbody>
			<tr>
				<td>头像</td>
				<td><img class="detialImg" alt="用户头像"
					src="${pageContext.request.contextPath }/imgs/${customer.cimgurl }"></td>
			</tr>
		</tbody>
		<tbody>
			<tr>
				<td>姓名</td>
				<td>${customer.cname }</td>
			</tr>
		</tbody>
		<tbody>
			<tr>
				<td>密码</td>
				<td>${customer.cpassword }</td>
			</tr>
		</tbody>
		<tbody>
			<tr>
				<td>电话</td>
				<td>${customer.cphone }</td>
			</tr>
		</tbody>
	</table>
</div>
<a class="updatebut btn btn-success btn-sm" href="javascript:void(0)"
	onclick="editInfo()"> <i class="fa fa-pencil-square-o"></i>&nbsp;&nbsp;修改
</a>
<!--修改模态窗口 -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" style="width:400px" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">用户信息编辑</h4>
			</div>
			<div class="modal-body modal-li">
				<form enctype="multipart/form-data">
					<ul>
						<li><label for="name">头像&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="file" class="form-control" id="fileinput">
						<li><label for="name">姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control text-input" id="cname"
							placeholder="请输入序号"></li>
						<li><label for="name">密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control text-input" id="cpassword"
							placeholder="请输入序号"></li>
						<li><label for="name">电话&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control text-input" id="cphone"
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
		$('#cname').val("${customer.cname }");
		$('#cpassword').val("${customer.cpassword }");
		$('#cphone').val("${customer.cphone }");

		$('#modal').modal('show');
	}
	 //提交更改    
    function update() {    
        //获取模态框数据    
       var cimgurl = $('#fileinput').val();
        var cname = $('#cname').val();    
        var cpassword = $('#cpassword').val();    
        var cphone = $('#cphone').val();    
        var cimgurl = $('#cimgurl').val();    
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