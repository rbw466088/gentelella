$(function() {
	sel();
});

function sel() {
	var gameName = $("#gameName").val();
	var gameType = $("#gameType").val();
	var gameCompany = $("#gameCompany").val();
	var gameYear = $("#gameYear").val();
	if(gameYear){
		var test = /^\d{4}$/;
		if(!test.test(gameYear)){
			alert("发行年份应为四位数字，请重新输入！");
			return;
		}
	}
	var param = "gameName="+gameName+"&gameType="+gameType+"&gameCompany="+gameCompany+"&gameYear="+gameYear;
	$.post("getData",param,function(data){
		var $data=$("#js-data");
//		$data.html(data);
		
		$data.html("");
		$.each(data,function(i,item){
			var tr=$("<tr>");
			$("<td style=\"display: none\">"  + item.gameId +  "</td>").appendTo(tr);
			$("<td>"  + item.gameName +  "</td>").appendTo(tr);
			$("<td>"  + item.gameType +  "</td>").appendTo(tr);
			$("<td>"  + item.gameCompany +  "</td>").appendTo(tr);
			$("<td>"  + item.gameYear +  "</td>").appendTo(tr);
			$("<td><input type=\"button\" onclick=\"up(" + item.gameId + ");\" value=\"修改\"/> " +
			"<input type=\"button\" onclick=\"del(" + item.gameId + ");\" value=\"删除\"/></td>").appendTo(tr);
			$data.append(tr);
		});
	},"JSON");
}

