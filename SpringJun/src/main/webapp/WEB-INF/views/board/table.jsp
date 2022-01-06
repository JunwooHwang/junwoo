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
</head>
<body>
	<h1>게시판 목록 리스트</h1>
	<div class="card-body">
   		<div class="table-responsive">
			<table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
			    <thead>
			        <tr role="row">
			        	<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 76px;">게시판 번호</th>
			        	<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 101px;">제목</th>
			        	<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 60px;">작성자</th>
			        	<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending" style="width: 71px;">작성일</th>
			        	<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 30px;">조회수</th>
			        	<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending" style="width: 67px;">좋아요</th>
			        </tr>
			    </thead>
			    <tfoot>
			        <tr>
			        	<th rowspan="1" colspan="1">게시판 번호</th>
			        	<th rowspan="1" colspan="1">제목</th>
			        	<th rowspan="1" colspan="1">작성자</th>
			        	<th rowspan="1" colspan="1">작성일</th>
			        	<th rowspan="1" colspan="1">조회수</th>
			        	<th rowspan="1" colspan="1">좋아요</th>
		        	</tr>
			    </tfoot>
		   		<tbody>
		   			<c:forEach items="${list}" var="board">  
				    	<tr class="odd">
				            <td class="sorting_1">${board.bno}</td>
				            <td><a href="/board/detail?bno=${board.bno}">${board.title}</a></td>
				            <td>${board.writer}</td>
				            <td>${board.regdate}</td>
				            <td>${board.cnt}</td>
				            <td>${board.good}</td>
				        </tr>
			        </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>