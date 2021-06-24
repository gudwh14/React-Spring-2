# 1. 프로젝트 선정

`React` `SpringBoot` 를 학습하기 위해 진행된 개인 프로젝트입니다.

`React`  `SpringBoot` 를 사용한 두번째 프로젝트입니다.

앞서 진행했던 첫번째 프로젝트보다 원할하고 체계적으로 진행하고자 하여 기획단계부터 시작합니다.

**페이지 기획 , 데이터베이스 기획 , REST-API 기획**

## 아이템 선정

- GYM(필라테스, 요가 , 헬스장) 운동 예약 시스템 서비스를 만들어주는 프로젝트입니다.
- GYM 시설에서 예약시스템을 따로 만들지 않고 해당 서비스를 통해 자신의 시설 **예약시스템**을 만들 수 있습니다.

## 기술 스택
<div>
  <img  src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white"</img>
  <img  src="https://img.shields.io/badge/Spring Data JPA-6DB33F?style=flat-square&logo=Spring&logoColor=white"</img>
  <img  src="https://img.shields.io/badge/React-61DAFB?style=flat-square&logo=React&logoColor=white"</img>
  <img  src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=white"</img>
  <img  src="https://img.shields.io/badge/HTML-E34F26?style=flat-square&logo=HTML5&logoColor=white"</img>
  <img  src="https://img.shields.io/badge/CSS-1572B6?style=flat-square&logo=CSS3&logoColor=white"</img>
  <img  src="https://img.shields.io/badge/H2 Database-4479A1?style=flat-square&logo=Java&logoColor=white"</img>
</div>

# 2. 기능 정의

### 회원 가입

- 일반 사용자
    - 회원정보를 입력받아 회원가입을 진행 한다.

        회원 정보 
        
        #필수 `이름, 연락처`
        
        #선택 `시설 선택`

- 시설 관리자
    - 시설정보를 입력받아 회원가입을 진행한다.

        시설 정보 

        #필수 `시설이름, 시설 종류(헬스장, 필라테스, 요가), 시설 위치, 연락처`

        #선택 `수강권 생성`

    - 회원가입에 성공하면 시설 관리 ID 를 지급합니다.

### 로그인

- 일반 사용자 : `사용자 이름, 연락처` 를 이용해 로그인
- 시설 관리자 : `지급된 ID, 연락처` 를 이용해 로그인

### 시설 관리자 기능

1. 시설 일정 관리
    - 캘린더를 이용해서 운동 일정을 (추가 , 삭제 , 수정) 할 수 있습니다.
    - 운동 일정은 `날짜, 시간, 강사 선생님, 신청 가능여부` 를 보여줍니다.
2. 수강권 생성
    - 해당 시설에서 이용할 수 있는 수강권을 생성 합니다.
    - 수강권 생성 정보

        #필수 `유효기간, 수강 가능한 횟수, 수강권 정보(수강권 이름, 수강취소가능 횟수)`
        
        #선택 `안내사항`

3. 회원 관리
    - 회원(일반 사용자)의 시설 가입을 (수락, 거절) 할 수 있습니다.
    - 회원에게 수강권을 지급 할 수 있습니다.
    - 시설에 등록 되어있는 회원들의 정보를 확인 합니다.
    - 회원 정보

        `이름 , 연락처, 시설 최초 등록 날짜, 수강권 여부, 수강권 정보`

4. 공지사항 작성
    - 공지사항 , 이벤트 게시글을 작성 할 수 있습니다.

        `글 제목, 글 내용 , 작성시간`

### 일반 사용자 기능

1. 시설 가입하기
    - 일반 사용자는 `시설명` 검색을 통해 해당 시설을 찾아 가입 할 수 있습니다.
2. 시설 정보 확인
    - 시설 정보 , 해당 시설이 보유한 수강권 정보를 확인 할 수 있습니다.
3. 수강 신청
    - 사용자가 가지고있는 수강권을 사용하여 시설 일정에 따라 수강을 신청 할 수 있습니다.
4. 수강 취소
    - 신청한 수강을 취소 할 수 있습니다.
5. 수강 예약 내역 확인
    - 신청한 수강내역들을 확인 할 수 있습니다.

## 3. 페이지 설계

`whimsical` 를 이용하여 페이지 설계를 진행하였습니다.

