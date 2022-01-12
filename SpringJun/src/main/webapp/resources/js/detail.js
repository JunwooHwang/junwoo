/**
 * 
 */
$(document).ready(function(){
	// 댓글쓰기 버튼을 클릭하면
	$("#addReplyBtn").on("click",function(){
		//모달창을 띄워라
		//$(".modal").Modal("show");
	});
	//console.log(replyService);
	//댓글쓰기 버튼을 클릭하면
	var bno=$("#bno").html();
	
	$("#modalRegisterBtn").on("click",function(){
		// 클릭했을때 가져와야하는 변수들이라서 클릭이벤트에 변수선언
		var reply=$("input[name='reply']").val();
		var replyer=$("input[name='replyer']").val();
		//replyService함수 호출
		replyService.add({reply:reply,replyer:replyer,bno:bno});
		
	})
})

var replyService=(function(){ //replyService함수선언
	// 댓글쓰기를 하기 위한 함수 선언
	function add(reply){
        console.log("reply");
        $.ajax({
           url:"/replies/new",
           type:"post",
           data:JSON.stringify(reply), // JSON.stringfy : 자바스크립트의 값을 JASON 문자열로 변환
           contentType:"application/json; charset=utf-8",
           success:function(){
              
           },   // 통신이 정상적으로 성공했으면
           error:function(){
              
           }      // 통신이 비정상적으로 처리가 되어 error가 있으면
        })
     }
	// 댓글목록리스트를하기 위한 함수 선언
	
	// 댓글수정를 하기 위한 함수 선언
	
	// 댓글삭제를 하기 위한 함수 선언
	
	
	
	return{add:add};
})()

