# 미디엄 클론 코딩

## 프로젝트 개요

---

미디엄 클론 코딩 미션(https://www.scode.gg/p/13201) 수행

[Github 저장소](https://github.com/AidennnLee/Medium_Misson__LeeYeWon.git)

## 구현 상황

---

### 회원

가입
- GET /member/join : 가입 폼
- POST /member/join : 가입 폼 처리

로그인
- GET /member/login : 로그인 폼
- POST /member/login : 로그인 폼 처리

로그아웃
- POST /member/logout : 로그아웃

폼
- 회원가입 폼
  - username
  - password
  - passwordConfirm

- 로그인 폼
  - username
  - password

### 글 CRUD

홈
- GET / : 홈 (최신글 30개 노출)

글 목록 조회
- GET /post/list : 전체 글 리스트

글 상세내용 조회
GET /post/1 : 1번 글 상세보기

글 작성
- GET /post/write : 글 작성 폼
- POST /post/write : 글 작성 처리

글 수정
- GET /post/1/modify : 1번 글 수정 폼
- PUT /post/1/modify : 1번 글 수정 폼 처리

글 삭제
- DELETE /post/1/delete : 1번 글 삭제

폼
- 글 쓰기 폼
  - title
  - body

- 글 수정 폼
  - title
  - body

## 구조

---

### home

---

#### Controller

HomeController
- @GetMapping("/")

### member

---

#### Entity

Member

| 속성명         | 설명      |
|-------------|---------|
| id          | 회원 번호   |
| username    | 회원명     |
| password    | 비밀번호    |

#### Controller

MemberController

- 회원가입
  - @GetMapping("/member/join")
  - @PostMapping("/member/join")
- 로그인
  - @GetMapping("/member/login")

#### Service

MemberService

#### Repository

MemberRepository

#### Form

JoinForm

#### Security

MemberSecurityService

MemberRole

### article

---

#### Entity

Article

| 속성명   | 설명   |
|-------|------|
| id    | 글 번호 |
| title | 글 제목 |
| body  | 글 본문 |
|createDate|작성일|
|writer|작성자|

#### Controller

ArticleController

- 전체 글 목록
  - @GetMapping("/post/list")
- 글 상세 페이지
  - @GetMapping("/post/{id}")
- 글 작성
  - @GetMapping("/post/write")
  - @PostMapping("/post/write")
- 글 수정
  - @GetMapping("/post/{id}/modify")
  - @PostMapping("/post/{id}/modify")
- 글 삭제
  - @GetMapping("/post/{id}/delete")

#### Service

ArticleService

#### Repository

ArticleRepository

#### Form

ArticleForm