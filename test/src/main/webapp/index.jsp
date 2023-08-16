<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
    <style>
        table {
            width: 100%;
            border: 1px solid #444444;
            border-collapse: collapse;
        }
        table th {
            border: 1px solid #444444;
            text-align: center;
            height: 40px;
            background-color: dodgerblue;
            color: cornsilk;
        }
        table td {
            border: 1px solid #444444;
            text-align: center;
        }
    </style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
    	$(document).ready(function () {
    		
    		var data = {
                id : 1,
               	name : "test",
               	pw : "test",
               	age : "20",
               	sex : "2",
               	birth : "test",
            }
    		
	       /*$('#select').on('click', function () {
	            $.ajax({
	                type : 'POST',
	                url : '/selectBoard',
	                contentType : 'application/json; charset=utf-8',
	                data: JSON.stringify(data),
	        		error : function(error) {
	        			console.log("error");
	        		},
	        		success : function(data) {
	        			console.log("success");
	        		}
	            })
	        })*/
	        
	        /* 조회 */
	        $('#select').on('click', function() {
	        	console.log("SELECT");
	        	$('#board').attr('action', '/selectBoardPost').submit();      
	        })
	        
	        /* 등록 */
   	        $('#reg').on('click', function() {	   
				console.log("REG");  	
	        	$('#board').attr('action', '/updateBoard').submit();      
	        })
	    });
    </script>
</head>
<body>
<div style="text-align: center;">
    <h1>메인</h1>
    <form id="board" method="POST">     
	    <table style="width: 700px; margin: auto">
	        <tr>
	            <th style="width: 10%">번호</th>
	            <th style="width: 50%">제목</th>
	            <th style="width: 15%">작성자</th>
	            <th style="width: 15%">등록일</th>
	            <th style="width: 10%">조회수</th>
	        </tr>
	        <c:forEach var="board" items="${boardList}">
	            <tr>
	                <td>${board.id}</td>
	                <td style="text-align: left"><a href="getBoard?seq=${board.id}">${board.title}</a></td>
	                <td>test</td>
	                <td><fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
	                <td>${board.content}</td>
	            </tr>
	        </c:forEach>
	    </table>
	    <button id="reg">등록</button>
	    <button id="select">조회</button>
	</form>
</div>
</body>
</html>