// 중복확인을 위해 전역변수를 만들어준다.
var isCheckedUsername = false;

// 중복체크 함수
function validate() {
	if (!isCheckedUsername) {
		alert('username 중복체크를 해주세요');
	}
	return isCheckedUsername;
}

// 데이터베이스에 ajax 요청을 해서 중복유저네임이 있는지 확인 -> 있으면 1 리턴, 없으면 0리턴, 오류는 -1을 리턴한다.
function usernameCheck() {
	// 성공
	var tfUsername = $('#username').val();
	// alert(tfUsername);
	console.log(tfUsername);
	$.ajax({
		type : 'get',
		url : `/blog/user?cmd=usernameCheck&username=${tfUsername}`
	}).done(function(result) {
		if (result == 1) {
			alert('아이디가 중복되었습니다.');
		} else if (result == 0) {
			alert('사용하실 수 있는 아이디입니다.');
			isCheckedUsername = true;
		} else {
			console.log('develop : 서버오류');
		}
	}).fail(function() {
		console.log(error);
	});

}
