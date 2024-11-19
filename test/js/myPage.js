
document.addEventListener('DOMContentLoaded', function () {
  const buttons = document.querySelectorAll('.sidebar-menu button');
  const sections = document.querySelectorAll('.content-section');

  buttons.forEach(button => {
    button.addEventListener('click', function () {
      // 모든 버튼에서 active 클래스 제거
      buttons.forEach(btn => btn.classList.remove('active'));

      // 모든 섹션 숨기기
      sections.forEach(section => section.classList.add('hidden'));

      // 현재 클릭한 버튼 활성화
      button.classList.add('active');

      // 관련 섹션 보이기
      const tabId = button.getAttribute('data-tab');
      const activeSection = document.getElementById(tabId);
      if (activeSection) {
        activeSection.classList.remove('hidden');
      }
    });
  });

  // 기본 섹션 로드
  buttons[0].click();


});





  // 샘플 공지사항 데이터
  const notices = [
    {
        id: 1,
        type: 'normal',
        title: '북커뮤니티 서비스 개편 안내',
        author: '회원1',
        date: '2024.03.17',
        views: 1234,
        isImportant: false
    },
    {
        id: 2,
        type: 'normal',
        title: '3월 독서 이벤트 안내',
        author: '회원1',
        date: '2024.03.15',
        views: 856,
        isImportant: false
    },
    {
        id: 3,
        type: 'normal',
        title: '도서 리뷰 작성 가이드라인 안내',
        author: '회원1',
        date: '2024.03.10',
        views: 567,
        isImportant: false
    },
    {
        id: 4,
        type: 'normal',
        title: '새로운 도서 추천 시스템 도입 안내',
        author: '회원1',
        date: '2024.03.05',
        views: 789,
        isImportant: false
    },
    {
        id: 5,
        type: 'normal',
        title: '개인정보 처리방침 개정 안내',
        author: '회원1',
        date: '2024.03.01',
        views: 2345,
        isImportant: false
    }
];


const comments = [
  {
      id: 1,
      type: 'normal',
      title: '북커뮤니티 서비스 개편 안내',
      author: '회원1',
      date: '2024.03.17',
      views: 1234,
      isImportant: false
  },
  {
      id: 2,
      type: 'normal',
      title: '3월 독서 이벤트 안내',
      author: '회원1',
      date: '2024.03.15',
      views: 856,
      isImportant: false
  },
  {
      id: 3,
      type: 'normal',
      title: '도서 리뷰 작성 가이드라인 안내',
      author: '회원1',
      date: '2024.03.10',
      views: 567,
      isImportant: false
  },
  {
      id: 4,
      type: 'normal',
      title: '새로운 도서 추천 시스템 도입 안내',
      author: '회원1',
      date: '2024.03.05',
      views: 789,
      isImportant: false
  },
  {
      id: 5,
      type: 'normal',
      title: '개인정보 처리방침 개정 안내',
      author: '회원1',
      date: '2024.03.01',
      views: 2345,
      isImportant: false
  }
];

// 내가 작성한 댓글 목록 렌더링 함수
// 구분을 번호로 했을 떄
function renderCommentList() {
  const commentList = document.getElementById('commentList');
  commentList.innerHTML = ''; // 기존 내용을 초기화

  comments.forEach((comment, index) => { // 매개변수는 () 안에 정의
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${index + 1}</td> <!-- 순번 열 -->
      <td><a href="#" class="title-link">${comment.title}</a></td> <!-- 제목 -->
      <td>${comment.author}</td> <!-- 작성자 -->
      <td class="date-cell">${comment.date}</td> <!-- 작성일 -->
      <td class="views-cell">${comment.views.toLocaleString()}</td> <!-- 조회수 -->
    `;
    commentList.appendChild(row);
  });
}




// 내가 작성한 게시글 목록 렌더링 함수
// 구분을 중요, 일반으로 했을 때
function renderNoticeList() {
    const noticeList = document.getElementById('noticeList');
    noticeList.innerHTML = '';

    notices.forEach(notice => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>
                <span class="notice-badge ${notice.isImportant ? 'important' : 'normal'}">
                    ${notice.isImportant ? '중요' : '일반'}
                </span>
            </td>
            <td><a href="#" class="title-link">${notice.title}</a></td>
            <td>${notice.author}</td>
            <td class="date-cell">${notice.date}</td>
            <td class="views-cell">${notice.views.toLocaleString()}</td>
        `;
        noticeList.appendChild(row);
    });
}



// 검색 기능
document.querySelector('.search-button').addEventListener('click', () => {
    const searchType = document.querySelector('.search-select').value;
    const searchText = document.querySelector('.search-input').value;
    // 실제 검색 로직 구현 필요
    console.log('Search:', searchType, searchText);
});

// 페이지네이션 버튼 클릭 이벤트
document.querySelectorAll('.page-button').forEach(button => {
    button.addEventListener('click', () => {
        if (!button.classList.contains('active')) {
            document.querySelector('.page-button.active').classList.remove('active');
            button.classList.add('active');
            // 실제 페이지 전환 로직 구현 필요
        }
    });
});

// 초기 게시글 목록 렌더링
renderNoticeList();

// 초기 댓글목록 렌더링
renderCommentList();