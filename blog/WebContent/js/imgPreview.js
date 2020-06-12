var d = "";
$("#img__preview").on("change", function(e){
	var f = e.target.files[0];
	if(!f.type.match("image.*")) {
		alert("이미지만 첨부할 수 있습니다.");
		$("#img__preview").val('');
		return;
	}
	
	// f.size = 1024*1024*2 넘어가면 return 때리기!
	
	var reader = new FileReader();
	reader.onload = function(e) {
		$("#img__wrap").attr("src", e.target.result);
	};
	// 바구니 채워 놓는 시간이 2초
	reader.readAsDataURL(f); // 비동기 실행
});