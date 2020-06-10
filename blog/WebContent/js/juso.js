var isCheckedUsername = false;

// juso.go.kr 라이브러리 함수(시작) ------------------
function goPopup() {
	window.open("/blog/juso/jusoPopup.jsp", "pop",
			"width=570,height=420, scrollbars=yes, resizable=yes");
}

function jusoCallBack(roadFullAddr) {
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	var tfAddress = document.querySelector("#address");
	tfAddress.value = roadFullAddr;
	// document.form.roadFullAddr.value = roadFullAddr;
}

// juso.go.kr 라이브러리 함수 (끝) --------------------