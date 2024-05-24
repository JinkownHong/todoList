# 🚀 ToDo 앱 백엔드 서버

이번 프로젝트의 미션은 “투두앱 백엔드 서버 만들기”입니다. 과제는 필수 구현(STEP 1) 단계부터 선택 구현 기능(STEP 4)까지 총 4단계로 구분되어 있습니다.

<img src="https://techcourse-storage.s3.ap-northeast-2.amazonaws.com/2020-03-16T10:41:53.786image.png" width="400">

# 📋 프로젝트 개요

이 프로젝트는 사용자가 할 일 목록을 관리할 수 있는 백엔드 서버를 구축하는 것입니다. 주요 기능은 할 일 추가, 수정, 삭제, 조회 및 댓글 작성 등 입니다.

# ✨ 주요 기능
각 STEP 별 소개와 함께 저는 현재 어디까지 해당 기능을 구현했는지도 함께 표기하였습니다.
해당 내용은 기능을 추가할 때마다 지속적으로 변경될 내용인 점 참고 부탁드리겠습니다.
### STEP 1

* [x] **할일카드 작성 기능**
    * 할 일 제목, 할일 내용, 작성일, 작성자 이름을 저장 가능
    * 저장된 할 일의 정보를 반환 받아 확인 가능
* [x] **선택한 할 일 조회 기능**
    * 선택한 할 일의 정보 조회 가능
    * 반환된 할 일 정보에는 할 일 제목, 할일 내용, 작성일, 작성자 이름 정보가 포함
* [x] **할 일 카드 목록 조회 기능**
    * 등록된 할 일 전체를 조회
    * 조회된 할 일 목록은 작성일 기준 내림차순으로 정렬
* [x] **선택한 할 일 수정 기능**
    * 선택한 할 일의 제목, 작성자명, 작성 내용을 수정 가능
    * 수정된 할 일의 정보를 반환 받아 확인 가능
* [x] **선택한 할 일 삭제 기능**
    * 선택한 게시글을 삭제 가능

### STEP 2

* [x] **할일카드 완료 기능 API**
    * 완료처리 한 할일 카드는 목록 조회 시 완료 여부 필드가 TRUE로 반환
    * 완료 여부 기본값은 FALSE
* [x] **댓글 작성 API**
    * 댓글 작성 시 ‘작성자 이름’과 ‘비밀번호’ 함께 받기
    * 선택한 할 일의 DB 저장 유무 확인 (todoId)
    * 댓글 등록 및 반환 (응답에서 비밀번호는 제외)
* [x] **댓글 수정 API**
    * 선택한 댓글의 DB 저장 유무 확인
    * 작성자 이름과 비밀번호를 함께 받아 저장된 값과 일치하면 수정 가능
    * 댓글 수정 및 반환 (응답에서 비밀번호는 제외)
* [x] **댓글 삭제 API**
    * 선택한 댓글의 DB 저장 유무 확인
    * 작성자 이름과 비밀번호를 함께 받아 저장된 값과 일치하면 삭제 가능
    * 댓글 삭제 시 성공 메시지와 상태코드 반환
* [x] **선택한 할 일 조회 기능 응답에 연관된 댓글 목록 추가**
    * 선택한 할 일 조회 API 응답에 연관된 댓글 목록 추가
    * 연관되지 않은 댓글은 포함되지 않음

### STEP 3

* [ ] **할 일 목록 API에 작성일 기준 정렬 기능 추가**
    * API 요청 시 정렬 기준(오름차순, 내림차순) 포함
    * 정렬 기준에 따른 할 일 목록 반환
* [ ] **할 일 목록 API에 작성자 기준 필터 기능 추가**
    * API 요청 시 작성자 이름 포함
    * 작성자 이름이 일치하는 할 일 목록 반환
* [x] **할 일 작성, 수정 API에 validation 추가**
    * 할 일 제목이 1자 이상, 200자 이내인지 검사
    * 할 일 본문이 1자 이상 1000자 이하인지 검사
    * 조건 미충족 시 실패 응답
* [x] **ResponseEntity를 사용하여 API 응답에 적절한 코드 반환**
    * 조회 성공: status 200 OK
    * 작성 성공: status 201 Created
    * 수정 성공: status 200 OK
    * 삭제 성공: status 204 No Content
    * 작성, 수정 실패: status 400 Bad Request

### STEP 4: 선택 구현 기능

* [ ] **할 일 카드 목록 API 응답에 연관된 댓글 내용 추가**
    * 할 일 목록과 댓글 목록을 효율적으로 매칭
    * N + 1 query 문제 알아보기
* [ ] **할 일 카드 목록 API에 pagination 기능 추가**
    * offset 기반 pagination과 cursor 기반 pagination 알아보기
