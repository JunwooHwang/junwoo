<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet">
<link href="../resources/css/sb-admin-2.min.css" rel="stylesheet">
<link href="../resources/css/all.min.css" rel="stylesheet" type="text/css">
<!-- Bootstrap Core CSS -->
<link href="../resources/css/bootstrap.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../resources/css/metisMenu.css" rel="stylesheet">


<!-- Custom Fonts -->
<link href="../resources/css/font-awesome.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../resources/js/detail.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.js"></script>
<script type="text/javascript" src="../resources/js/sb-admin-2.js"></script>
<script type="text/javascript" src="../resources/js/metisMenu.js"></script>


</head>




<body>
	<div class="form-group row">
		<div id="bno" class="col-sm-12 mb-3 mb-sm-0">${detail.bno}</div>
		<div class="col-sm-12 mb-3 mb-sm-0">
	    	${detail.title}
		</div>
	  
		<div class="col-sm-12 mb-3 mb-sm-0">
			${detail.content}
		</div>
		<div class="col-sm-12 mb-3 mb-sm-0">
			<a href="/board/modify?bno=${detail.bno}">수정</a>
			<a href="/board/remove?bno=${detail.bno}">삭제</a>
		</div>
		<div class="panel-body">
			<button id="addReplyBtn" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">댓글 쓰기</button>
			
			<div>
				<ul id="replyList">
				</ul>
			</div>
			
			
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <h4 class="modal-title" id="myModalLabel">댓글</h4>
		                </div>
		                <div class="modal-body">
		                    <div>
		                    	<input type="text" name="rno">
		                    </div>
		                    <div>
		                    	<label>작성자</label>
		                    	<input type="text" name="replyer">
		                    </div>
		                    <div>
		                    	<label>내용</label>
		                    	<input type="text" name="reply">
		                    </div>
		                </div>
		                <div class="modal-footer">
		                    <button id="modalRegisterBtn" type="button" class="btn btn-primary">댓글 쓰기</button>
		                    <button id="modalModBtn" type="button" class="btn btn-primary">댓글 수정</button>
		                    <button id="modalRemoveBtn" type="button" class="btn btn-primary">댓글 삭제</button>
		                    <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		                </div>
		            </div>
		            <!-- /.modal-content -->
		        </div>
		        <!-- /.modal-dialog -->
		    </div>
		</div>
		
	</div>
</body>
</html>