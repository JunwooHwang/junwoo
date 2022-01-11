/**
 * 
 */
$(document).ready(function(){
	var actionForm = $("#actionForm");
	// 현재 페이지 번호를 클릭하면 form태그 안에 있는 search
	$(".paginate_button a").on("click",function(e){
		e.preventDefault();
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	})
	
	$(".AS").on("click",function(){
		actionForm.find("input[name='pageNum']").val("1")
	})
})