function doTrace(){
	$("#default_welcome").hide();
	$("#mine").hide();
	$("#find").hide();
	$(".scroll").click();
	$("#trace").show();
}
function doMine(){
	$("#default_welcome").hide();
	$("#find").hide();
	$("#trace").hide();
	$("#mine").show();
	$("#toTop").click();
}
function doFind(){
	$("#default_welcome").hide();
	$("#mine").hide();
	$("#trace").hide();
	$("#find").show();
	$("#toTop").click();
}

function doStart(){
	 $.ajax({
			type : "GET",
			url : "traceStart.action",
			success : function(json) {
				alert("satrt");
			}
	 }
	 );
	 $(".dataShow").location.reload();
	 doTrace();
}
function doReset(){
	 $.ajax({
			type : "GET",
			url : "traceReset.action",
			success : function(json) {
				alert("reset");
			}
	 }
	 );
	 $(".dataShow").location.reload();
	 doTrace();
}
function doclick_Mine(){
	$(".show_border").display='block';
}