* [ ] **회원가입, 로그인 기능 추가**
    * 로그인한 사용자가 자신의 할 일, 댓글만 수정, 삭제할 수 있게 구현
    * 인증, 인가에 대해 알아보기
    * Basic Authentication과 Bearer Authentication 알아보기

# ✨ 각 STEP 별 해설

### STEP 1

#### 개발 시작 전
- ‘나만 사용할 수 있는 앱’을 목표로 시작.
- ‘todo’ 하나의 domain 생성, 해당 package 안에 controller, dto, exception, model, repository, service 패키지 구분.

#### 코드 해설

**Controller**
- @RestController Annotation 활용
- CRUD에 맞는 Annotation 활용, 적절한 Status Code 응답 설정
- Controller 안 새로운 Todo를 만들거나, Todo를 수정 시 제목이나, 이름을 미입력할 경우 예외 처리
(단순히 입력받는 데이터를 체크하고 오류를 전달하기 때문에 Controller 안에서 해당 로직을 처리)
- Step 1 까지 Controller 가 하나이기 때문에 @ExceptionHandler 를 Controller 에서 처리
- Dto를 통해 요청, 응답 관련 Data Class 처리

**Service**
- TodoService 인터페이스와 이를 상속받는 TodoServiceImpl로 구성
        * Service / ServiceImpl 구분 이유
		현재 상황에서는 구분할 큰 이유는 없으나 앱의 기능들이 복잡해질 경우를 가정
		예시로 이전 작성한 Todo를 수정하기 위해 패스워드가 필요할 경우 두 가지 수정 가능한 방법이 있다 가정
		하나는 기존 적어 놓은 패스워드를 기반으로 수정, 또 하나는 패스워드를 잊어버려 다른 인증 기반 시스템으로 인증 후 수정
		예시와 같이 구현체를 2개 이상 갖게 되어야 할 경우 인터페이스를 구분하는 것이 더 효율적이지 않을까 싶어 구분

- Todo를 수정하거나 삭제할 때 저장되지 않은 todoId 입력 시 ModelNotFoundException throw
- SQL 쿼리 활용 모든 할 일 목록을 작성일 기준 내림차순 정렬
- TodoResponse 내 date Type을 LocalDateTime에서 String으로 수정

**Repository**
- Jpa Repository를 상속받은 인터페이스로 구성
- findByOrderByDateDesc() 메서드 구성

### STEP 2

##### 개발 시작 전
* 가장 고민한 포인트는 comment domain package 를 추가적으로 만들어야 하나 싶었습니다. 사실 이전 Todo 와 URL 도 동일하고, 구성 요소도 비슷하고, 연관성이 매우 높아 동일한 Aggregate 단위라고 판단했습니다.
그래서 처음 Todo와 동일한 Controller 와 동일한 Service 를 활용하여 개발을 진행해보자 생각했습니다.
시작 전 다소 아쉬웠던 부분은 처음 필수 구현단계를 구현할 때, 혼자 사용하는 앱의 백엔드를 개발하자 판단한 부분이었습니다. user domain을 별도로 만들어 Comment 를 작성하는 사람과 Todo를 작성하는 사람을 구분짓지 않고 개발할 수 있겠다 생각하였으나, 해당 부분까지는 진행하지 못했습니다.
때문에 추후 해당 부분을 포함하여 개선해 볼 생각입니다.


##### 코드 해설
###### STEP 2 해설의 경우, 별도 Layer 분리 없이 이전 1 단계에서  추가된 기능이나, 변경된 부분을 중점으로 해설드리는 부분 참고 부탁드리겠습니다.

- Todo, Comment 를 하나의 domain 으로 다루기 때문에 domain 명 todo 에서 post 로 변경
- 처음 URL 이 동일하여 Controller 기존 Todo Controller 만 활용 예정이었으나, Swagger 에서 구분이 어려워 Controller 분리
- 할 일 카드 완료 기능 추가, 처음 할 일 카드를 작성할 경우 기존 할 일을 아직 완료하지 않았다는 가정하에 FALSE 반환
- Comment, Todo 테이블 기존 @JoinColumn 방식이 아닌, Id를 통한 매핑을 진행하려 했으나 동일한 Aggregate 단위로 @JoinColumn 어노테이션 활용
- 역방향 조회 목적 두 테이블 간 관계 양방향으로 매핑
- 작성자와 패스워드 검증 메서드 Comment Entity 단에 구성
- Todo, Comment 연관성이 높아 하나의 Service 활용, Service 명을 PostService로 변경
- GlobalExceptionHandler Class 생성

# 🔨 빌드 환경

* **Language:** Kotlin
* **IDE:** Intellij
* **SDK:** Eclipse Temurin 22.0.1