[페이지설계](https://whimsical.com/react-spring-McBWux7svnoEAozrD7Czof@3CRerdhrAw7tBuRsJbWrUpVZ)

<img width="909" alt="스크린샷 2021-06-21 오후 3 47 45" src="https://user-images.githubusercontent.com/37062292/122721629-dafa2800-d2ab-11eb-9840-26a70d009497.png">

## 4. 데이터베이스 설계
<img width="1362" alt="스크린샷 2021-06-21 오후 3 51 30" src="https://user-images.githubusercontent.com/37062292/122721844-109f1100-d2ac-11eb-8e5d-47c250ee5b0f.png">


## 5. REST API 설계

### 시설 관리자 (Manager)

### `POST`  /manager

- 새로운 관리자 생성

`Parameter`

```json
{
	"gym_name" : "String",
	"gym_type" : "String",
	"location" : "String",
	"Phone" : "String"
}
```

`Response`

```json
HTTP/1.1 201 Created
{
  "id" : "1",
	"gym_name" : "String",
	"gym_type" : "String",
	"location" : "String",
	"Phone" : "String"
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}
```

### `GET`  /manager/findByGymName/{keyword}

- keyword 로 시설 찾기

`Parameter`

```json
{
	"keyword" : "String"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
  "gym_list" : [
		{
			"id" : "0",
			"gym_name" : "String"
		}
	]
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

## 공지사항 관리

### `POST`  /notice

- 새로운  공지사항 글 작성

`Parameter`

```json
{
	"manager_id" : "id",
	"title" : "String",
	"context" : "String",
	"write_at" : "date"
}
```

`Response`

```json
HTTP/1.1 201 Created
{
  "id" : "1",
	"manager_id" : "id",
	"title" : "String",
	"context" : "String",
	"write_at" : "date"
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}
```

### `GET`  /notice/{manger_id}

- 해당 시설에 작성된 공지사항 조회

`Parameter`

```json
{
	"manger_id" : "id"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
  "notice" : [
		{
			"id" : "id",
			"title" : "String",
			"write_at" : "date"
		}
	]
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `GET`  /notice/{notice_id}

- 해당 ID 공지사항 게시글 조회

`Parameter`

```json
{
	"notice_id" : "id"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
  "id" : "1",
	"manager_id" : "id",
	"title" : "String",
	"context" : "String",
	"write_at" : "date"
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `DELETE`  /notice/{notice_id}

- 해당 ID 공지사항 게시글 삭제

`Parameter`

```json
{
	"notice_id" : "id"
}
```

`Response`

```json
HTTP/1.1 204 No Content

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

## 관리자 수강권 관리

### `POST`  /ticket

- 새로운 수강권 생성

`Parameter`

```json
{
	"manager_id" : "id",
	"type" : "String",
	"total_times" : 0,
	"cancel_times" : 0,
	"valid" : 0,
	"notice" : "String"
}
```

`Response`

```json
HTTP/1.1 202 Created
{
	"id" : 0,
	"manager_id" : "id",
	"type" : "String",
	"total_times" : 0,
	"cancel_times" : 0,
	"valid" : 0,
	"notice" : "String"
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}
```

### `GET`  /ticket/{manager_id}

- 시설이 보유한 수강권 반환

`Parameter`

```json
{
	"manager_id" : "id"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
	"ticket" : [
		{
			"id" : 0,
			"type" : "String",
			"total_times" : 0
		}
	]
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `GET`  /ticket/{ticket_id}

- 해당 ID 수강권 반환

`Parameter`

```json
{
	"ticket_id" : "id"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
	"id" : 0,
	"manager_id" : "id",
	"type" : "String",
	"total_times" : 0,
	"cancel_times" : 0,
	"valid" : 0,
	"notice" : "String"
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `DELETE`  /ticket/{ticket_id}

- 해당 ID 수강권 삭제

`Parameter`

```json
{
	"ticket_id" : "id"
}
```

`Response`

```json
HTTP/1.1 204 No Content

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

## 시설 스케줄 관리

### `POST`  /schedule

- 새로운 시설 일정 생성

`Parameter`

```json
{
	"manager_id" : "id",
	"period" : "String",
	"day " : "String",
	"time " : "String",
	"teacher" : "String",
	"total_people" : 0
}
```

`Response`

```json
HTTP/1.1 201 Created
{
	"id" : 0,
	"manager_id" : "id",
	"period" : "String",
	"day " : "String",
	"time " : "String",
	"teacher" : "String",
	"total_people" : 0
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `GET`  /schedule/{manager_id}

- 시설의 일정 조회

`Parameter`

```json
{
	"manager_id" : "id"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
	"id" : 0,
	"manager_id" : "id",
	"period" : "String",
	"day " : "String",
	"time " : "String",
	"teacher" : "String",
	"total_people" : 0
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `DELETE`  /schedule/{manager_id}

- 시설의 일정 삭제

`Parameter`

```json
{
	"manager_id" : "id"
}
```

`Response`

```json
HTTP/1.1 204 No Content

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### 일반 사용자 (USER)

### `POST`  /user

- 새로운 유저 등록

`Parameter`

```json
{
	"name" : "String",
	"phone" : 0
}
```

`Response`

```json
HTTP/1.1 201 Created
{
	"id" : 0,
	"name" : "String",
	"phone" : 0
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}
```

## 유저 수강권 관리

### `POST`  /userTicket

- 유저의 새로운 수강권 등록

`Parameter`

```json
{
	"user_id" : "id",
	"ticket_id" : "id"
}
```

`Response`

```json
HTTP/1.1 201 Created
{
	"id" : 0,
	"user_id" : "id",
	"ticket_id" : "id"
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}
```

### `GET`  /userTicket/{user_id}/{manager_id}

- 해당시설의 유저의 수강권 조회

`Parameter`

```json
{
	"user_id" : "id",
	"manager_id" : "id"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
	"user_ticket" : [
		{
			"userTicket_id" : "id",
			"ticket_id" : "id",
			"type" : "String",
			"total_times" : 0
		}
	] 
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `GET`  /userTicket/{userTicket_id}

- 유저가 보유한 수강권 자세한 정보 조회

`Parameter`

```json
{
	"userTicket_id" : "id"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
	"type" : "String",
	"total_times" : 0,
	"cancel_times" : 0,
	"valid" : 0,
	"notice" : "String",
	"apply_times" : 0,
	"user_cancel_times" : 0,
	"apply_at" : "date"
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `GET`  /userTicket/{user_id}

- 유저가 보유한 수강권 리스트 조회

`Parameter`

```json
{
	"userTicket_id" : "id"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
	"ticket_list" : [
		{
			"manager_id" : "id",
			"gym_name" : "String",
			"type" : "String",
			"total_times" : 0,
			"cancel_times" : 0,
			"valid" : 0,
			"notice" : "String",
			"apply_times" : 0,
			"user_cancel_times" : 0,
			"apply_at" : "date"
			}
	]
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

## 유저 스케줄(수강신청) 관리

### `POST`  /userClass

- 유저가 새로운 수강 예약하기

`Parameter`

```json
{
	"user_id" : "id",
	"schedule_id" : "id",
	"calss_at" : "datetime" 
}
```

`Response`

```json
HTTP/1.1 201 Created
{
	"id" : 0,
	"user_id" : "id"
	"schedule_id" : "id",
	"calss_at" : "datetime" 
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}
```

### `GET`  /userClass/{user_id}

- 유저가 예약한 수강신청 조회

`Parameter`

```json
{
	"user_id" : "id",
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
	"user_schedule" : [
		{
			"gym_name" : "String",
			"time" : "String",
			"teacher" : "String",
			"calss_at" : "date"
		}
	]
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `GET`  /userClass/{schedule_id}/{class_at}

- 해당 시설의 일정에 대한 유저 일정 조회

`Parameter`

```json
{
	"schedule_id" : "id",
	"calss_at" : "date"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
	"total_schedule" : 0
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `DELETE`  /userClass/{userClass_id}

- 유저가 예약한 수강신청 취소

`Parameter`

```json
{
	"userClass_id" : "id"
}
```

`Response`

```json
HTTP/1.1 204 No Content

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

## 유저 관리

### `POST`  /Membership

- 유저가 새로운 시설 등록

`Parameter`

```json
{
	"user_id" : "id",
	"manager_id" : "id",
	"init_at" : "date"
}
```

`Response`

```json
HTTP/1.1 201 Created
{
	"id" : 0,
	"user_id" : "id",
	"manager_id" : "id",
	"init_at" : "date"
}

HTTP/1.1 400 Bad Request
{
  "msg" : "Check your Parameter"
}
```

### `GET`  /Membership/{manager_id}

- 시설에 등록된 유저 조회

`Parameter`

```json
{
	"manager_id" : "id"
}
```

`Response`

```json
HTTP/1.1 200 Ok
{
	"user_list" : [
		{
			"user_id" : "id",
			"name" : "String",
			"phone" : "String",
			"init_at" : "date",
			"accept" : 0
		}
	]
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `PUT`  /Membership/accept/{membership_id}

- 시설등록 요청된 유저 승인

`Parameter`

```json
{
	"membership_id" : "id"
}
```

`Response`

```json
HTTP/1.1 201 Created
{
	"id" : 0,
	"user_id" : "id",
	"manager_id" : "id",
	"init_at" : "date",
	"ticket_id" : "id",
	"accept" : 0
}

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```

### `DELETE`  /Membership/reject/{membership_id}

- 시설등록 요청된 유저 거절(삭제)

`Parameter`

```json
{
	"membership_id" : "id"
}
```

`Response`

```json
HTTP/1.1 204 No Content

HTTP/1.1 400 Bad Request
{
	"msg" : "Check your Parameter"
}

HTTP/1.1 404 Not Found
```
