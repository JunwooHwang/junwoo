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
		//replyService함수 호출     ajax로 보내고자하는 json타입               , callback함수 호출
		replyService.add({reply:reply,replyer:replyer,bno:bno},function(result){alert("insert 작업 : "+result)});
	})
	// detail.jsp가 실행되자마자 댓글목록리스트가 실행되어야 함.
	replyService.getList({bno:bno},function(list){
		console.log(list);
		
		var str="";
			
		for(var i=0; i<list.length; i++){
			str+=list[i].reply+"<br>"
			//$("#replyList").html(list[i].reply);
		}
		$("#replyList").html(str);
		
	});
})

var replyService=(function(){ //replyService함수선언
	// 댓글쓰기를 하기 위한 함수 선언
	function add(reply,callback){
        console.log("reply");
        $.ajax({
           url:"/replies/new",
           type:"post",
           data:JSON.stringify(reply), // JSON.stringfy : 자바스크립트의 값을 JASON 문자열로 변환
           contentType:"application/json; charset=utf-8",
           // callback 함수 선언
           success:function(result){ // 통신이 정상적으로 성공했으면
        	   
        	   // 만약에 callback이 있으면
        	   if(callback){
        		// callback함수를 호출
        		   callback(result);
        	   }
        	   
           },   
           error:function(){ // 통신이 비정상적으로 처리가 되어 error가 있으면
              
           }      
        })
     }
	// 댓글목록리스트를하기 위한 함수 선언
	// url에 .json 을 붙여야  xml파일 형식으로 안보여줌!!!
	function getList(param,callback){
		var bno =param.bno;
		console.log(bno);
		$.getJSON(
				"/replies/list/"+bno+".json",
				function(data){
					if(callback){
						callback(data);
					}
				})
	}
	
	// 댓글수정를 하기 위한 함수 선언
	
	// 댓글삭제를 하기 위한 함수 선언
	
	
	
	return{
		add:add,
		getList:getList
	};
})()

