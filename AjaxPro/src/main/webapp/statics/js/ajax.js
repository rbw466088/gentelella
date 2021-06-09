var $path = "http://" + location.host + "/AjaxPro/";

// 检查表单元素的值是否为空
function check() {
	var userName = $("#userName").val();
	var pwd = $("#userPwd").val();
	var password = $("#password").val();
	var myform = document.getElementById("myForm");
	for (var i = 0; i < myform.length; i++) {
		if (myform.elements[i].value == "") {
			// alert(myform.elements[i].title + "不能为空");
			myform.elements[i].focus();
			return;
		}
	}
	if (pwd != password) {
		return;
	}
	$.post("ajaxUserName", "userName=" + userName,function(data) {
		if (data == "true") {
			return;
		} else {
			$("#myForm").submit();
		}
	});

}

$(function() {
	var flag = false;
	// 用户名验证
	$("#userName").blur(function() {
		var userName = this.value;
		var userNameJoin = $("#userNameJoin");
		if (!userName) {
			userNameJoin.html("用户名不能为空！");
			userNameJoin.css("color", "red")
			flag = false;
			return;
		} else {
			$.post("ajaxUserName", "userName=" + userName, function(data) {
				if (data == "true") {
					userNameJoin.html("用户名已被使用！");
					userNameJoin.css("color", "red");
					flag = false;
					return;
				} else {
					userNameJoin.html("用户名可以使用！");
					userNameJoin.css("color", "blue");
					flag = true;
				}
			});
		}
	});

	// 密码验证
	$("#userPwd").blur(function() {
		var userPwd = this.value;
		var userPwdJoin = $("#userPwdJoin");
		if (!userPwd) {
			userPwdJoin.html("密码不能为空！");
			userPwdJoin.css("color", "red");
			flag = false;
			return;
		} else {
			userPwdJoin.html("密码可以使用！");
			userPwdJoin.css("color", "blue");
			flag = true;
		}
	});

	// 密码二次验证
	$("#password").blur(function() {
		var userPwd = $("#userPwd").val();
		var password = this.value;
		var passwordJoin = $("#passwordJoin");
		if (!password) {
			passwordJoin.html("确认密码不能为空！");
			passwordJoin.css("color", "red");
			flag = false;
			return;
		} else if (userPwd != password) {
			passwordJoin.html("两次输入的密码不一样！");
			passwordJoin.css("color", "red");
			flag = false;
			return;
		} else {
			passwordJoin.html("两次输入的密码一样！");
			passwordJoin.css("color", "blue");
			flag = true;
		}
	});
	
});
