<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
	.notice{
		margin:200px 0 0 500px;
	}
	.detial a{
		width:70px;
		margin-left:960px;
		margin-top:250px;
	}
</style>	


<div class="notice">
	<h3>${notice.notice }</h3>
</div>
<div class="detial">
<a class="detialbut btn btn-success btn-sm"  href="javascript:void(0)"
	onclick="editInfo()">
  <i class="fa fa-pencil-square-o"></i>&nbsp;&nbsp;修改</a>

 </div>
 <!--修改模态窗口 -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" style="width:400px" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">通知信息编辑</h4>
			</div>
			<div class="modal-body modal-li">
				<form enctype="multipart/form-data">
					<ul>
						
						<li><label for="name">通知&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<input type="text" class="form-control text-input" id="notice"
							placeholder="请输入通知"></li>
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
		$('#notice').val("${notice.notice }");

		$('#modal').modal('show');
	}
	 //提交更改    
    function update() {    
        //获取模态框数据    
       var gimgurl = $('#notice').val();
        $.ajax({    
            type: "post",    
            url: "${pageContext.request.contextPath}/updateUserInfo",    
            data: "notice=" + notice,    
            dataType: 'html',    
            contentType: "application/x-www-form-urlencoded; charset=utf-8",    
            success: function(result) {    
               location.href="${pageContext.request.contextPath}/findCustomerByid?id=1";    
            }    
        });   
        $('#modal').modal('hide');    
    }    
</script>