<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-color: #59D78D;
	margin:0px;
	padding:0px;
}

.top {
	width: 100%;
	height: 210px;
	background-color: #334C58;
	padding: 1px;
	text-align: center;
}

.top .title {
	width: 370px;
	color: #FFFFFF;
	font-size: 24px;
	margin: 120px auto 0px;
}

.top .englishTitle {
	width: 270px;
	color: #B8B8B8;
	font-size: 10px;
	margin: auto;
}

.middle {
	background-color: #FFFFFF;
	width: 430px;
	height: 300px;
	margin: 35px auto 0px;
	padding: 70px;
}
.middle .biaodan .radios{
	width:250px;
	margin:auto;
}
.middle .biaodan .user {
	font-size: 15px ;
	color:#7F7E7E;
}
.middle .biaodan .teacherRadio { 
	margin-left:40px;
}
.middle .biaodan .btn{
	width:100%;
}
</style>

</head>
<body>
	<div class="top">
		<div class="title">基于Java的校园二手资源共享系统</div>
		<div class="englishTitle">Campus Second-hand Resource Sharing System Based on Java</div>
	</div>
	<div class="middle">
		<div class="biaodan">
			<form action="${pageContext.request.contextPath }/login"
				method="post" class="form-horizontal" role="form">
				<div class="form-group has-feedback">
					<div class="input-group">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-user"></span>
						</span> <input type="text" class="form-control"
							name="username" placeholder="UserName" autofocus>
					</div>
				</div>
				<div class="form-group has-feedback">
					<div class="input-group">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-lock"></span>
						</span> <input type="password" class="form-control"
							name="password" placeholder="Password" autofocus>
					</div>
				</div>
				<div class="form-group has-feedback">
					<div class="radios">
					<input type="radio" name="userType" id="customer" value="customer"
						class="userRadio" checked="checked"/> <label class="user" for="customer">customer</label>
					<input type="radio" name="userType" id="manager" value="manager"
						class="userRadio teacherRadio" /> <label class="user" for="manager">manager</label>
					</div>
				</div>
				<div class="form-group has-feedback">
					<input type="button" class="btn btn-success"  onclick="chase()" value="SIGN IN"></button>
				</div>
				<div class="form-group has-feedback">
					<a href="${pageContext.request.contextPath}/customer/register.jsp">没有账号？</a>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	function chase(){
		var name = $('#username').val();
		var password = $('#password').val();
		var juese = $('input:radio[name="userType"]:checked').val(); 
		if(juese=='customer'){
			 $.ajax({    
            type: "post",    
            url: "${pageContext.request.contextPath }/login",    
            data: "name=" + name + "&password=" + password + "&juese=" + juese,    
            dataType: 'html',    
            contentType: "application/x-www-form-urlencoded; charset=utf-8",    
            success: function(result) {    
               location.href="${pageContext.request.contextPath}/notice";    
            }    
        });  
		}else{
		 $.ajax({    
            type: "post",    
            url: "${pageContext.request.contextPath }/login",     
            data:  "name=" + name + "&password=" + password + "&juese=" + juese,
            dataType: 'html',    
            contentType: "application/x-www-form-urlencoded; charset=utf-8",    
            success: function(result) {    
               location.href="${pageContext.request.contextPath}/mFindAllGoods?curPage=1";    
            }    
        });  
		
		}
		
	}
</script>
</html>