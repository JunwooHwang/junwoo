/**
 * 
 */
$(document).ready(function(){
	// 상세페이지가 실행되면 댓글 글쓰기 버튼 활성화
	$("#modalRegisterBtn").show();
	// 상세페이지가 실행되면 댓글 글수정 버튼 활성화
	$("#modalModBtn").show();
	// 상세페이지가 실행되면 댓글 글삭제 버튼 활성화
	$("#modalRemoveBtn").show();
	
	
	
	// 댓글쓰기 버튼을 클릭하면
	$("#addReplyBtn").on("click",function(){
		//모달창을 띄워라
		//$(".modal").Modal("show");
	});
	//console.log(replyService);
	var bno=$("#bno").html();
	
	// 댓글목록리스트 함수 선언
	function showList(){
		replyService.getList({bno:bno},function(list){
			console.log(list);
			
			var str="";
				
			for(var i=0; i<list.length; i++){
				str+="<li><div><b>"+list[i].reply+"</b></div>"
				str+="<div>"+list[i].replyer
				str+="</div></li>"
				//$("#replyList").html(list[i].reply);
			}
			$("#replyList").html(str);
			
		});
	}
	// detail.jsp가 실행되자마자 댓글목록리스트가 실행되어야 함.
	showList();
	
	
	
	
	//모달창안에
	//댓글쓰기 버튼을 클릭하면
	$("#modalRegisterBtn").on("click",function(){
		// 클릭했을때 가져와야하는 변수들이라서 클릭이벤트에 변수선언
		var reply=$("input[name='reply']").val();
		var replyer=$("input[name='replyer']").val();
		//replyService함수 호출     ajax로 보내고자하는 json타입               
		replyService.add({reply:reply,replyer:replyer,bno:bno},
				function(result){
						alert("insert 작업 : "+result); // callback함수 호출
						// 목록리스트를 처리
						showList();
				}
		);
		//모달창 숨겨라
		$(".modal").modal("hide");
	});

	// 댓글내용을 클릭하면 (수정 및 삭제를 하기 위해서)
	$("#replyList").on("click",function(){
		
		replyService.reDetail(7,function(detail){
			
			$("input[name='replyer").val(detail.replyer)
			$("input[name='reply").val(detail.reply)

			
			// 상세페이지가 실행되면 댓글 글쓰기 버튼 비활성화
			$("#modalRegisterBtn").hide();
			// 상세페이지가 실행되면 댓글 글수정 버튼 활성화
			$("#modalModBtn").show();
			// 상세페이지가 실행되면 댓글 글삭제 버튼 활성화
			$("#modalRemoveBtn").show();
			// 모달창을 띄워라
			$(".modal").modal("show");
			
		});
			
		
	});
	
	
	
	
	
	
})
 //replyService함수선언
var replyService=(function(){
	// 댓글쓰기를 하기 위한 함수 선언
	function add(reply,callback){
        console.log("reply");
        $.ajax({
           url:"/replies/new",
           type:"post",
           data:JSON.stringify(reply),
           // JSON.stringfy : 자바스크립트의 값을 JASON 문자열로 변환
           contentType:"application/json; charset=utf-8",
           // callback 함수 선언
           success:function(result){ 
        	   // 통신이 정상적으로 성공했으면
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
	// 댓글수정을 위해 댓글내용 가져오기 함수 선언
	function reDetail(rno,callback){
		var rno=rno
		$.getJSON(
				"/replies/"+rno+".json",
				function(data){
					if(callback){
						callback(data);
					}
				})
	}
	// 댓글수정을 하기 위한 함수 선언
	
	// 댓글삭제를 하기 위한 함수 선언
	
	
	
	return{
		add:add,
		getList:getList,
		reDetail:reDetail
	};
})()

