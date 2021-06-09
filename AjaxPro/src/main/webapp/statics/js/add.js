var $path = "http://" + location.host + "/AjaxPro/";

function ret() {
	$("#addInfo").css("display","none");
	$("#show").css("display","block");
}

function add() {
	$("#addInfo").css("display","block");
	$("#show").css("display","none");
}

function addGames() {
	var gameName = $("#gameNameAdd").val();
	var gameType = $("#gameTypeAdd").val();
	var gameCompany = $("#gameCompanyAdd").val();
	var gameYear = $("#gameYearAdd").val();
	if(!gameName){
		alert("游戏名称不能为空！");
		return;
	}
	if(gameYear){
		var test = /^\d{4}$/;
		if(!test.test(gameYear)){
			alert("发行年份应为四位数字，请重新输入！");
			return;
		}
	}
	
	var param = "gameName="+gameName+"&gameType="+gameType+"&gameCompany="+gameCompany+"&gameYear="+gameYear;
	$.post("addGames",param,function(data){
		var $data=$("#js-data");
		
		if(data==true){
			alert("添加成功！");
			$("#addInfo").css("display","none");
			$("#show").css("display","block");
			sel();
		}else{
			alert("添加失败！");
			add();
		}
	},"JSON");
}
