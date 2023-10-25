/**
 * myscript.js
 */

function bbsCheck() { //게시판 유효성 검사

	//1)작성자 2글자 이상 입력
	let wname = document.getElementById("wname").value; //작성자 가져오기
	wname = wname.trim();
	if (wname.length < 2) {
		alert();
		document.getElementById("wname").focus(); //작성자칸에 커서 생성
		return false; //전송하지 않음
	}//if end

	//2)제목 2글자 이상 입력
	let subject = document.getElementById("subject").value;
	subject = subject.trim();
	if (subject.length < 2) {
		alert("제목 2글자 이상 입력해 주세요");
		document.getElementById("subject").focus();
		return false;
	}//if end 

	//3)내용 2글자 이상 입력
	let content = document.getElementById("content").value;
	content = content.trim();
	if (content.length < 2) {
		alert("내용 2글자 이상 입력해 주세요");
		document.getElementById("content").focus();
		return false;
	}//if end    

	//4)비밀번호는 4글자이상이면서, 숫자형 기호만 입력
	let passwd = document.getElementById("passwd").value;
	passwd = passwd.trim();
	if (passwd.length < 4 || isNaN(passwd)) {
		alert("비밀번호 4글자 이상 숫자로 입력해 주세요");
		document.getElementById("passwd").focus();
		return false;
	}//if end

	return true; //onsubmit이벤트에서 서버로 전송

}//bbsCheck() end


function pwCheck() {
	let passwd = document.getElementById("passwd").value;
	passwd = passwd.trim();
	if (passwd.length < 4 || isNaN(passwd)) {
		alert("비밀번호 4글자 이상 숫자로 입력해 주세요");
		document.getElementById("passwd").focus();
		return false;
	}//if end

	let message = "진행된 내용은 복구되지 않습니다\n계속 진행할까요?";
	if (confirm(message)) { //확인 true, 취소 false
		return true;
	} else {
		return false;
	}//if end
}//pwCheck()

function key(a) {
	a.value = a.value.replace(/[^0-9]/g, '');
	return true;
}


function searchCheck() {
	let word = document.getElementById("word").value;
	word = word.trim();
	if (word.length == 0) {
		alert("검색어를 입력해주세요!");
		return false;
	}//if end
	return true;
}//searchCheck() end




function idCheck() {
	//모달창
	//부모창과 자식창이 한몸으로 구성되어있음

	//새창만들기
	//부모창과 자식창이 별개로 구성되어있음
	//모바일에 기반을둔 frontend단(SPA)에서는 사용하지 말것
	window.open("idCheckForm.jsp", "idwin", "width=400, height=350");

	/*$("#idCheck").show();*/
}//idCheck() end


function passwdCheck() {
	//2)비밀번호 5~10글자 인지?
	let passwd = document.getElementById("passwd").value;
	passwd = passwd.trim();
	if (!(passwd.length >= 5 && passwd.length <= 10)) {
		alert("비밀번호 5~10글자 사이 입력해 주세요");
		document.getElementById("passwd").focus();
		return false;
	} //if end


	//3)비밀번호와 비밀번호확인이 서로 일치하는지?
	let repasswd = document.getElementById("repasswd").value;
	repasswd = repasswd.trim();
	if (passwd == repasswd) {
		alert("비밀번호 중복확인 완료!")
	} else {
		alert("비밀번호와 비밀번호 확인이 틀립니다")
		return false;
	}//if end
}//passwdCheck() end



//////////id글자수 확인//////////
function blankCheck() {
	let id = document.getElementById("id").value;
	id = id.trim();
	if (id.length < 5) {
		alert("아이디는 5~10글자 이내로 입력해 주세요");
		return false;
	}//if end
	return true;
}//blankCheck() end

/*$("#idCheck a").click(function(){
	$(this).css({"display":"none"});
})
*/


function EmailCheck() {
	window.open("emailCheckForm.jsp", "idwin", "width=400, height=350");
}
function blankCheck() {
	let Email = document.getElementById("email").value;
	Email = Email.trim();
	if (Email.length < 5) {
		alert("이메일은 5~25글자 이내로 입력해 주세요");
		return false;
	}//if end
	return true;
}//blankCheck() end




//회원가입 유효성 검사
function memberCheck() {

	//1)아이디 5~10글자 인지?
	let id = document.getElementById("id").value; //작성자 가져오기
	id = id.trim();
	if (!(id.length >= 5 && id.length <= 10)) {
		alert("id 5~10글자 사이 입력해 주세요");
		document.getElementById("id").focus(); //작성자칸에 커서 생성
		return false; //전송하지 않음
	}//if end

	/*  //2)비밀번호 5~10글자 인지?
	  let passwd = document.getElementById("passwd").value;
	  passwd = passwd.trim();
	  if (!(passwd.length >= 5 && passwd.length <= 10)){
		  alert("비밀번호 5~10글자 사이 입력해 주세요");
		  document.getElementById("passwd").focus();
		  return false;
	  }//if end */

	/*//3)비밀번호와 비밀번호확인이 서로 일치하는지?
	let repasswd = document.getElementById("repasswd").value;
	repasswd = repasswd.trim();
	if (passwd == repasswd) {
		alert("비밀번호 중복확인 완료!")
	} else {
		alert("비밀번호와 비밀번호 확인이 틀립니다")
		return false;
	}*/

	//4)이름 두글자 이상 인지?
	let mname = document.getElementById("mname").value;
	mname = mname.trim();
	if (mname.length < 2) {
		alert("이름2글자 이상 입력해주세요!");
		document.getElementById("mname").focus();
		return false;
	}//if end 

	//5)이메일 5글자 인지?
	let email = document.getElementById("email").value;
	email = email.trim();
	if (email.length < 5) {
		alert("이메일2글자 이상 입력해주세요!");
		document.getElementById("email").focus();
		return false;
	}//if end 


	//6)직업을 선택했는지?
	let job = document.getElementById("job").value;
	if (job == "0") {
		alert("직업을 선택해 주세요");
		return false;
	}//if end

}//memberCheck() end


function findIDCheck() {
	let mname = document.getElementById("mname").value;
	mname = mname.trim();
	if (mname.length < 1) {
		alert("이름 2글자 이상 입력해주세요!");
		document.getElementById("mname").focus();
		return false;
	}//end

	let email = document.getElementById("email").value;
	email = email.trim();
	if (email.length < 5) {
		alert("이메일5글자 이상 입력해주세요!");
		document.getElementById("email").focus();
		return false;
	}//end

}//findIDCheck() end











