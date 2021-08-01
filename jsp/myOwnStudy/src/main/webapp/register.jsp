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
                if (userId == "") { //���̵� �Ƚ��� ��
                    document.getElementById("idError").innerHTML = "not typed";
                    // console.log("none ID");
                    document.getElementById("userId").focus();
                    isOk = false;
                    return isOk;
                    // alert('ID please');
                } else if (userId.length < 4 || userId.length > 8) { //���̵� 4�� �̸��̰ų� 8�� �ʰ��� ��                    
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
                if (userPwd == "") { //���̵� �Ƚ��� ��
                    document.getElementById("pwdError").innerHTML = "not typed";
                    console.log("none ID");
                    document.getElementById("userPwd").focus();
                    isOk = false;
                    return isOk;
                    // alert('ID please');
                } else if (userPwd.length < 4 || userPwd.length > 8) { //���̵� 4�� �̸��̰ų� 8�� �ʰ��� ��
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
                if (email.match(regExp) != null) //�̸��� �����̸� 
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
                if (userName != "") {   // �̸�ĭ�� ���� ���� ��
                    document.getElementById("nameError").innerHTML = "";
                    result = true;
                } else {    //�̸�ĭ�� �� �������� ��
                    document.getElementById("nameError").innerHTML = "name please";
                    document.getElementById("userName").focus();
                }
                return result;
            }
            function birthdayCheck(birthday) {
                let result = false;
                birthday = String(birthday);
                if (birthday != "") { //���� �Էµƴٸ�
                    document.getElementById("birthdayError").innerHTML = "";
                    result = true;
                } else {  // �Է��� �ȵ��ִٸ�
                    document.getElementById("birthdayError").innerHTML = "not typed ";
                    result = false;
                }
                return result;
            }
            function mobileCheck(mobile) {
                let result = false;
                var regExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;

                if (mobile.match(regExp) != null) //��ȭ��ȣ �����̸� 
                {
                    result = true;
                    document.getElementById("mobileError").innerHTML = "";
                } else {
                    result = false;
                    document.getElementById("mobileError").innerHTML = "phone number please";
                }

                return result; // ���Ŀ� �´� ��� true ����
            }
            function addressCheck(address) {
                let result = false;

                if (address != "") {    //�ּҰ� �ִٸ�
                    result = true;
                    document.getElementById("addressError").innerHTML = "";
                } else {  //�ּ� ���ƴٸ�
                    result = false;
                    document.getElementById("addressError").innerHTML = "type please";
                }
                return result;
            }
            function validateCheck() {
                let isChecked = false;
                //���̵� ����
                let userId = document.getElementById("userId").value;
                userId = String(userId).toLowerCase();

                // //��� ����
                let userPwd = document.getElementById("userPwd").value;
                let userPwd2 = document.getElementById("userPwd2").value;
                // //�̸�
                let userName = document.getElementById("userName").value;
                // if (nameCheck(userName)) {
                //     userName = userName.replace(/^(?![\s-])[\w\s-]+$/, ""); //���� ���ֱ�
                //     console.log(userName);
                // }
                //���� ��������
                let birthday = document.getElementById("birthday").value;

                //�̸���
                let email = document.getElementById("email").value;
                // emailCheck(email);
                //��
                let mobile = document.getElementById("mobile").value;
                // ���� ��������
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