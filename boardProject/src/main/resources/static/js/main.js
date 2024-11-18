//console.log("main.js loaded.");

// 쿠키에 저장된 이메일 input 창에 뿌려놓기
// 로그인이 안된 경우에 수행

// 쿠키에서 매개변수로 전달받은 key가 일치하는 Value 얻어오기 함수
const getCookie = (key) => {
  
  const cookies = document.cookie;  // "K=V; K=V; ..."

  //console.log(cookies); // saveId=user01@kh.or.kr; testKey=testValue

  // cookies 문자열을 배열 형태로 변환
  const cookieList = cookies.split("; ") // ["K=V", "K=V" ...]
                      .map(el => el.split("=") ); // ["K", "V"]..


  //console.log(cookieList);  // ['saveId', 'user01@kh.or.kr'], ['testKey', 'testValue']
  // 배열.map(함수) : 배열의 각 요소를 이용해 함수 수행 후 
  //                  결과 값으로 새로운 배열을 만들어서 반환

  // 배열 -> 객체로 변환 (그래야 다루기 쉽다.)

  const obj = {};

  for(let i=0; i<cookieList.length; i++){
    const k = cookieList[i][0]; // key 값
    const v = cookieList[i][1]; // value 값
    obj[k]= v; // 객체에 추가
    //obj["saveId"] = "user01@kh.or.kr"
    //obj["saveId"] = "testValue"
    
  }
  // console.log(obj)

  return obj[key];  // 매개변수로 전달받은 key와
                    // obj 객체에 저장된 key가 일치하는 요소의 value값 반환
}       

getCookie();


// 이메일 작성 input 태그 요소
const loginEmail = document.querySelector("#loginForm input[name='memberEmail']"); // 아이디 input 태그

if(loginEmail != null) {  // 로그인창의 이메일 input 태그가 화면에 존재할 때


} else {  // 로그인창의 이메일 input 태그가 존재할 때

  // 쿠기 중 key 값이 "saveId"인 요소의 value 얻어오기
  const saveId = getCookie("saveId"); // 이메일 또는 undefined

  // saveId 값이 있을 경우
  if(saveId != undefined){
    loginEmail.value = saveId; // 쿠키에서 얻어온 이메일 값을 input 요소의 value에 세팅

    // 아이디 저장 체크박스에 체크해두기
    document.querySelector("input[name='saveId']").checked = true;

  }


}





// 이메일, 비밀번호 미작성 시 로그인  막기
const loginForm = document.querySelector("#loginForm");

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


// 회원 목록 조회 (비동기)

const selectMemberListBtn = document.querySelector("#selectMemberList");
selectMemberListBtn.addEventListener("click", () => {


fetch("/member/list")
.then(resp => resp.json())
.then(memberList => {
  console.log(memberList); 

// 테이블의 tbody 요소 선택
  const memberListBody = document.querySelector("#memberList");

  memberListBody.innerHTML = "";

  memberList.forEach(member => {
    const row = document.createElement("tr"); // 새 행 생성

  // 회원 번호 셀 생성
  const memberNo = document.createElement("td");
  memberNo.textContent = member.memberNo; // 회원 번호 삽입
  row.appendChild(memberNo);

  // 이메일 셀 생성
  const email = document.createElement("td");
  email.textContent = member.memberEmail; // 이메일 삽입
  row.appendChild(email);

  // 닉네임 셀 생성
  const nickname = document.createElement("td");
  nickname.textContent = member.memberNickname; // 닉네임 삽입
  row.appendChild(nickname);

  // 탈퇴 여부 셀 생성
  const delFl = document.createElement("td");
  delFl.textContent = member.memberDelFl === 'Y' ? 'Y' : 'N '; // 탈퇴 여부 확인
  row.appendChild(delFl);

  // 생성한 행을 tbody에 추가
  memberListBody.appendChild(row);
  });


  })
  .catch(error => {
    console.error("Error:", error); // 오류 처리
  });
});



// 특정 회원 비밀번호 초기화(Ajax)

const resetPwBtn = document.querySelector("#resetPw");



resetPwBtn.addEventListener("click", e => {
  fetch("/member/resetPassword")
  .then(resp => resp.json())
  .then(memberNo => {
    console.log(memberNo); 




  });
});



// 특정 회원 탈퇴 복구(Ajax)

const restoration = document.querySelector("#restorationBtn");

restoration.addEventListener("click", e => {
  fetch("/member/restoration")
  .then(resp => resp.json())
  .then(memberDelFl => {
    console.log(memberDelFl); 




  });
});