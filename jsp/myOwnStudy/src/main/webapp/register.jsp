<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>event cancel</title>
<script src="externalJS.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>

            function idCheck(userId) {
                let isOk = false;
                // console.log(isOk);
                if (userId == "") { //아이디 안썼을 때
                    document.getElementById("idError").innerHTML = "not typed";
                    // console.log("none ID");
                    document.getElementById("userId").focus();
                    isOk = false;
                    return isOk;
                    // alert('ID please');
                } else if (userId.length < 4 || userId.length > 8) { //아이디 4자 미만이거나 8자 초과일 때                    
                    document.getElementById("idError").innerHTML = 'ID shorter than 4 or longer than 8';
                    document.getElementById("userId").focus();
                    isOk = false;
                    return isOk;
                } else {
                    document.getElementById("idError").innerHTML = '';
                    isOk = true;
                    return isOk;
                }
            }
            function CheckPwd(userPwd) {
                let isOk = false;
                // console.log(isOk);
                if (userPwd == "") { //아이디 안썼을 때
                    document.getElementById("pwdError").innerHTML = "not typed";
                    console.log("none ID");
                    document.getElementById("userPwd").focus();
                    isOk = false;
                    return isOk;
                    // alert('ID please');
                } else if (userPwd.length < 4 || userPwd.length > 8) { //아이디 4자 미만이거나 8자 초과일 때
                    // alert('ID shorter than 4 or longer 8');
                    document.getElementById("pwdError").innerHTML = 'Password shorter than 4 or longer than 8';
                    console.log("4 or 8");
                    document.getElementById("userPwd").focus();
                    isOk = false;
                    return isOk;
                } else {
                    document.getElementById("pwdError").innerHTML = '';
                    isOk = true;
                    return isOk;
                }
            }
            function CheckPwd2(userPwd, userPwd2) {
                let isOk = false;
                // console.log(isOk);

                console.log("userPwd : ", userPwd + " userPwd2 :" + userPwd2);
                if (userPwd != userPwd2) {
                    document.getElementById("pwdError2").innerHTML = 'not matched password';
                } else {
                    document.getElementById("pwdError2").innerHTML = '';
                    isOk = true;
                }

                return isOk;
            }
            function emailCheck(email) {
                let result = false;

                let regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
                if (email.match(regExp) != null) //이메일 형식이면 
                {
                    document.getElementById("emailError").innerHTML = "";
                    result = true;
                } else {
                    document.getElementById("emailError").innerHTML = "email please";
                }
                // cons.log(email);
                return result;
            }
            function nameCheck(userName) {
                let result = false;
                if (userName != "") {   // 이름칸에 뭔가 있을 때
                    document.getElementById("nameError").innerHTML = "";
                    result = true;
                } else {    //이름칸에 뭐 안적었을 때
                    document.getElementById("nameError").innerHTML = "name please";
                    document.getElementById("userName").focus();
                }
                return result;
            }
            function birthdayCheck(birthday) {
                let result = false;
                birthday = String(birthday);
                if (birthday != "") { //뭔가 입력됐다면
                    document.getElementById("birthdayError").innerHTML = "";
                    result = true;
                } else {  // 입력이 안돼있다면
                    document.getElementById("birthdayError").innerHTML = "not typed ";
                    result = false;
                }
                return result;
            }
            function mobileCheck(mobile) {
                let result = false;
                var regExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;

                if (mobile.match(regExp) != null) //전화번호 형식이면 
                {
                    result = true;
                    document.getElementById("mobileError").innerHTML = "";
                } else {
                    result = false;
                    document.getElementById("mobileError").innerHTML = "phone number please";
                }

                return result; // 형식에 맞는 경우 true 리턴
            }
            function addressCheck(address) {
                let result = false;

                if (address != "") {    //주소가 있다면
                    result = true;
                    document.getElementById("addressError").innerHTML = "";
                } else {  //주소 안쳤다면
                    result = false;
                    document.getElementById("addressError").innerHTML = "type please";
                }
                return result;
            }
            function validateCheck() {
                let isChecked = false;
                //아이디 검증
                let userId = document.getElementById("userId").value;
                userId = String(userId).toLowerCase();

                // //비번 검증
                let userPwd = document.getElementById("userPwd").value;
                let userPwd2 = document.getElementById("userPwd2").value;
                // //이름
                let userName = document.getElementById("userName").value;
                // if (nameCheck(userName)) {
                //     userName = userName.replace(/^(?![\s-])[\w\s-]+$/, ""); //띄어쓰기 없애기
                //     console.log(userName);
                // }
                //생일 가져오기
                let birthday = document.getElementById("birthday").value;

                //이메일
                let email = document.getElementById("email").value;
                // emailCheck(email);
                //폰
                let mobile = document.getElementById("mobile").value;
                // 성별 가져오기
                let sexes = document.getElementsByName("sex");
                let sex = "";
                for (let i in sexes) {
                    if (sexes[i].checked)
                        sex = sexes[i].value;
                }

                //regi path
                let regiPathSelect = document.getElementById("registerPath");
                let regiPath = regiPathSelect.options[regiPathSelect.selectedIndex].value;

                //address
                let address = document.getElementById("address").value;

                // agreement
                let isAgreement = false;
                if (document.getElementById("agreement").checked) {
                    isAgreement = true;
                }
                if (idCheck(userId) && CheckPwd(userPwd) && CheckPwd2(userPwd, userPwd2) && nameCheck(userName) && emailCheck(email) && mobileCheck(mobile) && addressCheck(address) && isAgreement) {
                    isChecked = true;
                }
                return isChecked;
            }
        </script>
</head>

<body>
	<!-- <form action="34_registerSub.html"> -->
	<form method="POST" action="register.do" enctype="UTF-8">
		<h3>Sign in</h3>
		<div class="form-group">
			<label for="userId">ID :</label> <input type="text"
				class="form-control" id="userId" placeholder="Enter ID"
				name="userId">
			<div id="idError" class="text-danger"></div>
		</div>
		<div class="form-group">
			<label for="userPwd">Password:</label> <input type="password"
				class="form-control" id="userPwd" placeholder="Enter password"
				name="userPwd" onchange="CheckPwd(this);">
			<div id="pwdError" class="text-danger"></div>
		</div>
		<div class="form-group">
			<label for="userPwd2">Password Again :</label> <input type="password"
				class="form-control" id="userPwd2"
				placeholder="Enter password again">
			<div id="pwdError2" class="text-danger"></div>
		</div>
		<!--
		<button type="submit" class="btn btn-success"
			onclick="return validateCheck();">Submit</button>
		-->
		<button type="submit" class="btn btn-success">Submit</button>	
	</form>
</body>

</html>