# 미디엄 클론 코딩

## 프로젝트 개요

---

미디엄 클론 코딩 미션(https://www.scode.gg/p/13201) 수행

[Github 저장소](https://github.com/AidennnLee/Medium_Misson__LeeYeWon.git)

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

- @GetMapping("/member/join")
- @PostMapping("/member/join")
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

#### Controller

#### Service

#### Repository

#### Security

#### Form
