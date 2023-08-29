# hotel-reservation

호텔 예약 사이트 / 요구 사항 명세

1. VIEW
   
	1) 메인 페이지에서는 현재 존재하는 모든 방을 보여준다. (사진, 가격, 별점, 좋아요 여부 표시)
		- 메인페이지는 누구나 접근 가능
		- 로그인, 회원가입 페이지로 이동
		- 언어 선택
		- 존재하는 방들을 특정 조건(가격별...)으로 분류하는 필터링 기능


	2) 로그인, 회원가입 페이지
		- 누구나 접근 가능, 로그인 중인 사용자는 접근 불가
		- 로그인 시 사용하는 정보는 ID와 pw
		- 로그인 페이지 -> 아이디 찾기, 비밀번호 찾기 페이지로 이동
		- 회원가입 시 사용하는 정보
		 : id, pw, phone number, email, nickname(option), birth date(option)
		- 회원가입 시 이메일 인증 (전화번호 인증x)
		- 로그인 시 '일반회원' / '판매자' 판단 후, '일반회원'은 메인페이지로 / '판매자'는 마이페이지로 이동


	3) 마이페이지
		- 인증된 사용자만 접근 가능
		- 메뉴 제공
			- 일반회원
			: 개인 정보 확인 및 수정 페이지(마이페이지)
				- 개인정보 접근 전에 비밀번호 입력이 선행(비밀번호 입력 페이지)
				- id를 제외한 모든 정보 수정 가능
				- email 변경 시 이메일 인증
			: 예약 정보 확인 페이지
				- 예약한 내역 목록 표시
				- 각 목록 당 게시물 제목, 예약 날짜, 가격의 현재 예약 상황 표시
				- 해당 리스트 요소 클릭 시 세부 예약 내용 페이지로 이동
			: 좋아요 목록 확인 페이지
				- 방 목록

			- 판매자
			 : 개인 정보 확인 및 수정 페이지(마이페이지)
				- 개인정보 접근 전에 비밀번호 입력이 선행(비밀번호 입력 페이지)
				- id를 제외한 모든 정보 수정 가능
				- email 변경 시 이메일 인증
			: 판매 목록 페이지
			 	- 내가 등록한 게시물 목록 표시
				- 현재 판매되는 게시물 disable(숨기기)/delete(삭제)
				- 게시물 요소 클릭 시 예약 신청 내역 표시 (리스트로 나열) - 예약 승인 / 취소 버튼
			: 게시물 업로드 페이지
				- 게시물 제목, 가격, 1박 당 가격, 사진 첨부


	4) 방 세부 내용
		- 누구나 접근 가능
		- 게시물 제목, 좋아요 표시, 별점, 사진, 체크인 / 체크아웃 날짜, 예약하기 버튼, 계산된 가격 정보, 세부정보
		- (후기, 지도)
		- 예약 버튼 클릭 시 
			로그인된 사람만 예약 가능, 로그인이 되어있지 않다면 로그인 페이지로 이동
			로그인이 되어있다면 예약이 완료됨. 세부 예약 내용 페이지로 이동


	5) 세부 예약 내용 페이지
		- 방 게시물 제목, 예약 날짜, 가격 표시


	6) 아이디 / 비밀번호 찾기
		- 하나의 페이지로 구성. 상단에 아이디 찾기, 비밀번호 찾기 영역으로 구분
		- 아이디 찾기 : 등록한 이메일로 사용자의 아이디가 발송
		- 비밀번호 찾기
			: 비밀번호 재설정. 
			: id 정보 필수. 비밀번호 변경 시 전화번호 인증 혹은 이메일 인증 선택




3. Mapping 정의

	1) 메인 
		GET "/home" -> home.html

 
	2) 로그인
		GET(로그인 페이지로 이동) "/user/login" => not authenticated
		POST(로그인 시도) "/user/login"

 
	3) 회원가입
		GET(회원가입 페이지로 이동) "/user/join" => not authenticated
		POST(회원가입 시도) "/user/join"


	4) 마이페이지
		GET(마이페이지로 이동) "/user/mypage"
		GET(개인정보 확인 페이지) "/user/mypage/myinfo"
		GET(예약정보 확인 페이지) "/user/mypage/reservation"
		GET(현재판매목록 페이지) "/user/mypage/sale"
		GET(좋아요 목록) "/user/mypage/heart"
		GET(게시물 업로드) "/board"


	5) 방 세부 내용
		GET(방 내용) "/rooms/{roomID}" -> /rooms/main
		POST(방예약) "/rooms/reservation/{roomID}"
				

	6) 세부 예약 내용 페이지
		GET "/mypage/room"


	7) 아이디/비밀번호 찾기
		GET(페이지로 이동) "/user/info"
		GET_REST(ID 찾기, email 발송 시) "/user/id/{userEmail}"
		GET_REST(비밀번호 찾기, 전화번호/이메일, 인증번호 받기) "/user/pw/{userID}/{email or phonenumber}"
		GET_REST(pw 찾기) "/user/pw/{인증번호}"
		POST/PUT(pw 변경 시) "/user/pw/{userID}



5. DB
   
    user_role(role)
   
    user(id, pw, tel, email, nickname, birth, role)

    
    room(no, title, price, text, user, state)
   
    room_state(state) - post, hidden
   
    room_images(no, room, image)
   
    heart(user, room)
   
    
    rating(user, room, score)
   
    rate_score(score)
   
    
    reservation(user, room, reserve_date, price, state)
   
    reserve_state(state) - canceled, accept





