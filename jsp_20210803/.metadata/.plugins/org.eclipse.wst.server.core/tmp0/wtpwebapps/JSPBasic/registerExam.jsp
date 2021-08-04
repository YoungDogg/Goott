<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>회원가입</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
        // 가입 버튼을 누르면 아래의 조건에 따라 유효성 검사(데이터가 유효한지?)를 하고, 
        // 유효하면 34_registerSub.html 페이지에 데이터를 전송한다.
        // 유효하지 않은 데이터가 나오면 에러 메시지를 띄운다(db에 저장 x)

        // 아이디 : 4자 이상 8자 이하 필수(소문자로 저장)
        // 비밀번호 : 4자 이상 12자 이하 필수, 비밀번호 확인과 동일할것
        // 이름 : 필수 항목(중간의 공백이 없도록 저장한다)
        // 이메일 : 이메일 주소 형식인지 아닌지 검사
        // 휴대전화 : 전화번호 형식인지 아닌지 검사
        // 가입 조항 동의에 반드시 체크가 되어 있을 것.

        function idCheck(userId) {
            // 아이디 검증 
            // 검증 ok : true, 검증 실패 : false 
            let result = false; // 아이디 검증 실패 가정...

            if (userId == "") {
                document.getElementById("iderror").innerHTML = "아이디는 필수 항목입니다.";
                document.getElementById("userId").focus();
            } else if (userId.length < 4 || userId.length > 8) {
                document.getElementById("iderror").innerHTML = "아이디는 4자 이상 8자 이하로 입력해 주세요";
                document.getElementById("userId").focus();
            } else {
                document.getElementById("iderror").innerHTML = "<img src='img/check.png' width='10%' />";
                result = true;
            }

            return result;

        }

        // 비밀 번호 검증
        function pwdCheck(userPwd, userPwd2) {
            // 검증 ok : true, 검증 실패 : false 
            let result = false; // 검증 실패 가정...
            if (userPwd == "") {
                document.getElementById("pwderror").innerHTML = "비밀번호는 필수 항목입니다.";
                document.getElementById("userPwd").focus();
            } else if (userPwd.length < 4 || userPwd.length > 12) {
                document.getElementById("pwderror").innerHTML = "비밀번호는 4자 이상 12자 이하로 입력해 주세요";
                document.getElementById("userPwd").focus();
            } else if (userPwd != userPwd2) {
                document.getElementById("pwderror").innerHTML = "비밀번호가 서로 맞지 않습니다.";
                document.getElementById("userPwd2").value = "";
                document.getElementById("userPwd").focus();
            } else {
                document.getElementById("pwderror").innerHTML = "<img src='img/check.png' width='10%' />";
                result = true;
            }

            return result;
        }


        function nameCheck(userName) {
            let result = false;
            if (userName == "") {
                document.getElementById("nameerror").innerHTML = "이름은 필수 입니다.";
                document.getElementById("userName").focus();
            } else {
                document.getElementById("nameerror").innerHTML = "";
                result = true;
            }

            return result;
        }

        function validate() {
            let isCheckOk = false; // flag변수

            let userId = document.getElementById("userId").value.toLowerCase();
            console.log(userId);
            let idCheckResult = idCheck(userId);

            let userPwd = document.getElementById("userPwd").value;
            let userPwd2 = document.getElementById("userPwd2").value;
            let pwdCheckResult = pwdCheck(userPwd, userPwd2);

            let userName = document.getElementById("userName").value;
            let nameCheckResult = nameCheck(userName);
            if (nameCheckResult) {
                userName = userName.replace(/\s/gi, ""); // 이름에서 공백 제거
            }

            // 성별 가져오기
            let genders = document.getElementsByName("gender");
            let gender = "";
            for (let i in genders) {
                if (genders[i].checked) {
                    gender = genders[i].value;
                }
            }

            // 생일 가져오기
            let birthDay = document.getElementById("birthDay").value;


            // 이메일 체크
            let email = document.getElementById("email").value;
            let emailCheckResult = emailCheck(email);

            // 전화번호 체크
            let mobile = document.getElementById("mobile").value;
            let mobileCheckResult = mobileCheck(mobile);

            // 가입경로
            let registerPathSelect = document.getElementById("registerPath");
            let registerPath = registerPathSelect.options[registerPathSelect.selectedIndex].value;

            // 주소
            // let addr = document.getElementById("addr").value;

            // 가입 조항 동의
            let isAgree = false;
            if (document.getElementById("agree").checked) {
                isAgree = true;
            }

            // 전체 유효성 검증에 모두 통과 했다면....
            if (idCheckResult && pwdCheckResult && nameCheckResult && emailCheckResult && mobileCheckResult && isAgree) {
                isCheckOk = true;
            }

            return isCheckOk;
        }

        function mobileCheck(mobile) {
            let result = false;
            if (mobile.length > 0) {
                let regExp = /^\d{3}-\d{3,4}-\d{4}$/;
                if (mobile.match(regExp) != null) {
                    // 전화번호 형식
                    result = true;
                    document.getElementById("mobileerror").innerHTML = "";
                } else {
                    document.getElementById("mobileerror").innerHTML = "전화번호 형식이 아닙니다";
                    document.getElementById("mobile").focus();
                }
            }

            return result;
        }

        function emailCheck(email) {
            let result = false;
            if (email.length > 0) {
                let regExp = /[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]$/i;

                if (email.match(regExp) != null) {
                    // 이메일 주소 형식이다.
                    result = true;
                    document.getElementById("emailerror").innerHTML = "";
                } else {
                    document.getElementById("emailerror").innerHTML = "이메일 주소 형식이 아닙니다";
                    document.getElementById("email").focus();
                }
            }

            return result;
        }
    </script>
    <style>
        .error {
            color: red;
        }
    </style>

