/**
 * myscript.js
 */

function bbsCheck() {//게시판 유효성 검사

	let wname = document.getElementById("wname").value;
	let subject = document.getElementById("subject").value;
	let content = document.getElementById("content").value;
	let passwd = document.getElementById("passwd").value;

	//1)작성자 2글자 이상 입력
	if (wname.length < 2) {
		alert("2글자 이상 입력해주세요!!")
		return false;
	}//if end

	//2)제목 2글자 이상 입력
	if (subject.length < 2) {
		alert("2글자 이상 입력해주세요!!")
		return false;
	}//if end

	//3)내용 2글자 이상 입력
	if (content.length < 2) {
		alert("2글자 이상 입력해주세요!!")
		return false;
	}//if end

	//4)비밀번호는 4글자이상이면서, 숫자형 기호만 입력
	if (passwd.length < 4) {
		alert("4글자 이상 입력해주세요!!")
		return false;
	}//if endn

	return true;
}//bbsCheck end

function key(a) {
	a.value = a.value.replace(/[^0-9]/g, '');

	return true;
}