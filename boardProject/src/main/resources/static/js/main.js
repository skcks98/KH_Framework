console.log("main.js loaded.");

// 이메일, 비밀번호 미작성 시 로그인  막기
const loginForm = document.querySelector("#loginForm");
const loginEmail = document.querySelector("#loginFrom input[name='memberEmail']"); // 아이디 input 태그
const loginPw = document.querySelector("#loginFrom input[name='memberPw']");  // 비밀번호 input 태그

// #loginForm이 화면에 존재할 때 (== 로그인 상태 아닐 때)
// -> 타입리프에 의해 로그인이 되었다면 #loginFrom 요소는 화면에 노출되지 않음
// -> 로그인 상태일 때 loginFrom 을 이용한 코드가 수행된ㄷ면
// 콘솔창에 error 발생


if(loginForm != null){

  // 제출 이벤트 발생 시
  loginForm.addEventListener("submit", e => {

    // 이메일 미작성
    if(loginEmail.value.trim().length === 0 ){
      alert("이메일을 작성해주세요!");
      e.preventDefault(); // 기본 이벤트(제출) 막기
      loginEmail.focus(); // 초점 이동

      return;
    }

    if(loginPw.value.trim().length === 0 ){
      alert("비밀번호을 작성해주세요!"); 
      e.preventDefault(); // 기본 이벤트(제출) 막기
      loginPw.focus(); // 초점 이동

      return;
    }

  });

}