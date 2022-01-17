/**
 * 
 */
$(document).ready(function(){
	$("input[type='submit']").on("click",function(){
		alert("aaaa");
		//가상의 form태그
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		console.log(files);
		
		for(var i=0;files.length;i++){
			formData.append("uploadFile",files[i]);
		}
		
		//ajax를 이용해서.......
		//formData 자체를 데이터로 전송하고 formData를 데이터로 전송할 때에는
		//processData,contentType는 false로해야함
		$.ajax({
			url:"uploadAjaxAction",
			type:"post",
			data:formData,
			processData:false, 
			contentType:false,
			success:function(result){
				alert("upload성공")
			}
		})
	})
})