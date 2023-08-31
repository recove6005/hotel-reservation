// 전화번호 11자리 문자열 생성


String telNum = document.querySelector('');
fetch('/user/sms?telNum=${telNum}')
.then(response => response.json())
.then(object => {})
.catch();

function check_verify_code() {
    
}