</head>

<body>
    <div id="wrap" class="container abc">
        <h3>회 원 가 입</h3>
        <form>
            <div class="form-group">
                <label for="userId">아이디:</label>
                <input type="text" class="form-control" id="userId" placeholder="Enter ID" name="userId"> <span
                    id="iderror" class="error"></span>
            </div>

            <div class="form-group">
                <label for="userPwd">비밀번호 :</label>
                <input type="password" class="form-control" id="userPwd" placeholder="Enter password"
                    name="userPwd"><span id="pwderror" class="error"></span>
            </div>

            <div class="form-group">
                <label for="userPwd2">비밀번호 확인 :</label>
                <input type="password" class="form-control" id="userPwd2" placeholder="Enter password">
            </div>

            <div class="form-group">
                <label for="userName">이름 :</label>
                <input type="text" class="form-control" id="userName" placeholder="Enter Name" name="userName"><span
                    id="nameerror" class="error"></span>
            </div>

            <div class="radio">
                <label><input type="radio" name="gender" value="female">여성</label>
            </div>

            <div class="radio">
                <label><input type="radio" name="gender" value="male">남성</label>
            </div>

            <div class="form-group">
                <label for="birthDay">생일 : </label><input type="date" id="birthDay" name="birthDay" />
            </div>

            <div class="form-group">
                <label for="email">이메일 :</label>
                <input type="text" class="form-control" id="email" placeholder="Enter email" name="email"><span
                    id="emailerror" class="error"></span>
            </div>

            <div class="form-group">
                <label for="mobile">전화번호 :</label>
                <input type="text" class="form-control" id="mobile" placeholder="Enter mobile" name="mobile"><span
                    id="mobileerror" class="error"></span>
            </div>

            <div class="form-group">
                <label for="registerPath">가입경로 :</label>
                <select id="registerPath" name="registerPath">
                    <option value="friend">지인</option>
                    <option value="internet">인터넷</option>
                    <option value="paper">전단지</option>
                    <option value="cf">광고</option>
                </select>
            </div>

            
            <div class="checkbox">
                <label><input type="checkbox" name="agree" id="agree">가입 조항에 동의합니다</label>
            </div>

            <button type="submit" class="btn btn-success" onclick="return validate();">Submit</button>
            <button type="reset" class="btn btn-warning">Cancel</button>
        </form>
        
        <img src="image/check.png" />
    </div>

    
</body>

</html>