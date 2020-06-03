<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %>

<div class="container" >
	<form action="/blog/user?cmd=joinProc" method="POST" class="was-validated" onSubmit="return validate()">
	  <div class="form-group">
	    <label for="username">Username:</label>
	    <button type="button" class="btn btn-primary float-right" onclick="usernameCheck()">중복확인</button>
	    <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
	  <div class="form-group">
	    <label for="password">Password:</label>
	    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
	    <div class="form-group">
		    <label for="email">Email:</label>
		    <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" required>
		    <div class="valid-feedback">Valid.</div>
		    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
  	    <div class="form-group">
		    <label for="address">Address:</label>
		    <button type="button" class="btn btn-primary float-right" onclick="goPopup()">주소 검색</button>
		    <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address" required readonly>
		    <div class="valid-feedback">Valid.</div>
		    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">회원가입완료</button>
	</form>
</div>

<script>

function goPopup(){
	var pop = window.open("/blog/juso/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadFullAddr){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		var tfAddress = document.querySelector("#address");
		tfAddress.value = roadFullAddr;
//		document.form.roadFullAddr.value = roadFullAddr;
}

</script>

<script>
	// 중복확인을 위해 전역변수를 만들어준다.
	var isCheckedUsername = false;
	
	function validate() {
		if(!isCheckedUsername) {
			alert('username 중복체크를 해주세요');
		}
		return isCheckedUsername;
	}

	function usernameCheck() {
		// 성공
		var tfUsername = $('#username').val();
//		alert(tfUsername);
		console.log(tfUsername);
		$.ajax({
			type: 'get',
			url: '/blog/user?cmd=usernameCheck&username='+tfUsername
		}).done(function(result){
			if(result == 1) {
				alert('아이디가 중복되었습니다.');
			}else if(result == 0){
				alert('사용하실 수 있는 아이디입니다.');
				isCheckedUsername = true;
			} else {
				console.log('develop : 서버오류');
			}
		}).fail(function(){
			console.log(error);
		});
		
	}
</script>

<%@ include file="../include/footer.jsp" %>