var $path = "http://"+location.host+"/school/";
$(function() {
	//用户名验证
	$("#name").blur(function() {
		var name = this.value;
		var nameJoin = $("#nameJoin");
		if (!name) {
			nameJoin.html("用户名不能为空！");
			nameJoin.css("color", "red");
		} else {
			$.post("ajaxName", "name=" + name, callBack);
			function callBack(data) {
				if (data == "true") {
					nameJoin.html("用户名已被使用！");
					nameJoin.css("color", "red");
				} else {
					nameJoin.html("用户名可以使用！");
					nameJoin.css("color", "blue");
				}
			}
		}
	});

	//邮箱验证
	$("#email").blur(function() {
		var email = this.value;
		var emailJoin = $("#emailJoin");
		if (!email) {
			emailJoin.html("邮箱不能为空！");
			emailJoin.css("color", "red");
		} else {
			$.post("ajaxEmail", "email=" + email, callBack);
			function callBack(data) {
				if (data == "true") {
					emailJoin.html("邮箱已被使用！");
					emailJoin.css("color", "red");
				} else {
					emailJoin.html("邮箱可以使用！");
					emailJoin.css("color", "blue");
				}
			}
		}
	});
});

