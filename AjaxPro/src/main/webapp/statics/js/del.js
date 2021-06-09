var $path = "http://" + location.host + "/AjaxPro/";

function del($id) {
	if(window.confirm("确定删除吗？")==true){
		$.post("delGames","id="+$id,function(data){
			var $data=$("#js-data");
			
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
		return true;
	}else{
		return false;
	}
}
